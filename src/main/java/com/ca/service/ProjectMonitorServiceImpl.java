package com.ca.service;

import com.ca.entity.Projects;
import com.ca.repository.ProjectsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class ProjectMonitorServiceImpl implements ProjectMonitorService {
	final static Logger logger = Logger.getLogger("ProjectMonitorService");
	@Autowired
	ProjectsRepository projectsRepository;

	@Override
	public List<Projects> getProjects() {
		return projectsRepository.findAll();
	}

	@Override
	public Projects createProjects(Projects body) {
		logger.info("post request "+body);
		return projectsRepository.save(body);
	}

	@Override
	public void deleteProject(Integer id) {
		projectsRepository.deleteById(id);
	}

	@Override
	public Optional<Projects> getProjectById(Integer id) {
		return projectsRepository.findById(id);
	}
}
