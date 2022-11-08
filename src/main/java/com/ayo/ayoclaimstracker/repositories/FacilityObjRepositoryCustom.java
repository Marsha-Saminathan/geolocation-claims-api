package com.ayo.ayoclaimstracker.repositories;

import org.springframework.stereotype.Repository;

import com.ayo.ayoclaimstracker.models.FacilityObj;

@Repository
public interface FacilityObjRepositoryCustom {
	
	public void saveFacilityObj(String facility);
	

}
