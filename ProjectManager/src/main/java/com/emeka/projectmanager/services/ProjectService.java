package com.emeka.projectmanager.services;

import com.emeka.projectmanager.exceptions.ProjectException;
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

        try {
            project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
            return projectRepository.save(project);
        }catch (Exception e){
            throw new ProjectException("Project ID: "+project.getProjectIdentifier().toUpperCase() +" already taken");
        }

    }

}
