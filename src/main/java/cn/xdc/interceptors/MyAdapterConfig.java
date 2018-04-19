package cn.xdc.interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

//标注此文件为一个配置项，spring boot才会扫描到该配置。该注解类似于之前使用xml进行配置
@Configuration
public class MyAdapterConfig extends WebMvcConfigurerAdapter {
    
    @Autowired
    private UserLoginHandlerInterceptor userLoginHandlerInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 判断用户是否登录的拦截器
        registry.addInterceptor(userLoginHandlerInterceptor)
                .addPathPatterns("/user/**")
                .addPathPatterns("/admin/**")
                .addPathPatterns("/question/**")
                .addPathPatterns("/project/**")
                .addPathPatterns("/investigation/**")
                .addPathPatterns("/client/**");
    }

}
