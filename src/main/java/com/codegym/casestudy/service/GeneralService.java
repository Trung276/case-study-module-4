package com.codegym.casestudy.service;

import java.util.Optional;

public interface GeneralService<T> {
    Iterable<T> findAll();  //tim tat ca

    Optional<T> findById(Long id);  //tim theo id

    Iterable<T> findByName(String keyword);     //tim theo keyword
    void save(T t); //luu

    void remove(Long id); //su dung xoa mem = cach cap nhat activated = false
}
