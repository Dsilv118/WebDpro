-- [ VI ] Sub Query : ���� QUERY(SQL��) �ȿ� QUERY(SQL��)�� ����


-- �� 1. ���� ���� ����
 -- ���������� �ʿ��� EX. �޿��� ���� ���� �޴� ����� �̸��� �޿��� ���
SELECT ENAME, MAX(SAL) FROM EMP; -- ����
SELECT ENAME, MAX(SAL) FROM EMP GROUP BY ENAME; -- �� ����
SELECT ENAME, SAL 
    FROM EMP
    WHERE SAL = (SELECT MAX(SAL) FROM EMP); -- ��������

-- �������� ����(1) ������ ��������(���������� �������� ������) :  =  >=  <  <=  != 
    -- EX. SCOTT�� �ٹ��ϴ� �μ��̸� ��� 
SELECT DEPTNO FROM EMP WHERE ENAME='SCOTT';
SELECT DNAME
    FROM DEPT
    WHERE DEPTNO=(SELECT DEPTNO FROM EMP WHERE ENAME='SCOTT');
    
-- �������� ����(2) ������ ��������(�������� �������� 2�� �̻�) : IN, > ALL ANY(SOME), EXISTS
    -- EX. JOB�� MANAGER�� ����� �μ��̸�
SELECT DEPTNO FROM EMP WHERE JOB='MANAGER'; -- �������� ����� 3��
SELECT DNAME 
    FROM DEPT 
    WHERE DEPTNO IN (SELECT DEPTNO FROM EMP WHERE JOB='MANAGER'); -- ��������
    
    
-- �� 2. �����༭������
    -- EX. SCOTT�� ������ �μ���ȣ���� �ٹ��ϴ� ����� �̸��� �޿� 
SELECT DEPTNO FROM EMP WHERE ENAME='SCOTT'; -- ��������
SELECT ENAME, SAL 
    FROM EMP 
    WHERE DEPTNO=(SELECT DEPTNO FROM EMP WHERE ENAME='SCOTT') AND ENAME <> 'SCOTT'; -- ��������
    -- EX. SCOTT�� ������ �ٹ������� �ٹ��ϴ� ����� �̸��� �޿�
        -- ������ �߰� (DALLAS 50�� �μ�, 50�� �μ��� HONG ���)
SELECT * FROM DEPT WHERE LOC='DALLAS';
INSERT INTO DEPT VALUES (50, 'IT', 'DALLAS');
INSERT INTO EMP (EMPNO, ENAME, DEPTNO) VALUES (9999, 'HONG', 50);
SELECT * FROM EMP;
SELECT LOC 
    FROM EMP E,DEPT D 
    WHERE E.DEPTNO=D.DEPTNO AND ENAME='SCOTT'; -- ��������
SELECT ENAME, SAL
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND LOC=(SELECT LOC FROM EMP E,DEPT D 
    WHERE E.DEPTNO=D.DEPTNO AND ENAME='SCOTT')
    AND ENAME != 'SCOTT';
ROLLBACK; -- DML(�߰�, ����, ����, �˻�) ��ɾ� ���
    -- EX. ���� �Ի��ϰ� ���� �Ի��ڸ� ���
SELECT MIN(HIREDATE) FROM EMP; -- ������ ��������
SELECT HIREDATE, ENAME FROM EMP
    WHERE HIREDATE = (SELECT MIN(HIREDATE) FROM EMP); -- ��������
    -- EX. �ֱ� �Ի��ϰ� �ֱ� �Ի��ڸ� ���
SELECT MAX(HIREDATE) FROM EMP; -- ��������
SELECT HIREDATE, ENAME FROM EMP
    WHERE HIREDATE = (SELECT MAX(HIREDATE) FROM EMP); -- ��������
    -- EX. ���� �Ի���, ���� �Ի��� �̸�, �ֱ� �Ի���, �ֱ� �Ի��� �̸�
