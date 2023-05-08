package projects;

import projects.dao.dbConnection;

public class ProjectsApp {

	public static void main(String[] args) {
		dbConnection.getConnection();
	}

}
