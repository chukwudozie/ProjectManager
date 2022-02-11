package com.emeka.projectmanager.controller;

import com.emeka.projectmanager.model.Project;
import com.emeka.projectmanager.services.ErrorValidationService;
import com.emeka.projectmanager.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private ErrorValidationService validationService;

    @PostMapping
    public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project, BindingResult result){
        ResponseEntity<?> errorMap = validationService.validate(result);
        if(errorMap != null) return errorMap;
        Project project1 = projectService.saveOrUpdateProject(project);
        return  new ResponseEntity<>(project1, HttpStatus.CREATED);
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<?> findProjectById(@PathVariable String projectId){
        Project project = projectService.findProjectById(projectId);
        return new ResponseEntity<>(project,HttpStatus.OK);
    }

    @GetMapping
    public Iterable<Project> getAllProjects(){
        return projectService.findAllProjects();
    }

    @DeleteMapping("/{projectId}")
    public ResponseEntity<?> deleteProjectByIdentifier(@PathVariable String projectId){
        projectService.deleteProjectByIdentifier(projectId);
        return new ResponseEntity<>("Project with ID: " + projectId + " deleted", HttpStatus.OK);
    }

    @PutMapping("/{projectId}")
    public Project updateProject(@RequestBody Project project, @PathVariable String projectId){
       return projectService.updateUser(project,projectId);
    }
}