SELECT E1.HIREDATE, E1.ENAME, E2.HIREDATE, E2.ENAME 
    FROM EMP E1, EMP E2
    WHERE E1.HIREDATE = (SELECT MIN(HIREDATE) FROM EMP)
      AND E2.HIREDATE = (SELECT MAX(HIREDATE) FROM EMP);
SELECT (SELECT MIN(HIREDATE) FROM EMP) FIRSTDAY,
       (SELECT ENAME FROM EMP WHERE HIREDATE=(SELECT MIN(HIREDATE) FROM EMP)) FIRSTMAN,
       (SELECT MAX(HIREDATE) FROM EMP) LASTDAY,
       (SELECT ENAME FROM EMP WHERE HIREDATE=(SELECT MAX(HIREDATE) FROM EMP)) LASTMAN
       FROM DUAL;
    -- EX. SCOTT �� ���� �μ���ȣ�� �ٹ��ϴ� ������� �޿���
SELECT DEPTNO FROM EMP WHERE ENAME='SCOTT'; -- ��������
SELECT SUM(SAL) FROM EMP 
    WHERE DEPTNO=(SELECT DEPTNO FROM EMP WHERE ENAME='SCOTT'); -- ��������
    -- EX. SCOTT�� ������ JOB�� ���� ����� ��� �ʵ�
SELECT JOB FROM EMP WHERE ENAME='SCOTT'; -- ��������
SELECT * FROM EMP WHERE JOB=(SELECT JOB FROM EMP WHERE ENAME='SCOTT'); -- ��������
    -- EX. DALLAS���� �ٹ��ϴ� ����� �̸��� �μ���ȣ
SELECT DEPTNO FROM DEPT WHERE LOC='DALLAS'; -- ��������
SELECT ENAME, DEPTNO FROM EMP WHERE DEPTNO=(SELECT DEPTNO FROM DEPT WHERE LOC='DALLAS'); -- ��������
    -- EX. 'KING'�� ���ӻ���� ����� �̸��� �޿��� ���
    -- �������� �̿�
SELECT EMPNO FROM EMP WHERE ENAME='KING'; 
SELECT ENAME, SAL FROM EMP WHERE MGR=(SELECT EMPNO FROM EMP WHERE ENAME='KING'); 
    -- SELF JOIN �̿�
SELECT E1.ENAME, E1.SAL
    FROM EMP E1, EMP E2
    WHERE E1.MGR=E2.EMPNO AND E2.ENAME='KING'; 
    -- EX1. ��ձ޿� ���Ϸ� �޴� ����� �̸��� �޿��� ���
SELECT AVG(SAL) FROM EMP; -- ��������
SELECT ENAME, SAL FROM EMP
    WHERE SAL <= (SELECT AVG(SAL) FROM EMP);
    -- EX2. ��ձ޿� ���Ϸ� �޴� ����� �̸��� �޿�, ��ձ޿��� ���
SELECT AVG(SAL) FROM EMP;
SELECT ENAME, SAL, ROUND((SELECT AVG(SAL) FROM EMP), 0) "AVG_SAL"
    FROM EMP
    WHERE SAL < ROUND((SELECT AVG(SAL) FROM EMP), 0);
    -- EX2. ��ձ޿� ���Ϸ� �޴� ����� �̸��� �޿�, ��ձ޿����� ���̸� ���
SELECT AVG(SAL) FROM EMP;
SELECT ENAME, SAL, ROUND((SELECT AVG(SAL) FROM EMP), 0)-SAL "DIFF"
    FROM EMP
    WHERE SAL < ROUND((SELECT AVG(SAL) FROM EMP), 0);
-- ������ ���߿� ��������
    -- EX. SCOTT�� JOB�� �μ���ȣ�� ���� ������ ��� �ʵ� ���.
SELECT JOB, DEPTNO FROM EMP WHERE ENAME='SCOTT'; -- ������ ���߿� ��������
SELECT * FROM EMP
    WHERE (JOB, DEPTNO) = (SELECT JOB, DEPTNO FROM EMP WHERE ENAME='SCOTT') AND ENAME!='SCOTT';


