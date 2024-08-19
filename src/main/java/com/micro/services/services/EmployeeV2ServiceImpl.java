package com.micro.services.services;

import com.micro.services.entity.EmployeeEntity;
import com.micro.services.model.Employee;
import com.micro.services.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeV2ServiceImpl implements CrudService<Employee>{

    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public Employee save(Employee employee) {
        if(employee.getID().isEmpty()){
            employee.setID(UUID.randomUUID().toString());
        }
        EmployeeEntity employeeEntity = new EmployeeEntity(employee);
        employeeRepository.save(employeeEntity);
        return employee;
    }

    @Override
    public List<Employee> getAll() {
        return null;
    }

    @Override
    public Employee getByID(String id) {
        return null;
    }

    @Override
    public String delete(String id) {
        return null;
    }
}
