package com.ayo.ayoclaimstracker.repositories;

import com.ayo.ayoclaimstracker.models.Facility;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.math.BigInteger;
import java.util.Date;
import java.util.UUID;

@Repository
public interface FacilityRepository extends CrudRepository<Facility, UUID> {
	

	Iterable<Facility> findAll();

	Iterable<Facility> findByCountryLikeIgnoreCaseOrRegionLikeIgnoreCaseOrDistrictLikeIgnoreCaseOrMunicipalityLikeIgnoreCaseOrNameLikeIgnoreCaseOrTypeLikeIgnoreCaseOrOwnershipLikeIgnoreCaseOrderByNameAsc(
			String country, String region, String district, String municipality, String name, String type,
			String ownership);


	@Transactional
	@Modifying
	@Query(value = "INSERT INTO claimtracker.medicalfacilities("
			+ "id, country, region, district, municipality, name, type, ownership, latitude, longitude, "
			+ "phone_number, claim_type, services, number_of_beds, consultation_fee, admission_fee, attendant, "
			+ "contact_number, facility_fee, burial_fee, storage_fee, embalming_fee, death_registration_fee, "
			+ "burial_type, government_approved, validated, validation_start, validation_end, black_listed)"
			+ "VALUES (?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8, ?9, ?10, ?11, ?12, ?13, ?14, ?15, ?16, ?17, ?18, ?19, ?20, ?21, ?22, ?23, ?24, ?25, ?26, ?27, ?28, ?29)", nativeQuery = true)
	public void insertFacility(UUID id, String country, String region, String district, String municipality,
			String name, String type, String owernership, Double latitude, Double longitude, String phone_number,
			String claim_type, String services, Integer number_of_beds, Long consultation_fee, Long admission_fee,
			String attendant, String contact_number, BigInteger facility_fee, BigInteger burial_fee,
			BigInteger storage_fee, BigInteger embalming_fee, BigInteger death_registration_fee, String burial_type,
			Boolean goverment_approved, Boolean validated, Date validation_start, Date validation_end,
			Boolean blacklisted);

}
