package com.example.homework23_06;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService implements EmployeeServiceImp {
    List<Employee> employees = new ArrayList<>(List.of(
            new Employee("Аня", "Стрельченко"),
            new Employee("Николай", "Дуденко")
    ));

    int arraySize = 6;

    @Override
    public Employee add(String firstName, String lastName) {
        Employee employee = new Employee(
                firstName,
                lastName
        );
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.add(employee);
        return employee;
    }


    @Override
    public Employee remove(String firstName, String lastName) {
        Employee employee = new Employee(
                firstName,
                lastName
        );
        if (employees.contains(employee)) {
            employees.remove(employee);
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
        for (Employee employee1 : employees) {
            if (lastName.equals(employee1.getLastName()) && firstName.equals(employee1.getFirstName()))
                employees.equals(employee1);
            return employee1;
        }
        throw new EmployeeNotFoundException();
    }


    public List<Employee> printAll() {
return new ArrayList<>(employees);
        }
    }







