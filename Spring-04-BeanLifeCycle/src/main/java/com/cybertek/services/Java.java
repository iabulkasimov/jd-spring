package com.cybertek.services;

import com.cybertek.interfaces.Course;

public class Java implements Course {
    public void getTeachingHours() {
        System.out.println("Weekly Java teaching hours: 20");
    }

    public void myInitMethod(){
        System.out.println("Executing init method.");
    }

    public void myDestroyMethod(){
        System.out.println("Executing destroy method.");
    }
}
