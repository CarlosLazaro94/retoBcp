package bcp.reto.retoBcp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

/**
 * @author Carlos Lazaro
 * @project reto-bcp
 * */

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
    @Bean
    public Docket apiDocket(){
        return  new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("bcp.reto.retoBcp.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(getApiIn());
    }

    private ApiInfo getApiIn(){
        return new ApiInfo(
                "Api Tipo Cambio",
                    "RETO BCP",
                "1.0",
                "",
                new Contact("Carlos Lazaro","", "carlos091294@gmail.com"),
                "LICENSE",
                "LICENSE URL",
                Collections.emptyList()
        );
    }
}
