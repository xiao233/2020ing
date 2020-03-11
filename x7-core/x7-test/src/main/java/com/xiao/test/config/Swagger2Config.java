package com.xiao.test.config;

import com.xiao.common.annotation.OpenSwagger2;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * swagger2 配置
 * @author 晓
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

    /**
     * 是否开启swagger api
     */
    @Value("${swagger.enable}")
    private Boolean enable;

    /**
     * 开放式api
     * @return
     */
    @Bean
    public Docket openApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("openApi")
                .genericModelSubstitutes(DeferredResult.class)
                .useDefaultResponseMessages(false)
                .forCodeGeneration(false)
                .select()
                //只有加这个注解的才显示在swagger
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                //只有加这个注解的才对外开放
                .apis(RequestHandlerSelectors.withMethodAnnotation(OpenSwagger2.class))
                .paths(PathSelectors.any())//过滤的接口
                .build()
                .apiInfo(openApiInfo());
    }

    /**
     * 内部api
     * @return
     */
    @Bean
    public Docket innerApi() {


        return new Docket(DocumentationType.SWAGGER_2)
                //是否开启swagger api
                .enable(enable)
                .groupName("innerApi")
                .genericModelSubstitutes(DeferredResult.class)
                .useDefaultResponseMessages(false)
                .forCodeGeneration(true)
                .select()
                //只有加这个注解的才显示在swagger
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(innerApiInfo());


    }

    /*
     * 设置内部api
     */
    private ApiInfo innerApiInfo(){
        return new ApiInfoBuilder()
                .title("x7程序")
                .description("Restful API 接口文档")
                .version("1.0")
                .contact(new Contact("xiao", "", "1462966599.com"))//作者
                .build();
    }


    /**
     * 设置外部api
     * @return
     */
    private ApiInfo openApiInfo() {
        return new ApiInfoBuilder()
                .title("x7程序")
                .description("Restful API 接口文档")
                .version("1.0")
                .contact(new Contact("xiao","", "1462966599@qq.com"))//作者
                .build();
    }

}
