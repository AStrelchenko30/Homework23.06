package com.example.homework23_06;

import java.util.List;
import java.util.Optional;

public interface EmployeeServiceImp {

    Employee add(String firstName, String lastName, int salary, int workPlace);

    Employee remove(String firstName, String lastName, int salary, int workPlace);

    Employee find(String firstName, String lastName, int salary, int workPlace);


    Employee findEmployeeWithMaxSalary(Integer departmentId);

    Employee findEmployeeWithMinSalary(Integer departmentId);
    List<Employee> printAllByDepartment(Integer departmentId);
   List<Employee> printAll();


}
