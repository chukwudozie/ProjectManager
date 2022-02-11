package com.emeka.projectmanager.services;

import com.emeka.projectmanager.exceptions.ProjectException;
import com.emeka.projectmanager.model.Project;
import com.emeka.projectmanager.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project saveOrUpdateProject(Project project){

        //todo: Write logic for either save or update

//        Project project1 = projectRepository.findByProjectIdentifier(project.getProjectIdentifier());
//        if(project1 != null){
//            project1.setProjectName(project.getProjectName());
//            project1.setDescription(project.getDescription());
//            project1.setUpdated_At(Date.from(Instant.now()));
//            projectRepository.save(project1);
//        }

        try {
            project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
            return projectRepository.save(project);
        }catch (Exception e){
            throw new ProjectException("Project ID: "+project.getProjectIdentifier().toUpperCase() +" already taken");
        }

    }

    /**
     *We are returning a single project by the project identifier as the value is unique in the DB
     */
    public Project findProjectById(String projectId){
        Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase());
        if(project == null){
            throw new ProjectException("Project ID: "+projectId+" doesn't exist");
        }
        return project;
    }

    public Iterable<Project> findAllProjects(){
        return projectRepository.findAll();
    }

    public void deleteProjectByIdentifier(String projectId){
        Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase());
        if(project == null){
            throw new ProjectException("Project with ID "+projectId+" doesn't exist and cannot be deleted");
        }
        projectRepository.delete(project);
    }

    public Project updateUser(Project project, String projectId){
        Project project1 = projectRepository.findByProjectIdentifier(projectId);
        if(project1 == null){
            throw new ProjectException("No project with ID specified");
        }
        project1.setProjectName(project.getProjectName());
        project1.setDescription(project.getDescription());
        return projectRepository.save(project1);

    }
}
