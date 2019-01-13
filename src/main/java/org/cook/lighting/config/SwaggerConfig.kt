package org.cook.lighting.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

/**
 * Created by cook on 2019/1/13
 */
@EnableSwagger2
//@Profile({"dev", "qa"})
@Configuration
class SwaggerConfig {

    @Bean
    fun api(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
    }

    private fun apiInfo(): ApiInfo {
        return ApiInfoBuilder()
                .title("lighting api")
                .description("orange-tech dolphin")
                .termsOfServiceUrl("http://orange-tech.com/")
                .contact(Contact("Swagger", "127.0.0.1", "orange-tech@lighting.com"))
                .version("1.0")
                .build()
    }

}