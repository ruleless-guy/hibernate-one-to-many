package com.alpha.hibernate.controller;

import com.alpha.hibernate.entity.Laptop;
import com.alpha.hibernate.view.View;

import java.util.List;

public interface LaptopController extends View<Laptop> {
    boolean save(Laptop laptop);
    boolean update(Laptop laptop);
    boolean delete(Laptop laptop);
    boolean deleteById(Long id);
    Laptop findById(Long id);
    List<Laptop> findAll();
}
