-- ex1
INSERT INTO DEPT VALUES (50, 'IT', 'SEOUL');

-- ex2.
SELECT COUNT(*) CNT FROM DEPT WHERE DEPTNO=40;
SELECT * FROM DEPT WHERE DEPTNO=50;
INSERT INTO DEPT VALUES (44, 'IT', 'SEOUL');
SELECT * FROM DEPT;