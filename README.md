# CS307 Hibernate CRUD

This project reads Oracle departments with JDBC and demonstrates CRUD with Hibernate. Both DAOs use the same practice table, `HR.DEMO_DEPARTMENTS`.

## Configure the project

- **JDK:** Select your installed JDK as the project SDK and Maven runner JDK in IntelliJ. Set `maven.compiler.source` and `maven.compiler.target` in [`pom.xml`](pom.xml) to the Java version you want to compile for. This project targets Java 27.
- **Maven dependencies:** In the same POM, specify versions of Hibernate ORM and the Oracle JDBC driver that work with your JDK. The versions used here are `org.hibernate.orm:hibernate-core:7.4.16.Final` and `com.oracle.database.jdbc:ojdbc11:23.26.4.0.0`. Reload Maven after changing the POM.
- **Oracle JDBC URL:** For Hibernate, set `hibernate.connection.url` in [`hibernate.cfg.xml`](src/main/resources/hibernate.cfg.xml). The format is `jdbc:oracle:thin:@//HOST:PORT/SERVICE_NAME`. The example uses `jdbc:oracle:thin:@//localhost:1521/FREEPDB1`. Change the host, port, and service name to match your SQL Developer connection. The JDBC demo uses the same URL and `hr` by default. Set `DB_URL` or `DB_USER` in its run configuration if your connection differs.

## Run the examples

1. Connect to Oracle as `hr` in SQL Developer and run [`sql/demo-tables.sql`](sql/demo-tables.sql) as a script (F5).
2. Configure the password for the demo you want to run:
   - **Hibernate:** Set `hibernate.connection.password` in your local [`hibernate.cfg.xml`](src/main/resources/hibernate.cfg.xml). Replace the example value `hr` if your Oracle password differs. Keep your actual password out of commits.
3. Run [`JdbcDepartmentDemo`](src/main/java/org/example/JdbcDepartmentDemo.java) to see `JdbcDepartmentDao.findAll()` execute SQL and map each row to a Java object.
4. Run [`HibernateDepartmentDemo`](src/main/java/org/example/HibernateDepartmentDemo.java) to see `HibernateDepartmentDao.findAll()` read the same rows using Hibernate. The demo then inserts, reads, updates, and deletes a temporary department with ID 6. Leave ID 6 unused before running the demo.

Hibernate generates no database schema changes. The setup script creates and seeds the practice table
