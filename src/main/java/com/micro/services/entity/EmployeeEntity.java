package com.micro.services.entity;

import jakarta.persistence.Entity;

import jakarta.persistence.Table;
import org.springframework.data.annotation.Id;

@Entity
@Table(name="employee")
public class EmployeeEntity {
    private String name;

    public String getName() {
        return name;
    }

    public String getID() {
        return ID;
    }

    public String getAddress() {
        return address;
    }

    @Id
    private String ID;
    private String address;
}
