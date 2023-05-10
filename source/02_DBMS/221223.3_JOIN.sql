-- [ III ] join : 2�� �̻��� ���̺��� �����Ͽ� �����͸� �˻��ϴ� ���
SELECT * FROM EMP WHERE ENAME='SCOTT'; -- 1�� 
SELECT * FROM DEPT; -- 4��
-- CROSS JOIN (FROM ���� ���̺��� 2�� �̻�)
SELECT * FROM EMP, DEPT WHERE ENAME='SCOTT'; -- 1(EMP���̺��� ����)*4(DEPT���̺� ����)

SELECT * FROM EMP WHERE ENAME='SCOTT';

--�� 1. EQUI JOIN(�����ʵ� DEPTNO���� ��ġ�Ǵ� ���Ǹ� JOIN)
SELECT * FROM EMP, DEPT    
    WHERE ENAME='SCOTT' AND EMP.DEPTNO=DEPT.DEPTNO;
    -- EX. ��� ����� ���, �̸�, JOB, �����, �μ���ȣ, �μ��̸�, �ٹ���
SELECT EMPNO, ENAME, JOB, MGR, EMP.DEPTNO, DNAME, LOC
    FROM EMP, DEPT
    WHERE EMP.DEPTNO=DEPT.DEPTNO;
SELECT EMPNO, ENAME, JOB, MGR, E.DEPTNO, DNAME, LOC
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO;
    -- EX. �޿��� 2000�̻��� ������ �̸�, ��å, �޿�, �μ���, �ٹ��� ���
SELECT ENAME, JOB, SAL, DNAME, LOC
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO AND SAL>=2000;
    -- EX. 20�μ��� ������ �̸�, �μ���ȣ, �ٹ��� ���
SELECT ENAME, E.DEPTNO, LOC
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO AND D.DEPTNO=20;
    -- Ex. LOC�� CHICAGO�� ����� �̸�, ����, �޿�, �μ���, �ٹ��ڸ� ���
SELECT ENAME, JOB, SAL, DNAME, LOC
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND LOC='CHICAGO';
    -- Ex. �μ���ȣ�� 10�̰ų� 20���� ����� �̸�, ����, �ٹ����� ���(�޿���)
SELECT ENAME, JOB, LOC
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND E.DEPTNO IN (10, 20);
    -- Ex. JOB�� SALESMAN�̰ų� MANAGER�� ����� �̸�, �޿�, ��, ����((SAL+COMM)*12), �μ���, �ٹ����� ���(������ ū ������ ����)
SELECT ENAME, SAL, COMM, (SAL+NVL(COMM, 0))*12 ����, JOB, LOC
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND JOB IN ('SALESMAN', 'MANAGER') 
    ORDER BY ���� DESC;
    --Ex. COMM�� NUJLL�̰� SAL�� 1200�̻��� ����� �̸�, �޿�, �Ի���, �μ���ȣ, �μ��� (�μ��� ��, �޿�ū �� ����)
SELECT ENAME, SAL, HIREDATE, E.DEPTNO, DNAME
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND COMM IS NULL AND SAL>=1200
    ORDER BY DNAME, SAL DESC;
    
    --	źź ������ ����
--	NEW YORK���� �ٹ��ϴ� ����� �̸��� �޿��� ����Ͻÿ�
SELECT ENAME, SAL
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND LOC='NEW YORK';
--	ACCOUNTING �μ� �Ҽ� ����� �̸��� �Ի����� ����Ͻÿ�
SELECT ENAME, HIREDATE
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND DNAME='ACCOUNTING';
--	������ MANAGER�� ����� �̸�, �μ����� ����Ͻÿ�
SELECT ENAME, DNAME
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND JOB='MANAGER';
--	Comm�� null�� �ƴ� ����� �̸�, �޿�, �μ��ڵ�, �ٹ����� ����Ͻÿ�.
SELECT ENAME, SAL, E.DEPTNO, LOC
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND COMM IS NOT NULL;
    

