package com.cybertek;

import com.cybertek.entity.Employee;
import com.cybertek.repository.DepartmentRepository;
import com.cybertek.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class Spring09OrmMappingJpqlNamedQueriesApplication {

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    DepartmentRepository departmentRepository;

    public static void main(String[] args) {
        SpringApplication.run(Spring09OrmMappingJpqlNamedQueriesApplication.class, args);
    }

        @EventListener
        public void testEmployee(ApplicationStartedEvent event){
            System.out.println(employeeRepository.getEmployeeDetail());
            System.out.println(employeeRepository.getEmployeeSalary());

            System.out.println("**********");
            System.out.println(employeeRepository.getEmployeeByEmail("sdubber7@t-online.de"));
            System.out.println(employeeRepository.getEmployeeByEmail("sdubber7@t-online.de").get());

            System.out.println("**********");
            System.out.println(employeeRepository.getEmployeeBySalary(119674));
            System.out.println(employeeRepository.getEmployeeByFirstNameOrSalary("Avrom", 119674));

            System.out.println("****Update******");
            employeeRepository.updateEmployeeJPQL(1);
            employeeRepository.updateEmployeeNativeQuery(2);

            System.out.println("**********");
            System.out.println(employeeRepository.retrieveEmployeeSalaryGreaterThan(100000));

            System.out.println("**********");
            System.out.println(departmentRepository.findAppleDepartment("Kids"));
            System.out.println(departmentRepository.countAllDepartments());
        }


}
