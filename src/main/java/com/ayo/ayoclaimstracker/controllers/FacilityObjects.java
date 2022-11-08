package com.ayo.ayoclaimstracker.controllers;


import java.util.ArrayList;
import java.util.List;

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

import com.ayo.ayoclaimstracker.interfaces.services.IFacilityObj;
import com.ayo.ayoclaimstracker.models.FacilityObj;
import com.ayo.ayoclaimstracker.models.ResponseMessage;

@RestController
@RequestMapping(path = "facilities", produces = {MediaType.APPLICATION_JSON_VALUE})
public class FacilityObjects {

    @Autowired
    private IFacilityObj facilityObjservice;

    @GetMapping
    public List<FacilityObj> getFacilities(@RequestParam String searchString) {
        return facilityObjservice.find("%" + searchString.toLowerCase() + "%");
    }

    //get country list
    @GetMapping("/countries")
    public List<String> getCountries() {
        return facilityObjservice.getCountryList();
    }

    @PostMapping("/addfacility")
    public ResponseEntity<ResponseMessage> addFacility(@RequestBody String facility) {
        String message = "";
        System.out.println("Facility To Add" + facility);
        try {
            facilityObjservice.saveFacilityObj(facility);
            message = "Uploaded the Facility";
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(e.getMessage()));
        }

    }
}