-- �� 2. NON-EQUI JOIN
SELECT * FROM EMP WHERE ENAME='SCOTT'; -- ���� ����
SELECT * FROM SALGRADE; -- �޿� ��� ����
SELECT * FROM EMP, SALGRADE WHERE ENAME='SCOTT'; -- CROSS JOIN 
SELECT * FROM EMP, SALGRADE WHERE SAL >= LOSAL AND SAL <= HISAL AND ENAME='SCOTT';
SELECT * FROM EMP, SALGRADE WHERE SAL BETWEEN LOSAL AND HISAL AND ENAME='SCOTT';
    --Ex.��� ����� ���, �̸�, ��å, �����, �޿�, �޿����(1���, 2���, ..)
SELECT EMPNO, ENAME, JOB, MGR, SAL, GRADE || '���' GRADE
    FROM EMP, SALGRADE
    WHERE SAL BETWEEN LOSAL AND HISAL;
    
--    ?	źź������ ��������
--	Comm�� null�� �ƴ� ����� �̸�, �޿�, ���, �μ���ȣ, �μ��̸�, �ٹ����� ����Ͻÿ�.
SELECT ENAME, SAL, GRADE, E.DEPTNO, DNAME, LOC
    FROM EMP E, DEPT D, SALGRADE S
    WHERE E.DEPTNO=D.DEPTNO AND SAL BETWEEN LOSAL AND HISAL
        AND COMM IS NOT NULL;
--	�̸�, �޿�, �Ի���, �޿����
SELECT ENAME, SAL, HIREDATE, GRADE 
    FROM EMP, SALGRADE 
    WHERE SAL BETWEEN LOSAL AND HISAL;
--	�̸�, �޿�, �Ի���, �޿����, �μ���, �ٹ���
SELECT ENAME, SAL, GRADE, DNAME, LOC
    FROM EMP E, DEPT D, SALGRADE
    WHERE E.DEPTNO=D.DEPTNO AND SAL BETWEEN LOSAL AND HISAL;
--	�̸�, �޿�, ���, �μ��ڵ�, �ٹ���. �� comm �� null�ƴ� ���
SELECT ENAME, GRADE, E.DEPTNO, LOC
    FROM EMP E, DEPT D, SALGRADE
    WHERE E.DEPTNO=D.DEPTNO AND SAL BETWEEN LOSAL AND HISAL
        AND COMM IS NOT NULL;
--	�̸�, �޿�, �޿����, ����, �μ���, �μ��� ���, �μ��� ������ ������. ����=(sal+comm)*12 comm�� null�̸� 0
SELECT ENAME, SAL, GRADE, (SAL+NVL(COMM, 0))*12 ANNUAL, DNAME
    FROM EMP E, DEPT D, SALGRADE
    WHERE E.DEPTNO=D.DEPTNO AND SAL BETWEEN LOSAL AND HISAL
    ORDER BY DNAME, ANNUAL;
--	�̸�, ����, �޿�, ���, �μ��ڵ�, �μ��� ���. �޿��� 1000~3000����. �������� : �μ���, �μ������� ������, ���������� �޿� ū��
SELECT ENAME, JOB, SAL, GRADE, E.DEPTNO, DNAME
    FROM EMP E, DEPT D, SALGRADE
    WHERE E.DEPTNO=D.DEPTNO AND (SAL BETWEEN LOSAL AND HISAL) AND (SAL BETWEEN 1000 AND 3000)
    ORDER BY DNAME, JOB, SAL DESC;
--	�̸�, �޿�, ���, �Ի���, �ٹ���. 81�⿡ �Ի��� ���. ��� ū��
SELECT ENAME, SAL, GRADE, HIREDATE, LOC
    FROM EMP E, DEPT D, SALGRADE
    WHERE E.DEPTNO=D.DEPTNO AND (SAL BETWEEN LOSAL AND HISAL) AND HIREDATE LIKE '81/%'
    ORDER BY GRADE DESC;


