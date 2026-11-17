package org.example;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public final class DBConfig {
    public static final SessionFactory SESSION_FACTORY = buildSessionFactory();

    private DBConfig() {
    }
    private static SessionFactory buildSessionFactory() {
        String password = System.getenv("DB_PASSWORD");
        if (password == null || password.isBlank()) {
            throw new IllegalStateException("Set DB_PASSWORD before starting the application.");
        }

        return new Configuration()
                .configure()
                .setProperty("hibernate.connection.password", password)
                .buildSessionFactory();
    }
}
