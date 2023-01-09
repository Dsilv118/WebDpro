-- ��ɺ� Query
-- 1. ȸ������ 
-- ��ȭ��ȣ�� �̸��� �Է¹޾� ȸ������(ȸ�����Խ� ����Ʈ�� 1000�� ����)
    -- public int insertCustomer(String CTEL, String CNAME)
    -- public int insertCustomer(CustomerDto dto)
    
INSERT INTO CUSTOMER VALUES (CUSEQ.NEXTVAL, '010-2345-5678', '��浿', 1000, 0, 1);
ROLLBACK; -- COMMIT�̳� ROLLBACK �� �ϳ��� ����
-- 2. ��4�ڸ�(FULL) �˻�
--    �� ��4�ڸ��� FULL��ȣ�� �Է¹޾� ������(ID, ��ȭ, �̸�, ����Ʈ, ���Ŵ�����, ������, �������� ���� �߰� ������ �ݾ�) �� ���Ŵ����� ū ������ ���
--    ��� ����� 0�� �̻� 
    -- public ArrayList<CustomerDto> ctelGetCustomers(String searchTel)

SELECT CID, CTEL, CNAME, CPOINT, CBUY, CGNAME,
       (HIPOINT+1)-CBUY GRND
    FROM CUSTOMER C, CUSGRADE CU
    WHERE C.CGID=CU.CGID; -- �ְ� ���� ��쿡 �߸� ����

SELECT CNAME, CBUY, (SELECT (HIPOINT+1)-CBUY FROM CUSTOMER WHERE CGID!=5 AND CID=C.CID)
    FROM CUSTOMER C, CUSGRADE CS
    WHERE C.CGID=CS.CGID; -- �̿��� �������� �����

SELECT CID, CTEL, CNAME, CPOINT, CBUY, CGNAME,
       (SELECT (HIPOINT+1)-CBUY FROM CUSTOMER WHERE CGID!=5 AND CID=C.CID) GRND
    FROM CUSTOMER C, CUSGRADE CU
    WHERE C.CGID=CU.CGID AND CTEL LIKE '%'||'9999'; -- DAO�� �� QUERY


SELECT A.CID, A.CTEL, A.CNAME, A.CPOINT, A.CBUY, A.CGNAME, CASE WHEN A.CGID = 5 THEN 0 ELSE (A.HIPOINT+1)-A.CBUY END AS GRND
    FROM (SELECT CID, CTEL, CNAME, CPOINT, CBUY, CGNAME, C.CGID, HIPOINT 
            FROM CUSTOMER C, CUSGRADE CU 
            WHERE C.CGID=CU.CGID AND SUBSTR(CTEL, -4, 4)='9999' OR C.CGID=CU.CGID AND SUBSTR(CTEL, 1, 13)='010-5601-1338') A
    ORDER BY A.CBUY DESC;

-- 3. ��ǰ����
--    ��id(��ȣ)�� ��ǰ���Ű����� �Է¹޾� ���� ó��.
--    (1) ���Ŵ����ݾ׿� �ݹ� ���űݾ��� ����
--    (2) �ݹ� ���Ŵ����ݾ��� 5%����Ʈ�� ����
--    (3) ����� ���Ŵ����ݾ׿� ���� ���� ������ ���������� ��� �� ������ ���� 
-- ��ǰ���� (CID, PRICE �Է¹޾� CPOINT, CBUY, CGID update)
    -- public int buy(int cid, int price)
-- 3�� �� �ٲ� �� ������ ��� (CID, CTEL, CNAME, CPOINT, CBUY, CGNAME, CGID, GRND)
    -- public CustomerDto getCustomer(int cid)
    
    -- 1�ܰ� : CPOINT, CBUY ����
UPDATE CUSTOMER
    SET CPOINT=CPOINT+(3000000*0.05), CBUY=CBUY+3000000
    WHERE CID=1;
    
    -- ������ CBUY�� ���� CGID ����
SELECT CNAME, CBUY, C.CGID �����, CS.CGID �ٲ𷹺�
    FROM CUSTOMER C, CUSGRADE CS
    WHERE CBUY BETWEEN LOPOINT AND HIPOINT;
    
