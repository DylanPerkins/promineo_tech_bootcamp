package projects.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import projects.entity.Category;
import projects.entity.Material;
import projects.entity.Project;
import projects.entity.Step;
import projects.exception.dbException;
import provided.util.DaoBase;

@SuppressWarnings("unused")
public class ProjectDao extends DaoBase {
    private static final String CATEGORY_TABLE = "category";
    private static final String MATERIAL_TABLE = "material";
    private static final String PROJECT_TABLE = "project";
    private static final String PROJECT_CATEGORY_TABLE = "project_category";
    private static final String STEP_TABLE = "step";

    public Project insertProject(Project project) {
        // @formatter:off
        String sql = ""
        + "INSERT INTO " + PROJECT_TABLE + " "
        + "(project_name, estimated_hours, actual_hours, difficulty, notes) "
        + "VALUES (?, ?, ?, ?, ?)";
        // @formatter:on

        try (Connection conn = dbConnection.getConnection()) {
            startTransaction(conn);

            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                setParameter(stmt, 1, project.getProjectName(), String.class);
                setParameter(stmt, 2, project.getEstimatedHours(), BigDecimal.class);
                setParameter(stmt, 3, project.getActualHours(), BigDecimal.class);
                setParameter(stmt, 4, project.getDifficulty(), Integer.class);
                setParameter(stmt, 5, project.getNotes(), String.class);

                stmt.executeUpdate();

                Integer projectId = getLastInsertId(conn, PROJECT_TABLE);
                commitTransaction(conn);

                project.setProjectId(projectId);
                return project;
            } catch (SQLException e) {
                rollbackTransaction(conn);
                throw new dbException(e);
            }

        } catch (SQLException e) {
            throw new dbException(e);
        }
    }

    public List<Project> selectAllProjects() {
        // @formatter:off
        String sql = ""
        + "SELECT * "
        + "FROM " + PROJECT_TABLE + " "
        + "ORDER BY project_name";
        // @formatter:on

        try (Connection conn = dbConnection.getConnection()) {
            startTransaction(conn);

            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                try (ResultSet rs = stmt.executeQuery()) {
                    List<Project> projects = new LinkedList<>();

                    while (rs.next()) {
                        projects.add(extract(rs, Project.class));
                    }

                    return projects;

                }
            } catch (SQLException e) {
                rollbackTransaction(conn);
                throw new dbException(e);
            }

        } catch (SQLException e) {
            throw new dbException(e);
        }

    }

    public Optional<Project> selectProjectById(Integer projectId) {
        // @formatter:off
        String sql = ""
        + "SELECT * "
        + "FROM " + PROJECT_TABLE + " "
        + "WHERE project_id = ?";
        // @formatter:on

        try (Connection conn = dbConnection.getConnection()) {
            startTransaction(conn);
            try {
                Project project = null;

                try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                    setParameter(stmt, 1, projectId, Integer.class);

                    try (ResultSet rs = stmt.executeQuery()) {
                        if (rs.next()) {
                            project = extract(rs, Project.class);
                        }
                    }
                }

                if(Objects.nonNull(project)) {
                    project.getMaterials().addAll(selectMaterialsByProjectId(conn, projectId));
                    project.getCategories().addAll(selectCategoriesByProjectId(conn, projectId));
                    project.getSteps().addAll(selectStepsByProjectId(conn, projectId));
                }

                return Optional.ofNullable(project);
            } catch (Exception e) {
                rollbackTransaction(conn);
                throw new dbException(e);
            }
        } catch (SQLException e) {
            throw new dbException(e);
        }
    }

    private Collection<? extends Step> selectStepsByProjectId(Connection conn, Integer projectId) throws SQLException{
        // @formatter:off
        String sql = ""
        + "SELECT s.* "
        + "FROM " + STEP_TABLE + " s "
        + "JOIN " + PROJECT_TABLE + " p "
        + "USING (project_id) "
        + "WHERE p.project_id = ?";
        // @formatter:on

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            setParameter(stmt, 1, projectId, Integer.class);

            try (ResultSet rs = stmt.executeQuery()) {
                List<Step> steps = new LinkedList<>();

                while (rs.next()) {
                    steps.add(extract(rs, Step.class));
                }

                return steps;
            }
        }
    }

    private Collection<? extends Category> selectCategoriesByProjectId(Connection conn, Integer projectId) throws SQLException{
        // @formatter:off
        String sql = ""
        + "SELECT c.* "
        + "FROM " + CATEGORY_TABLE + " c "
        + "JOIN " + PROJECT_CATEGORY_TABLE + " pc "
        + "USING (category_id) "
        + "WHERE pc.project_id = ?";
        // @formatter:on

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            setParameter(stmt, 1, projectId, Integer.class);

            try (ResultSet rs = stmt.executeQuery()) {
                List<Category> categories = new LinkedList<>();

                while (rs.next()) {
                    categories.add(extract(rs, Category.class));
                }

                return categories;
            }
        }
    }

    private Collection<? extends Material> selectMaterialsByProjectId(Connection conn, Integer projectId) throws SQLException{
        // @formatter:off
        String sql = ""
        + "SELECT m.* "
        + "FROM " + MATERIAL_TABLE + " m "
        + "JOIN " + PROJECT_TABLE + " p "
        + "USING (project_id) "
        + "WHERE p.project_id = ?";
        // @formatter:on

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            setParameter(stmt, 1, projectId, Integer.class);

            try (ResultSet rs = stmt.executeQuery()) {
                List<Material> materials = new LinkedList<>();

                while (rs.next()) {
                    materials.add(extract(rs, Material.class));
                }

                return materials;
            }
        }
    }
}
