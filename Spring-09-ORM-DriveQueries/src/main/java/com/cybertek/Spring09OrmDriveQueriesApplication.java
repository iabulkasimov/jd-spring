package com.cybertek;

//import com.cybertek.repository.RegionRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//import javax.annotation.PostConstruct;

import com.cybertek.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class Spring09OrmDriveQueriesApplication {

    @Autowired
    RegionRepository regionRepository;

    public static void main(String[] args) {
        SpringApplication.run(Spring09OrmDriveQueriesApplication.class, args);

    }

    @PostConstruct
    public void testRegions() {

        System.out.println("--------Regions start---------");

        System.out.println("findByCountry: " + regionRepository.findByCountry("Canada"));

        System.out.println("-------Regions End----------");
    }

}