-- �� 3. SELF-JOIN
SELECT EMPNO, ENAME, MGR FROM EMP WHERE ENAME='SMITH';
SELECT EMPNO, ENAME FROM EMP WHERE EMPNO=7902;
SELECT WORKER.EMPNO, WORKER.ENAME, WORKER.MGR, MANAGER.EMPNO, MANAGER.ENAME
    FROM EMP WORKER, EMP MANAGER
    WHERE WORKER.ENAME='SMITH' AND WORKER.MGR=MANAGER.EMPNO;
    -- Ex. ��� ����� ���, �̸�, ����� ���, ����� �̸�
SELECT W.EMPNO, W.ENAME, W.MGR, M.ENAME
    FROM EMP W, EMP M
    WHERE W.MGR=M.EMPNO; -- 13�� (KING�� MGR�� NULL�̶�. EMPNO�� NULL�Ұ�)
    -- Ex. 'SMITH�� ���� FORD��' �������� ���
SELECT W.ENAME || '�� ���� ' || M.ENAME || '��' MESSAGE
    FROM EMP W, EMP M
    WHERE W.MGR=M.EMPNO;

INSERT INTO DEPT VALUES (50, 'IT', 'DALLAS');
INSERT INTO EMP VALUES (9999, 'ȫ', NULL, NULL, NULL, 6000, NULL, 50);

--   ?	źź ������
--	�Ŵ����� KING�� ������� �̸��� ������ ����Ͻÿ�.
SELECT W.ENAME, W.JOB
    FROM EMP W, EMP M
    WHERE W.MGR=M.EMPNO AND M.ENAME='KING';
--	SCOTT�� ������ �μ���ȣ���� �ٹ��ϴ� ����� �̸��� ����Ͻÿ�
SELECT S.ENAME
    FROM EMP W, EMP S
    WHERE W.ENAME='SCOTT' AND W.DEPTNO=S.DEPTNO AND S.ENAME!='SCOTT';
--	SCOTT�� ������ �ٹ������� �ٹ��ϴ� ����� �̸��� ����Ͻÿ�(2�ܰ� ��������)
SELECT E1.ENAME, E2.ENAME, LOC
    FROM EMP E1, EMP E2, DEPT D
    WHERE E1.ENAME='SCOTT' AND E2.DEPTNO=D.DEPTNO AND D.LOC='DALLAS' AND E2.ENAME!='SCOTT';
-- ȫ������ 50������ ������ ���󺹱�(����)
ROLLBACK;
SELECT * FROM DEPT;

-- �� 4. OUTER JOIN : EQUI JOIN & SELF JOIN�� ���ǿ� �������� �ʴ� ����� ��Ÿ���� 
-- (1) SELF JOIN������ OUTER JOIN 
SELECT W.ENAME, W.MGR, M.EMPNO, M.ENAME
    FROM EMP W, EMP M
    WHERE W.MGR=M.EMPNO(+);
    -- Ex. "SMITH�� ���� FORD" ... "KING�� ���� ����"
SELECT W.ENAME || '�� ���� ' || NVL(M.ENAME, '����')
    FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO(+);
    -- Ex. ���ܻ��
SELECT M.EMPNO, M.ENAME
    FROM EMP W, EMP M
    WHERE W.MGR(+)=M.EMPNO AND W.ENAME IS NULL;
-- (2) EQUI JOIN������ OUTER JOIN 
SELECT * FROM EMP; -- 14��
SELECT * FROM DEPT; -- 4�� (10, 20, 30, 40 �μ�)
SELECT * FROM EMP E, DEPT D WHERE E.DEPTNO=D.DEPTNO;    -- 40�� �μ� ��� �ȵ�
SELECT * FROM EMP E, DEPT D WHERE E.DEPTNO(+)=D.DEPTNO; -- 40�� �μ� ��� ��

