package com.cybertek.repository;

import com.cybertek.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,String> {

    //Division
    @Query("select d from Department d where d.division in ?1")
    List<Department> getDepartmentByDivisionIn(List<String> division);

    List<Department> retrieveDepartmentByDivision(String division);

    @Query(nativeQuery = true)
    List<Department>retrieveDepartmentByDivisionContains(String pattern);

    List<Department>findAppleDepartment(String division);

    List<Department> countAllDepartments();
}
