package com.cybertek.configs;

import com.cybertek.services.Java;
import com.cybertek.services.Selenium;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.cybertek")
public class CybertekAppConfig {

    @Bean
    public Java java(){
        return new Java();
    }

    @Bean
    public Selenium selenium(){
        return new Selenium();
    }
}