-- �� <��������> PART1
--1. �̸�, ���ӻ���
SELECT E1.ENAME �̸�, E2.ENAME ���ӻ��
    FROM EMP E1, EMP E2
    WHERE E1.MGR=E2.EMPNO;
--2. �̸�, �޿�, ����, ���ӻ���
SELECT E1.ENAME �̸�, E1.SAL �޿�, E1.JOB ����, E2.ENAME ���ӻ��
    FROM EMP E1, EMP E2
    WHERE E1.MGR=E2.EMPNO;
--3. �̸�, �޿�, ����, ���ӻ��� . (��簡 ���� �������� ��ü ���� �� ���.
    --��簡 ���� �� '����'���� ���)
SELECT E1.ENAME �̸�, E1.SAL �޿�, E1.JOB ����, NVL(E2.ENAME, '����') ���ӻ��
    FROM EMP E1, EMP E2
    WHERE E1.MGR=E2.EMPNO(+);    
--4. �̸�, �޿�, �μ���, ���ӻ���
SELECT E1.ENAME �̸�, E1.SAL �޿�, DNAME �μ���, E2.ENAME ���ӻ��
    FROM EMP E1, EMP E2, DEPT D
    WHERE E1.MGR=E2.EMPNO AND E1.DEPTNO=D.DEPTNO;
--5. �̸�, �޿�, �μ��ڵ�, �μ���, �ٹ���, ���ӻ���, (��簡 ���� �������� ��ü ���� �� ���)
SELECT E1.ENAME �̸�, E1.SAL �޿�, E1.DEPTNO �μ��ڵ�, DNAME �μ���, LOC �ٹ���, NVL(E2.ENAME, '��� ����') ���ӻ��
    FROM EMP E1, EMP E2, DEPT D
    WHERE E1.MGR=E2.EMPNO(+) AND E1.DEPTNO=D.DEPTNO;
--6. �̸�, �޿�, ���, �μ���, ���ӻ���. �޿��� 2000�̻��� ���
SELECT E1.ENAME �̸�, E1.SAL �޿�, GRADE, DNAME �μ���, E2.ENAME ���ӻ��
    FROM EMP E1, EMP E2, DEPT D, SALGRADE S
    WHERE E1.MGR=E2.EMPNO AND E1.DEPTNO=D.DEPTNO AND (E1.SAL BETWEEN LOSAL AND HISAL) AND E1.SAL > 2000;
--7. �̸�, �޿�, ���, �μ���, ���ӻ���, (���ӻ�簡 ���� �������� ��ü���� �μ��� �� ����)
SELECT E1.ENAME �̸�, E1.SAL �޿�, GRADE ���, DNAME �μ���, NVL(E2.ENAME, '��� ����') ���ӻ��
    FROM EMP E1, EMP E2, DEPT D, SALGRADE S
    WHERE E1.MGR=E2.EMPNO(+) AND E1.DEPTNO=D.DEPTNO AND (E1.SAL BETWEEN LOSAL AND HISAL)
    ORDER BY DNAME;
--8. �̸�, �޿�, ���, �μ���, ����, ���ӻ���. ����=(�޿�+comm)*12 �� comm�� null�̸� 0
SELECT E1.ENAME �̸�, E1.SAL �޿�, GRADE ���, DNAME �μ���, (E1.SAL+NVL(E1.COMM, 0))*12 ����, E2.ENAME ���ӻ��
    FROM EMP E1, EMP E2, DEPT D, SALGRADE S
    WHERE E1.MGR=E2.EMPNO AND E1.DEPTNO=D.DEPTNO AND (E1.SAL BETWEEN LOSAL AND HISAL);
--9. 8���� �μ��� �� �μ��� ������ �޿��� ū �� ����
SELECT E1.ENAME �̸�, E1.SAL �޿�, GRADE ���, DNAME �μ���, (E1.SAL+NVL(E1.COMM, 0))*12 ����, E2.ENAME ���ӻ��
    FROM EMP E1, EMP E2, DEPT D, SALGRADE S
    WHERE E1.MGR=E2.EMPNO AND E1.DEPTNO=D.DEPTNO AND (E1.SAL BETWEEN LOSAL AND HISAL)
    ORDER BY DNAME, E1.SAL DESC;
