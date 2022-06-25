package com.example.homework23_06;

import java.util.List;

public interface EmployeeServiceImp {
    Employee add(String firstName,String lastName);
    Employee find(String firstName,String lastName);
    Employee remove(String firstName,String lastName);

    List<Employee> printAll();

}
