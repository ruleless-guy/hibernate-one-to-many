package com.alpha.hibernate.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FullName {

    @Column( name = "first_name", length = 30, nullable = false )
    private String firstName;

    @Column( name = "last_name", length = 30, nullable = false )
    private String lastName;
}
