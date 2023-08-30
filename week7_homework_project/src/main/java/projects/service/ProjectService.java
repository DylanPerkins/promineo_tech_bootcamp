package projects.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import projects.dao.ProjectDao;
import projects.entity.Project;
import projects.exception.dbException;

public class ProjectService {
    private ProjectDao projectDao = new ProjectDao();

    public Project addProject(Project project) {
        return projectDao.insertProject(project);
    }

    public List<Project> fetchAllProjects() {
        // @formatter:off
        return projectDao.selectAllProjects()
            .stream()
            .sorted((r1, r2) -> r1.getProjectId() - r2.getProjectId())
            .collect(Collectors.toList());
        // @formatter:on
    }

    public Project fetchProjectById(Integer projectId) {
        return projectDao.selectProjectById(projectId).orElseThrow(
                () -> new NoSuchElementException("Project with the specified id (" + projectId + ") does not exist."));
    }

    public void deleteProject(Integer projectId) {
        if (!projectDao.deleteProjectById(projectId)) {
            throw new dbException("Project with the specified id (" + projectId + ") does not exist.");
        }
    }

    public void modifyProjectDetails(Project project) {
        if (!projectDao.modifyProjectDetails(project)) {
            throw new dbException("Project with the specified id (" + project.getProjectId() + ") does not exist.");
        }
    }

}
