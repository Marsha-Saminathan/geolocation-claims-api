package com.ayo.ayoclaimstracker.models;


import java.util.UUID;

import javax.persistence.*;

@Entity
@Table(name = "tower_locations", schema="claimtracker")
public class TowerLocation {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;
  private String baseStation;
  private String towerNumber;
  private String siteName;
  private String region;
  private String district;
  private String municipality;
  private double latitude;
  private double longitude;


  public UUID getId() {
    return this.id;
  }

  public void setId(UUID id) {
    this.id = id;
  }


  public String getBaseStation() {
    return baseStation;
  }

  public void setBaseStation(String baseStation) {
    this.baseStation = baseStation;
  }


  public String getTowerNumber() {
    return towerNumber;
  }

  public void setTowerNumber(String towerNumber) {
    this.towerNumber = towerNumber;
  }


  public String getSiteName() {
    return siteName;
  }

  public void setSiteName(String siteName) {
    this.siteName = siteName;
  }


  public String getDistrict() {
    return district;
  }

  public void setDistrict(String district) {
    this.district = district;
  }


  public String getRegion() {
    return region;
  }

  public void setRegion(String region) {
    this.region = region;
  }


  public String getMunicipality() {
    return municipality;
  }

  public void setMunicipality(String municipality) {
    this.municipality = municipality;
  }


  public double getLatitude() {
    return latitude;
  }

  public void setLatitude(double latitude) {
    this.latitude = latitude;
  }


  public double getLongitude() {
    return longitude;
  }

  public void setLongitude(double logitude) {
    this.longitude = logitude;
  }

}
