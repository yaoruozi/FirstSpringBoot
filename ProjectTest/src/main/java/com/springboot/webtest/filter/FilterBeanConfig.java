package com.springboot.webtest.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author:yao
 * Date:2018-11-24-23:33
 */
@Configuration
public class FilterBeanConfig {
    /**
     * 1 构造filter
     * 2 配置拦截urlPattern
     * 3 利用FilterRegistrationBean行包装
     */
    @Bean
    public FilterRegistrationBean logFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new LogFilter());
        List<String> urlList = new ArrayList<String>();
        urlList.add("*"); //拦截所有请求
        filterRegistrationBean.setUrlPatterns(urlList);
        return filterRegistrationBean;


    }
}
