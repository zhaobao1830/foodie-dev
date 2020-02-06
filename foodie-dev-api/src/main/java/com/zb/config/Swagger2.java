package com.zb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.RequestHandlerProvider;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

// Swagger2相应配置
@Configuration
@EnableSwagger2
public class Swagger2 {

    // http://localhost:8088/swagger-ui.html // springfox-swagger-ui样式
    // http://localhost:8088/doc.html // swagger-bootstrap-ui样式的

    // 配置Swagger2核心配置 docket
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2) // 指定api类型为Swagger2
                     .apiInfo(apiInfo())               // 定义api文档汇总信息
                     .select()
                     .apis(RequestHandlerSelectors
                             .basePackage("com.zb.controller")) // 指定controller包
                      .paths(PathSelectors.any())       // 所有controller
                      .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("天天吃货 电商平台接口api")  // 文档页面标题
                .contact(new Contact("zb1830",
                        "https://www.cnblogs.com/zhaobao1830/",
                        "373098777@qq.com"))  // 联系人信息
                .description("为天天吃货提供的api文档") // 详细信息
                .version("1.0.1")  // 文档版本号
                .termsOfServiceUrl("https://www.cnblogs.com/zhaobao1830/") // 网站地址
                .build();
    }
}
