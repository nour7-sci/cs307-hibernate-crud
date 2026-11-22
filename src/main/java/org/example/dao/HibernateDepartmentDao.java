package org.example.dao;

import org.example.DBConfig;
import org.example.model.Department;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class HibernateDepartmentDao {

    public List<Department> findAll() {

        try (Session session = DBConfig.SESSION_FACTORY.openSession()) {

            return session.createSelectionQuery(
                    "FROM Department d ORDER BY d.id", Department.class
            ).getResultList();

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

        return new ArrayList<>();
    }

    public Optional<Department> findById(int id) {

        try (Session session = DBConfig.SESSION_FACTORY.openSession()) {

            return Optional.ofNullable(session.find(Department.class, id));

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

        return Optional.empty();
    }

    public boolean insert(Department department) {

        Transaction transaction = null;

        try (Session session = DBConfig.SESSION_FACTORY.openSession()) {

            transaction = session.beginTransaction();

            session.persist(department);

            transaction.commit();

            return true;

        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.err.println(ex.getMessage());
        }

        return false;
    }

    public boolean update(int id, Department changes) {

        Transaction transaction = null;

        try (Session session = DBConfig.SESSION_FACTORY.openSession()) {

            transaction = session.beginTransaction();

            Department department = session.find(Department.class, id);
            boolean found = department != null;

            if (found) {
                department.setName(changes.getName());
                department.setManagerId(changes.getManagerId());
            }

            transaction.commit();

            return found;

        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.err.println(ex.getMessage());
        }

        return false;
    }

    public boolean delete(int id) {

        Transaction transaction = null;

        try (Session session = DBConfig.SESSION_FACTORY.openSession()) {

            transaction = session.beginTransaction();

            Department department = session.find(Department.class, id);
            boolean found = department != null;

            if (found) {
                session.remove(department);
            }

            transaction.commit();

            return found;

        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.err.println(ex.getMessage());
        }

        return false;
    }
}
