package com.alpha.hibernate.dao;

import com.alpha.hibernate.dao.DaoImpl;
import com.alpha.hibernate.entity.Person;
import com.alpha.hibernate.repository.PersonRepository;

import java.util.List;

public class PersonDao extends DaoImpl<Person, Long> implements PersonRepository {

    public PersonDao() {
        super();
    }

    @Override
    public boolean save(Person entity) {
        return super.save(entity);
    }

    @Override
    public boolean update(Person entity) {
        return super.update(entity);
    }

    @Override
    public boolean delete(Person entity) {
        return super.delete(entity);
    }

    @Override
    public boolean deleteById(Long aLong) {
        return super.deleteById(aLong);
    }

    @Override
    public Person findById(Long aLong) {
        return super.findById(aLong);
    }

    @Override
    public List<Person> findAll() {
        return super.findAll();
    }
}
