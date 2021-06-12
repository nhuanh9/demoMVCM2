package com.company.service;

import java.util.List;

public interface GeneralService<T> {
    List<T> findAll();

    T findById(int id);

    void add(T t);

    void edit(int id, T t);

    void delete(int id);

}
