package com.alpha.hibernate.dto;

import com.alpha.hibernate.entity.BaseEntity;
import com.alpha.hibernate.entity.Laptop;
import com.alpha.hibernate.entity.Person;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LaptopDto extends BaseEntity<Long> implements Dto<Laptop> {

    private String brand;
    private String description;
    private Person person;

    public LaptopDto(Laptop laptop){
        super.setId(laptop.getId());
        this.brand = laptop.getBrand();
        this.description = laptop.getDescription();
        this.person = laptop.getPerson();
    }

    @Override
    public Laptop getEntity() {
        Laptop laptop = new Laptop();
        laptop.setId(super.getId());
        laptop.setBrand(this.brand);
        laptop.setDescription(this.description);
        laptop.setPerson(this.person);
        return laptop;
    }
}
