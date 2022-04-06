package com.cybertek.services;

import com.cybertek.interfaces.Course;
import lombok.Data;

@Data
public class Java implements Course {

    private OfficeHours officeHours;
/*
    public OfficeHours getOfficeHours() {
        return officeHours;
    }

    public void setOfficeHours(OfficeHours officeHours) {
        this.officeHours = officeHours;
    }
 */

    @Override
    public void getTeachingHours() {
        System.out.println("Weekly Java teaching hours: "+ (20 + officeHours.getHours()));
    }
}
