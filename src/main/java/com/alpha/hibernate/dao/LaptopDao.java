package com.alpha.hibernate.dao;

import com.alpha.hibernate.dao.DaoImpl;
import com.alpha.hibernate.entity.Laptop;
import com.alpha.hibernate.repository.LaptopRepository;

import java.util.List;

public class LaptopDao extends DaoImpl<Laptop, Long> implements LaptopRepository {

    public LaptopDao() {
        super();
    }

    @Override
    public boolean save(Laptop entity) {
        return super.save(entity);
    }

    @Override
    public boolean update(Laptop entity) {
        return super.update(entity);
    }

    @Override
    public boolean delete(Laptop entity) {
        return super.delete(entity);
    }

    @Override
    public boolean deleteById(Long aLong) {
        return super.deleteById(aLong);
    }

    @Override
    public Laptop findById(Long aLong) {
        return super.findById(aLong);
    }

    @Override
    public List<Laptop> findAll() {
        return super.findAll();
    }
}
