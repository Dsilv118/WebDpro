-- -- [XI] �ε��� : ��ȸ�� ������ �ϴ� �ε���
SELECT * FROM USER_INDEXES;

DROP TABLE EMP01;
CREATE TABLE EMP01 AS SELECT * FROM EMP; -- EMP���̺��� ���� ������ EMP01;
SELECT * FROM EMP01; -- 14��
INSERT INTO EMP01 SELECT * FROM EMP01; -- �ڵ����� ��Ƣ�� 1��(28��) 2��(56��)
SELECT TO_CHAR(COUNT(*), '9,999,999') FROM EMP01;
INSERT INTO EMP01 SELECT * FROM EMP01; -- �� 11�� (11����)
INSERT INTO EMP01 (EMPNO, ENAME, DEPTNO) VALUES (1111, 'HONG', 40);
INSERT INTO EMP01 SELECT * FROM EMP01; -- 1��(22��) 2��(44��) 3��(90��)
SELECT TO_CHAR(COUNT(*), '9,999,999') FROM EMP01;
-- �ε��� ���� �� ��ȸ 
SELECT * FROM EMP01 WHERE ENAME='HONG'; -- �� �ε��� ���� �� ��ȸ �ð�(91��) 0.025��
-- �ε��� ����
CREATE INDEX IDX_EMP01_ENAME ON EMP01(ENAME); -- 0.659�� 
-- �ε��� ���� �� ��ȸ 
SELECT * FROM EMP01 WHERE ENAME='HONG'; -- �� �ε��� ���� �� ��ȸ �ð�(91��) 0.002��
COMMIT;
INSERT INTO EMP01 SELECT * FROM EMP01; -- �ε��� ���� �� 91�� -> 182������ INSERT �ð� : 35.25��
SELECT TO_CHAR(COUNT(*), '9,999,999') FROM EMP01;
ROLLBACK; -- 14.19��
DROP INDEX IDX_EMP01_ENAME;
INSERT INTO EMP01 SELECT * FROM EMP01; -- �ε��� ������ 91�� -> 182������ INSERT �ð� : 4.355��

SELECT * FROM USER_INDEXES WHERE TABLE_NAME='EMP01';
DROP TABLE EMP01; -- ���̺��� ������ش� ���̺��� �ε����� �ڵ� ����

