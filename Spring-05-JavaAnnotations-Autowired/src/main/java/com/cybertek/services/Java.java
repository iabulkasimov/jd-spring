package com.cybertek.services;

import com.cybertek.interfaces.Course;
import com.cybertek.interfaces.ExtraSessions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Java implements Course {

    //Field Injection
    @Autowired
//    private OfficeHours officeHours;
    private ExtraSessions extraSessions;
//
    /*
    //Constructor Injection
    @Autowired
    public Java(OfficeHours officeHours) {
        this.officeHours = officeHours;
    }
     */

//    public OfficeHours getOfficeHours() {
//        return officeHours;
//    }

    /*
    //Setter Injection
    @Autowired
    public void setOfficeHours(OfficeHours officeHours) {
        this.officeHours = officeHours;
    }
    */

    @Override
    public void getTeachingHours() {
//        System.out.println("Weekly teaching hours : "+(30+ officeHours.getHours()));
        System.out.println("Weekly teaching hours : "+(30+ extraSessions.getHours()));
    }
}
