package com.cybertek;

import com.cybertek.interfaces.Course;
import com.cybertek.services.Java;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CybertekApp {
    public static void main(String[] args) {

        ApplicationContext container = new ClassPathXmlApplicationContext("config.xml");

        Course course = container.getBean("java", Java.class);
        course.getTeachingHours();
        ((ClassPathXmlApplicationContext)container).close();
    }
}
