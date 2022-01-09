package com.example.codeCreate;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.io.File;
import java.util.Collections;

public class CodeCreate {
    //数据库连接地址
    private static final String DATA_URL = "jdbc:mysql://47.103.79.58:3306/blob?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true";
    //数据库密码
    private static final String DATA_PASSWORD = "root";
    //数据库用户名
    private static final String DATA_USERNAME = "root";
    //创建作者
    private static final String AUTHOR = "yejidaxuesheng";
    //文件生产目录
    private static final String OUT_PUT_DIR = "D://codeCreate/";
    //读取的表名
    private static final String TABLE_NAME = "Test";
    //父目录包路径
    private static final String PARENT_MODULE = "com.example.basecode.moduls";
    //模块名称
    private static final String  MODULE_NAME = "test";
    public static void main(String[] args) {
        String parentPath = PARENT_MODULE.replace(".","/") + File.separator;
        FastAutoGenerator.create(DATA_URL, DATA_USERNAME, DATA_PASSWORD)
                .globalConfig(builder -> {
                    builder.author(AUTHOR) // 设置作者
//                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir(OUT_PUT_DIR); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent(PARENT_MODULE) // 设置父包名
                            .moduleName(MODULE_NAME) // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, OUT_PUT_DIR+parentPath+MODULE_NAME+"/mapper/xml")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude(TABLE_NAME); // 设置需要生成的表名
//                            .addTablePrefix("t_", "c_"); // 设置过滤表前缀
                })
                //实体对象设置
                .strategyConfig(builder->{builder
                        .entityBuilder()
                        .enableLombok()
                        .enableTableFieldAnnotation()
                        .idType(IdType.ASSIGN_UUID)
                        .build();
                })
                //控制层设置
                .strategyConfig(builder->{builder
                        .controllerBuilder()
                        .enableRestStyle()
                        .build();
                })
                .strategyConfig(builder->{builder
                        .mapperBuilder()
                        .enableMapperAnnotation	()
                        .build();
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();

    }
}
