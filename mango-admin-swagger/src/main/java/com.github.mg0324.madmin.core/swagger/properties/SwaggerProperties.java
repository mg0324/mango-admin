package com.github.mg0324.madmin.core.swagger.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "mango.swagger")
@Data
public class SwaggerProperties {
    private String title = "接口文档";
    private String description;
    private String serviceUrl = "http://127.0.0.1";
    private String contact = "1092017732@qq.com";
    private String version = "1.0";
    private String groupName = "默认分组";
    private String packagePath = "com.github.mg0324";

}
