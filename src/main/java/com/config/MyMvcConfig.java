package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * Description: 扩展SpringMvc
 * <p>
 * 如果想diy一些定制化的功能，只需要写这个组件，然后将其交给springboot，springboot就会帮我们自动装配。
 */
@Configuration

/**
 * 第一：导入一个类 DelegatingWebMvcConfiguration ：会获取容器中所有的WebMvcConfigurer
 * 第二：同时会顺带添加 WebMvcConfigurationSupport，但 WebMvcAutoConfiguration 中有
 * 这条 @ConditionalOnMissingBean(WebMvcConfigurationSupport.class)
 * 因此不能添加
 */
//@EnableWebMvc

public class MyMvcConfig implements WebMvcConfigurer {

    /**
     * 映射资源
     */
    public void addViewControllers(ViewControllerRegistry registry) {
        //首页映射
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
        //登录映射
        registry.addViewController("/main.html").setViewName("dashboard");
    }

    /**
     * 装配组件
     */
    @Bean
    public LocaleResolver localeResolver() { //自定义的国际化组件
        return new MyLocaleResolver();
    }

    /**
     * 拦截器注册
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/", "/index.html", "/login", "/css/*", "/img/**", "/js/**");
    }
}
