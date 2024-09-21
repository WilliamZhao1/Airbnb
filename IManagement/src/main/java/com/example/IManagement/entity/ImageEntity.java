package com.example.IManagement.entity;

import javax.persistence.*;

@Entity
@Table(name = "image")
public class ImageEntity {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String imageUrl;
    private int houseId;  

    // Constructors, getters, and setters    
    public ImageEntity() {}
    
    public ImageEntity(String url) {
    	this.imageUrl = url;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getHouseId() {
        return houseId;
    }

    public void setHouseId(int houseId) {
        this.houseId = houseId;
    }
}
