package com.ayo.ayoclaimstracker.repositories;

import org.springframework.stereotype.Repository;

import com.ayo.ayoclaimstracker.models.FacilityObj;

@Repository
public interface InvestigationRepositoryCustom {
	
	public void saveInvestigation(String investigation);

}
