package com.ayo.ayoclaimstracker.controllers;

import java.util.List;

import com.ayo.ayoclaimstracker.models.ParameterTowersInRange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ayo.ayoclaimstracker.interfaces.services.ITowerLocation;
import com.ayo.ayoclaimstracker.models.ResponseMessage;
import com.ayo.ayoclaimstracker.models.TowerLocation;

@RestController
@RequestMapping(path = "towerlocations", produces = {MediaType.APPLICATION_JSON_VALUE})
public class TowerLocations {


    @Autowired
    private ITowerLocation service;

    @GetMapping
    public List<TowerLocation> GetTowerLocation(@RequestParam String searchString) {
        List<TowerLocation> result = service.find("%" + searchString + "%");
        return result;
    }

    @GetMapping("/towers-in-range")
    public List<TowerLocation> FindAllTowerLocationsInRange(@RequestParam ParameterTowersInRange location) {
        List<TowerLocation> result = service.findAllTowerLocationsInRange(location.getlatitude(), location.getLongitude(), location.getDistance());
        return result;
    }

    @PostMapping
    public ResponseEntity<ResponseMessage> post(@RequestBody TowerLocation location) {
    	String message = "";
    	try {
    		message = "Uploaded the tower location successfully: " + location;
    		service.insertTowerLocation(location);
    		return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
    	}catch(Exception e)
    	{
    		return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(e.getMessage()));
    	}      
    }

}
