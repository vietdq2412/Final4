package com.finalexam.final4.service;

import java.util.Optional;

public interface IService<T> {
    Iterable<T> findAll();

    Optional<T> findById(Long id);

    T save(T t);

    void delete(Long id);
}
