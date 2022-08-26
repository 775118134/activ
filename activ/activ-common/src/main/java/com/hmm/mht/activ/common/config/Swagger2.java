package com.hmm.mht.activ.common.config;

import com.fasterxml.classmate.TypeResolver;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@ConditionalOnProperty(name = "swagger.enabled", matchIfMissing = true)
public class Swagger2 {

    @Bean
    public Docket createRestApi(TypeResolver typeResolver) {

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(
                        new ApiInfoBuilder()
                                .title("API文档")
                                .description("API文档")

                                //      .termsOfServiceUrl("http://775118134@qq.com")
                                //      .contact(new Contact("hmm",
                                //              "http://775118134@qq.com",
                                //              "775118134@qq.com"))
                                .version("1.0")
                                .build())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.hmm.mht.activ"))
                .paths(PathSelectors.any())
                .build()
                //                .additionalModels(typeResolver.resolve(BR.class))
                ;

    }
}
