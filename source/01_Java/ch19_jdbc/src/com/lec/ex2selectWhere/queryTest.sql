-- Ex1. �μ���ȣ �ް� �μ����� ����ϱ�
SELECT * FROM DEPT WHERE DEPTNO=40;
-- 40�� ����
-- Ex2. �μ���ȣ �ް� �μ������� ������� ���(���, �̸�, �޿�, ����)
SELECT * FROM DEPT WHERE DEPTNO=40;
SELECT E1.EMPNO, E1.ENAME WOR, E1.SAL, E2.ENAME MAN
    FROM EMP E1, EMP E2 
    WHERE E1.MGR=E2.EMPNO AND E1.DEPTNO=30;

-- Ex3. �μ��̸� �˻�
SELECT * FROM DEPT;