package com.example.homework23_06;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class EmployeeControler {
    private final EmployeeService employeeService;

    public EmployeeControler(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/employee/add")
    public String addEmployee(@RequestParam("firstName") String firstName,
                              @RequestParam("lastName") String lastName) {
        employeeService.addEmployee(firstName, lastName);

        return "firstName:" + " " + firstName + " " + "lastName:" + " " + lastName + " " + "Добавлен в ЛИСТ";
    }

    @GetMapping(path = "/employee/remove")
    public String removeEmployee(@RequestParam("firstName") String firstName,
                                 @RequestParam("lastName") String lastName) {
        employeeService.removeEmployee(firstName, lastName);
        return "firstName:" + " " + firstName + " " + "lastName:" + " " + lastName + " " + "Удален из списка";
    }


    @GetMapping(path = "/employee/find")
    public String findEmployee(@RequestParam("firstName") String firstName,
                               @RequestParam("lastName") String lastName) {
        employeeService.findEmployee(firstName, lastName);
        return "firstName:" + " " + firstName + " " + "lastName:" + " " + lastName + " " + "Уже есть в списке";
    }
@GetMapping(path ="/employee/printAll")
    public String printAll(@RequestParam() List<Employee>employees){
        employeeService.printAll();
        return "Списко сотрудников" + employees;
}
}

