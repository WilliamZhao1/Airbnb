package com.example.IManagement.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.IManagement.entity.HouseEntity;
import com.example.IManagement.entity.ImageEntity;
import com.example.IManagement.service.HouseService;
import com.example.IManagement.service.ImageService;

import org.springframework.ui.Model;
import net.coobird.thumbnailator.Thumbnails;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ListingController {
	
    @Autowired
    private HouseService houseService;
    
    @Autowired
    private ImageService imageService;
	
	@GetMapping("/page-property-3-col")
	public String getHouseInfo(Model model) {
		List<HouseEntity> houseList = houseService.getAllHouses();
		// Get the list of imageEntity for the thumbnails
		List<ImageEntity> thumbnails = houseList.stream()
                .map(HouseEntity::getId)
                .map(imageService::getThumbnail)
                .collect(Collectors.toList());
		
		// Get the image url of the thumbnails
        List<String> thumbnailList = thumbnails.stream()
                .map(ImageEntity::getImageUrl)
                .collect(Collectors.toList());
        
        thumbnailList.forEach(thumbnail -> System.out.println(thumbnail));
        
        // Make sure the thumbnails are sized correctly
        thumbnailList.forEach(thumbnail -> {
			try {
				resizeImage(thumbnail, 370, 240);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		model.addAttribute("houseList", houseList);
		model.addAttribute("thumbnailList", thumbnailList);
		return "page-property-3-col";
	}
	
	public void resizeImage(String inputFilePath, int width, int height) throws IOException {
	    File inputFile = new File(inputFilePath);
	    
	    // Resize the image and overwrite the original file
	    Thumbnails.of(inputFile)
	              .size(width, height)
	              .outputFormat("jpg")  // Ensure the format is correct; adjust as necessary
	              .toFile(inputFile);
	}
}
