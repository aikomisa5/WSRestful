package com.britos.wsrestful.service.interfaces;

import com.britos.wsrestful.model.Employee;

import java.util.List;

public interface IEmployeeService {
    public List<Employee> allEmployees();
    public Employee newEmployee(Employee nuevoEmployee);
    public Employee getEmployeeById(Long id);
    public Employee replaceEmployee(Employee nuevoEmployee, Long id);
    public Employee alterEmployee(Employee nuevoEmployee, Long id);
    void deleteEmployee(Long id);
}
