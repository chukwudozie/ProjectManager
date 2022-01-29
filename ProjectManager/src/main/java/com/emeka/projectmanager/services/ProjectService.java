package com.emeka.projectmanager.services;

import com.emeka.projectmanager.model.Project;
import com.emeka.projectmanager.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project saveOrUpdateProject(Project project){

        //todo: Write logic for either save or update
        return projectRepository.save(project);
    }

}
