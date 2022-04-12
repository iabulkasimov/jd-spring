package com.cybertek.services;

import com.cybertek.interfaces.Course;
import com.cybertek.interfaces.ExtraHours;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


@Component
public class Java implements Course {

//    @Autowired
    private ExtraHours extraHours;

    @Value("${instructor}")
    private String instructor;

    @Override
    public String toString() {
        return "Java{" +
                "instructor='" + instructor + '\'' +
                '}';
    }

    public Java(ExtraHours extraHours) {
        this.extraHours = extraHours;
    }

    @Override
    public void getTrainingHours() {
        System.out.println("Weekly java training hours : " +(extraHours.getTraningHour()+2));
    }
}
