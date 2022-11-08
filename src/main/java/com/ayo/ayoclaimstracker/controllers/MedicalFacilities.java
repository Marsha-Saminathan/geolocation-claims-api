package com.ayo.ayoclaimstracker.controllers;

import com.ayo.ayoclaimstracker.helpers.BlobStorageHelper;
import com.ayo.ayoclaimstracker.interfaces.services.IFacility;
import com.ayo.ayoclaimstracker.interfaces.services.IFacilityObj;
import com.ayo.ayoclaimstracker.models.Facility;
import com.ayo.ayoclaimstracker.models.FacilityObj;
import com.ayo.ayoclaimstracker.models.ResponseMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microsoft.azure.storage.blob.CloudBlobContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "medicalfacilities", produces = { MediaType.APPLICATION_JSON_VALUE })
public class MedicalFacilities {

	@Autowired
	private IFacility facilityservice;

	@GetMapping
	public List<Facility> GetFacilities(@RequestParam String searchString) {
		List<Facility> result = facilityservice.find("%" + searchString.toLowerCase() + "%");
		return result;
	}

	@PostMapping
	public ResponseEntity<ResponseMessage> uploadFiles(@RequestParam("facility") String facilityAsString,
			@RequestParam("files") MultipartFile[] files) {
		String message = "";
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			List<String> fileNames = new ArrayList<>();
			Facility facility = objectMapper.readValue(facilityAsString, Facility.class);
			BlobStorageHelper storage = new BlobStorageHelper();
			CloudBlobContainer container = storage.GetContainer(facility.getId());

			facilityservice.insertFacility(container, facility, files);
			message = "Uploaded the files successfully: " + fileNames;
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(e.getMessage()));
		}
	}

}
