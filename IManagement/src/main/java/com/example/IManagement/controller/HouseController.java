package com.example.IManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.IManagement.entity.House;
//import com.example.IManagement.service.HouseService;

import java.util.List;

//@RestController
//@RequestMapping("/houses")
//public class HouseController {
//
//    private final HouseService houseService;
//
//    @Autowired
//    public HouseController(HouseService houseService) {
//        this.houseService = houseService;
//    }
//
//    @GetMapping
//    public ResponseEntity<List<House>> getAllHouses() {
//        List<House> houses = houseService.getAllHouses();
//        return ResponseEntity.ok(houses);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<House> getHouseById(@PathVariable Integer id) {
//        return houseService.getHouseById(id)
//                .map(ResponseEntity::ok)
//                .orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
//    @PostMapping
//    public ResponseEntity<House> createHouse(@RequestBody House house) {
//        House savedHouse = houseService.saveHouse(house);
//        return ResponseEntity.ok(savedHouse);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteHouse(@PathVariable Integer id) {
//        houseService.deleteHouse(id);
//        return ResponseEntity.ok().build();
//    }
//}
