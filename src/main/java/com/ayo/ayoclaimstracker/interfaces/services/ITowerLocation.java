package com.ayo.ayoclaimstracker.interfaces.services;

import com.ayo.ayoclaimstracker.models.TowerLocation;

import java.util.List;

public interface ITowerLocation {

    List<TowerLocation> find(String searchString);
    List<TowerLocation> findAllTowerLocationsInRange(double latitude, double longitude, double distance);
    void insertTowerLocation(TowerLocation emp);
    void updateTowerLocation(TowerLocation emp);
    void deleteTowerLocation(TowerLocation emp);
}
