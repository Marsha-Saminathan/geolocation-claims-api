package com.ayo.ayoclaimstracker.models;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@Table(name = "medicalfacilities", schema = "claimtracker")
public class Facility {

	public Facility() {
	}

	@Id
    private String id;
    private String country;
    private String region;
    private String district;
    private String municipality;
    private String name;
    private String type;
    private String ownership;
    private String latitude;
    private String longitude;
    private String phoneNumber;
    private String claimType;
    private String services;
    private Integer numberOfBeds;
    private Long consultationFee;
    private Long admissionFee;
    private String burialType;
    private String attendant;
    private String contactNumber;
    private Long facilityFee;
    private Long burialFee;
    private Long storageFee;
    private Long embalmingFee;
    private Long deathRegistrationFee = (long) 0;
    private Boolean governmentApproved;
    private Boolean validated;
    private java.sql.Date validationStart;
    private java.sql.Date validationEnd;
    private Boolean blackListed;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }


    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }


    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }


    public String getMunicipality() {
        return municipality;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public String getOwnership() {
        return ownership;
    }

    public void setOwnership(String ownership) {
        this.ownership = ownership;
    }


    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }


    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    public String getClaimType() {
        return claimType;
    }

    public void setClaimType(String claimType) {
        this.claimType = claimType;
    }


    public String getServices() {
        return services;
    }

    public void setServices(String services) {
        this.services = services;
    }


    public Integer getNumberOfBeds() {
        return numberOfBeds;
    }

    public void setNumberOfBeds(Integer numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }


    public Long getConsultationFee() {
        return consultationFee;
    }

    public void setConsultationFee(Long consultationFee) {
        this.consultationFee = consultationFee;
    }


    public Long getAdmissionFee() {
        return admissionFee;
    }

    public void setAdmissionFee(Long admissionFee) {
        this.admissionFee = admissionFee;
    }

    public String getBurialType() {
        return burialType;
    }

    public void setBurialType(String burialType) {
        this.burialType = burialType;
    }

    public String getAttendant() {
        return attendant;
    }

    public void setAttendant(String attendant) {
        this.attendant = attendant;
    }


    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }


    public Long getFacilityFee() {
        return facilityFee;
    }

    public void setFacilityFee(Long facilityFee) {
        this.facilityFee = facilityFee;
    }


    public Long getBurialFee() {
        return burialFee;
    }

    public void setBurialFee(Long burialFee) {
        this.burialFee = burialFee;
    }


    public Long getStorageFee() {
        return storageFee;
    }

    public void setStorageFee(Long storageFee) {
        this.storageFee = storageFee;
    }


    public Long getEmbalmingFee() {
        return embalmingFee;
    }

    public void setEmbalmingFee(Long embalmingFee) {
        this.embalmingFee = embalmingFee;
    }


    public Long getDeathRegistrationFee() {
        return deathRegistrationFee;
    }

    public void setDeathRegistrationFee(Long deathRegistrationFee) {
        this.deathRegistrationFee = deathRegistrationFee;
    }

    public Boolean getGovernmentApproved() {
        return governmentApproved;
    }

    public void setGovernmentApproved(Boolean governmentApproved) {
        this.governmentApproved = governmentApproved;
    }


    public Boolean getValidated() {
        return validated;
    }

    public void setValidated(Boolean validated) {
        this.validated = validated;
    }


    public java.sql.Date getValidationStart() {
        return validationStart;
    }

    public void setValidationStart(java.sql.Date validationStart) {
        this.validationStart = validationStart;
    }


    public java.sql.Date getValidationEnd() {
        return validationEnd;
    }

    public void setValidationEnd(java.sql.Date validationEnd) {
        this.validationEnd = validationEnd;
    }


    public Boolean getBlackListed() {
        return blackListed;
    }

    public void setBlackListed(Boolean blackListed) {
        this.blackListed = blackListed;
    }

}
