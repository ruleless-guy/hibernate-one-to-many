package com.alpha.hibernate.view;

import com.alpha.hibernate.entity.Laptop;
import com.alpha.hibernate.entity.Person;

import java.util.List;

public class PersonView extends ViewImpl<Person>{

    @Override
    public void printDetails(List<Person> people) {
        super.printDetails(people);
    }

    @Override
    public void printDetails(Person person) {
        StringBuilder sb = new StringBuilder();
        sb.append("[Person -> id = ");
        sb.append(person.getId());
        sb.append(", first name = ");
        sb.append(person.getFullName().getFirstName());
        sb.append(", last name = ");
        sb.append(person.getFullName().getLastName());
        sb.append(", age = ");
        if( null == person.getAge()){
            sb.append("unknown");
        }else{
            sb.append(person.getAge());
        }

        sb.append(", laptop id = ");
        List<Laptop> laptopList = person.getLaptopList();
        if( null == laptopList){
            sb.append("no laptop");
        }else{
            for(int i = 0; i < laptopList.size(); i++){
                sb.append(laptopList.get(i));
                if( i < laptopList.size() - 1){
                    sb.append(", ");
                }
            }
        }

        sb.append("]");

        System.out.println(sb.toString());
    }
}
