package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Project;
import com.example.repository.ProjectRepository;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectRepository projectRepository;
	List<Project> lp = new ArrayList<>();

	public Project saveProject(Project project) {
		return projectRepository.save(project);
	}

	public List<Project> getAllProjects() {
		return projectRepository.findAll();
	}

	public Project getProjectById(Long id) {
		return projectRepository.findById(id).get();
	}

	public Project updateProject(Long id, Project project) {
		Project _temp = projectRepository.findById(id).get();
		_temp.setProjectName(project.getProjectName());
		_temp.setEngineer(project.getEngineer());
		return projectRepository.save(_temp);

	}

	public String deleteProject(Long id) {
		projectRepository.deleteById(id);
		return "The Project with id " + id + " has been deleted!!!";
	}

}
