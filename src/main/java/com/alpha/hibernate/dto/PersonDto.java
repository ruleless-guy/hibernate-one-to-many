package com.alpha.hibernate.dto;

import com.alpha.hibernate.entity.BaseEntity;
import com.alpha.hibernate.entity.FullName;
import com.alpha.hibernate.entity.Laptop;
import com.alpha.hibernate.entity.Person;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PersonDto extends BaseEntity<Long> implements Dto<Person> {

    private FullName fullName;
    private Integer age;
    private List<Laptop> laptopList;

    public PersonDto(Person person){
        super.setId(person.getId());
        this.fullName = person.getFullName();
        this.age = person.getAge();
        this.laptopList = person.getLaptopList();
    }

    @Override
    public Person getEntity() {
        Person person = new Person();
        person.setId(super.getId());
        person.setFullName(this.fullName);
        person.setAge(this.age);
        person.setLaptopList(this.laptopList);
        return person;
    }
}
