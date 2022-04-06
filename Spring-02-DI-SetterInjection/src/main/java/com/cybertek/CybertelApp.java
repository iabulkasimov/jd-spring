package com.cybertek;

import com.cybertek.interfaces.Course;
import com.cybertek.services.Java;
import com.cybertek.services.Selenium;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CybertelApp {
    public static void main(String[] args) {
        ApplicationContext container = new ClassPathXmlApplicationContext("config.xml");

        Course course = container.getBean("java", Java.class);

        course.getTeachingHours();
    }
}
