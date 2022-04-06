package com.cybertek;

import com.cybertek.interfaces.Course;
import com.cybertek.services.Java;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CybertelApp {
    public static void main(String[] args) {
        ApplicationContext container = new ClassPathXmlApplicationContext("config.xml");

        Course course1 = container.getBean("java", Java.class);
        Course course2 = container.getBean("java", Java.class);

        System.out.println("Pointing same object:" + (course1 == course2));
        System.out.println("Memory location for the course1:" + course1);
        System.out.println("Memory location for the course2:" + course2);

//        course1.getTeachingHours();
//        course2.getTeachingHours();
    }
}
