package com.example.IManagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.IManagement.entity.ImageEntity;

public interface ImageRepository extends JpaRepository<ImageEntity, Integer> {
	List<ImageEntity> findByHouseId(int houseId);
}

