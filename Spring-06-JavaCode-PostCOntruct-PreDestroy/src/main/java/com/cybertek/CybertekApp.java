package com.cybertek;

import com.cybertek.config.CybertekConfig;
import com.cybertek.interfaces.Course;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CybertekApp {
    public static void main(String[] args) {

        ApplicationContext container = new AnnotationConfigApplicationContext(CybertekConfig.class);

        Course course = container.getBean("java", Course.class);

        course.getTrainingHours();
        ((AnnotationConfigApplicationContext)container).close();


    }
}
