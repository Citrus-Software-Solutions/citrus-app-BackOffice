package com.example.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.vaadin.artur.helpers.LaunchUtil;

/**
 * The entry point of the Spring Boot application.
 */
@SpringBootApplication
@ComponentScan(basePackages = { "com.vaadin.example.rest.data", "com.example.restprovider" })
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        LaunchUtil.launchBrowserInDevelopmentMode(SpringApplication.run(Application.class, args));
    }

}
