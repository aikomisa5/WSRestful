package com.britos.wsrestful.controller;

import com.britos.wsrestful.exceptions.EmployeeNotFoundException;
import com.britos.wsrestful.model.Employee;
import com.britos.wsrestful.repository.EmployeeRepository;

import java.util.List;

import com.britos.wsrestful.service.implementation.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepository repository;

    @Autowired
    private EmployeeService service;

    public EmployeeController() {}

    @GetMapping("/employees")
    List<Employee> allEmployees() {
       return service.allEmployees();
    }

    @PostMapping("/employees")
    Employee newEmployee(@RequestBody Employee newEmployee) {
        return service.newEmployee(newEmployee);
    }

    @GetMapping("/employees/{id}")
    Employee getEmployeeById(@PathVariable Long id) {
        return service.getEmployeeById(id);
    }

    @PutMapping("/employees/{id}")
    Employee replaceEmployee(@RequestBody Employee nuevoEmployee, @PathVariable Long id) {
        return service.replaceEmployee(nuevoEmployee,id);
    }

    @PatchMapping("/employees/{id}")
    Employee alterEmployee(@RequestBody Employee nuevoEmployee, @PathVariable Long id) {
        return service.alterEmployee(nuevoEmployee,id);
    }

    @DeleteMapping("/employees/{id}")
    void deleteEmployee(@PathVariable Long id) {
        service.deleteEmployee(id);
    }
}