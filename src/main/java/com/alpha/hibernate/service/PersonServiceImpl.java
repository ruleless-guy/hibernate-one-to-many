package com.alpha.hibernate.service;

import com.alpha.hibernate.dto.PersonDto;
import com.alpha.hibernate.entity.Person;
import com.alpha.hibernate.repository.PersonRepository;

import java.util.ArrayList;
import java.util.List;

public class PersonServiceImpl implements PersonService{

    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    @Override
    public boolean save(PersonDto entity) {
        Person person = entity.getEntity();
        return personRepository.save(person);
    }

    @Override
    public boolean update(PersonDto entity) {
        Person person = entity.getEntity();
        return personRepository.update(person);
    }

    @Override
    public boolean delete(PersonDto entity) {
        Person person = entity.getEntity();
        return personRepository.delete(person);
    }

    @Override
    public boolean deleteById(Long id) {
        return personRepository.deleteById(id);
    }

    @Override
    public PersonDto findById(Long id) {
        Person person = personRepository.findById(id);
        if( null == person ) return null;
        PersonDto personDto = new PersonDto(person);
        return personDto;
    }

    @Override
    public List<PersonDto> findAll() {
        List<PersonDto> personDtoList = null;
        List<Person> personList = personRepository.findAll();
        for(Person p : personList){
            if( null == personDtoList )
                personDtoList = new ArrayList<>();
            personDtoList.add(new PersonDto(p));
        }
        return personDtoList;
    }
}
