package com.thoughtworks.gaia.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

/**
 * Created by jxzhong on 2017/5/9.
 */

//@Configuration
//@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(true)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
//                .apis(RequestHandlerSelectors.basePackage("com.thoughtworks.gaia"))
//                .paths(PathSelectors.any())
                .paths(regex("/api/gaia/swagger.json"))
                .build()
                .pathMapping("/api/gaia/");
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Swagger 2")
                .description("更多Spring Boot相关文章请关注：http://blog.didispace.com/")
                .termsOfServiceUrl("http://www.baidu.com/")
                .contact("程序猿Leo Jiang")
                .version("1.0.1.0")
                .build();
    }
}