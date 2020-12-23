package com.alpha.hibernate;

import com.alpha.hibernate.controller.LaptopController;
import com.alpha.hibernate.controller.LaptopControllerImpl;
import com.alpha.hibernate.repository.LaptopRepository;
import com.alpha.hibernate.dao.LaptopDao;
import com.alpha.hibernate.dao.PersonDao;
import com.alpha.hibernate.entity.FullName;
import com.alpha.hibernate.entity.Laptop;
import com.alpha.hibernate.entity.Person;
import com.alpha.hibernate.service.LaptopService;
import com.alpha.hibernate.service.LaptopServiceImpl;

import java.util.List;

public class App {
    public static void main( String[] args ) {
//        saveFromPersonDao();
//        saveFromLaptopDao();
        saveFromLaptopController();
    }


    private static void saveFromPersonDao(){
        Person person1 = new Person();
        person1.setFullName(new FullName("Khun","Pyae Phyo Aung"));
        person1.setAge(22);

        Person person2 = new Person();
        person2.setFullName(new FullName("Than Sin","Cho"));
        person2.setAge(22);

        Laptop laptop1 = new Laptop();
        laptop1.setBrand("Dell");
        laptop1.setDescription("Dell i5 5th gen");
        laptop1.setPerson(person1);

        Laptop laptop2 = new Laptop();
        laptop2.setBrand("MacBook");
        laptop2.setDescription("MacBook Pro 2016");
        laptop2.setPerson(person1);

        Laptop laptop3 = new Laptop();
        laptop3.setBrand("Acer");
        laptop3.setDescription("Acer swift 7");
        laptop3.setPerson(person2);

        person1.getLaptopList().add(laptop1);
        person1.getLaptopList().add(laptop2);
        person2.getLaptopList().add(laptop3);

        PersonDao personDao = new PersonDao();

        /*save*/
        personDao.save(person1);
        personDao.save(person2);


        /*retrieve all*/
//        List<Person> personList = personDao.findAll();
//        if( null != personList ){
//            for(Person person : personList){
//                StringBuilder sb = new StringBuilder();
//                sb.append("id = ");
//                sb.append(person.getId());
//                sb.append(", first name = ");
//                sb.append(person.getFullName().getFirstName());
//                sb.append(", last name = ");
//                sb.append(person.getFullName().getLastName());
//                System.out.println(sb.toString());
//            }
//        }


        /*update*/
//        Person person = personDao.findById(2L);
//        if( null!= person){
//            person.setAge(25);
//            personDao.update(person);
//        }


        /*delete by id*/
//        personDao.deleteById(2L);


        //delete
//        Person person = personDao.findById(2L);
//        if( null != person ){
//            personDao.delete(person);
//        }


    }

    private static void saveFromLaptopDao(){
        Person person1 = new Person();
        person1.setFullName(new FullName("Khun","Pyae Phyo Aung"));
        person1.setAge(22);

        Person person2 = new Person();
        person2.setFullName(new FullName("Than Sin","Cho"));
        person2.setAge(22);

        Laptop laptop1 = new Laptop();
        laptop1.setBrand("Dell");
        laptop1.setDescription("Dell i5 5th gen");
        laptop1.setPerson(person1);

        Laptop laptop2 = new Laptop();
        laptop2.setBrand("MacBook");
        laptop2.setDescription("MacBook Pro 2016");
        laptop2.setPerson(person1);

        Laptop laptop3 = new Laptop();
        laptop3.setBrand("Acer");
        laptop3.setDescription("Acer swift 7");
        laptop3.setPerson(person2);

        LaptopDao laptopDao = new LaptopDao();

        //save
        laptopDao.save(laptop1);
        laptopDao.save(laptop2);
        laptopDao.save(laptop3);


        //retrieve all
//        List<Laptop> laptopList = laptopDao.findAll();
//        if(null != laptopList){
//            for(Laptop laptop : laptopList){
//                StringBuilder sb = new StringBuilder();
//                sb.append("Id = ");
//                sb.append(laptop.getId());
//                sb.append(", brand = ");
//                sb.append(laptop.getBrand());
//                sb.append(", person id = ");
//                sb.append(laptop.getPerson().getId());
//                System.out.println(sb.toString());
//            }
//        }


        //retrieve by id
//        Laptop laptop = laptopDao.findById(1L);
//        if( null != laptop){
//            StringBuilder sb = new StringBuilder();
//            sb.append("id = ");
//            sb.append(laptop.getId());
//            sb.append(", brand = ");
//            sb.append(laptop.getBrand());
//            sb.append(", person id = ");
//            sb.append(laptop.getPerson().getId());
//            System.out.println(sb.toString());
//        }

        //update
//        Laptop laptop = laptopDao.findById(2L);
//        if( null != laptop ){
//            laptop.setDescription("Updated");
//            System.out.println(laptopDao.update(laptop)? "updated" : "Not updated");
//        }


        //delete by id
//        System.out.println( laptopDao.deleteById(3L) ? "Deleted" : "Not deleted" );


        //delete by entity
//        Laptop laptop = laptopDao.findById(3L);
//        if( null != laptop ){
//            System.out.println( laptopDao.delete(laptop) ? "Deleted" : "Not deleted" );
//        }


    }

    private static void saveFromLaptopController(){
//        Person person1 = new Person();
//        person1.setFullName(new FullName("Khun","Pyae Phyo Aung"));
//        person1.setAge(22);
//
//        Person person2 = new Person();
//        person2.setFullName(new FullName("Than Sin","Cho"));
//        person2.setAge(22);
//
//        Laptop laptop1 = new Laptop();
//        laptop1.setBrand("Dell");
//        laptop1.setDescription("Dell i5 5th gen");
//        laptop1.setPerson(person1);
//
//        Laptop laptop2 = new Laptop();
//        laptop2.setBrand("MacBook");
//        laptop2.setDescription("MacBook Pro 2016");
//        laptop2.setPerson(person1);
//
//        Laptop laptop3 = new Laptop();
//        laptop3.setBrand("Acer");
//        laptop3.setDescription("Acer swift 7");
//        laptop3.setPerson(person2);

        LaptopRepository laptopRepository = new LaptopDao();
        LaptopService laptopService = new LaptopServiceImpl(laptopRepository);
        LaptopController laptopController = new LaptopControllerImpl(laptopService);

        //save
//        laptopController.save(laptop1);
//        laptopController.save(laptop2);
//        laptopController.save(laptop3);

        //retrieve all
//        List<Laptop> laptopList = laptopController.findAll();
//        laptopController.printDetails(laptopList);


        //retrieve by id
//        Laptop laptop = laptopController.findById(1L);
//        if( null != laptop ){
//            laptopController.printDetails(laptop);
//        }


        //delete by id
//        laptopController.deleteById(3L);


        //delete by entity error
//        Laptop laptop = laptopController.findById(1L);
//        if( null != laptop ){
//            laptopController.delete(laptop);
//        }


        //delete by entity
//        Laptop laptop = laptopController.findById(1L);
//        if( null != laptop ){
//            laptopController.deleteById(laptop.getId());
//        }



        //update
//        Laptop laptop = laptopController.findById(2L);
//        if( null != laptop ){
//            laptop.setDescription("Updated");
//            System.out.println(laptopController.update(laptop));
//        }

    }

}
