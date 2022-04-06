package com.cybertek.services;

import com.cybertek.interfaces.Course;
import com.cybertek.interfaces.ExtraSessions;

public class Java implements Course {

//    OfficeHours officeHours;
    ExtraSessions extraSessions;

    public Java(ExtraSessions extraSessions) {
        this.extraSessions = extraSessions;
    }
//    public Java(OfficeHours officeHours) {
//        this.officeHours = officeHours;
//    }

    @Override
    public void getTeachingHours() {
//        System.out.println("Weekly Java teaching hours: "+ (20 + officeHours.getHours()));
        System.out.println("Weekly Java teaching hours: "+ (20 + extraSessions.getHours()));
    }
}
