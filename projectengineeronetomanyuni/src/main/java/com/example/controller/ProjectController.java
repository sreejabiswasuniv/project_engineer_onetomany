package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Project;
import com.example.service.ProjectServiceImpl;

@RestController
public class ProjectController {

	@Autowired
	private ProjectServiceImpl projectServiceImpl;

	@PostMapping("/projects")
	public ResponseEntity<Project> addProject(@RequestBody Project project) {
		try {
			if (project == null) {
				return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
			}
			Project savedProject = projectServiceImpl.saveProject(project);
			return new ResponseEntity<>(savedProject, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/projects")
	public List<Project> getAll() {
		return projectServiceImpl.getAllProjects();
	}

	@GetMapping("/projectById")
	public ResponseEntity<Project> getOneProject(@RequestParam Long id) {
		try {
			if (id == null) {
				return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
			}
			Project fetchedProject = projectServiceImpl.getProjectById(id);
			return new ResponseEntity<>(fetchedProject, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/projects")
	public ResponseEntity<Project> updateOneProject(@RequestParam Long id, @RequestBody Project project) {
		try {
			if (id == null || project == null) {
				return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
			}
			Project updatedProject = projectServiceImpl.updateProject(id, project);
			return new ResponseEntity<>(updatedProject, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/projects")
	public ResponseEntity<String> deleteOneProject(@RequestParam Long id) {
		try {
			if (id == null) {
				return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
			}
			String response = projectServiceImpl.deleteProject(id);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
