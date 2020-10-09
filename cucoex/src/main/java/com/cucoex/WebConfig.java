package com.cucoex;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {


	
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(
                "/webjars/**",
                "/assets/**",
                "/css/**",
                "/js/**",
                "/img/**",
                "/vendor/**")
                .addResourceLocations(
                        "classpath:/META-INF/resources/webjars/",
                        "classpath:/static/assets/",
                        "classpath:/static/css/",
                        "classpath:/static/js/",
                        "classpath:/static/img/",
                        "classpath:/static/vendor/");
    }
	
	public WebConfig() {
		System.out.println("Iniciando configuracion de la aplicacion");
	}

}
