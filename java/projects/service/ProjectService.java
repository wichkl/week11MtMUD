package projects.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import projects.dao.ProjectDao;
import projects.entity.Project;
import projects.exception.DbException;

public class ProjectService {

	private ProjectDao projectDao = new ProjectDao();
		//a passthrough to the DAO layer
	public Project addProject(Project project) {
		return projectDao.insertProject(project);
	}
		//a passthrough to the DAO layer
	public List<Project> fetchAllProjects() {
		return projectDao.fetchAllProjects();
	}
		//a passthrough to the DAO layer
	public Project fetchProjectById(Integer projectId) {
		return projectDao.fetchProjectById(projectId).orElseThrow(() -> new NoSuchElementException("Project with project ID=" + projectId + " does not exist."));
	}
		//call the DAO to update and return details to the method call
	public void modifyProjectDetails(Project project) {
		if(!projectDao.modifyProjectDeatils(project)) {
			throw new DbException("Project with ID=" + project.getProjectId() + " does not exist.");
		}
		
	}
		//a passthrough to the DAO layer upon entering an existing project ID
	public void deleteProject(Integer projectId) {
		if(!projectDao.deleteProject(projectId)) {
			throw new DbException("Project with ID=" + projectId + "does not exist.");
		}
		
	}

}
