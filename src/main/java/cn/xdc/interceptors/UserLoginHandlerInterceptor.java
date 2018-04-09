package cn.xdc.interceptors;

import cn.xdc.bean.User;
import cn.xdc.interceptors.service.TokenService;
import cn.xdc.interceptors.utils.CookieUtils;
import cn.xdc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@PropertySource(value = "classpath:sso.properties")
public class UserLoginHandlerInterceptor implements HandlerInterceptor {

    public static final String COOKIE_NAME = "USER_TOKEN";
    @Value("${login_index_page}")
    private String loginIndexPage;

    @Autowired
    private TokenService tokenService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        // 获取cookie的值 , cookie的值就是 token
        String token = CookieUtils.getCookieValue(request, COOKIE_NAME);
        // 根据token 获取user
        User user = this.tokenService.getUserByToken(token);
        // 如果 token为null,或者 user为 null , 说明用户没有登录
        if (StringUtils.isEmpty(token) || null == user) {
            // 跳转到登录页面，把用户请求的url作为参数传递给登录页面。
            response.sendRedirect(loginIndexPage+"?redirect=" + request.getRequestURL());
            // 返回false
            return false;
        }
        // 把用户信息放入Request
        request.setAttribute("user", user);
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
