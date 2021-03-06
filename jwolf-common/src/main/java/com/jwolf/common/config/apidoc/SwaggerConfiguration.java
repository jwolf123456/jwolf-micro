package com.jwolf.common.config.apidoc;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;
import java.util.List;

/**
 * @param
 * @author zr 2019/05/22 上午11:04
 * @return
 * @description : swagger
 */
@Configuration
public class SwaggerConfiguration {
    @Value("${spring.application.name}")
    private String applicationName;

    @Bean
    @Profile({"test", "dev"})
    public Docket testApi() {

        //API描述
        ApiInfo apiInfo = new ApiInfoBuilder()
                .title(applicationName+"-微服务")
                .description(applicationName)
                .contact(new Contact("jwolf", "http://www.baidu.com", "523083921.qq.com"))
                .version("1.0.0")
                .build();
        //授权信息应用到全局
        List<SecurityContext> securityContext = Lists.newArrayList(SecurityContext.builder()
                .securityReferences(Collections.singletonList(new SecurityReference("BASE_TOKEN", new AuthorizationScope[]{new AuthorizationScope("global", "")})))
                .build());

        return new Docket(DocumentationType.OAS_30)
                .pathMapping("/")
                .enable(true)
                .select()
                //.apis(RequestHandlerSelectors.any()) //这个会显示系统相关api
                .apis(RequestHandlerSelectors.basePackage("com.jwolf.service."+applicationName+".controller"))
                .paths(PathSelectors.any())
                .build()
                .securitySchemes(Lists.newArrayList(new ApiKey("BASE_TOKEN", "token", "xxxxx")))
                .securityContexts(securityContext)
                .apiInfo(apiInfo);
    }

}

