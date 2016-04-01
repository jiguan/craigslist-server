package com.guan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

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
