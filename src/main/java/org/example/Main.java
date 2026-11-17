package org.example;

import org.example.dao.DepartmentDao_v2;
import org.example.model.Department;
import org.hibernate.SessionFactory;

public class Main {
    public static void main(String[] args) {
        try (SessionFactory factory = DBConfig.SESSION_FACTORY) {
            DepartmentDao_v2 dao = new DepartmentDao_v2();
            for (Department department : dao.listAllDep()) {
                System.out.println(department.getId() + " " + department.getName()
                        + " " + department.getManagerId());
            }

            int id = 6;
            if (dao.findById(id).isPresent()) {
                throw new IllegalStateException("Department 6 already exists. Choose an unused demo ID.");
            }

            dao.insert(new Department(id, "Math", 4));
            try {
                Department created = dao.findById(id).orElseThrow();
                System.out.println("Created: " + created.getName());

                dao.update(id, new Department(id, "Applied Math", null));
                Department updated = dao.findById(id).orElseThrow();
                System.out.println("Updated: " + updated.getName()
                        + ", manager: " + updated.getManagerId());
            } finally {
                System.out.println("Deleted demo row: " + dao.delete(id));
            }
        }
    }


}
