package com.example.homework23_06;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeService implements EmployeeServiceImp {
    private final Map<String, Employee> employeeMap;


    int arraySize = 6;

    public EmployeeService() {
        this.employeeMap = new HashMap<>(Map.of(
                "0", new Employee("Олег", "Харатьян", 100_000, 1),
                "1", new Employee("Елена", "Воробей", 36_000, 1),
                "3", new Employee("Анна", "Стрельченко", 56_000, 2),
                "4", new Employee("Иван", "Иванов", 50_000, 2),
                "5", new Employee("Жан-Клод", "Ван Дам", 560_000, 3),
                "6", new Employee("Жан", "Рено", 750_000, 3),
                "7", new Employee("Доннальд", "Трамп", 10_000, 4),
                "8", new Employee("Жак", "Кусто", 145_000, 4)
        ));
    }

    @Override
    public Employee add(String firstName, String lastName, int salary, int workPlace) {
        Employee employee = new Employee(
                firstName,
                lastName,
                salary,
                workPlace
        );
        if (employeeMap.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException();
        }
        employeeMap.put(employee.getFullName(), employee);
        return employee;
    }


    @Override
    public Employee remove(String firstName, String lastName, int salary, int workPlace) {
        Employee employee = new Employee(
                firstName,
                lastName,
                salary,
                workPlace
        );
        if (employeeMap.containsKey(employee.getFullName())) {
        employeeMap.remove(employee.getFullName());
        return employee;
        }
         throw new EmployeeNotFoundException();
    }

    @Override
    public Employee find(String firstName, String lastName, int salary, int workPlace) {
        Employee employee = new Employee(
                firstName,
                lastName,
                salary,
                workPlace
        );
        if (employeeMap.containsKey(employee.getFullName())) {
            employeeMap.get(employee.getFullName());
            return employee;
        }
        throw new EmployeeNotFoundException();

    }

    @Override
    public Employee findEmployeeWithMaxSalary(Integer departmentId) {
        return employeeMap.values().stream().filter(employee ->
                        employee.getDepartmentId() == departmentId)
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);



    }

    @Override
    public Employee findEmployeeWithMinSalary(Integer departmentId) {
        return employeeMap.values().stream().filter(employee1 ->
                        employee1.getDepartmentId() == departmentId)
                .min(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    public List<Employee> printAllByDepartment(Integer departmentId) {
        List<Employee> result = employeeMap.values().stream().filter(employee -> employee.getDepartmentId() == departmentId)
                .collect(Collectors.toList());
        return result;
    }

    public List<Employee> printAll() {
        List<Employee> result = employeeMap.values().stream().collect(Collectors.toList());
        return result;

    }
}




















