package com.ayo.ayoclaimstracker.repositories;

import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.query.NativeQuery;
import org.springframework.stereotype.Repository;

import com.ayo.ayoclaimstracker.models.FacilityObj;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;


public class InvestigationRepositoryCustomImpl implements InvestigationRepositoryCustom {

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public void saveInvestigation(String investigation) {
		entityManager.createNativeQuery(
				"INSERT INTO claimtracker.investigations (investigationid,investigationobj) VALUES (:investigationid,:investigationObj)")
				.unwrap(NativeQuery.class).setParameter("investigationid", UUID.randomUUID())
				.setParameter("investigationObj", investigation, JsonBinaryType.INSTANCE).executeUpdate();
	}
}
