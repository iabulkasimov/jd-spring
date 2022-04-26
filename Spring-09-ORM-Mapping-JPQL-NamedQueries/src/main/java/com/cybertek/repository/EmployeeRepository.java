package com.cybertek.repository;

import com.cybertek.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    @Query("select e from Employee e where e.email = 'amcnee1@google.es'")
    Employee getEmployeeDetail();

    @Query("select e.salary from Employee e where e.email = 'amcnee1@google.es'")
    Integer getEmployeeSalary();

    //Single bind parameter
    @Query("select e from Employee e where e.email = ?1 ")
    Optional<Employee> getEmployeeByEmail(String email);

    //Multiple bind parameter
    @Query("select e from Employee e where e.email = ?1 and e.salary = ?2 ")
    Optional<Employee> getEmployeeByEmailAndSalary(String email,int salary);

    //Single named parameter

    @Query("select e from Employee e where e.salary =:salary")
    Employee getEmployeeBySalary(@Param("salary")int salary);

    //Multiple named parameters
    @Query("select e from Employee e where e.firstName =:name OR e.salary =:salary")
    List<Employee> getEmployeeByFirstNameOrSalary(@Param("name")String name,@Param("salary")int salary);

    //Not Equal
    @Query("select e from Employee e where e.salary <>?1 ")
    List<Employee>getEmployeeBySalaryNotEqual(int salary);

    // Like / Contains / StartsWith / Ends With
    @Query("select e from Employee e where e.firstName LIKE ?1")
    List<Employee> getEmployeeByFirstNameLike(String pattern);

    //Less than
    @Query("select e from Employee e where e.salary < ?1 ")
    List<Employee>getEmployeeBySalaryLessThan(int salary);

    //Greater than
    @Query("select e from Employee e where e.salary > ?1")
    List<Employee>getEmployeeBySalaryGreaterThan(int salary);

    //Between
    @Query("select e from Employee e where e.salary BETWEEN ?1 and ?2")
    List<Employee>getEmployeeBySalaryBetween(int salary1,int salary2);

    //Before
    @Query("select e from Employee e where e.hireDate >?1")
    List<Employee>getEmployeeByHireDateBefore(LocalDate date);

    //After
    @Query("select e from Employee e where e.hireDate <?1")
    List<Employee> getEmployeeByHireDateAfter(LocalDate date);

    //Null
    @Query("select e from Employee e where e.email IS null ")
    List<Employee> getEmployeeByEmailIsNull();

    //Not Null
    @Query("select e from Employee e where e.email is not NULL ")
    List<Employee>getEmployeeByEmailIsNotNull();

    //Sort salary in ascending order
    @Query("select e from Employee e ORDER BY e.salary")
    List<Employee> getEmployeeBySalaryOrderByAsc();

    //Sort Salary in descending order
    @Query("select e from Employee e order by e.salary desc ")
    List<Employee> getEmployeeBySalaryOrderByDesc();

    //Native Query
    @Query(value = "select * from Employees where salary = ?1",nativeQuery = true)
    List<Employee> readEmployeeBySalary(int salary);

    @Modifying
    @Transactional
    @Query("update Employee e set e.email='admin@email.com' where e.id=:id")
    void updateEmployeeJPQL(@Param("id")Integer id);

    @Modifying
    @Transactional
    @Query(value = "update employees set email='admin@email.com' where id=:id",nativeQuery = true)
    void updateEmployeeNativeQuery(@Param("id")Integer id);

    //Named Query
    List<Employee> retrieveEmployeeSalaryGreaterThan(Integer salary);

}
