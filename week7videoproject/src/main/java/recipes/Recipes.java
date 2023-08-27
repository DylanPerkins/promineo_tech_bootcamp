package recipes;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import recipes.dao.dbConnection;
import recipes.entity.Category;
import recipes.entity.Ingredient;
import recipes.entity.Recipe;
import recipes.entity.Step;
import recipes.entity.Unit;
import recipes.exception.dbException;
import recipes.service.RecipeService;

public class Recipes {

    private Scanner scanner = new Scanner(System.in);
    private RecipeService recipeService = new RecipeService();
    private Recipe curRecipe;

    private List<String> operations = List.of(
            "1. Create and populate tables",
            "2. Add a recipe",
            "3. List all recipes",
            "4. Select a recipe",
            "5. Add an ingredient to the current recipe",
            "6. Add a step to the current recipe",
            "7. Add a category to the current recipe");

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
                    case 2:
                        addRecipe();
                        break;
                    case 3:
                        listRecipes();
                        break;
                    case 4:
                        selectRecipe();
                        break;
                    case 5:
                        addIngredientToCurrentRecipe();
                        break;
                    case 6:
                        addStepToCurrentRecipe();
                        break;
                    case 7:
                        addCategoryToCurrentRecipe();
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

    private void addCategoryToCurrentRecipe() {
        if (Objects.isNull(curRecipe)) {
            System.out.println("\nNo recipe selected, please select a recipe first");
            return;
        }

        List<Category> categories = recipeService.fetchCategories();

        System.out.println("\nCategories:");

        categories.forEach(category -> System.out.println("\t" + category.getCategoryName()));

        String category = getStringInput("\nEnter the category name to add");

        if (Objects.nonNull(category)) {
            recipeService.addCategoryToRecipe(curRecipe.getRecipeId(), category);
            curRecipe = recipeService.fetchRecipeById(curRecipe.getRecipeId());
        }


    }

    private void addStepToCurrentRecipe() {
        if (Objects.isNull(curRecipe)) {
            System.out.println("\nNo recipe selected, please select a recipe first");
            return;
        }

        String stepText = getStringInput("Enter the instruction");

        if (Objects.nonNull(stepText)) {
            Step step = new Step();

            step.setRecipeId(curRecipe.getRecipeId());
            step.setStepText(stepText);

            recipeService.addStep(step);
            curRecipe = recipeService.fetchRecipeById(step.getRecipeId());
        }
    }

    private void addIngredientToCurrentRecipe() {
        if (Objects.isNull(curRecipe)) {
            System.out.println("\nNo recipe selected, please select a recipe first");
            return;
        }

        String name = getStringInput("Enter the ingredient name");
        String instruction = getStringInput("Enter some instructions, if any");
        Double inputAmount = getDoubleInput("Enter the amount of the ingredient");
        List<Unit> units = recipeService.fetchUnits();

        BigDecimal amount = Objects.isNull(inputAmount) ? null : BigDecimal.valueOf(inputAmount).setScale(2);

        System.out.println("\nUnits:");

        units.forEach(unit -> System.out.println("\t" + unit.getUnitId() + ": " + unit.getUnitNameSingular() + " ("
                + unit.getUnitNamePlural() + ")"));

        Integer unitId = getIntInput("\nEnter the unit ID. (Press 'Enter' for none)");

        Unit unit = new Unit();
        unit.setUnitId(unitId);

        Ingredient ingredient = new Ingredient();
        ingredient.setRecipeId(curRecipe.getRecipeId());
        ingredient.setIngredientName(name);
        ingredient.setInstruction(instruction);
        ingredient.setAmount(amount);
        ingredient.setUnit(unit);

        recipeService.addIngredient(ingredient);
        curRecipe = recipeService.fetchRecipeById(ingredient.getRecipeId());
    }

    private void selectRecipe() {
        List<Recipe> recipes = listRecipes();

        Integer recipeId = getIntInput("\nEnter recipe ID");

        curRecipe = null;

        for (Recipe recipe : recipes) {
            if (recipe.getRecipeId().equals(recipeId)) {
                curRecipe = recipeService.fetchRecipeById(recipeId);
                break;
            }
        }

        if (Objects.isNull(curRecipe)) {
            System.out.println("\nRecipe with ID=" + recipeId + " not found");
        }
    }

    private List<Recipe> listRecipes() {
        List<Recipe> recipes = recipeService.fetchRecipes();

        System.out.println("\nRecipes:");
        recipes.forEach(recipe -> System.out.println("\t" + recipe.getRecipeId() + ": " + recipe.getRecipeName()));

        return recipes;
    }

    private void addRecipe() {
        String name = getStringInput("Enter recipe name");
        String notes = getStringInput("Enter recipe notes");
        Integer numServings = getIntInput("Enter number of servings");
        Integer prepMinutes = getIntInput("Enter prep time in minutes");
        Integer cookMinutes = getIntInput("Enter cook time in minutes");

        LocalTime prepTime = minutesToLocalTime(prepMinutes);
        LocalTime cookTime = minutesToLocalTime(cookMinutes);

        Recipe recipe = new Recipe();

        recipe.setRecipeName(name);
        recipe.setNotes(notes);
        recipe.setNumServings(numServings);
        recipe.setPrepTime(prepTime);
        recipe.setCookTime(cookTime);

        Recipe dbRecipe = recipeService.addRecipe(recipe);
        System.out.println("\nRecipe added: " + dbRecipe.toString());

        curRecipe = recipeService.fetchRecipeById(dbRecipe.getRecipeId());
    }

    private LocalTime minutesToLocalTime(Integer numMinutes) {
        int min = Objects.isNull(numMinutes) ? 0 : numMinutes;
        int hours = min / 60;
        int minutes = min % 60;

        return LocalTime.of(hours, minutes);
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

        if (Objects.isNull(curRecipe)) {
            System.out.println("\nCurrent recipe: none");
        } else {
            System.out.println("\nCurrent recipe: " + curRecipe);
        }

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

    private String getStringInput(String prompt) {
        System.out.print(prompt + ": ");
        String line = scanner.nextLine();

        return line.isBlank() ? null : line.trim();
    }

    private Double getDoubleInput(String string) {
        String input = getStringInput(string);

        if (Objects.isNull(input)) {
            return null;
        }

        try {
            return Double.parseDouble(input);
        } catch (NumberFormatException e) {
            throw new dbException(input + " is not a valid number");
        }
    }
}
