package com.ayo.ayoclaimstracker.models;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;

@Entity
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
@Table(name = "facilities", schema = "claimtracker")

public class FacilityObj {

	public FacilityObj(){
	}
	@Id
	public String facilityid;

	@Type(type = "jsonb")
	@Column(columnDefinition = "jsonb")
	@Basic(fetch = FetchType.LAZY)
	public String facilityobj;

	public String getId() {
		return facilityid;
	}

	public void setId(String id) {
		this.facilityid = id;
	}

	public String getFacilityData() {
		return facilityobj;
	}

	public void setFacilityData(String facilityobj) {
		this.facilityobj = facilityobj;
	}

}