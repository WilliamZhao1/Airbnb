package com.example.IManagement.controller;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.IManagement.entity.House;
import com.example.IManagement.entity.HouseEntity;
import com.example.IManagement.entity.ImageEntity;
import com.example.IManagement.service.HouseService;
import com.example.IManagement.service.ImageService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class AddPropertyController {

    @Autowired
    private HouseService houseService;
    
    @Autowired
    private ImageService imageService;
	
	@CrossOrigin(origins = "http://127.0.0.1:5500")
    @PostMapping(value = "/uploadProperty")
    public String uploadProperty(@RequestParam("formData") String formData,
    		  @RequestParam(name = "pictures", required = false) MultipartFile[] pictures) throws Exception {
    	
		System.out.println(formData);
    	ObjectMapper objectMapper = new ObjectMapper();
    	HouseEntity newHouse = objectMapper.readValue(formData, HouseEntity.class);
    	
        System.out.println("Received title: " + newHouse.getTitle());
        System.out.println("Received amenities: " + newHouse.getHouseAmenity());
        
        houseService.saveHouse(newHouse);

        // Process pictures
        String folderName = newHouse.getTitle() + "-" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        String directoryPath = "D:\\eclipse\\workspace\\IManagement\\src\\main\\resources\\static\\images\\listings\\" + folderName;
        
        if (pictures != null && pictures.length > 0) {
            File directory = new File(directoryPath);
            if (!directory.exists()) {
                directory.mkdirs();  // Create the directory if it doesn't exist
            }

            for (MultipartFile file : pictures) {
                if (!file.isEmpty()) {
                    try {
                        // Define the path for each file
                        Path filePath = Paths.get(directoryPath, file.getOriginalFilename());
                        
                        // Save the file to the specified path
                        file.transferTo(filePath);
                        
                        // Save the file path to the database
                        ImageEntity newImage = new ImageEntity();
                        newImage.setHouseId(newHouse.getId());
                        newImage.setImageUrl("images/listings/" + folderName + "/" + file.getOriginalFilename());
                        System.out.println("Saved: " + "images/listings/" + folderName + "/" + file.getOriginalFilename());
                        imageService.saveImage(newImage);
                    } catch (Exception e) {
                        e.printStackTrace();
                        return "Error uploading files";
                    }
                }
            }
        }
        return "Property listing uploaded successfully";
    }
}
