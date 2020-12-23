package com.alpha.hibernate.dao;

import com.alpha.hibernate.utils.HibernateUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public class DaoImpl<T extends Serializable, ID extends Serializable> implements IDao<T, ID>{

    private Class<T> entityClass;
    private Session session;
    private Transaction transaction;

    public DaoImpl(){
        entityClass = (Class<T>) ((ParameterizedType)(getClass().getGenericSuperclass())).getActualTypeArguments()[0];
    }

    private void beginTransaction(){
        session = HibernateUtils.getSessionFactory().openSession();
        transaction = session.beginTransaction();
    }

    @Override
    public boolean save(T entity) {
        if( null == entity ) return false;
        boolean saved = false;
        try{
            beginTransaction();
            session.save(entity);
            transaction.commit();
            saved = true;
        }catch (HibernateException ex) {
            transaction.rollback();
            saved = false;
        }finally {
            session.close();
        }
        return saved;
    }

    @Override
    public boolean update(T entity) {
        if( null == entity ) return false;
        boolean updated = false;
        try{
            beginTransaction();
            session.merge(entity);
            transaction.commit();
            updated = true;
        }catch (HibernateException ex) {
            System.out.println(ex.getMessage());
            transaction.rollback();
            updated = false;
        }finally {
            session.close();
        }
        return updated;
    }

    @Override
    public boolean delete(T entity) {
        if( null == entity ) return false;
        boolean deleted = false;
        try{
            beginTransaction();
            session.delete(entity);
            transaction.commit();
            deleted = true;
        }catch (HibernateException ex) {
            transaction.rollback();
            deleted = false;
        }finally {
            session.close();
        }
        return deleted;
    }

    @Override
    public boolean deleteById(ID id) {
        T entity = findById(id);
        return delete(entity);
    }

    @Override
    public T findById(ID id) {
        if( null == id) return null;
        T entity = null;
        try{
            beginTransaction();
            entity = session.get(entityClass, id);
            transaction.commit();
        }catch (HibernateException ex) {
            transaction.rollback();
        }finally {
            session.close();
        }
        return entity;
    }

    @Override
    public List<T> findAll() {
        List<T> resultList = null;
        try{
            beginTransaction();
            StringBuilder queryBuilder = new StringBuilder();
            queryBuilder.append("from ").append(entityClass.getName());
            TypedQuery<T> typedQuery = session.createQuery(queryBuilder.toString());
            resultList = typedQuery.getResultList();
            transaction.commit();
        }catch (HibernateException ex) {
            transaction.rollback();
        }finally {
            session.close();
        }
        return resultList;
    }
}
