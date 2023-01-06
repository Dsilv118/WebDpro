-- ���̺�, ������ ���� �� ����
DROP SEQUENCE CUSEQ;
DROP TABLE CUSTOMER;
DROP TABLE CUSGRADE;

CREATE TABLE CUSGRADE (
    CGID    NUMBER(1) PRIMARY KEY,
    CGNAME  VARCHAR(20) NOT NULL,
    LOPOINT NUMBER(7) NOT NULL,
    HIPOINT NUMBER(7)
);
SELECT * FROM CUSGRADE;

CREATE TABLE CUSTOMER (
    CID    NUMBER(5) PRIMARY KEY,
    CTEL   VARCHAR2(50) NOT NULL,
    CNAME  VARCHAR2(30) NOT NULL,
    CPOINT NUMBER(8) NOT NULL CHECK(CPOINT>0),
    CBUY   NUMBER(10) NOT NULL CHECK(CBUY>=0),
    CGID   NUMBER(1) NOT NULL,
    FOREIGN KEY (CGID) REFERENCES CUSGRADE(CGID)
);
SELECT * FROM CUSTOMER;

CREATE SEQUENCE CUSEQ
    MAXVALUE 99999
    NOCACHE
    NOCYCLE;

-- ���� ������ insert
INSERT INTO CUSGRADE VALUES (1, '�����', 0, 500000);
INSERT INTO CUSGRADE VALUES (2, '�ǹ�', 500001, 1500000);
INSERT INTO CUSGRADE VALUES (3, '���', 1500001, 3000000);
INSERT INTO CUSGRADE VALUES (4, 'VIP', 3000001, 5000000);
INSERT INTO CUSGRADE VALUES (5, 'VVIP', 5000001, 6000000);
INSERT INTO CUSGRADE VALUES (6, 'ML', 6000001, NULL);
SELECT * FROM CUSGRADE;

INSERT INTO CUSTOMER VALUES (CUSEQ.NEXTVAL, '010-2345-5678', 'ȫ�浿', 1000, 0, 1);
INSERT INTO CUSTOMER VALUES (CUSEQ.NEXTVAL, '010-5601-1338', '�ű浿', 1000, 0, 1);
INSERT INTO CUSTOMER VALUES (CUSEQ.NEXTVAL, '010-8577-4533', '�ӱ浿', 1000, 0, 1);
SELECT * FROM CUSTOMER;
COMMIT;

-- ��ɺ� Query
-- 1. ȸ������ 
--    ��ȭ��ȣ�� �̸��� �Է¹޾� ȸ������(ȸ�����Խ� ����Ʈ�� 1000�� ����)
INSERT INTO CUSTOMER VALUES (CUSEQ.NEXTVAL, '010-2345-5678', 'ȫ�浿', 1000, 0, 1);


-- 2. ��4�ڸ�(FULL) �˻�
--    �� ��4�ڸ��� FULL��ȣ�� �Է¹޾� ������(ID, ��ȭ, �̸�, ����Ʈ, ���Ŵ�����, ������, �������� ���� �߰� ������ �ݾ�) �� ���Ŵ����� ū ������ ���
--    ��� ����� 0�� �̻� 
SELECT HIPOINT FROM CUSGRADE WHERE CGNAME=H.CGNAME;
SELECT CID, CTEL, CNAME, CPOINT, CBUY, CGNAME;


-- 3. ��ǰ����
--    ��id(��ȣ)�� ��ǰ���Ű����� �Է¹޾� ���� ó��.
--    (1) ���Ŵ����ݾ׿� �ݹ� ���űݾ��� ����
--    (2) �ݹ� ���Ŵ����ݾ��� 5%����Ʈ�� ����
--    (3) ����� ���Ŵ����ݾ׿� ���� ���� ������ ���������� ��� �� ������ ���� 



-- 4. �� ��޺� ���
--    � ������ ���ϴ��� �����ͺ��̽��� �����̸��� ����ϸ� Ư�� �������� �Է¹޴´�.
--    �ش� ���� ������(ID, ��ȭ, �̸�, ����Ʈ, ���Ŵ�����, ������, �������� ���� �߰� ��
--    ���� �ݾ�)�� ���Ŵ����� ū ������ ���



-- 5. ��ü ���
--    ��ü ������(ID, ��ȭ, �̸�, ����Ʈ, ���Ŵ�����, ������, �������� ���� �߰� ������
--    �ݾ�)�� ���Ŵ����� ū ������ ���



-- 6. ȸ��Ż�� ? ��ȭ��ȣ�� �Է¹޾� Ż��ó��


















