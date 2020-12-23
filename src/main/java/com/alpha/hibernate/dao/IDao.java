package com.alpha.hibernate.dao;

import java.io.Serializable;
import java.util.List;

public interface IDao<T extends Serializable, ID extends Serializable> {
    boolean save(T entity);
    boolean update(T entity);
    boolean delete(T entity);
    boolean deleteById(ID id);
    T findById(ID id);
    List<T> findAll();
}
