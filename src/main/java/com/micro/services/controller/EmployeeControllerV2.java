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

@RestController
@RequestMapping("/v2/emp_info")
public class EmployeeControllerV2 {
    @Qualifier("employeeV2ServiceImpl")
    @Autowired
    EmployeeV2ServiceImpl employeeServiceImpl;

    @GetMapping("/employee")
    public Employee getEmployee(@RequestParam String id){
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
