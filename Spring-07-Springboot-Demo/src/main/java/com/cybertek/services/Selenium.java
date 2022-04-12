package com.cybertek.services;

import com.cybertek.interfaces.Course;
import org.springframework.stereotype.Component;

@Component
public class Selenium implements Course {
    @Override
    public void getTrainingHours() {
        System.out.println("Weekly selenium training hours : 5");
    }
}
