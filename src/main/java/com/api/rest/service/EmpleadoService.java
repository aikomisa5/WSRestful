package com.api.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.rest.exceptions.EmpleadoNotFoundException;
import com.api.rest.model.Empleado;
import com.api.rest.repository.EmpleadoRepository;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository repository;

    public Empleado getEmpleadoById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EmpleadoNotFoundException(id));
    }
    
    public List<Empleado> getallEmpleados() {
        return repository.findAll();
    }

    public Empleado saveEmpleado(Empleado empleado) {
        return repository.save(empleado);
    }
    
    public Empleado patchEmpleado(Empleado nuevoEmpleado, Long id) {
        return repository.findById(id)
                .map(empleado -> {
                    empleado.setNombre(nuevoEmpleado.getNombre());
                    empleado.setApellido(nuevoEmpleado.getApellido());
                    return repository.save(empleado);
                })
                .orElseGet(() -> {
                    nuevoEmpleado.setId(id);
                    return repository.save(nuevoEmpleado);
                });
    }

    public Empleado putEmpleado(Empleado nuevoEmpleado, Long id) {
        return repository.findById(id)
                .map(empleado -> {
                    empleado.setNombre(nuevoEmpleado.getNombre());
                    empleado.setApellido(nuevoEmpleado.getApellido());
                    return repository.save(empleado);
                })
                .orElseGet(() -> {
                    nuevoEmpleado.setId(id);
                    return repository.save(nuevoEmpleado);
                });
    }

    public void deleteEmployee(Long id) {
        repository.deleteById(id);
    }
}
