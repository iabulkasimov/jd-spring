package com.cybertek;

//import com.cybertek.repository.RegionRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//import javax.annotation.PostConstruct;

import com.cybertek.repository.DepartmentRepository;
import com.cybertek.repository.EmployeeRepository;
import com.cybertek.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class Spring09OrmDriveQueriesApplication {

    @Autowired
    RegionRepository regionRepository;
    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    EmployeeRepository employeeRepository;

    public static void main(String[] args) {
        SpringApplication.run(Spring09OrmDriveQueriesApplication.class, args);

    }

    @EventListener
    public void testRegions(ApplicationStartedEvent event) {

        System.out.println("--------Regions start---------");

        System.out.println("findByCountry: " + regionRepository.findByCountry("Canada"));
        System.out.println("findDistinctByCountry: " + regionRepository.findDistinctByCountry("Canada"));
        System.out.println("findByCountryContaining: " + regionRepository.findByCountryContaining("United"));
        System.out.println("findByCountryContainingOrderByCountry: " + regionRepository.findByCountryContainingOrderByCountry("Asia"));
        System.out.println("findTop2ByCountry: " + regionRepository.findTop2ByCountry("Canada"));

        System.out.println("-------Regions End----------");
    }

    @EventListener
    public void testDepartments(ApplicationStartedEvent event) {

        System.out.println("--------Department start---------");

        System.out.println("findByDepartment: " + departmentRepository.findByDepartment("Toys"));
        System.out.println("findByDivision:" + departmentRepository.findByDivision("Outdoors"));
        System.out.println("findByDivisionEndingWith:" + departmentRepository.findByDivisionEndingWith("ics"));
        System.out.println("findDistinctTop3ByDivisionContains" + departmentRepository.findDistinctTop3ByDivisionContains("Hea"));

        System.out.println("-------Department End----------");

    }

//    @PostConstruct
    @EventListener
    public void testEmployees(ApplicationStartedEvent event){

        System.out.println("---------Employee start------------");

        System.out.println(employeeRepository.findByEmailIsNull());


        System.out.println("---------Employee End------------");

    }

}
