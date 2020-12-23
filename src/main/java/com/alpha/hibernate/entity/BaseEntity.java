package com.alpha.hibernate.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
@Getter
@Setter
public abstract class BaseEntity<T extends Serializable> implements Serializable {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private T id;

    protected BaseEntity(){}
}