--  PART2
--1.EMP ���̺��� ��� ����� ���� �̸�, �μ���ȣ, �μ����� ����ϴ� SELECT ������ �ۼ��Ͽ���.
SELECT ENAME �̸�, E.DEPTNO �μ���ȣ, DNAME �μ���
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO;
--2. EMP ���̺��� NEW YORK���� �ٹ��ϰ� �ִ� ����� ���Ͽ� �̸�, ����, �޿�, �μ����� ���
SELECT ENAME �̸�, JOB ����, SAL �޿�, DNAME �μ���, LOC �ٹ���
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND D.LOC='NEW YORK';
--3. EMP ���̺��� ���ʽ��� �޴� ����� ���Ͽ� �̸�,�μ���,��ġ�� ���
SELECT ENAME �̸�, DNAME �μ���, LOC �ٹ���, COMM ���ʽ�
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND E.COMM IS NOT NULL AND E.COMM != 0;
--4. EMP ���̺��� �̸� �� L�ڰ� �ִ� ����� ���Ͽ� �̸�,����,�μ���,��ġ�� ���
SELECT ENAME �̸�, JOB, DNAME �μ���, LOC �ٹ���
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND E.ENAME LIKE '%L%';
--5. ���, �����, �μ��ڵ�, �μ����� �˻��϶�. ������������ ������������
SELECT EMPNO ���, ENAME �����, E.DEPTNO �μ��ڵ�, DNAME �μ���
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO
    ORDER BY ENAME;
--6. ���, �����, �޿�, �μ����� �˻��϶�. 
    --�� �޿��� 2000�̻��� ����� ���Ͽ� �޿��� �������� ������������ �����Ͻÿ�
SELECT EMPNO ���, ENAME �����, SAL �޿�, DNAME �μ���
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND SAL>=2000
    ORDER BY SAL DESC;
--7. ���, �����, ����, �޿�, �μ����� �˻��Ͻÿ�. �� ������ MANAGER�̸� �޿��� 2500�̻���
-- ����� ���Ͽ� ����� �������� ������������ �����Ͻÿ�.
SELECT EMPNO ���, ENAME �����, JOB ����, SAL �޿�, DNAME �μ���
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND JOB='MANAGER' AND SAL >= 2500
    ORDER BY EMPNO;
--8. ���, �����, ����, �޿�, ����� �˻��Ͻÿ�. ��, �޿����� ������������ �����Ͻÿ�
SELECT EMPNO ���, ENAME �����, JOB ����, SAL �޿�, GRADE ���
    FROM EMP E, SALGRADE S
    WHERE (SAL BETWEEN LOSAL AND HISAL)
    ORDER BY SAL DESC;
--9. ������̺��� �����, ����� ��縦 �˻��Ͻÿ�(��簡 ���� �������� ��ü)
SELECT E1.ENAME �����, NVL(E2.ENAME, '��� ����') ���
    FROM EMP E1, EMP E2
    WHERE E1.MGR=E2.EMPNO(+);
--10. �����, ����, ����� ������ �˻��Ͻÿ�
SELECT E1.ENAME �����, E2.ENAME ����, E3.ENAME ����ǻ��
    FROM EMP E1, EMP E2, EMP E3
    WHERE E1.MGR=E2.EMPNO AND E2.MGR=E3.EMPNO;
--11. ���� ������� ���� ��簡 ���� ��� ������ �̸��� ��µǵ��� �����Ͻÿ�
SELECT E1.ENAME �����, NVL(E2.ENAME, '������') ����, NVL(E3.ENAME, '������') ����ǻ��
    FROM EMP E1, EMP E2, EMP E3
    WHERE E1.MGR=E2.EMPNO(+) AND E2.MGR=E3.EMPNO(+);
    

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    