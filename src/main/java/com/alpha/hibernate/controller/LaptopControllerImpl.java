package com.alpha.hibernate.controller;

import com.alpha.hibernate.dto.LaptopDto;
import com.alpha.hibernate.entity.Laptop;
import com.alpha.hibernate.service.LaptopService;
import com.alpha.hibernate.view.LaptopView;

import java.util.ArrayList;
import java.util.List;

public class LaptopControllerImpl extends LaptopView implements LaptopController{

    private final LaptopService laptopService;

    public LaptopControllerImpl(LaptopService laptopService){
        this.laptopService = laptopService;
    }

    @Override
    public boolean save(Laptop laptop) {
        LaptopDto laptopDto = new LaptopDto(laptop);
        return laptopService.save(laptopDto);
    }

    @Override
    public boolean update(Laptop laptop) {
        LaptopDto laptopDto = new LaptopDto(laptop);
        return laptopService.update(laptopDto);
    }

    @Override
    public boolean delete(Laptop laptop) {
        LaptopDto laptopDto = new LaptopDto(laptop);
        return laptopService.delete(laptopDto);
    }

    @Override
    public boolean deleteById(Long id) {
        return laptopService.deleteById(id);
    }

    @Override
    public Laptop findById(Long id) {
        LaptopDto laptopDto = laptopService.findById(id);
        if( null == laptopDto ) return null;
        return laptopDto.getEntity();
    }

    @Override
    public List<Laptop> findAll() {
        List<Laptop> laptopList = null;
        List<LaptopDto> laptopDtoList = laptopService.findAll();
        for(LaptopDto laptopDto : laptopDtoList ){
            if( null == laptopList )
                laptopList = new ArrayList<>();
            laptopList.add(laptopDto.getEntity());
        }
        return laptopList;
    }

    @Override
    public void printDetails(List<Laptop> laptops) {
        super.printDetails(laptops);
    }

    @Override
    public void printDetails(Laptop laptop) {
        super.printDetails(laptop);
    }
}
