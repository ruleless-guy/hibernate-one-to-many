package com.alpha.hibernate.service;

import com.alpha.hibernate.dto.LaptopDto;
import com.alpha.hibernate.entity.Laptop;
import com.alpha.hibernate.repository.LaptopRepository;

import java.util.ArrayList;
import java.util.List;

public class LaptopServiceImpl implements LaptopService{

    private final LaptopRepository laptopRepository;

    public LaptopServiceImpl(LaptopRepository laptopRepository){
        this.laptopRepository = laptopRepository;
    }

    @Override
    public boolean save(LaptopDto entity) {
        Laptop laptop = entity.getEntity();
        return laptopRepository.save(laptop);
    }

    @Override
    public boolean update(LaptopDto entity) {
        Laptop laptop = entity.getEntity();
        return laptopRepository.update(laptop);
    }

    @Override
    public boolean delete(LaptopDto entity) {
        Laptop laptop = entity.getEntity();
        return laptopRepository.delete(laptop);
    }

    @Override
    public boolean deleteById(Long id) {
        return laptopRepository.deleteById(id);
    }

    @Override
    public LaptopDto findById(Long id) {
        Laptop laptop = laptopRepository.findById(id);
        if( null == laptop ) return null;
        LaptopDto laptopDto = new LaptopDto(laptop);
        return laptopDto;
    }

    @Override
    public List<LaptopDto> findAll() {
        List<LaptopDto> laptopDtoList = null;
        List<Laptop> laptopList = laptopRepository.findAll();
        for (Laptop laptop : laptopList ){
            if( null == laptopDtoList )
                laptopDtoList = new ArrayList<>();
            laptopDtoList.add(new LaptopDto(laptop));
        }
        return laptopDtoList;
    }
}
