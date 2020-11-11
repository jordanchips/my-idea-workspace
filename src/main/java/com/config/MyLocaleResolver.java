package com.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * Description: 自定义的国际化组件
 */
public class MyLocaleResolver implements LocaleResolver {

    //解析请求
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        //获取请求中的语言参数
        String language = request.getParameter("lang");

        Locale locale = Locale.getDefault();//如果没有就用默认的

        //如果请求的链接携带了国际化的参数，如：zh_CN
        if (!StringUtils.isEmpty(language)) {
            String[] split = language.split("_");
            //拆分成：zh 和 CN
            locale = new Locale(split[0], split[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
