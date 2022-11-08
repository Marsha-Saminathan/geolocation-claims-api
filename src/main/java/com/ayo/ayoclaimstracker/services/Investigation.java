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
import com.ayo.ayoclaimstracker.interfaces.services.IInvestigation;
import com.ayo.ayoclaimstracker.models.Facility;
import com.ayo.ayoclaimstracker.repositories.FacilityObjRepository;
import com.ayo.ayoclaimstracker.repositories.InvestigationRepository;

@Service
public class Investigation implements IInvestigation {

	private final Path root = Paths.get("uploads");
	String connectStr = System.getenv("AZURE_STORAGE_CONNECTION_STRING");
	@Autowired
	private InvestigationRepository repository;

	@Override
	public List<com.ayo.ayoclaimstracker.models.Investigation> find(String searchString) {
		return (List<com.ayo.ayoclaimstracker.models.Investigation>) repository.find(searchString);
	}

	@Override
	public void updateInvestigation(com.ayo.ayoclaimstracker.models.Investigation emp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void executeUpdateInvestigation(com.ayo.ayoclaimstracker.models.Investigation emp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteInvestigation(com.ayo.ayoclaimstracker.models.Investigation emp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveInvestigation(String investigation) {
		repository.saveInvestigation(investigation);
		
	}

}
