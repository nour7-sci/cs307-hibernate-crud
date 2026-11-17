package org.example.dao;

import org.example.DBConfig;
import org.example.model.Department;

import java.util.ArrayList;
import java.util.Optional;

public class DepartmentDao_v2 {
    public ArrayList<Department> listAllDep() {
        return DBConfig.SESSION_FACTORY.fromTransaction(session ->
                new ArrayList<>(session.createQuery(
                        "FROM Department d ORDER BY d.id", Department.class
                ).list()));
    }

    public Optional<Department> findById(int id) {
        return DBConfig.SESSION_FACTORY.fromTransaction(session ->
                Optional.ofNullable(session.find(Department.class, id)));
    }

    public void insert(Department department) {
        DBConfig.SESSION_FACTORY.inTransaction(session -> session.persist(department));
    }

    public boolean update(int id, Department changes) {
        return DBConfig.SESSION_FACTORY.fromTransaction(session -> {
            Department department = session.find(Department.class, id);
            if (department == null) {
                return false;
            }

            department.setName(changes.getName());
            department.setManagerId(changes.getManagerId());
            return true;
        });
    }

    public boolean delete(int id) {
        return DBConfig.SESSION_FACTORY.fromTransaction(session -> {
            Department department = session.find(Department.class, id);
            if (department == null) {
                return false;
            }

            session.remove(department);
            return true;
        });
    }
}
