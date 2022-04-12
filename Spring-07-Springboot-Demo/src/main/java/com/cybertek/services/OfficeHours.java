package com.cybertek.services;

import com.cybertek.interfaces.ExtraHours;
import org.springframework.stereotype.Component;

@Component
public class OfficeHours implements ExtraHours {
    @Override
    public int getTraningHour() {
        return 30;
    }
}
