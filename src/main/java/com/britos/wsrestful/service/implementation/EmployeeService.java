package com.britos.wsrestful.service.implementation;

import com.britos.wsrestful.exceptions.EmployeeNotFoundException;
import com.britos.wsrestful.model.Employee;
import com.britos.wsrestful.repository.EmployeeRepository;
import com.britos.wsrestful.service.interfaces.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public EmployeeService(){}

    @Override
    public List<Employee> allEmployees() {
        return repository.findAll();
    }

    @Override
    public Employee newEmployee(Employee newEmployee) {
        return repository.save(newEmployee);
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    @Override
    public Employee replaceEmployee(Employee nuevoEmployee, Long id) {
        return repository.findById(id)
                .map(employee -> {
                    employee.setName(nuevoEmployee.getName());
                    employee.setSurname(nuevoEmployee.getSurname());
                    return repository.save(employee);
                })
                .orElseGet(() -> {
                    nuevoEmployee.setId(id);
                    return repository.save(nuevoEmployee);
                });
    }

    @Override
    public Employee alterEmployee(Employee nuevoEmployee, Long id) {
        return repository.findById(id)
                .map(employee -> {
                    employee.setName(nuevoEmployee.getName());
                    employee.setSurname(nuevoEmployee.getSurname());
                    return repository.save(employee);
                })
                .orElseGet(() -> {
                    nuevoEmployee.setId(id);
                    return repository.save(nuevoEmployee);
                });
    }

    @Override
    public void deleteEmployee(Long id) {
        repository.deleteById(id);
    }
}
