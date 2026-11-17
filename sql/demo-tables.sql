-- Run as HR in FREEPDB1 using Run Script (F5) in SQL Developer.
WHENEVER SQLERROR EXIT FAILURE ROLLBACK

CREATE TABLE IF NOT EXISTS HR.DEMO_DEPARTMENTS (
    department_id   NUMBER(10) PRIMARY KEY,
    department_name VARCHAR2(100 CHAR) NOT NULL,
    manager_id      NUMBER(10)
);

INSERT INTO HR.DEMO_DEPARTMENTS (department_id, department_name, manager_id)
SELECT -1, 'Engineering', 4 FROM dual
WHERE NOT EXISTS (SELECT 1 FROM HR.DEMO_DEPARTMENTS WHERE department_id = -1);

INSERT INTO HR.DEMO_DEPARTMENTS (department_id, department_name, manager_id)
SELECT -2, 'Finance', NULL FROM dual
WHERE NOT EXISTS (SELECT 1 FROM HR.DEMO_DEPARTMENTS WHERE department_id = -2);

COMMIT;
