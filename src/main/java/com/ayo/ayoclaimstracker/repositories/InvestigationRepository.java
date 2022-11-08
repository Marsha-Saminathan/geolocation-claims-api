package com.ayo.ayoclaimstracker.repositories;

import com.ayo.ayoclaimstracker.models.Investigation;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface InvestigationRepository extends CrudRepository<Investigation, UUID>, InvestigationRepositoryCustom {

	Iterable<Investigation> findAll();

	@Query(value = "SELECT * FROM claimtracker.investigations WHERE (LOWER(investigationobj ->>'claimNumber')) LIKE :search "
			+ "OR (LOWER(investigationobj ->>'MSISDN_mobileNumber')) LIKE :search "
			+ "OR (LOWER(investigationobj ->>'eventLocation')) LIKE :search ", nativeQuery = true)
	Iterable<Investigation> find(@Param("search") String search);

}
