package org.example;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public final class DBConfig {
    public static final SessionFactory SESSION_FACTORY = new Configuration()
            .configure()
            .buildSessionFactory();

    private DBConfig() {
    }
}
