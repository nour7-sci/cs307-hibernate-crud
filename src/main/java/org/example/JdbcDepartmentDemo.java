package org.example;

import org.example.dao.JdbcDepartmentDao;
import org.example.model.Department;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcDepartmentDemo {
    public static void main(String[] args) throws SQLException {
        String url = System.getenv().getOrDefault(
                "DB_URL", "jdbc:oracle:thin:@//localhost:1521/FREEPDB1");
        String user = System.getenv().getOrDefault("DB_USER", "hr");
        String password = System.getenv("DB_PASSWORD");
        if (password == null || password.isBlank()) {
            throw new IllegalStateException("Set DB_PASSWORD before starting the application.");
        }

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            JdbcDepartmentDao dao = new JdbcDepartmentDao(connection);
            for (Department department : dao.findAll()) {
                System.out.println(department.getId() + " " + department.getName()
                        + " " + department.getManagerId());
            }
        }
    }
}
