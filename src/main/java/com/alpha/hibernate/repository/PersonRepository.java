package com.alpha.hibernate.repository;

import com.alpha.hibernate.dao.IDao;
import com.alpha.hibernate.entity.Person;
import com.sun.xml.bind.v2.model.core.ID;

public interface PersonRepository extends IDao<Person, Long> {
}
