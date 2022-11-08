package com.ayo.ayoclaimstracker.controllers;


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
import com.ayo.ayoclaimstracker.interfaces.services.IInvestigation;
import com.ayo.ayoclaimstracker.models.FacilityObj;
import com.ayo.ayoclaimstracker.models.Investigation;
import com.ayo.ayoclaimstracker.models.ResponseMessage;

@RestController
@RequestMapping(path = "investigations", produces = { MediaType.APPLICATION_JSON_VALUE })
public class Investigations {

	@Autowired
	private IInvestigation investigationService;

	@GetMapping
	public List<Investigation> getFacility(@RequestParam String searchString) {
		List<Investigation> result = investigationService.find("%" + searchString.toLowerCase() + "%");
		return result;
	}

	@PostMapping("/addinvestigation")
	public ResponseEntity<ResponseMessage> addInvestigation(@RequestBody String investigation) {
		String message = "";
		System.out.println("Investigation To Add" + investigation);
		try {
			investigationService.saveInvestigation(investigation);
			message = "Uploaded the Investigation";
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(e.getMessage()));
		}

	}
}
