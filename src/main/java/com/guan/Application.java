package com.guan;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@EnableOAuth2Client
@EnableAuthorizationServer
@SpringBootApplication
public class Application {

   public static void main(String[] args) {
      SpringApplication.run(Application.class, args);
   }

   @Bean
   public Docket api() {
      return new Docket(DocumentationType.SWAGGER_2)
            .select()
               .apis(RequestHandlerSelectors.basePackage("com.guan.controller"))
               .paths(PathSelectors.any())
               .build()
            .pathMapping("/")
            .useDefaultResponseMessages(false)
            .enableUrlTemplating(false)
            .directModelSubstitute(Date.class, String.class)
            .genericModelSubstitutes(ResponseEntity.class)
            .apiInfo(apiInfo())
            .enableUrlTemplating(false)
            // when run without auth header, turn it on
            .enable(true);

   }
   //http://localhost:8080/swagger-ui.html
   private ApiInfo apiInfo() {
      SimpleDateFormat format = new SimpleDateFormat("HH:mm MM/dd/yyyy");
      return new ApiInfoBuilder()
            .title("Mao")
            .description("Update time: " + format.format(new Date()))
            // .termsOfServiceUrl("http://www-03.ibm.com/software/sla/sladb.nsf/sla/bm?Open")
            .contact("Ricky Guan")
            .version("1.0")
            .build();
   }
   
   @Bean
   public WebMvcConfigurerAdapter forward() {
       return new WebMvcConfigurerAdapter() {
           @Override
           public void addViewControllers(ViewControllerRegistry registry) {
               registry.addViewController("/swagger").setViewName("forward:/swagger-ui.html");
               registry.addViewController("/login").setViewName("forward:/login.html");
           }
       };
   }
}
