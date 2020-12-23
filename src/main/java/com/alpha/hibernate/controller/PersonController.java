package com.alpha.hibernate.controller;

import com.alpha.hibernate.entity.Person;
import com.alpha.hibernate.view.View;

import java.util.List;

public interface PersonController extends View<Person> {
    boolean save(Person person);
    boolean update(Person person);
    boolean delete(Person person);
    boolean deleteById(Long id);
    Person findById(Long id);
    List<Person> findAll();
}
