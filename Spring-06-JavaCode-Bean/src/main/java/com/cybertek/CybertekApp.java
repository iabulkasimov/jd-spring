package com.cybertek;

import com.cybertek.configs.CybertekAppConfig;
import com.cybertek.interfaces.Course;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CybertekApp {
    public static void main(String[] args) {

        ApplicationContext  container = new AnnotationConfigApplicationContext(CybertekAppConfig.class);

        Course courseJava = container.getBean("java", Course.class);
        courseJava.getTeachingHours();

        Course courseSelenium = container.getBean("selenium", Course.class);
        courseSelenium.getTeachingHours();

        System.out.println(courseJava.toString());


    }
}
