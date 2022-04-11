package com.cybertek.services;

import com.cybertek.interfaces.Course;
import org.springframework.stereotype.Component;

//No need to use @Component wit @Bean
public class Selenium implements Course {
    @Override
    public void getTeachingHours() {
        System.out.println("Weekly teaching hours : 20");
    }
}
