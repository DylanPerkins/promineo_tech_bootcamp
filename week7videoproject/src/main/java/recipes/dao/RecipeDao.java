package recipes.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import provided.util.DaoBase;
import recipes.entity.Category;
import recipes.entity.Ingredient;
import recipes.entity.Recipe;
import recipes.entity.Step;
import recipes.entity.Unit;
import recipes.exception.dbException;

public class RecipeDao extends DaoBase {
    private static final String CATEGORY_TABLE = "category";
    private static final String INGREDIENT_TABLE = "ingredient";
    private static final String RECIPE_TABLE = "recipe";
    private static final String RECIPE_CATEGORY_TABLE = "recipe_category";
    private static final String STEP_TABLE = "step";
    private static final String UNIT_TABLE = "unit";

    public Optional<Recipe> fetchRecipeById(int recipeId) {
        // @formatter:off
        String sql = ""
            + "SELECT * "
            + "FROM " + RECIPE_TABLE + " "
            + "WHERE recipe_id = ?";
        // @formatter:on

        try (Connection conn = dbConnection.getConnection()) {
            startTransaction(conn);

            try {
                Recipe recipe = null;

                try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                    setParameter(stmt, 1, recipeId, Integer.class);

                    try (ResultSet rs = stmt.executeQuery()) {
                        if (rs.next()) {
                            recipe = extract(rs, Recipe.class);
                        }
                    }
                }

                if (Objects.nonNull(recipe)) {
                    recipe.getIngredients().addAll(fetchRecipeIngredients(recipeId, conn));
                    recipe.getSteps().addAll(fetchRecipeSteps(recipeId, conn));
                    recipe.getCategories().addAll(fetchRecipeCategories(recipeId, conn));
                }

                return Optional.ofNullable(recipe);

            } catch (Exception e) {
                rollbackTransaction(conn);
                throw new dbException(e);
            }

        } catch (SQLException e) {
            throw new dbException(e);
        }
    }

    private List<Category> fetchRecipeCategories(int recipeId, Connection conn) throws SQLException {
        // @formatter:off
        String sql = ""
            + "SELECT c.* "
            + "FROM " + RECIPE_CATEGORY_TABLE + " rc "
            + "JOIN " + CATEGORY_TABLE + " c USING (category_id) "
            + "WHERE recipe_id = ? "
            + "ORDER BY c.category_name";
        // @formatter:on

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            setParameter(stmt, 1, recipeId, Integer.class);

            try (ResultSet rs = stmt.executeQuery()) {
                List<Category> categories = new LinkedList<Category>();

                while (rs.next()) {
                    categories.add(extract(rs, Category.class));
                }

                return categories;
            }
        }
    }

    private List<Step> fetchRecipeSteps(int recipeId, Connection conn) throws SQLException {
        // @formatter:off
        String sql = ""
            + "SELECT * "
            + "FROM " + STEP_TABLE + " S "
            + "WHERE s.recipe_id = ? ";
        // @formatter:on

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            setParameter(stmt, 1, recipeId, Integer.class);

            try (ResultSet rs = stmt.executeQuery()) {
                List<Step> steps = new LinkedList<Step>();

                while (rs.next()) {
                    steps.add(extract(rs, Step.class));
                }

                return steps;
            }
        }
    }

    private List<Ingredient> fetchRecipeIngredients(int recipeId, Connection conn) throws SQLException {
        // @formatter:off
        String sql = ""
            + "SELECT i.*, u.unit_name_singular, u.unit_name_plural "
            + "FROM " + INGREDIENT_TABLE + " i "
            + "LEFT JOIN " + UNIT_TABLE + " u USING (unit_id) "
            + "WHERE recipe_id = ? "
            + "ORDER BY i.ingredient_order";
        // @formatter:on

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            setParameter(stmt, 1, recipeId, Integer.class);

            try (ResultSet rs = stmt.executeQuery()) {
                List<Ingredient> ingredients = new LinkedList<Ingredient>();

                while (rs.next()) {
                    Ingredient ingredient = extract(rs, Ingredient.class);
                    Unit unit = extract(rs, Unit.class);

                    ingredient.setUnit(unit);
                    ingredients.add(ingredient);
                }

                return ingredients;
            }
        }
    }

    public Recipe insertRecipe(Recipe recipe) {
        // @formatter:off
        String sql = ""
            + "INSERT INTO " + RECIPE_TABLE + " "
            + "(recipe_name, notes, num_servings, prep_time, cook_time) "
            + "VALUES " 
            + "(?, ?, ?, ?, ?)";
        // @formatter:on

        try (Connection conn = dbConnection.getConnection()) {
            startTransaction(conn);

            return recipePreppedStatements(recipe, sql, conn);

        } catch (SQLException e) {
            throw new dbException(e);
        }
    }

    public void executeBatch(List<String> sqlBatch) {
        try (Connection conn = dbConnection.getConnection()) {
            startTransaction(conn);

            executeStatementBatches(sqlBatch, conn);

        } catch (Exception e) {
            throw new dbException(e);
        }
    }

    // Secondary/Embedded Functions

    private Recipe recipePreppedStatements(Recipe recipe, String sql, Connection conn) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            setParameter(stmt, 1, recipe.getRecipeName(), String.class);
            setParameter(stmt, 2, recipe.getNotes(), String.class);
            setParameter(stmt, 3, recipe.getNumServings(), Integer.class);
            setParameter(stmt, 4, recipe.getPrepTime(), LocalTime.class);
            setParameter(stmt, 5, recipe.getCookTime(), LocalTime.class);

            stmt.executeUpdate();
            Integer recipeId = getLastInsertId(conn, RECIPE_TABLE);

            commitTransaction(conn);

            recipe.setRecipeId(recipeId);
            return recipe;
        } catch (Exception e) {
            rollbackTransaction(conn);
            throw new dbException(e);
        }
    }

    private void executeStatementBatches(List<String> sqlBatch, Connection conn) throws SQLException {
        try (Statement stmt = conn.createStatement()) {
            for (String sql : sqlBatch) {
                stmt.addBatch(sql);
            }

            stmt.executeBatch();
            commitTransaction(conn);

        } catch (Exception e) {
            rollbackTransaction(conn);
            throw new dbException(e);
        }
    }

    public List<Recipe> fetchAllRecipes() {
        // @formatter:off
        String sql = ""
            + "SELECT * "
            + "FROM " + RECIPE_TABLE + " ORDER BY recipe_name";
        // @formatter:on

        try (Connection conn = dbConnection.getConnection()) {
            startTransaction(conn);

            return fetchAllRecipesResultSetQuery(sql, conn);

        } catch (SQLException e) {
            throw new dbException(e);
        }
    }

    private List<Recipe> fetchAllRecipesResultSetQuery(String sql, Connection conn) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            try (ResultSet rs = stmt.executeQuery()) {
                List<Recipe> recipes = new LinkedList<>();

                while (rs.next()) {
                    recipes.add(extract(rs, Recipe.class));
                }

                return recipes;
            }
        } catch (Exception e) {
            rollbackTransaction(conn);
            throw new dbException(e);
        }
    }

    public List<Unit> fetchAllUnits() {
        // @formatter:off
        String sql = ""
            + "SELECT * "
            + "FROM " + UNIT_TABLE + " ORDER BY unit_name_singular";
        // @formatter:on

        try (Connection conn = dbConnection.getConnection()) {
            startTransaction(conn);

            return fetchAllUnitsPreppedStatements(sql, conn);

        } catch (SQLException e) {
            throw new dbException(e);
        }
    }

    private List<Unit> fetchAllUnitsPreppedStatements(String sql, Connection conn) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            try (ResultSet rs = stmt.executeQuery()) {
                List<Unit> units = new LinkedList<>();

                while (rs.next()) {
                    units.add(extract(rs, Unit.class));
                }

                return units;
            }
        } catch (Exception e) {
            rollbackTransaction(conn);
            throw new dbException(e);
        }
    }

    public void addIngredientToRecipe(Ingredient ingredient) {
        // @formatter:off
        String sql = ""
            + "INSERT INTO " + INGREDIENT_TABLE + " "
            + "(recipe_id, unit_id, ingredient_name, instruction, ingredient_order, amount) "
            + "VALUES " 
            + "(?, ?, ?, ?, ?, ?)";
        // @formatter:on

        try (Connection conn = dbConnection.getConnection()) {
            startTransaction(conn);

            try {
                Integer order = getNextSequenceNumber(conn, ingredient.getRecipeId(), INGREDIENT_TABLE, "recipe_id");

                try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                    setParameter(stmt, 1, ingredient.getRecipeId(), Integer.class);
                    setParameter(stmt, 2, ingredient.getUnit().getUnitId(), Integer.class);
                    setParameter(stmt, 3, ingredient.getIngredientName(), String.class);
                    setParameter(stmt, 4, ingredient.getInstruction(), String.class);
                    setParameter(stmt, 5, order, Integer.class);
                    setParameter(stmt, 6, ingredient.getAmount(), BigDecimal.class);

                    stmt.executeUpdate();
                    commitTransaction(conn);
                }
            } catch (Exception e) {
                rollbackTransaction(conn);
                throw new dbException(e);
            }

        } catch (SQLException e) {
            throw new dbException(e);
        }
    }

    public void addStepToRecipe(Step step) {
        // @formatter:off
        String sql = ""
            + "INSERT INTO " + STEP_TABLE + " "
            + "(recipe_id, step_order, step_text) "
            + "VALUES " 
            + "(?, ?, ?)";
        // @formatter:on

        try (Connection conn = dbConnection.getConnection()) {
            startTransaction(conn);

            try {
                Integer order = getNextSequenceNumber(conn, step.getRecipeId(), STEP_TABLE, "recipe_id");

                try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                    setParameter(stmt, 1, step.getRecipeId(), Integer.class);
                    setParameter(stmt, 2, order, Integer.class);
                    setParameter(stmt, 3, step.getStepText(), String.class);

                    stmt.executeUpdate();
                    commitTransaction(conn);
                }
            } catch (Exception e) {
                rollbackTransaction(conn);
                throw new dbException(e);
            }

        } catch (SQLException e) {
            throw new dbException(e);
        }
    }

    public List<Category> fetchAllCategories() {
        // @formatter:off
        String sql = ""
            + "SELECT * FROM " + CATEGORY_TABLE + " "
            + "ORDER BY category_name";
        // @formatter:on

        try (Connection conn = dbConnection.getConnection()) {
            startTransaction(conn);

            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                try (ResultSet rs = stmt.executeQuery()) {
                    List<Category> categories = new LinkedList<>();

                    while (rs.next()) {
                        categories.add(extract(rs, Category.class));
                    }

                    return categories;
                }
            } catch (Exception e) {
                rollbackTransaction(conn);
                throw new dbException();
            }
        } catch (SQLException e) {
            throw new dbException(e);
        }
    }

    public void addCategoryToRecipe(Integer recipeId, String category) {
        String subQuery = "(SELECT category_id FROM " + CATEGORY_TABLE + " WHERE category_name = ?)";

        // @formatter:off
        String sql = ""
            + "INSERT INTO " + RECIPE_CATEGORY_TABLE + " (recipe_id, category_id) "
            + "VALUES (?, " + subQuery + ")";
        // @formatter:on

        try(Connection conn = dbConnection.getConnection()) {
            startTransaction(conn);

            try(PreparedStatement stmt = conn.prepareStatement(sql)) {
                setParameter(stmt, 1, recipeId, Integer.class);
                setParameter(stmt, 2, category, String.class);

                stmt.executeUpdate();
                commitTransaction(conn);
            } catch (Exception e) {
                rollbackTransaction(conn);
                throw new dbException(e);
            }

        } catch (SQLException e) {
            throw new dbException(e);
        }
    }
}