SELECT CS.CGID
    FROM CUSTOMER C, CUSGRADE CS
    WHERE CBUY BETWEEN LOPOINT AND HIPOINT AND CID=1; -- CID�� 1�� �������� �ٲ𷹺�
    
    -- DAO�� �� QUERY �ϼ� (1�ܰ� + 2�ܰ�)
UPDATE CUSTOMER
    SET CPOINT=CPOINT+(3000000*0.05), CBUY=CBUY+3000000, 
        CGID = (SELECT CS.CGID
                  FROM CUSTOMER C, CUSGRADE CS
                  WHERE CBUY+3000000 BETWEEN LOPOINT AND HIPOINT AND CID=1)
    WHERE CID=1;
SELECT * FROM CUSTOMER;

  
SELECT CID, CTEL, CNAME, CPOINT, CBUY, CGNAME,
       (SELECT (HIPOINT+1)-CBUY FROM CUSTOMER WHERE CGID!=5 AND CID=C.CID) GRND
    FROM CUSTOMER C, CUSGRADE CU
    WHERE C.CGID=CU.CGID AND CID=1;
    
-- 4. �� ��޺� ���
--    � ������ ���ϴ��� �����ͺ��̽��� �����̸��� ����ϸ� Ư�� �������� �Է¹޴´�.
--    �ش� ���� ������(ID, ��ȭ, �̸�, ����Ʈ, ���Ŵ�����, ������, �������� ���� �߰� ��
--    ���� �ݾ�)�� ���Ŵ����� ū ������ ���
-- 4�� �� ����޸�� ����
    -- public ArrayList<String> getLevelNames()
    
SELECT CGNAME FROM CUSGRADE;  
    
-- 4. �� ��޺� ���
    -- (cgname�� �Է¹޾� CID, CTEL, CNAME, CPOINT, CBUY, CGNAME, CGID, GRND ���)
    -- public ArrayList<CustomerDto> levelNameGetCustomers(String leveName)

SELECT CID, CTEL, CNAME, CPOINT, CBUY, CGNAME,
       (SELECT (HIPOINT+1)-CBUY FROM CUSTOMER WHERE CGID!=5 AND CID=C.CID) GRND
    FROM CUSTOMER C, CUSGRADE CU
    WHERE C.CGID=CU.CGID AND CGNAME='�����'
    ORDER BY CBUY DESC;    

SELECT CID, CTEL, CNAME, CPOINT, CBUY, CGNAME, CASE WHEN C.CGID = 5 THEN 0 ELSE (HIPOINT+1)-CBUY END AS GRND
    FROM CUSTOMER C, CUSGRADE CU
    WHERE C.CGID=CU.CGID AND CGNAME='�����'
    ORDER BY CBUY DESC;

-- 5. ��ü ���
--    ��ü ������(ID, ��ȭ, �̸�, ����Ʈ, ���Ŵ�����, ������, �������� ���� �߰� ������
--    �ݾ�)�� ���Ŵ����� ū ������ ���
    -- (CID, CTEL, CNAME, CPOINT, CBUY, CGNAME, CGID, GRND ���)
    -- public ArrayList<CustomerDto> getCustomers()

SELECT CID, CTEL, CNAME, CPOINT, CBUY, CGNAME,
       (SELECT (HIPOINT+1)-CBUY FROM CUSTOMER WHERE CGID!=5 AND CID=C.CID) GRND
    FROM CUSTOMER C, CUSGRADE CU
    WHERE C.CGID=CU.CGID
    ORDER BY CBUY DESC; 
    
SELECT CID, CTEL, CNAME, CPOINT, CBUY, CGNAME, CASE WHEN C.CGID = 5 THEN 0 ELSE (HIPOINT+1)-CBUY END AS LVND
    FROM CUSTOMER C, CUSGRADE CU
    WHERE C.CGID=CU.CGID
    ORDER BY CBUY DESC;

-- 6. ȸ��Ż�� ��ȭ��ȣ�� �Է¹޾� Ż��ó��
    -- public int deleteCustomer(String ctel)
DELETE FROM CUSTOMER WHERE CTEL='010-2345-5678';
ROLLBACK;

SELECT * FROM CUSTOMER;
COMMIT;