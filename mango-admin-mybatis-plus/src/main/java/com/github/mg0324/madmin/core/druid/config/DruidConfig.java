package com.github.mg0324.madmin.core.druid.config;

import com.alibaba.druid.support.http.StatViewServlet;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class DruidConfig {

    @Value("${druid.username:root}")
    private String druidUserName;
    @Value("${druid.password:mango-spring}")
    private String druidPassword;

    @Bean
    public ServletRegistrationBean<StatViewServlet> druidStatViewServlet() {
        ServletRegistrationBean<StatViewServlet> registrationBean = new ServletRegistrationBean<>(new StatViewServlet(),  "/druid/*");
        //registrationBean.addInitParameter("allow", "127.0.0.1");// IP白名单 (没有配置或者为空，则允许所有访问)
        registrationBean.addInitParameter("deny", "");// IP黑名单 (存在共同时，deny优先于allow)
        registrationBean.addInitParameter("loginUsername", druidUserName);
        registrationBean.addInitParameter("loginPassword", druidPassword);
        registrationBean.addInitParameter("resetEnable", "false");
        return registrationBean;
    }
}
