package recipes.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

import recipes.dao.RecipeDao;
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


    private List<String> convertSQLFileContentToSQLStatements(String content) {
        content = removeComments(content);
        content = removeEmptyLines(content);

        return extractSQLStatements(content);
    }

    private List<String> extractSQLStatements(String content) {
        List<String> lines = new LinkedList<>();

        while (!content.isEmpty()) {
            int semicolonPosition = content.indexOf(";");

            if (semicolonPosition == -1) {
                lines.add(content);
                break;
            } else {
                lines.add(content.substring(0, semicolonPosition + 1));
                content = content.substring(semicolonPosition + 1);
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
            int endOfLinePosition = sb.indexOf("\n", commentPosition + 1);
            sb.delete(commentPosition, endOfLinePosition);

            
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

    // public static void main(String[] args) {
    //     RecipeService recipeService = new RecipeService();
    //     recipeService.createAndPopulateTables();
    // }
}
