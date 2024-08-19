package com.micro.services.entity;

import com.micro.services.model.Employee;
import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="employee")
public class EmployeeEntity {
    @Id
    private String ID;
    private String address;

    public EmployeeEntity(String ID, String address, String name) {
        this.ID = ID;
        this.address = address;
        this.name = name;
    }

    private String name;

    public EmployeeEntity() {

    }
    public EmployeeEntity (Employee employee) {
        this.ID = employee.getID();
        this.address = employee.getAddress();
        this.name = employee.getName();
    }

    public String getName() {
        return name;
    }

    public String getID() {
        return ID;
    }

    public String getAddress() {
        return address;
    }


}
