package com.example.homework23_06;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeService implements EmployeeServiceImp {
private final Map<String,Employee> employeeMap;


    int arraySize = 6;

    public EmployeeService() {
        this.employeeMap = new HashMap<>();
    }

    @Override
    public Employee add(String firstName, String lastName) {
        Employee employee = new Employee(
                firstName,
                lastName
        );
        if (employeeMap.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException();
        }
        employeeMap.put(employee.getFullName(), employee);
        return employee;
    }


    @Override
    public Employee remove(String firstName, String lastName) {
        Employee employee = new Employee(
                firstName,
                lastName
        );
        if (employeeMap.containsKey(employee.getFullName())) {
            employeeMap.remove(employee.getFullName());
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee find(String firstName, String lastName) {
        Employee employee = new Employee(
                firstName,
                lastName
        );
            if (employeeMap.containsKey(employee.getFullName())){
            return employeeMap.get(employee.getFullName());
        }
        throw new EmployeeNotFoundException();
    }
}










