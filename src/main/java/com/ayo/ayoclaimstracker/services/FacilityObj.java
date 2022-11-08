package com.ayo.ayoclaimstracker.services;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayo.ayoclaimstracker.interfaces.services.IFacilityObj;
import com.ayo.ayoclaimstracker.models.Facility;
import com.ayo.ayoclaimstracker.repositories.FacilityObjRepository;

@Service
public class FacilityObj implements IFacilityObj {

	private final Path root = Paths.get("uploads");
	String connectStr = System.getenv("AZURE_STORAGE_CONNECTION_STRING");
	@Autowired
	private FacilityObjRepository repository;

	@Override
	public List<String> getCountryList() {
		return (List<String>) repository.getCountryList();
	}

	@Override
	public List<com.ayo.ayoclaimstracker.models.FacilityObj> getAll() {
		return (List<com.ayo.ayoclaimstracker.models.FacilityObj>) repository.findAll();
	}
	
	@Override
	public List<com.ayo.ayoclaimstracker.models.FacilityObj> find(String searchString) {
		return (List<com.ayo.ayoclaimstracker.models.FacilityObj>) repository.find(searchString);
	}

	@Override
	public void updateFacilityObj(com.ayo.ayoclaimstracker.models.Facility emp) {

	}

	@Override
	public void executeUpdateFacilityObj(com.ayo.ayoclaimstracker.models.Facility emp) {

	}

	@Override
	public void deleteFacilityObj(com.ayo.ayoclaimstracker.models.Facility emp) {

	}

	@Override
	public void saveFacilityObj(String facilityObj) {
		repository.saveFacilityObj(facilityObj);

	}

}
