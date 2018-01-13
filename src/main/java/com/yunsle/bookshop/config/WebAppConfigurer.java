package com.yunsle.bookshop.config;

import com.yunsle.bookshop.interceptor.AdminInterceptor;
import com.yunsle.bookshop.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Doublestar on 2018/1/13 13:39).
 */
@Configuration
public class WebAppConfigurer extends WebMvcConfigurerAdapter {
    @Autowired
    LoginInterceptor loginInterceptor;
    @Autowired
    AdminInterceptor adminInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
        registry.addInterceptor(loginInterceptor).addPathPatterns("/cart");
        registry.addInterceptor(loginInterceptor).addPathPatterns("/mycount");
        registry.addInterceptor(loginInterceptor).addPathPatterns("/myorder");
        registry.addInterceptor(adminInterceptor).addPathPatterns("/admin/**");
        super.addInterceptors(registry);
    }

}
