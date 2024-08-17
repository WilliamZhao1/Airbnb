package com.example.IManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.IManagement.entity.HouseEntity;
import com.example.IManagement.entity.ImageEntity;
import com.example.IManagement.repository.ImageRepository;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    public void saveImage(ImageEntity imageEntity) {
        imageRepository.save(imageEntity);
    }
    
    public List<ImageEntity> getAllImagesForHouse(int houseId) {
        return imageRepository.findByHouseId(houseId);
    }
    
    public ImageEntity getThumbnail(int houseId) {
        List<ImageEntity> images = imageRepository.findByHouseId(houseId);
        for (ImageEntity image : images) {
            if (image.getImageUrl().contains("thumbnail")) {
                return image;
            }
        }
        return new ImageEntity("images/listings/g1-1.jpg"); // or throw an exception if a thumbnail must exist
    }
}
