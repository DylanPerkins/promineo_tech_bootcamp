package projects.service;

import java.util.List;
import java.util.NoSuchElementException;

import projects.dao.ProjectDao;
import projects.entity.Project;

public class ProjectService {
    private ProjectDao projectDao = new ProjectDao();

    public Project addProject(Project project) {
        return projectDao.insertProject(project);
    }

    public List<Project> fetchAllProjects() {
        return projectDao.selectAllProjects();
    }

    public Project fetchProjectById(Integer projectId) {
        return projectDao.selectProjectById(projectId).orElseThrow(
                () -> new NoSuchElementException("Project with the specified id (" + projectId + ") does not exist."));
    }

}
