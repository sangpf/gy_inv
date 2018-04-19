package cn.xdc.interceptors.service;

import cn.xdc.bean.User;
import cn.xdc.interceptors.pojo.ItdragonResult;
import cn.xdc.interceptors.utils.HttpClientUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@Service
@PropertySource(value = "classpath:sso.properties")
public class TokenService {

    @Value("${SSO_BASE_URL}")
    public String SSO_BASE_URL;
    @Value("${SSO_DOMAIN_BASE_USRL}")
    public String SSO_DOMAIN_BASE_USRL;
    @Value("${SSO_USER_TOKEN}")
    private String SSO_USER_TOKEN;
    @Value("${SSO_PAGE_LOGIN}")
    public String SSO_PAGE_LOGIN;

    public User getUserByToken(String token) {
        try {
            // 调用sso系统的服务，根据token取用户信息
            String json = HttpClientUtil.doGet(SSO_DOMAIN_BASE_USRL + SSO_USER_TOKEN + token);
            System.out.println("从sso服务请求到 json值为 : " + json);
            // 把json转换成ItdragonResult
            ItdragonResult result = ItdragonResult.formatToPojo(json, User.class);
            if (null != result && result.getStatus() == 200) {
                User user = (User) result.getData();
                return user;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