-- �� ������ �������� : IN, ALL, ANY=SOME, EXISTS
-- (1) IN : �������� ��� �� �ϳ��� ��ġ�ϸ� ��
    -- EX. �μ��� �Ի����� ���� ���� ����� �̸�, �Ի���, �μ���ȣ
SELECT DEPTNO, MAX(HIREDATE) FROM EMP GROUP BY DEPTNO; -- ������ ���߿� ��������
SELECT ENAME, HIREDATE, DEPTNO
    FROM EMP E
    WHERE (DEPTNO, HIREDATE) IN (SELECT DEPTNO, MAX(HIREDATE) FROM EMP GROUP BY DEPTNO);
    -- EX. �޿��� 3000�̻� �޴� ����� �Ҽӵ� �μ��� ������� ��� �ʵ�
SELECT DEPTNO FROM EMP WHERE SAL >= 3000; -- ������ ���Ͽ� ��������
SELECT * FROM EMP WHERE DEPTNO IN (SELECT DEPTNO FROM EMP WHERE SAL >= 3000); -- ��������

-- (2) ALL : �������� ����� ��� �����ϸ� ��
    -- EX. 30�� �μ����� �� ����� �޿����� ū ������ ��� �ʵ�(MAX)
SELECT SAL FROM EMP WHERE DEPTNO=30; -- 950, 1250, 1500, 1600, 2850 ��������
SELECT * FROM EMP
    WHERE SAL > ALL (SELECT SAL FROM EMP WHERE DEPTNO=30); -- ������ �������� �̿�

SELECT * FROM EMP
    WHERE SAL > (SELECT MAX(SAL) FROM EMP WHERE DEPTNO=30); -- ������ �������� �̿� 
-- (3) ANY=SOME : �������� ����� �ϳ��� �����ϸ� ��
    -- EX. 30�� �μ����� �� �ϳ��� �޿����� ū ������ ��� �ʵ�(MIN)
SELECT SAL FROM EMP WHERE DEPTNO=30; -- ������ ���Ͽ� ��������
SELECT * FROM EMP
    WHERE SAL > ANY (SELECT SAL FROM EMP WHERE DEPTNO=30); -- ������ �������� �̿�

SELECT * FROM EMP
    WHERE SAL > (SELECT MIN(SAL) FROM EMP WHERE DEPTNO=30); -- ������ �������� �̿�
-- (4) EXISTS : �������� ����� �����ϸ� ��
    -- ���Ӻ��ϰ� �ִ� �������� ���, �̸�, �޿�
SELECT EMPNO, ENAME, SAL FROM EMP MANAGER
    WHERE EXISTS (SELECT * FROM EMP WHERE MANAGER.EMPNO=MGR); -- �������� �̿�

SELECT DISTINCT E2.EMPNO, E2.ENAME, E2.SAL
    FROM EMP E1, EMP E2
    WHERE E1.MGR=E2.EMPNO; -- SELF JOIN �̿�
        -- ���Ӻ��ϰ� ���� �������� ���, �̸�, �޿�
SELECT EMPNO, ENAME, SAL
    FROM EMP MANAGER
    WHERE NOT EXISTS (SELECT * FROM EMP WHERE MANAGER.EMPNO=MGR); -- �������� �̿�

SELECT E2.EMPNO, E2.ENAME, E2.SAL
    FROM EMP E1, EMP E2
    WHERE E1.MGR(+)=E2.EMPNO AND E1.ENAME IS NULL;

-- (4)	źź������ (������, ������)
-- źź EX1. �μ����� ���� �޿��� ���� �޴� ����� ����(��� ��ȣ, ����̸�, �޿�, �μ���ȣ)�� ���(IN ������ �̿�)
SELECT DEPTNO, MAX(SAL) FROM EMP GROUP BY DEPTNO; -- ��������
SELECT EMPNO, ENAME, SAL, DEPTNO FROM EMP
    WHERE (DEPTNO, SAL) IN (SELECT DEPTNO, MAX(SAL) FROM EMP GROUP BY DEPTNO);
