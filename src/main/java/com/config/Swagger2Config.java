package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Description:
 * Auther:cherry
 * CreateTime:2020-08-11 14:20
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Bean
    public Docket controllerApi(){
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(new ApiInfoBuilder()
            .title("调试")
            .description("接口列表")
            .contact(new Contact("cherry",null,"yichaotang@qq.com"))
            .version("版本号:1.0")
            .build())
        .select()
        .apis(RequestHandlerSelectors.basePackage("com.controller"))
        .paths(PathSelectors.any())
        .build();
    }

}
