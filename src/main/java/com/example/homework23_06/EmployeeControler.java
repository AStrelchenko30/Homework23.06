package com.example.homework23_06;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeControler {
    private final EmployeeService employeeService;

    public EmployeeControler(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/add")
    public String addEmployee(@RequestParam("firstName") String firstName,
                              @RequestParam("lastName") String lastName,
                              @RequestParam("salary") int salary,
                              @RequestParam("department") int department) {
        employeeService.add(firstName, lastName, salary, department);

        return "firstName:" + " " + firstName + " " + "lastName:" + " " + lastName + " " + "Добавлен в ЛИСТ";
    }

    @GetMapping(path = "/remove")
    public String removeEmployee(@RequestParam("firstName") String firstName,
                                 @RequestParam("lastName") String lastName,
                                 @RequestParam("salary") int salary,
                                 @RequestParam("department") int department) {
        employeeService.remove(firstName, lastName, salary, department);
        return "firstName:" + " " + firstName + " " + "lastName:" + " " + lastName + " " + "Удален из списка";
    }


    @GetMapping(path = "/find")
    public String findEmployee(@RequestParam("firstName") String firstName,
                               @RequestParam("lastName") String lastName,
                               @RequestParam("salary") int salary,
                               @RequestParam("department") int department) {
        employeeService.find(firstName, lastName, salary, department);
        return "firstName:" + " " + firstName + " " + "lastName:" + " " + lastName + " " + "Уже есть в списке";
    }

    @GetMapping(path = "/departments/max-salary")
    public Employee findEmployeeWithMaxSalary(@RequestParam("departmentId") int departmentId) {
        return employeeService.findEmployeeWithMaxSalary(departmentId);



    }

    @GetMapping(path = "/departments/min-salary")
    public Employee findEmployeeWithMinSalary(@RequestParam("departmentId") int departmentId) {
        return employeeService.findEmployeeWithMinSalary(departmentId);

    }
    @GetMapping(path = "/departments/all")
    public String printAllByDepartment(@RequestParam("departmentId") int departmentId){
        final List<Employee> employeeAllByDepartment = employeeService.printAllByDepartment(departmentId);
        final List<String> employees=employeeAllByDepartment.stream()
                .map(Employee::getFullName).toList();
        return employees.toString();
    }
    @GetMapping(path="/departments/printAll")
    public List<Employee> printAll(){
        final List<Employee> employeeAll = employeeService.printAll();
        employeeAll.stream().map(Employee::getFullName).toList();
return employeeAll;

   }
}





