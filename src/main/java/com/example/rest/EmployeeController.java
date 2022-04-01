package com.example.rest;

import com.example.exception.InvalidIdException;
import com.example.exception.UserNotFoundException;
import com.example.model.Employee;
import com.example.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeRepo employeeRepo;

    @GetMapping("/helloWorld/{name}")
    public String helloWorldApp(@PathVariable String name){
        return "Welcome : "+name;
    }

    @PostMapping("/employee")
    public ResponseEntity<Object> saveEmp(@RequestBody Employee employee){
        Employee emp = employeeRepo.save(employee);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(emp.getEmpID()).toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable Integer id){
        Employee emp = employeeRepo.findById(id).orElse(null);
        if(id ==0)
            throw new InvalidIdException("Invalid Id Provided : "+id);
        if(emp == null)
            throw new UserNotFoundException("User Not Found with Emp Id : "+id);
        return emp;

    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeRepo.findAll();
    }
}
