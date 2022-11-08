package com.ayo.ayoclaimstracker.services;

import com.ayo.ayoclaimstracker.interfaces.services.ITowerLocation;
import com.ayo.ayoclaimstracker.repositories.TowerLocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TowerLocation implements ITowerLocation {

    @Autowired
    private TowerLocationRepository repository;

    @Override
    public List<com.ayo.ayoclaimstracker.models.TowerLocation> find(String searchString) {
        return (List<com.ayo.ayoclaimstracker.models.TowerLocation>) repository.findByBaseStationLikeIgnoreCaseOrTowerNumberLikeIgnoreCaseOrSiteNameLikeIgnoreCaseOrDistrictLikeIgnoreCaseOrRegionLikeIgnoreCaseOrMunicipalityLikeIgnoreCase(searchString, searchString, searchString, searchString, searchString, searchString);
    }

    @Override
    public List<com.ayo.ayoclaimstracker.models.TowerLocation> findAllTowerLocationsInRange(double latitude, double longitude, double distance) {
        return (List<com.ayo.ayoclaimstracker.models.TowerLocation>) repository.findAllTowerLocationsInRange(latitude, longitude, distance);
    }

	@Override
	public void insertTowerLocation(com.ayo.ayoclaimstracker.models.TowerLocation emp) {
		
		repository.insertTowerLocation(emp.getId(), emp.getBaseStation(), emp.getTowerNumber(), emp.getSiteName(), emp.getDistrict(),
				emp.getRegion(), emp.getMunicipality(), emp.getLatitude(), emp.getLongitude());
	}
	
	@Override
	public void updateTowerLocation(com.ayo.ayoclaimstracker.models.TowerLocation emp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteTowerLocation(com.ayo.ayoclaimstracker.models.TowerLocation emp) {
		// TODO Auto-generated method stub
		
	}

}
