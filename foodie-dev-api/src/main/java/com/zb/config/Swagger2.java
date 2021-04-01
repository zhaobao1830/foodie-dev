package com.zb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author: zhaobao1830
 * @Date: 2021/4/1 14:32
 */
@Configuration
@EnableSwagger2
public class Swagger2 {

//    http://localhost:8089/swagger-ui.html     原路径
//    http://localhost:8089/doc.html     原路径

    /**
     * 配置swagger2核心配置 docket
     * @return
     */
    @Bean
    public Docket createRestApi() {
        /**
         * 指定api类型为swagger2
         */
        return new Docket(DocumentationType.SWAGGER_2)
                /**
                 * 用于定义api文档汇总信息
                 */
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors
                        /**
                         * 指定controller包
                         */
                        .basePackage("com.zb.controller"))
                /**
                 * 所有controller
                 */
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                /**
                 * 文档页标题
                 */
                .title("java架构师接口api")
                /**
                 * 联系人信息
                 */
                .contact(new Contact("zhaobao1830", "", ""))
                /**
                 * 详细信息
                 */
                .description("java架构师api文档")
                /**
                 * 文档版本号
                 */
                .version("1.0.1")
                /**
                 * 网站地址
                 */
                .termsOfServiceUrl("")
                .build();
    }

}
