package com.api.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.rest.model.Empleado;
import com.api.rest.service.EmpleadoService;

@RestController
public class EmpleadoController {

    @Autowired
    private EmpleadoService service;
    
    @GetMapping("/empleados/{id}")
    Empleado getEmpleadoById(@PathVariable Long id) {
        return service.getEmpleadoById(id);
    }

    @GetMapping("/empleados")
    List<Empleado> getAllEmpleados() {
       return service.getallEmpleados();
    }

    @PostMapping("/empleados")
    Empleado saveEmpleado(@RequestBody Empleado empleado) {
        return service.saveEmpleado(empleado);
    }
    
    @PatchMapping("/empleados/{id}")
    Empleado patchEmpleado(@RequestBody Empleado nuevoEmpleado, @PathVariable Long id) {
        return service.patchEmpleado(nuevoEmpleado,id);
    }

    @PutMapping("/empleados/{id}")
    Empleado putEmpleado(@RequestBody Empleado nuevoEmpleado, @PathVariable Long id) {
        return service.putEmpleado(nuevoEmpleado,id);
    }

    @DeleteMapping("/empleados/{id}")
    void deleteEmpleado(@PathVariable Long id) {
        service.deleteEmployee(id);
    }
}