package recipes.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import recipes.dao.RecipeDao;
import recipes.entity.Category;
import recipes.entity.Ingredient;
import recipes.entity.Recipe;
import recipes.entity.Step;
import recipes.entity.Unit;
import recipes.exception.dbException;

// This class is used to create and populate the tables in the recipes database.

public class RecipeService {
    private static final String SCHEMA_FILE = "recipe_schema.sql";
    private static final String DATA_FILE = "recipe_data.sql";

    private RecipeDao recipeDao = new RecipeDao();

    public void createAndPopulateTables() {
        loadFromFile(SCHEMA_FILE);
        loadFromFile(DATA_FILE);
    }

    private void loadFromFile(String fileName) {
        String content = readFileContent(fileName);
        List<String> sqlStatements = convertSQLFileContentToSQLStatements(content);

        recipeDao.executeBatch(sqlStatements);
    }

    public Recipe fetchRecipeById(int recipeId) {
        return recipeDao.fetchRecipeById(recipeId)
                .orElseThrow(() -> new NoSuchElementException("Recipe with ID=" + recipeId + " not found"));
    }

    private List<String> convertSQLFileContentToSQLStatements(String content) {
        content = removeComments(content);
        content = removeEmptyLines(content);

        return extractSQLStatements(content);
    }

    private List<String> extractSQLStatements(String content) {
        List<String> lines = new LinkedList<>();

        while (!content.isEmpty()) {
            int semicolon = content.indexOf(";");

            if (semicolon == -1) {
                if (!content.isBlank()) {
                    lines.add(content);
                }

                content = "";
            } else {
                lines.add(content.substring(0, semicolon).trim());
                content = content.substring(semicolon + 1);
            }
        }

        return lines;
    }

    private String removeEmptyLines(String content) {
        return content.replaceAll("\\s+", " ");
    }

    private String removeComments(String content) {
        StringBuilder sb = new StringBuilder(content);
        int commentPosition = 0;

        while ((commentPosition = sb.indexOf("--", commentPosition)) != -1) {
            int endOfLine = sb.indexOf("\n", commentPosition + 1);

            if (endOfLine == -1) {
                sb.replace(commentPosition, sb.length(), "");
            } else {
                sb.replace(commentPosition, endOfLine + 1, "");
            }
        }

        return sb.toString();
    }

    private String readFileContent(String fileName) {
        try {
            Path path = Paths.get(getClass().getClassLoader().getResource(fileName).toURI());
            return Files.readString(path);
        } catch (Exception e) {
            throw new dbException(e);
        }
    }

    public Recipe addRecipe(Recipe recipe) {
        return recipeDao.insertRecipe(recipe);
    }

    public List<Recipe> fetchRecipes() {
        // @formatter:off
        return recipeDao.fetchAllRecipes()
            .stream()
            .sorted((r1, r2) -> r1.getRecipeId() - r2.getRecipeId())
            .collect(Collectors.toList());

        // @formatter:on
    }

    public List<Unit> fetchUnits() {
        return recipeDao.fetchAllUnits();
    }

    public void addIngredient(Ingredient ingredient) {
        recipeDao.addIngredientToRecipe(ingredient);
    }

    public void addStep(Step step) {
        recipeDao.addStepToRecipe(step);
    }

    public List<Category> fetchCategories() {
        return recipeDao.fetchAllCategories();
    }

    public void addCategoryToRecipe(Integer recipeId, String category) {
        recipeDao.addCategoryToRecipe(recipeId, category);
    }

    public List<Step> fetchSteps(Integer recipeId) {
        return recipeDao.fetchSteps(recipeId);
    }

    public void modifyStep(Step step) {
        if(!recipeDao.modifyStep(step)) {
            throw new dbException("Step wth ID=" + step.getStepId() + " not found");
        }
    }

    public void deleteRecipe(Integer recipeId) {
        if(!recipeDao.deleteRecipe(recipeId)) {
            throw new dbException("Recipe with ID=" + recipeId + " not found");
        }
    }

}
