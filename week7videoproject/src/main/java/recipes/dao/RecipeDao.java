package recipes.dao;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;
import provided.util.DaoBase;
import recipes.exception.dbException;

public class RecipeDao extends DaoBase {
    public void executeBatch(List<String> sqlBatch) {
        try(Connection conn = dbConnection.getConnection()){
            startTransaction(conn);

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

        } catch (Exception e) {
            throw new dbException(e);
        }
    }
}
