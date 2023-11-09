package com.tpi.demo.service;

import java.util.List;
import java.util.Optional;

public interface Service<T, ID> {
    List<T> findAll();
    Optional<T> findById(ID id);
    boolean delete(ID id);

    public void add(T entity);


}
