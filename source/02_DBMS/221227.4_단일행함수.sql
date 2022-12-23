-- [ IV ] �����Լ�:�������Լ�
-- �Լ� = �������Լ� + �׷��Լ� (�����Լ�)
SELECT HIREDATE, TO_CHAR(HIREDATE, 'YYYY-MM-DD') -- ������ ������ ����
    FROM EMP;
SELECT ENAME, INITCAP (ENAME) FROM EMP; -- ������ �Լ�(INPUT 1�� -> OUTPUT 1��)
SELECT SUM(SAL), AVG(SAL) FROM EMP; -- �׷� �Լ�(INPUT n�� -> OUTPUT 1��)
SELECT DEPTNO, AVG(SAL) FROM EMP GROUP BY DEPTNO; -- �׷� �Լ�(INPUT n�� -> OUTPUT 1��)

-- �� �������Լ��� ���� : ���ڰ����Լ�, ���ڰ����Լ�, ��¥�����Լ�, ����ȯ�Լ�, NVL(), ETC....
-- 1. ���ڰ����Լ�
    -- DUAL���̺� : ����Ŭ���� ������ 1�� 1��¥�� DUMMY TABLE 
SELECT * FROM DUAL;
DESC DUAL;
SELECT * FROM DUMMY;
DESC DUMMY;
SELECT ABS(-1) FROM DUMMY; -- ���밪

SELECT FLOOR(34.5678) FROM DUAL; -- �Ҽ������� ����(����)
SELECT FLOOR(34.5678*100)/100 FROM DUAL; -- �Ҽ��� �ι�°���� ����(����)
SELECT TRUNC(34.5678, 2) FROM DUAL; -- �Ҽ��� �ι�° �ڸ����� ����(����)
SELECT TRUNC(34.5678) FROM DUAL;    -- �Ҽ������� ����(����)
SELECT TRUNC(34.5678, -1) FROM DUAL; -- 1�� �ڸ����� ����(����)
    -- Ex. EMP���̺��� �̸�, �޿�(���� �ڸ����� ����)
SELECT ENAME, SAL, TRUNC(SAL, -2) FROM EMP;

SELECT CEIL(34.5678) FROM DUAL; -- �Ҽ������� �ø�
SELECT ROUND(34.5678) FROM DUAL; -- �Ҽ������� �ݿø�
SELECT ROUND(34.5678, 2) FROM DUAL; -- �Ҽ��� �ι�° �ڸ����� �������� �ݿø�
SELECT ROUND(34.5678, -1) FROM DUAL; -- ���� �ڸ����� �ݿø�

SELECT MOD(9, 2) FROM DUAL; -- ������ ������
    
    -- Ex. Ȧ���⵵�� �Ի��� ����� ��� ���� ���
SELECT * FROM EMP WHERE MOD(TO_CHAR(HIREDATE, 'RR'), 2) = 1;

-- 2. ���ڰ����Լ�
-- �� ��ҹ��� ����
SELECT INITCAP('WELCOME TO ORACLE') FROM DUAL; -- ù���ڸ� �빮�ڷ�
SELECT INITCAP('Welcome To Oracle') FROM DUAL; 
SELECT UPPER('ABCabc') FROM DUAL; -- �빮�ڷ�
SELECT LOWER('ABCabc') FROM DUAL; -- �ҹ��ڷ�
    -- Ex. �̸��� SCOTT�� ������ ��� �ʵ� 
SELECT * FROM EMP WHERE UPPER(ENAME)='SCOTT';    
SELECT * FROM EMP WHERE INITCAP(ENAME)='Scott';
    -- Ex. Job�� MANAGER�� ������ ��� �ʵ�
SELECT * FROM EMP WHERE UPPER(JOB) = 'MANAGER';
SELECT * FROM EMP WHERE INITCAP(JOB) = 'Manager';
SELECT * FROM EMP WHERE LOWER(JOB) = 'manager';

-- �� ���ڿ���(concat�Լ�, ||������)
SELECT 'AB'||'CD'||'EF'||'GH' FROM DUAL;
SELECT CONCAT(CONCAT('AB','CD'), CONCAT('EF','GH')) FROM EMP;
    -- Ex. SMITH�� manager��
SELECT CONCAT(CONCAT(ENAME, '�� '), CONCAT(JOB, '��')) FROM EMP;
SELECT ENAME || '�� ' || JOB || '��' FROM EMP;

