package com.micro.services.services;

import com.micro.services.entity.EmployeeEntity;
import com.micro.services.model.Employee;
import com.micro.services.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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
       List<EmployeeEntity> employeeEntities = employeeRepository.findAll();
        return employeeEntities.stream().map((employee)->{
           return new Employee(employee.getID(), employee.getName(), employee.getAddress());
       }).toList();
    }

    @Override
    public Employee getByID(String id) {
        EmployeeEntity employeeEntity= employeeRepository.getReferenceById(id);
        return new Employee(employeeEntity.getID(), employeeEntity.getName(), employeeEntity.getAddress());
    }

    @Override
    public String delete(String id) {
        return null;
    }
}
