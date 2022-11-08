package com.ayo.ayoclaimstracker.repositories;

import com.ayo.ayoclaimstracker.models.FacilityObj;

import org.hibernate.query.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

import javax.transaction.Transactional;

@Repository
public interface FacilityObjRepository extends CrudRepository<FacilityObj, UUID>, FacilityObjRepositoryCustom {

	@Query(value = "SELECT * FROM claimtracker.facilities WHERE (LOWER(facilityobj ->>'country')) LIKE :search "
			+ "OR (LOWER(facilityobj ->>'region')) LIKE :search "
			+ "OR (LOWER(facilityobj ->>'district')) LIKE :search "
			+ "OR (LOWER(facilityobj ->>'municipality')) LIKE :search "
			+ "OR (LOWER(facilityobj ->>'name')) LIKE :search " + "OR (LOWER(facilityobj ->>'type')) LIKE :search "
			+ "OR (LOWER(facilityobj ->>'ownership')) LIKE :search "
			+ "OR (LOWER(facilityobj ->>'blacklisted')) LIKE :search ", nativeQuery = true)
	Iterable<FacilityObj> find(@Param("search") String search);

	@Query(value = "SELECT * FROM claimtracker.facilities", nativeQuery = true)
	Iterable<FacilityObj> findAll();

	@Query(value = "SELECT DISTINCT facilityobj ->>'country' FROM claimtracker.facilities", nativeQuery = true)
	Iterable<String> getCountryList();

}
