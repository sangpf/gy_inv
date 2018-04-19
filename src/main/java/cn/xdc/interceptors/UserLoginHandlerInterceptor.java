package cn.xdc.interceptors;

import cn.xdc.bean.User;
import cn.xdc.interceptors.service.TokenService;
import cn.xdc.interceptors.utils.CookieUtils;
import org.apache.commons.codec.binary.StringUtils;
import cn.xdc.service.UserService;
import cn.xdc.utils.StrUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@PropertySource(value = "classpath:sso.properties")
public class UserLoginHandlerInterceptor implements HandlerInterceptor {
    private static Logger log = Logger.getLogger(Object.class);

    public static final String COOKIE_NAME = "USER_TOKEN";
    @Value("${login_index_page}")
    private String loginIndexPage;

    @Autowired
    private TokenService tokenService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        // 获取请求的类型
        String type = request.getHeader("X-Requested-With");// XMLHttpRequest

        // 获取cookie的值 , cookie的值就是 token
        String token = CookieUtils.getCookieValue(request, COOKIE_NAME);
        log.info("=====================>> gy_inv服务拦截器, 判断用户是否登录, 从cookie中获取 COOKIE_NAME = USER_TOKEN 值为 : "+token);

        User user = null;
        if (StrUtils.isNotEmpty(token)){
            // 根据token 获取user
            user = this.tokenService.getUserByToken(token);
            log.info("======================>> gy_inv服务拦截器 使用token :" + token+", 请求sso服务, 获取 user :"+user);
            request.getSession().setAttribute("user",user);
        }

        // 如果 token为null,或者 user为 null , 说明用户没有登录
        if (StrUtils.isEmpty(token) || null == user) {
            // 转发
            if (StringUtils.equals("XMLHttpRequest", type)) {
                log.info("=======================>> gy_inv服务拦截器, 此请求为 ajax请求 ");
                // ajax请求 ,返回给前端一个标志, 让页面判断然后跳转
                response.setHeader("login_status", "no_login");
                response.setHeader("contextpath", loginIndexPage);

                response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                return false;

            } else {
                log.info("=======================>> gy_inv服务拦截器, 此请求为 一般请求, 下面还是重定向 ");
                response.sendRedirect(loginIndexPage+"?redirect=" + request.getRequestURL());
                return false;
            }
        }
        // 返回值决定handler是否执行。true：执行，false：不执行。
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                Exception ex) throws Exception {
    }

}
