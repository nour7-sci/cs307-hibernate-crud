# CS307 Hibernate Department CRUD

A Java 27 and Maven example that reads Oracle departments with JDBC and implements CRUD with Hibernate. Both DAOs use the same practice table, `HR.DEMO_DEPARTMENTS`.

1. Open `pom.xml` in IntelliJ and select JDK 27.
2. Connect to Oracle as `hr` in SQL Developer and run `sql/demo-tables.sql` as a script (F5). The default connection is `localhost:1521/FREEPDB1`.
3. Set `DB_PASSWORD` to the Oracle HR password in the IntelliJ run configuration for `org.example.Main`.
4. Run `Main`. It lists the seeded departments, then inserts, reads, updates, and deletes a temporary department with ID 6. Leave ID 6 unused before running the demo.

Hibernate generates no database schema changes. The setup script creates and seeds the practice table.
