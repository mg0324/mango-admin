package com.github.mg0324.madmin.core.mybatisplus.generator;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.github.mg0324.madmin.core.base.BaseController;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MybatisPlusGenerator {
    public MybatisPlusGenerator() {
    }

    public static void execute(final GenerateConfig config, final String projectPath, String[] tables) throws IOException {
        AutoGenerator mpg = new AutoGenerator();
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setOpen(false);
        //gc.setSwagger2(true);
        gc.setDateType(DateType.ONLY_DATE);
        gc.setAuthor(config.getAuthor());
        mpg.setGlobalConfig(gc);
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(config.getDbType());
        dsc.setDriverName(config.getDbDriver());
        dsc.setUsername(config.getDbUserName());
        dsc.setPassword(config.getDbPassword());
        dsc.setUrl(config.getDbUrl());
        mpg.setDataSource(dsc);
        StrategyConfig strategy = new StrategyConfig();
        strategy.setCapitalMode(true);
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setInclude(tables);
        strategy.setRestControllerStyle(true);
        strategy.setEntityLombokModel(true);
        strategy.setSuperControllerClass(BaseController.class.getName());
        mpg.setStrategy(strategy);
        PackageConfig pc = new PackageConfig();
        pc.setParent(config.getPackageName());
        pc.setModuleName(config.getModuleName());
        pc.setEntity("bean.entity");
        mpg.setPackageInfo(pc);
        InjectionConfig cfg = new InjectionConfig() {
            public void initMap() {
            }
        };
        String templatePath = "/templates/mapper.xml.vm";
        List<FileOutConfig> focList = new ArrayList();
        focList.add(new FileOutConfig(templatePath) {
            public String outputFile(TableInfo tableInfo) {
                return projectPath + "/src/main/resources/mybatis/mappers/" + config.getModuleName() + "/" + tableInfo.getEntityName() + "Mapper" + ".xml";
            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setXml((String)null);
        mpg.setTemplate(templateConfig);
        mpg.execute();
    }
}
