package com.jc.config;

import com.jc.util.apiVersion.ApiVersionInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by jasonzhu on 2016/11/23.
 */
@Configuration

public class WebMvcConfig extends WebMvcConfigurerAdapter {
    @Autowired
    private ApiVersionInterceptor apiVersionInterceptor;

    @Bean(name = "apiVersionInterceptor")
    public ApiVersionInterceptor apiVersionInterceptor(){
        return new ApiVersionInterceptor();
    }

    @ConditionalOnBean(ApiVersionInterceptor.class)
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册api版本拦截器
        InterceptorRegistration ir=registry.addInterceptor(apiVersionInterceptor);
        //配置拦截路径
        ir.addPathPatterns("/**");

    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        super.addResourceHandlers(registry);
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }

}
