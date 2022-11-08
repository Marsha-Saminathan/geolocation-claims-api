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
@Table(name = "investigations", schema = "claimtracker")

public class Investigation {

	public Investigation(){
	}
	@Id
	public String investigationid;

	@Type(type = "jsonb")
	@Column(columnDefinition = "jsonb")
	@Basic(fetch = FetchType.LAZY)
	public String investigationobj;

	public String getId() {
		return investigationid;
	}

	public void setId(String id) {
		this.investigationid = id;
	}

	public String getInvestigationData() {
		return investigationobj;
	}

	public void setINvestigationData(String investigationobj) {
		this.investigationobj = investigationobj;
	}

}