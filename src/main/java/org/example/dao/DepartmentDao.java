package org.example.dao;

import org.example.model.Department;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DepartmentDao {
    private final Connection connection;

    public DepartmentDao(Connection conn) {
        this.connection = conn;
    }

    public ArrayList<Department> listAllDep() {
        String sql = """
                SELECT department_id, department_name, manager_id
                FROM HR.DEMO_DEPARTMENTS
                ORDER BY department_id
                """;
        ArrayList<Department> departments = new ArrayList<>();

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int id = rs.getInt("department_id");
                String name = rs.getString("department_name");
                Integer managerId = rs.getObject("manager_id", Integer.class);
                departments.add(new Department(id, name, managerId));
            }
            return departments;
        } catch (SQLException e) {
            throw new RuntimeException("Could not list departments", e);
        }
    }
}
