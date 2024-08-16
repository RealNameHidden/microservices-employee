package com.micro.services.services;

import com.micro.services.error.EmployeeNotFoundException;
import com.micro.services.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements CrudService<Employee> {

    private List<Employee> employeeList = new ArrayList<>();

    @Override
    public Employee save(Employee employee) {
        this.employeeList.add(employee);
        return employee;
    }

    @Override
    public List<Employee> getAll() {
        return employeeList;
    }

    @Override
    public Employee getByID(String id) {
        return this.employeeList.stream()
                .filter((emp)->id.equals(emp.getID())).findFirst()
                .orElseThrow(()->new EmployeeNotFoundException("Employee is missing"));
    }

    @Override
    public String delete(String id) {
        employeeList.removeIf((emp)->id.equals(emp.getID()));
        return id;
    }
}
