package com.ca.service;

import com.ca.entity.Projects;

import java.util.List;
import java.util.Optional;

public interface ProjectMonitorService {

    public List<Projects> getProjects();

    Projects createProjects(Projects body);

    void deleteProject(Integer id);

    Optional<Projects> getProjectById(Integer id);
}
