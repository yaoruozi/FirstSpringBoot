package com.springboot.webtest.common.configuration;

import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.google.common.collect.Lists;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.List;

/**
 * Author:yao
 * Date:2018-11-28-23:37
 * 阿里巴巴数据库连接池的配置
 */
@Configuration

public class DruidConfig {
    @ConfigurationProperties(prefix = "spring.druid")
    @Bean(initMethod = "init", destroyMethod = "close")
    public DruidDataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setProxyFilters(Lists.newArrayList(staFilter()));
        return dataSource;
    }

    //使用阿里巴巴的filter
    @Bean
    public com.alibaba.druid.filter.Filter staFilter() {
        StatFilter statFilter = new StatFilter();
        statFilter.setSlowSqlMillis(3000);
        statFilter.setLogSlowSql(true);
        statFilter.setMergeSql(true);
        return statFilter;
    }

    //添加数据库监控
    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        return new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
    }

}
