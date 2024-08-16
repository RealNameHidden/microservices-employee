package com.micro.services.services;

import java.util.List;

public interface CrudService <T>{

    T save(T obj);

    List<T> getAll();

    T getByID(String id);

    String delete(String id);
}
