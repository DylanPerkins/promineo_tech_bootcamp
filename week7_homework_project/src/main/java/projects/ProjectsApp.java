package projects;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import projects.entity.Project;
import projects.exception.dbException;
import projects.service.ProjectService;

public class ProjectsApp {
	private static final ProjectService projectService = new ProjectService();

	// @formatter:off
	private List<String> operations = List.of(
			"1) Add a new project"
	);
	// @formatter:on
	private Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		new ProjectsApp().processUserSelection();
	}

	private void processUserSelection() {
		boolean done = false;

		while (!done) {
			try {
				int selection = obtainUserSelection();

				switch (selection) {
					case -1:
						done = exitMenu();
						break;
					case 1:
						createProject();
						break;
					default:
						System.out.println("\n" + selection + " is not a valid selection. Please try again.");
						break;
				}

			} catch (Exception e) {
				System.out.println("\nError: " + e.getMessage() + ".\nPlease try again.");
			}
		}
	}

	private boolean exitMenu() {
		System.out.println("\nGoodbye!");
		return true;
	}

	private void createProject() {
		String projectName = getStringInput("Enter project name");
		BigDecimal estimatedHours = getDecimalInput("Enter estimated hours");
		BigDecimal actualHours = getDecimalInput("Enter actual hours");
		Integer difficulty = getIntInput("Enter difficulty (1-5)");
		String notes = getStringInput("Enter notes");

		Project project = new Project();

		project.setProjectName(projectName);
		project.setEstimatedHours(estimatedHours);
		project.setActualHours(actualHours);
		project.setDifficulty(difficulty);
		project.setNotes(notes);

		Project dbProject = projectService.addProject(project);

		System.out.println("\nCreated project: " + dbProject);

	}

	private BigDecimal getDecimalInput(String prompt) {
		String input = getStringInput(prompt);

		if (Objects.isNull(input)) {
			return null;
		}

		try {
			return new BigDecimal(input).setScale(2);
		} catch (NumberFormatException e) {
			throw new dbException(input + " is not a valid decimal number.");
		}
	}

	private int obtainUserSelection() {
		printOperations();

		Integer input = getIntInput("\nPlease select an operation");

		return Objects.isNull(input) ? -1 : input;
	}

	private Integer getIntInput(String prompt) {
		String input = getStringInput(prompt);

		if (Objects.isNull(input)) {
			return null;
		}

		try {
			return Integer.valueOf(input);
		} catch (NumberFormatException e) {
			throw new dbException(input + " is not a valid integer.");
		}
	}

	private String getStringInput(String prompt) {
		System.out.print(prompt + ": ");
		String input = scanner.nextLine();

		return input.isBlank() ? null : input.trim();
	}

	private void printOperations() {
		System.out.println();
		System.out.println("Here's what you can do: (Press 'Enter' to quit)");

		operations.forEach(op -> System.out.println("\t" + op));
	}

}
