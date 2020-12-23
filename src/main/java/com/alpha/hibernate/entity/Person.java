package com.alpha.hibernate.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table( name = "person")
@Getter
@Setter
public class Person extends BaseEntity<Long> {

    @Embedded
    private FullName fullName;

    @Column( name = "age", length = 3 )
    private Integer age;

    @OneToMany( cascade = CascadeType.ALL, mappedBy = "person", fetch = FetchType.EAGER)
    private List<Laptop> laptopList = new ArrayList<>();
}
