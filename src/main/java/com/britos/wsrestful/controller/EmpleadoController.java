package com.britos.wsrestful.controller;

import com.britos.wsrestful.exceptions.EmpleadoNotFoundException;
import com.britos.wsrestful.model.Empleado;
import com.britos.wsrestful.repository.EmpleadoRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class EmpleadoController {

    @Autowired
    private EmpleadoRepository repository;

    EmpleadoController() {}

    @GetMapping("/empleados")
    List<Empleado> getEmpleados() {
        return repository.findAll();
    }

    @PostMapping("/empleados")
    Empleado newEmployee(@RequestBody Empleado nuevoEmpleado) {
        return repository.save(nuevoEmpleado);
    }

    @GetMapping("/empleados/{id}")
    Empleado getEmpleadoById(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new EmpleadoNotFoundException(id));
    }

    @PutMapping("/empleados/{id}")
    Empleado reemplazarEmpleado(@RequestBody Empleado nuevoEmpleado, @PathVariable Long id) {

        return repository.findById(id)
                .map(employee -> {
                    employee.setName(nuevoEmpleado.getName());
                    employee.setRole(nuevoEmpleado.getRole());
                    return repository.save(employee);
                })
                .orElseGet(() -> {
                    nuevoEmpleado.setId(id);
                    return repository.save(nuevoEmpleado);
                });
    }

    @DeleteMapping("/empleados/{id}")
    void eliminarEmpleado(@PathVariable Long id) {
        repository.deleteById(id);
    }


}

