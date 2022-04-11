package com.cybertek.services;

import com.cybertek.interfaces.ExtraSessions;

//No need to use @Component wit @Bean
public class OfficeHours implements ExtraSessions {

    @Override
    public int getTeachingHours() {
        return 5;
    }
}