-- źź EX2. ����(JOB)�� MANAGER�� ����� ���� �μ��� �μ� ��ȣ�� �μ���� ������ ���(IN)
SELECT DEPTNO FROM EMP WHERE JOB='MANAGER'; -- ��������
SELECT DEPTNO, DNAME, LOC 
    FROM DEPT 
    WHERE DEPTNO IN (SELECT DEPTNO FROM EMP WHERE JOB='MANAGER');
-- źź EX3. �޿��� 3000�̻��� ����� �� ���� ����� ����� �ش� ��޺� �ְ� ������ �޴� ������� ���, �̸�, ����, �Ի���, �޿�, �޿������ ���
SELECT GRADE, MAX(SAL) FROM EMP, SALGRADE WHERE (SAL BETWEEN LOSAL AND HISAL) AND SAL >= 3000 GROUP BY GRADE;
SELECT EMPNO, ENAME, JOB, HIREDATE, SAL, GRADE 
    FROM EMP, SALGRADE 
    WHERE (SAL BETWEEN LOSAL AND HISAL) AND 
    (GRADE, SAL) IN (SELECT GRADE, MAX(SAL) FROM EMP, SALGRADE WHERE (SAL BETWEEN LOSAL AND HISAL) AND SAL >= 3000 GROUP BY GRADE);
-- źź EX4. �����ȭ : �Ի��� �б⺰�� ���� ���� ������ �޴� ������� �б�, ���, �̸�, JOB, �����, �Ի���, �޿�, �󿩸� ����ϼ���
SELECT HIREDATE, CEIL(EXTRACT(MONTH FROM HIREDATE)/3) "QUARTER" FROM EMP;
SELECT HIREDATE, CEIL(TO_CHAR(HIREDATE, 'MM')/3) "QUARTER" FROM EMP;
SELECT HIREDATE, TO_CHAR(HIREDATE, 'Q') "QUARTER" FROM EMP;

SELECT TO_CHAR(HIREDATE, 'Q'), MAX(SAL) FROM EMP GROUP BY TO_CHAR(HIREDATE, 'Q'); -- ��������

SELECT TO_CHAR(HIREDATE, 'Q') "QUATER", EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM
    FROM EMP 
    WHERE (TO_CHAR(HIREDATE, 'Q'), SAL) IN (SELECT TO_CHAR(HIREDATE, 'Q'), MAX(SAL) FROM EMP GROUP BY TO_CHAR(HIREDATE, 'Q'))
    ORDER BY "QUATER"; 
-- źź EX5. �޿��� 3000�̸��� ��� �߿� ���� �ֱٿ� �Ի��� ����� �����ȣ�� �̸�, �޿�, �Ի����� ���
SELECT EMPNO, ENAME, SAL, HIREDATE
    FROM EMP
    WHERE HIREDATE = (SELECT MAX(HIREDATE) FROM EMP WHERE SAL<3000);
-- źź EX6. SALESMAN ��� ����� ���� �޿��� ���� �޴� ������� �̸��� �޿��� ����(��� ����)�� ����ϵ� ���� ����� ������� �ʴ´�.(ALL�̿�)
SELECT ENAME, SAL, JOB
    FROM EMP
    WHERE SAL > ALL (SELECT SAL FROM EMP WHERE JOB='SALESMAN');
-- źź EX7. SALESMAN �Ϻ� � �� ������� �޿��� ���� �޴� ������� �̸��� �޿��� ����(��� ����)�� ����ϵ� ���� ����� ���(ANY)
SELECT ENAME, SAL, JOB
    FROM EMP
    WHERE SAL > ANY (SELECT SAL FROM EMP WHERE JOB='SALESMAN');


-- �� �� ��������
--1. ������̺��� ���� ���� �Ի��� ����� �̸�, �޿�, �Ի���
SELECT MIN(HIREDATE) FROM EMP;
SELECT ENAME, SAL, HIREDATE
    FROM EMP
    WHERE HIREDATE=(SELECT MIN(HIREDATE) FROM EMP);
