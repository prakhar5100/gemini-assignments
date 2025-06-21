Oracle Assignment Questions 


1. Basic SELECT Query
SELECT * FROM employees;

2. Filtering Data
SELECT * FROM employees
WHERE department = 'Sales';

3. Sorting Data
SELECT name, salary FROM employees
WHERE department = 'Marketing'
ORDER BY salary DESC;

4. Using Aggregate Functions
SELECT AVG(salary) AS avg_salary FROM employees
WHERE department = 'HR';

5. Group By Clause
SELECT department, COUNT(*) AS total_employees
FROM employees
GROUP BY department;

6. Using DISTINCT
SELECT DISTINCT job_title FROM employees;

7. Using LIKE Operator
SELECT * FROM employees
WHERE name LIKE 'J%';

8. Using AND/OR Conditions
SELECT * FROM employees
WHERE department = 'IT' OR salary > 50000;

9. Joining Tables (Inner Join)
SELECT e.name, d.department_name
FROM employees e
INNER JOIN departments d ON e.department_id = d.department_id;

10. Joining Tables (Left Join)
SELECT e.name, d.department_name
FROM employees e
LEFT JOIN departments d ON e.department_id = d.department_id;

11. Subqueries
SELECT * FROM employees
WHERE salary > (SELECT AVG(salary) FROM employees);

12. Using IN Operator
SELECT * FROM employees
WHERE department IN ('Sales', 'Marketing', 'HR');

13. Using BETWEEN Operator
SELECT * FROM employees
WHERE salary BETWEEN 40000 AND 60000;

14. Using EXISTS
SELECT * FROM departments d
WHERE EXISTS (
    SELECT 1 FROM employees e
    WHERE e.department_id = d.department_id
    AND e.salary > 70000
);

15. Date Functions
SELECT * FROM employees
WHERE hire_date > TO_DATE('2020-01-01', 'YYYY-MM-DD');

16. Updating Data
UPDATE employees
SET salary = salary * 1.10
WHERE department = 'IT';

17. Deleting Data
DELETE FROM employees
WHERE status = 'Inactive'; -- Assuming there is a 'status' column

18. Creating a Table
CREATE TABLE customers (
    customer_id NUMBER PRIMARY KEY,
    first_name VARCHAR2(50),
    last_name VARCHAR2(50),
    email VARCHAR2(100),
    phone_number VARCHAR2(15)
);

19. Modifying a Table (ALTER)
ALTER TABLE employees
ADD hire_date DATE;

20. Dropping a Table
DROP TABLE temporary_employees
PURGE;
