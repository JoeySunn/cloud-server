package com.cloud;

import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 作用描述
 *
 * @ProjectName: cloud-server
 * @Package: com.cloud
 * @Description: 接口对接API配置
 * @Author: 钱佳豪
 * @CreateDate: 2018/2/9 14:02
 * @UpdateDate: 2018/2/9 14:02
 * @UpdateRemark: The modified content
 * @Version: 1.0
 **/
@Configuration
@EnableSwagger2
public class SwaggerConfiguration{
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.cloud.code"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("API文档")
                .description("接口对接API")
                .termsOfServiceUrl("http://blog.didispace.com/")
                .contact(new Contact("钱佳豪","...","qianjiajoey@163.com"))
                .version("1.0")
                .build();
    }

}