-- 2. ȸ�翡�� ���� �޿��� ���� ����� �̸�, �޿�
SELECT MIN(SAL) FROM EMP;
SELECT ENAME, SAL
    FROM EMP
    WHERE SAL=(SELECT MIN(SAL) FROM EMP);
-- 3. ȸ�� ��պ��� �޿��� ���� �޴� ����� �̸�, �޿�, �μ��ڵ�
SELECT ROUND(AVG(SAL)) FROM EMP;
SELECT ENAME, SAL, DEPTNO
    FROM EMP E
    WHERE SAL > (SELECT ROUND(AVG(SAL)) FROM EMP);
--4. ȸ�� ��� ������ �޿��� �޴� ����� �̸�, �޿�, �μ���
SELECT ROUND(AVG(SAL)) FROM EMP;
SELECT ENAME, SAL, DNAME
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND SAL <= (SELECT ROUND(AVG(SAL)) FROM EMP);
--5. SCOTT���� ���� �Ի��� ����� �̸�, �޿�, �Ի���, �޿� ���
SELECT HIREDATE FROM EMP WHERE ENAME='SCOTT';
SELECT ENAME, SAL, HIREDATE, GRADE
    FROM EMP, SALGRADE
    WHERE (SAL BETWEEN LOSAL AND HISAL) AND HIREDATE < (SELECT HIREDATE FROM EMP WHERE ENAME='SCOTT');
--6. 5��(SCOTT���� ���� �Ի��� ����� �̸�, �޿�, �Ի���, �޿� ���)�� �μ��� �߰��ϰ� �޿��� ū �� ����
SELECT ENAME, SAL, HIREDATE, GRADE, DNAME
    FROM EMP E, DEPT D, SALGRADE S
    WHERE E.DEPTNO=D.DEPTNO AND (SAL BETWEEN LOSAL AND HISAL) AND HIREDATE < (SELECT HIREDATE FROM EMP WHERE ENAME='SCOTT')
    ORDER BY SAL DESC;
--7. BLAKE ���� �޿��� ���� ������� ���, �̸�, �޿�
SELECT SAL FROM EMP WHERE ENAME='BLAKE';
SELECT EMPNO, ENAME, SAL
    FROM EMP
    WHERE SAL > (SELECT SAL FROM EMP WHERE ENAME='BLAKE');
--8. MILLER���� �ʰ� �Ի��� ����� ���, �̸�, �Ի���
SELECT EMPNO, ENAME, HIREDATE
    FROM EMP
    WHERE HIREDATE > (SELECT HIREDATE FROM EMP WHERE ENAME='MILLER');
--9. �����ü ��� �޿����� �޿��� ���� ������� ���, �̸�, �޿�
SELECT EMPNO, ENAME, SAL
    FROM EMP
    WHERE SAL > (SELECT AVG(SAL) FROM EMP);
--10. CLARK�� ���� �μ���ȣ�̸�, ����� 7698�� ������ �޿����� ���� �޿��� �޴� ����� ���, �̸�, �޿�
SELECT DEPTNO FROM EMP WHERE ENAME='CLARK';
SELECT SAL FROM EMP WHERE EMPNO=7698;
SELECT EMPNO, ENAME, SAL
    FROM EMP
    WHERE SAL > (SELECT SAL FROM EMP WHERE EMPNO=7698) AND DEPTNO=(SELECT DEPTNO FROM EMP WHERE ENAME='CLARK');
