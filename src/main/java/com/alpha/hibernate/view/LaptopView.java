package com.alpha.hibernate.view;

import com.alpha.hibernate.entity.Laptop;

import java.util.List;

public class LaptopView extends ViewImpl<Laptop> {

    @Override
    public void printDetails(List<Laptop> laptops) {
        super.printDetails(laptops);
    }

    @Override
    public void printDetails(Laptop laptop) {
        StringBuilder sb = new StringBuilder();
        sb.append("[Laptop -> id = ");
        sb.append(laptop.getId());
        sb.append(", brand = ");
        sb.append(laptop.getBrand());
        sb.append(", description = ");
        if( null == laptop.getDescription() ){
            sb.append("no description");
        }else{
            sb.append(laptop.getDescription());
        }
        sb.append(", person id = ");
        sb.append(laptop.getPerson().getId());
        sb.append("]");

        System.out.println(sb.toString());
    }
}
