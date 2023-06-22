package projects;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import projects.exception.dbException;

public class ProjectsApp {

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
						done = true;
						break;
					default:
						System.out.println("\n" + selection + " is not a valid selection. Please try again.");
						break;
				}

			} catch (Exception e) {
				System.out.println("\nError: " + e.getMessage() + ".\nPlease Try again.");
			}
		}
	}

	private int obtainUserSelection() {
		printOperations();

		Integer input = getIntInput("\nPlease select an operation: ");

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
