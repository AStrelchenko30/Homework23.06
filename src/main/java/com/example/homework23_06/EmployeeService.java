package com.example.homework23_06;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeService implements EmployeeServiceImpl {
    List<Employee> employees = new ArrayList<>(List.of(
            new Employee("Аня", "Стрельченко"),
            new Employee("Николай", "Дуденко")
    ));

int arraySize=6;
    @Override
    public void addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(
                firstName,
                lastName
        );
        int newArraySize=employees.size()+1;
        try {
            employees.add(employee);
        } catch (EmployeeAlreadyAddedException e) {
            System.out.println("Сотрудник уже есть в списке");
        }
        if(newArraySize>=arraySize){
            throw new ArrayIsFull(employees);
        }
        }



    @Override
    public void removeEmployee(String firstName, String lastName) {
        for (Employee employee1 : employees) {
            if (lastName.equals(employee1.getLastName()) && firstName.equals(employee1.getFirstName()))
                try {
                    employees.remove(employee1);
                } catch (EmployeeNotFoundException e) {
                    System.out.println("Данного сотрудника нет в списке");
                }
        }
    }

    @Override
    public void findEmployee(String firstName, String lastName) {
        for (Employee employee1 : employees) {
            if (lastName.equals(employee1.getLastName()) && firstName.equals(employee1.getFirstName()))
                try {
                    employees.equals(employee1);
                } catch (EmployeeNotFoundException e) {
                    System.out.println("Данного сотрудника нет в списке");

                }
        }
    }
    public void printAll(){
        for (Employee employee1 : employees) {
            System.out.println(employee1);
        }
    }
}






