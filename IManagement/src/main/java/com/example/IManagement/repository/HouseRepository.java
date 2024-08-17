package com.example.IManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.IManagement.entity.House;
import com.example.IManagement.entity.HouseEntity;

public interface HouseRepository extends JpaRepository<HouseEntity, Integer> {
}
