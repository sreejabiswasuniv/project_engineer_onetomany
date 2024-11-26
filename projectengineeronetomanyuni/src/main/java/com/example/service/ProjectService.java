package com.example.service;

import java.util.List;

import com.example.entity.Project;

public interface ProjectService {

	Project saveProject(Project project);

	List<Project> getAllProjects();

	Project getProjectById(Long id);

	Project updateProject(Long id, Project project);

	String deleteProject(Long id);

}
