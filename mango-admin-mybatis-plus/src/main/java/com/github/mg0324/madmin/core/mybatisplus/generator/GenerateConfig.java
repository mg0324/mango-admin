package com.github.mg0324.madmin.core.mybatisplus.generator;

import com.baomidou.mybatisplus.annotation.DbType;
import lombok.Data;

@Data
public class GenerateConfig {
    private String packageName;
    private String moduleName;
    private String dbUserName;
    private String dbPassword;
    private String dbUrl;
    private DbType dbType;
    private String dbDriver;
    private String author;


}
