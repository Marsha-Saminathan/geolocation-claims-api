package com.ayo.ayoclaimstracker.interfaces.services;

import java.util.List;

import com.ayo.ayoclaimstracker.models.Facility;
import com.ayo.ayoclaimstracker.models.FacilityObj;
import com.ayo.ayoclaimstracker.models.Investigation;

public interface IInvestigation {

	List<Investigation> find(String searchString);

	void updateInvestigation(Investigation emp);

	void executeUpdateInvestigation(Investigation emp);

	void deleteInvestigation(Investigation emp);

	void saveInvestigation(String investigation);

}
