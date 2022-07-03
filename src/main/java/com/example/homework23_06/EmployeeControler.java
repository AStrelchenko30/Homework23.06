package com.example.homework23_06;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeControler {
    private final EmployeeService employeeService;

    public EmployeeControler(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/add")
    public String addEmployee(@RequestParam("firstName") String firstName,
                              @RequestParam("lastName") String lastName) {
        employeeService.add(firstName, lastName);

        return "firstName:" + " " + firstName + " " + "lastName:" + " " + lastName + " " + "Добавлен в ЛИСТ";
    }

    @GetMapping(path = "/remove")
    public String removeEmployee(@RequestParam("firstName") String firstName,
                                 @RequestParam("lastName") String lastName) {
        employeeService.remove(firstName, lastName);
        return "firstName:" + " " + firstName + " " + "lastName:" + " " + lastName + " " + "Удален из списка";
    }


    @GetMapping(path = "/find")
    public String findEmployee(@RequestParam("firstName") String firstName,
                               @RequestParam("lastName") String lastName) {
        employeeService.find(firstName, lastName);
        return "firstName:" + " " + firstName + " " + "lastName:" + " " + lastName + " " + "Уже есть в списке";
    }

}


