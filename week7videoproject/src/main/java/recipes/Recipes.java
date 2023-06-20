package recipes;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import recipes.dao.dbConnection;
import recipes.exception.dbException;
import recipes.service.RecipeService;

public class Recipes {

    private Scanner scanner = new Scanner(System.in);
    private RecipeService recipeService = new RecipeService();

    private List<String> operations = List.of(
            "1. Create and populate tables");

    public static void main(String[] args) {
        dbConnection.getConnection();

        new Recipes().displayMenu();

    }

    private void displayMenu() {
        boolean finished = false;

        while (!finished) {

            try {
                int operation = getOperation();

                switch (operation) {
                    case -1:
                        finished = exitMenu();
                        break;
                    case 1:
                        createTables();
                        break;

                    default:
                        System.out.println("\nInvalid operation. Please try again.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("\nError: " + e.toString() + ". Please try again.");
            }
        }
    }

    private void createTables() {
        recipeService.createAndPopulateTables();
        System.out.println("\nTables created and populated");
    }

    private boolean exitMenu() {
        System.out.println("\nGoodbye!");
        return true;
    }

    private int getOperation() {
        printOperations();
        Integer op = getIntInput("\nEnter operation number (Press 'Enter' to quit)");

        return Objects.isNull(op) ? -1 : op;
    }

    private void printOperations() {
        System.out.println();
        System.out.println("Here's what you can do:");

        operations.forEach(op -> System.out.println("\t" + op));

    }

    private Integer getIntInput(String prompt) {
        String input = getStringInput(prompt);

        if (Objects.isNull(input)) {
            return null;
        }

        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new dbException(input + " is not a valid number");
        }
    }

    // private Double getDoubleInput(String prompt) {
    //     String input = getStringInput(prompt);

    //     if (Objects.isNull(input)) {
    //         return null;
    //     }

    //     try {
    //         return Double.parseDouble(input);
    //     } catch (NumberFormatException e) {
    //         throw new dbException(input + " is not a valid number");
    //     }
    // }

    private String getStringInput(String prompt) {
        System.out.print(prompt + ": ");
        String line = scanner.nextLine();

        return line.isBlank() ? null : line.trim();
    }
}
