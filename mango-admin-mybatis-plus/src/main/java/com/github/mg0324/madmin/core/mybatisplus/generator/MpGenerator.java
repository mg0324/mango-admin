package com.github.mg0324.madmin.core.mybatisplus.generator;


import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.config.GlobalConfig;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MpGenerator {
    public static final String dbUserName="";
    public static final String dbPassword="";
    public static final String dbUrl = "jdbc:sqlite::resource:sqlite/card.db";
    public static final DbType dbType = DbType.SQLITE;
    public static final String dbDriver = "org.sqlite.JDBC";
    public static final String author="mango";
    public static final String packageName = "com.github.mg0324.springboot.demo";
    public static final String moduleName="admin";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("请输入表名,多表逗号隔开:");
        String tables = br.readLine();
        String[] tableArray = tables.split(",");
        for(String tableName : tableArray){
            tableName = tableName.toLowerCase();
            //String projectPath = System.getProperty("user.dir")+"/noah-archive-admin";
            String projectPath = System.getProperty("user.dir");
            GlobalConfig gc = new GlobalConfig();
            GenerateConfig config = new GenerateConfig();
            config.setAuthor(author);
            config.setDbDriver(dbDriver);
            config.setDbPassword(dbPassword);
            config.setDbUserName(dbUserName);
            config.setDbType(dbType);
            config.setDbUrl(dbUrl);
            config.setPackageName(packageName);
            config.setModuleName(moduleName);
            MybatisPlusGenerator.execute(config,projectPath,new String[]{tableName});
        }

    }
}