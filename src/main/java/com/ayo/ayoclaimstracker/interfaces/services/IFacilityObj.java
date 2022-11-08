package com.ayo.ayoclaimstracker.interfaces.services;

import java.util.List;

import com.ayo.ayoclaimstracker.models.Facility;
import com.ayo.ayoclaimstracker.models.FacilityObj;

public interface IFacilityObj {

	List<FacilityObj> find(String searchString);
	
	List<FacilityObj> getAll();

	List<String> getCountryList();

	void updateFacilityObj(Facility emp);

	void executeUpdateFacilityObj(Facility emp);

	void deleteFacilityObj(Facility emp);

	void saveFacilityObj(String facilityobj);

}
