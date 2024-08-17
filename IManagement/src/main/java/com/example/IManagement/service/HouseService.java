package com.example.IManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.IManagement.entity.House;
import com.example.IManagement.entity.HouseEntity;
import com.example.IManagement.repository.HouseRepository;

import java.util.List;
import java.util.Optional;

@Service
public class HouseService {

    private final HouseRepository houseRepository;

    @Autowired
    public HouseService(HouseRepository houseRepository) {
        this.houseRepository = houseRepository;
    }

    public List<HouseEntity> getAllHouses() {
        return houseRepository.findAll();
    }

    public Optional<HouseEntity> getHouseById(Integer id) {
        return houseRepository.findById(id);
    }

    @Transactional
    public HouseEntity saveHouse(HouseEntity houseEntity) {
        return houseRepository.save(houseEntity);
    }

    public void deleteHouse(Integer id) {
        houseRepository.deleteById(id);
    }
}
