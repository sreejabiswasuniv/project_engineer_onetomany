package com.example.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/*
@Author Sreeja Biswas
This is an entity to be saved in oracle database.
*/

@Entity
@Table(name = "projects")
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pid")
	private Long id;

	@Column(name = "pname")
	private String projectName;

	// Unidirectional OneToMany with JoinColumn to store foreign key in engineers
	// table

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "project_id") // Foreign key in engineers table
	private List<Engineer> engineer;

	public Project() {
		super();

	}

	public Project(String projectName, List<Engineer> engineer) {
		super();
		this.projectName = projectName;
		this.engineer = engineer;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public List<Engineer> getEngineer() {
		return engineer;
	}

	public void setEngineer(List<Engineer> engineer) {
		this.engineer = engineer;
	}

	@Override
	public String toString() {
		return "Project [id=" + id + ", projectName=" + projectName + ", engineer=" + engineer + "]";
	}

}
