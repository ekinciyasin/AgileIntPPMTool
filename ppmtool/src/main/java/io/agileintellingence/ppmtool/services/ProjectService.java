package io.agileintellingence.ppmtool.services;

import io.agileintellingence.ppmtool.domain.Project;
import io.agileintellingence.ppmtool.exception.ProjectIdExeption;
import io.agileintellingence.ppmtool.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class ProjectService {

    @Autowired private ProjectRepository projectRepository;

    public Project saveOrUpdateProject(Project project){
    try {
        project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase(Locale.ROOT));
        return projectRepository.save(project);
    }catch(Exception e) {
        throw new ProjectIdExeption("Project ID '" +project.getProjectIdentifier().toUpperCase(Locale.ROOT)+"' already exists.");
    }
    }
    public Project findProjectIdentifier(String projectId){
        Project project = projectRepository.findByProjectIdentifier(projectId);
        if (project == null){
            throw new ProjectIdExeption("Project ID " + projectId + " does not exist.");
        }
        return project;
    }
    public Iterable<Project> findAllProjects(){
        return projectRepository.findAll();
    }
    public void deleteProjectByIdentifier(String projectId){
        Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase());
        if(project == null){
            throw new ProjectIdExeption("Project ID " + projectId + " does not exist.");
        }
        projectRepository.delete(project);
    }


}
