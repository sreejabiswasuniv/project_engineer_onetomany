package com.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/*
@Author Sreeja Biswas
This is an entity to be saved in oracle database.
*/

@Entity
@Table(name = "engineers")
public class Engineer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "engineerID")
	private Long eid;

	@Column(name = "ename")
	private String engineerName;

	public Engineer() {
		super();

	}

	public Engineer(String engineerName) {
		super();
		this.engineerName = engineerName;
	}

	public Long getEid() {
		return eid;
	}

	public void setEid(Long eid) {
		this.eid = eid;
	}

	public String getEngineerName() {
		return engineerName;
	}

	public void setEngineerName(String engineerName) {
		this.engineerName = engineerName;
	}

	@Override
	public String toString() {
		return "Engineer [eid=" + eid + ", engineerName=" + engineerName + "]";
	}

}
