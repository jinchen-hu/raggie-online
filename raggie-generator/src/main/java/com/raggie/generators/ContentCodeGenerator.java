package com.raggie.generators;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.querys.MySqlQuery;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.fill.Column;
import com.baomidou.mybatisplus.generator.query.SQLQuery;

import java.util.Arrays;

public class ContentCodeGenerator {
    private static final String SERVICE_NAME = "content";

    private static final String DATA_SOURCE_USER_NAME  = "root";
    private static final String DATA_SOURCE_PASSWORD  = "123";
    private static final String DATA_SOURCE_URL = "jdbc:mysql://127.0.0.1:3306/raggie_"+SERVICE_NAME+"?serverTimezone=UTC&useUnicode=true&useSSL=false&characterEncoding=utf8";

    private static final String OUTPUT_DIR = System.getProperty("user.dir")+"/raggie-generator/src/main/java";
    private static final String[] TABLE_NAMES = new String[]{
//			"mq_message",
//			"mq_message_history"
            "course_base",
            "course_market",
            "course_teacher",
            "course_category",
            "teachplan",
            "teachplan_media",
            "course_publish",
            "course_publish_pre"
    };
    public static void main(String[] args) {

        FastAutoGenerator.create(DATA_SOURCE_URL, DATA_SOURCE_USER_NAME, DATA_SOURCE_PASSWORD)
                .globalConfig(builder -> {
                    builder.author("Luke") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .outputDir(OUTPUT_DIR); // 指定输出目录
                })
                .dataSourceConfig(builder ->
                        builder.databaseQueryClass(SQLQuery.class)
                                .typeConvert(new MySqlTypeConvert())
                                .dbQuery(new MySqlQuery())
                )
                .packageConfig(builder ->
                        builder.parent("com.raggie")
                                .moduleName(SERVICE_NAME)
                                .mapper("mappers")
                                .xml("mappers")
                                .entity("model.po")
                )
                .strategyConfig(builder ->
                        builder.addInclude(TABLE_NAMES)
                                .addTablePrefix(SERVICE_NAME+"_")
                                // Entity strategy
                                .entityBuilder()
                                .naming(NamingStrategy.underline_to_camel)
                                .columnNaming(NamingStrategy.underline_to_camel)
                                .enableLombok()
                                .enableFileOverride()
                                .enableRemoveIsPrefix()
                                .addTableFills(Arrays.asList(
                                        new Column("create_time", FieldFill.INSERT),
                                        new Column("change_time", FieldFill.INSERT_UPDATE),
                                        new Column("update_time", FieldFill.UPDATE)))

                                // Controller strategy
                                .controllerBuilder()
                                .enableFileOverride()
                                .enableRestStyle()
                                .enableRestStyle()
                                .enableHyphenStyle()
                                // Service strategy
                                .serviceBuilder()
                                .enableFileOverride()
                                .formatServiceFileName("%sService")
                                .formatServiceImplFileName("%sServiceImp")
                                // Mapper strategy
                                .mapperBuilder()
                                .enableFileOverride()
                                .enableBaseColumnList()
                                .enableBaseResultMap()

                )
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }
}
