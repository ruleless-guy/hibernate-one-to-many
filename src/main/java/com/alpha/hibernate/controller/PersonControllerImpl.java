package com.alpha.hibernate.controller;

import com.alpha.hibernate.dto.PersonDto;
import com.alpha.hibernate.entity.Person;
import com.alpha.hibernate.service.PersonService;
import com.alpha.hibernate.view.PersonView;

import java.util.ArrayList;
import java.util.List;

public class PersonControllerImpl extends PersonView implements PersonController{

    private final PersonService personService;

    public PersonControllerImpl(PersonService personService){
        this.personService = personService;
    }

    @Override
    public boolean save(Person person) {
        PersonDto personDto = new PersonDto(person);
        return personService.save(personDto);
    }

    @Override
    public boolean update(Person person) {
        PersonDto personDto = new PersonDto(person);
        return personService.update(personDto);
    }

    @Override
    public boolean delete(Person person) {
        PersonDto personDto = new PersonDto(person);
        return personService.delete(personDto);
    }

    @Override
    public boolean deleteById(Long id) {
        return personService.deleteById(id);
    }

    @Override
    public Person findById(Long id) {
        PersonDto personDto = personService.findById(id);
        if( null == personDto ) return null;
        return personDto.getEntity();
    }

    @Override
    public List<Person> findAll() {
        List<Person> personList = null;
        List<PersonDto> personDtoList = personService.findAll();
        for(PersonDto personDto : personDtoList ){
            if( null == personList )
                personList = new ArrayList<>();
            personList.add(personDto.getEntity());
        }
        return personList;
    }

    @Override
    public void printDetails(Person person) {
        super.printDetails(person);
    }

    @Override
    public void printDetails(List<Person> people) {
        super.printDetails(people);
    }
}
