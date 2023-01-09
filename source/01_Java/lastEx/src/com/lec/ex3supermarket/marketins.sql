-- 기능별 Query
-- 1. 회원가입 
-- 전화번호와 이름을 입력받아 회원가입(회원가입시 포인트는 1000점 제공)
    -- public int insertCustomer(String CTEL, String CNAME)
    -- public int insertCustomer(CustomerDto dto)
    
INSERT INTO CUSTOMER VALUES (CUSEQ.NEXTVAL, '010-2345-5678', '장길동', 1000, 0, 1);
ROLLBACK; -- COMMIT이나 ROLLBACK 중 하나는 실행
-- 2. 폰4자리(FULL) 검색
--    폰 뒤4자리나 FULL번호를 입력받아 고객정보(ID, 전화, 이름, 포인트, 구매누적액, 고객레벨, 레벨업을 위한 추가 구매할 금액) 를 구매누적액 큰 순으로 출력
--    출력 결과는 0행 이상 
    -- public ArrayList<CustomerDto> ctelGetCustomers(String searchTel)

SELECT CID, CTEL, CNAME, CPOINT, CBUY, CGNAME,
       (HIPOINT+1)-CBUY GRND
    FROM CUSTOMER C, CUSGRADE CU
    WHERE C.CGID=CU.CGID; -- 최고 레벨 경우에 잘못 나와

SELECT CNAME, CBUY, (SELECT (HIPOINT+1)-CBUY FROM CUSTOMER WHERE CGID!=5 AND CID=C.CID)
    FROM CUSTOMER C, CUSGRADE CS
    WHERE C.CGID=CS.CGID; -- 이용할 서브쿼리 만들기

SELECT CID, CTEL, CNAME, CPOINT, CBUY, CGNAME,
       (SELECT (HIPOINT+1)-CBUY FROM CUSTOMER WHERE CGID!=5 AND CID=C.CID) GRND
    FROM CUSTOMER C, CUSGRADE CU
    WHERE C.CGID=CU.CGID AND CTEL LIKE '%'||'9999'; -- DAO에 들어갈 QUERY


SELECT A.CID, A.CTEL, A.CNAME, A.CPOINT, A.CBUY, A.CGNAME, CASE WHEN A.CGID = 5 THEN 0 ELSE (A.HIPOINT+1)-A.CBUY END AS GRND
    FROM (SELECT CID, CTEL, CNAME, CPOINT, CBUY, CGNAME, C.CGID, HIPOINT 
            FROM CUSTOMER C, CUSGRADE CU 
            WHERE C.CGID=CU.CGID AND SUBSTR(CTEL, -4, 4)='9999' OR C.CGID=CU.CGID AND SUBSTR(CTEL, 1, 13)='010-5601-1338') A
    ORDER BY A.CBUY DESC;

-- 3. 물품구입
--    고객id(번호)와 물품구매가격을 입력받아 구매 처리.
--    (1) 구매누적금액에 금번 구매금액이 누적
--    (2) 금번 구매누적금액의 5%포인트가 누적
--    (3) 변경될 구매누적금액에 따라 고객의 레벨이 상향조정될 경우 고객 레벨이 상향 
-- 물품구입 (CID, PRICE 입력받아 CPOINT, CBUY, CGID update)
    -- public int buy(int cid, int price)
-- 3번 후 바뀐 고객 정보를 출력 (CID, CTEL, CNAME, CPOINT, CBUY, CGNAME, CGID, GRND)
    -- public CustomerDto getCustomer(int cid)
    
    -- 1단계 : CPOINT, CBUY 수정
UPDATE CUSTOMER
    SET CPOINT=CPOINT+(3000000*0.05), CBUY=CBUY+3000000
    WHERE CID=1;
    
    -- 수정된 CBUY에 따라 CGID 조정
SELECT CNAME, CBUY, C.CGID 현등급, CS.CGID 바뀔레벨
    FROM CUSTOMER C, CUSGRADE CS
    WHERE CBUY BETWEEN LOPOINT AND HIPOINT;
    
SELECT CS.CGID
    FROM CUSTOMER C, CUSGRADE CS
    WHERE CBUY BETWEEN LOPOINT AND HIPOINT AND CID=1; -- CID가 1인 데이터의 바뀔레벨
    
    -- DAO에 들어갈 QUERY 완성 (1단계 + 2단계)
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
    
-- 4. 고객 등급별 출력
--    어떤 레벨을 원하는지 데이터베이스의 레벨이름을 출력하며 특정 레벨명을 입력받는다.
--    해당 레벨 고객정보(ID, 전화, 이름, 포인트, 구매누적액, 고객레벨, 레벨업을 위한 추가 구
--    매할 금액)를 구매누적액 큰 순으로 출력
-- 4번 전 고객등급명들 추출
    -- public ArrayList<String> getLevelNames()
    
SELECT CGNAME FROM CUSGRADE;  
    
-- 4. 고객 등급별 출력
    -- (cgname을 입력받아 CID, CTEL, CNAME, CPOINT, CBUY, CGNAME, CGID, GRND 출력)
    -- public ArrayList<CustomerDto> levelNameGetCustomers(String leveName)

SELECT CID, CTEL, CNAME, CPOINT, CBUY, CGNAME,
       (SELECT (HIPOINT+1)-CBUY FROM CUSTOMER WHERE CGID!=5 AND CID=C.CID) GRND
    FROM CUSTOMER C, CUSGRADE CU
    WHERE C.CGID=CU.CGID AND CGNAME='브론즈'
    ORDER BY CBUY DESC;    

SELECT CID, CTEL, CNAME, CPOINT, CBUY, CGNAME, CASE WHEN C.CGID = 5 THEN 0 ELSE (HIPOINT+1)-CBUY END AS GRND
    FROM CUSTOMER C, CUSGRADE CU
    WHERE C.CGID=CU.CGID AND CGNAME='브론즈'
    ORDER BY CBUY DESC;

-- 5. 전체 출력
--    전체 고객정보(ID, 전화, 이름, 포인트, 구매누적액, 고객레벨, 레벨업을 위한 추가 구매할
--    금액)를 구매누적액 큰 순으로 출력
    -- (CID, CTEL, CNAME, CPOINT, CBUY, CGNAME, CGID, GRND 출력)
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

-- 6. 회원탈퇴 전화번호를 입력받아 탈퇴처리
    -- public int deleteCustomer(String ctel)
DELETE FROM CUSTOMER WHERE CTEL='010-2345-5678';
ROLLBACK;

SELECT * FROM CUSTOMER;
COMMIT;