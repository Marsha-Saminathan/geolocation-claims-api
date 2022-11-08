package com.ayo.ayoclaimstracker.repositories;

import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.query.NativeQuery;
import org.springframework.stereotype.Repository;

import com.ayo.ayoclaimstracker.models.FacilityObj;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;


public class FacilityObjRepositoryCustomImpl implements FacilityObjRepositoryCustom {

	@PersistenceContext
	private EntityManager entityManager;
	

	@Transactional
	public void saveFacilityObj(String facilityObj) {
		entityManager.createNativeQuery(
				"INSERT INTO claimtracker.facilities (facilityid,facilityobj) VALUES (:facilityid,:facilityObj)")
				.unwrap(NativeQuery.class).setParameter("facilityid", UUID.randomUUID())
				.setParameter("facilityObj", facilityObj, JsonBinaryType.INSTANCE).executeUpdate();
	}

	public void insertWithEntityManager(FacilityObj facilityObj) {
	    this.entityManager.persist(facilityObj);
	}

}