--11.  �����ȭ. CLARK�� ���� �μ����̸�, ����� 7698�� ������ �޿����� ���� �޿��� �޴� ����� ���, �̸�, �޿�
SELECT DNAME FROM EMP E, DEPT D WHERE E.DEPTNO=D.DEPTNO AND ENAME='CLARK';
SELECT SAL FROM EMP WHERE EMPNO=7698;
SELECT EMPNO, ENAME, SAL
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND SAL > (SELECT SAL FROM EMP WHERE EMPNO=7698) AND DNAME=(SELECT DNAME FROM EMP E, DEPT D WHERE E.DEPTNO=D.DEPTNO AND ENAME='CLARK');
--12. BLAKE�� ���� �μ��� �ִ� ��� ����� �̸��� �Ի�����
SELECT DNAME FROM EMP E, DEPT D WHERE E.DEPTNO=D.DEPTNO AND ENAME='BLAKE';
SELECT ENAME, HIREDATE
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND DNAME=(SELECT DNAME FROM EMP E, DEPT D WHERE E.DEPTNO=D.DEPTNO AND ENAME='BLAKE');
--13. ��� �޿� �̻��� �޴� ��� �������� ���ؼ� �����ȣ�� �̸� �� �޿��� ���� ������ ���)
SELECT ROUND(AVG(SAL)) FROM EMP;
SELECT EMPNO, ENAME
    FROM EMP
    WHERE SAL >= (SELECT ROUND(AVG(SAL)) FROM EMP)
    ORDER BY SAL DESC;
-- 14.  �̸��� ��T���� �ִ� ����� �ٹ��ϴ� �μ����� �ٹ��ϴ� ��� ������ ��� ��ȣ,�̸�,�޿�(�� ��� �� ���)
SELECT EMPNO, ENAME, SAL
    FROM EMP
    WHERE DEPTNO IN (SELECT DEPTNO FROM EMP WHERE ENAME LIKE '%I%')
    ORDER BY EMPNO;
-- 15. �μ� ��ġ�� Dallas�� ��� �������� ���� �̸�,����,�޿�
SELECT ENAME, JOB, SAL
    FROM EMP
    WHERE 
-- 16. EMP ���̺��� King���� �����ϴ� ��� ����� �̸��� �޿�

-- 17. SALES�μ� ����� �̸�, ����

-- 18. ������ �μ� 30�� ���� ���޺��� ���� ����� ��� �ʵ�

-- 19.  FORD�� ������ ���޵� ���� ����� ��� �ʵ�

-- 20. �̸��� JONES�� ������ JOB�� ���ų� FORD�� SAL �̻��� �޴� ����� ������ �̸�, ����, �μ���ȣ, �޿�
    -- ��, ������ ���ĺ� ��, ������ ���� ������ ���

-- 21. SCOTT �Ǵ� WARD�� ������ ���� ����� ������ �̸�,����,�޿�

-- 22. CHICAGO���� �ٹ��ϴ� ����� ���� ������ �ϴ� ������� �̸�,����

-- 23. �μ� ��� ���޺��� ������ ���� ����� ���, �̸�, �޿�, �μ���ȣ
SELECT EMPNO, ENAME, SAL, DEPTNO
    FROM EMP E
    WHERE SAL > (SELECT AVG(SAL) FROM EMP WHERE DEPTNO=E.DEPTNO);
    -- ���, �̸�, �޿�, �μ���ȣ, �ش�μ��� ���
SELECT EMPNO, ENAME, SAL, DEPTNO, (SELECT ROUND(AVG(SAL)) FROM EMP WHERE DEPTNO=E.DEPTNO) AVG
    FROM EMP E
    WHERE SAL > (SELECT AVG(SAL) FROM EMP WHERE DEPTNO=E.DEPTNO);

-- 24. �������� ��� ���޺��� ���� ������ �޴� ����� �μ���ȣ, �̸�, �޿�
SELECT EMPNO, ENAME, SAL
    FROM EMP E
    WHERE SAL < (SELECT AVG(SAL) FROM EMP WHERE JOB=E.JOB);
-- 25. ��� �� �� �̻����κ��� ���� ���� �� �ִ� ����� ����, �̸�, ���, �μ���ȣ�� ���(��, �μ���ȣ ������ �������� ����)

-- 26.  ���� ����� ���, �̸�, ����, �μ���ȣ































