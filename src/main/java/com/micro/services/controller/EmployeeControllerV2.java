package com.micro.services.controller;

import com.micro.services.model.Employee;
import com.micro.services.services.CrudService;
import com.micro.services.services.EmployeeServiceImpl;
import com.micro.services.services.EmployeeV2ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController("/v2")
public class EmployeeControllerV2 {
    @Autowired
    EmployeeV2ServiceImpl employeeServiceImpl;

    private  ArrayList<Employee> EmployeeDirectory;

    @GetMapping("/employee")
    public Employee saveEmployee(@RequestParam String id){
        return employeeServiceImpl.getByID(id);
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        return employeeServiceImpl.getAll();
    }

    @PostMapping("/employee")
    public Employee saveEmployee(@RequestBody Employee employee){
        employeeServiceImpl.save(employee);
        return employee;
    }

    @DeleteMapping("/employee")
    public String deleteEmployee(@RequestParam String id){
        employeeServiceImpl.delete(id);
        return id;
    }
}
