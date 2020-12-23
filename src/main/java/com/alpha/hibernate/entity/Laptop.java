package com.alpha.hibernate.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table( name = "laptop")
@Getter
@Setter
public class Laptop extends BaseEntity<Long> {

    @Column( name = "brand", length = 30, nullable = false)
    private String brand;

    @Column( name = "description", length = 255)
    private String description;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn( name = "person_id", nullable = false)
    private Person person;
}
