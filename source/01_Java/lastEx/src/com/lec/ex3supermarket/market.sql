-- 테이블, 시퀀스 삭제 및 생성
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

-- 더미 데이터 insert
INSERT INTO CUSGRADE VALUES (1, '브론즈', 0, 500000);
INSERT INTO CUSGRADE VALUES (2, '실버', 500001, 1500000);
INSERT INTO CUSGRADE VALUES (3, '골드', 1500001, 3000000);
INSERT INTO CUSGRADE VALUES (4, 'VIP', 3000001, 5000000);
INSERT INTO CUSGRADE VALUES (5, 'VVIP', 5000001, 6000000);
INSERT INTO CUSGRADE VALUES (6, 'ML', 6000001, NULL);
SELECT * FROM CUSGRADE;

INSERT INTO CUSTOMER VALUES (CUSEQ.NEXTVAL, '010-2345-5678', '홍길동', 1000, 0, 1);
INSERT INTO CUSTOMER VALUES (CUSEQ.NEXTVAL, '010-5601-1338', '신길동', 1000, 0, 1);
INSERT INTO CUSTOMER VALUES (CUSEQ.NEXTVAL, '010-8577-4533', '임길동', 1000, 0, 1);
SELECT * FROM CUSTOMER;
COMMIT;

-- 기능별 Query
-- 1. 회원가입 
--    전화번호와 이름을 입력받아 회원가입(회원가입시 포인트는 1000점 제공)
INSERT INTO CUSTOMER VALUES (CUSEQ.NEXTVAL, '010-2345-5678', '홍길동', 1000, 0, 1);


-- 2. 폰4자리(FULL) 검색
--    폰 뒤4자리나 FULL번호를 입력받아 고객정보(ID, 전화, 이름, 포인트, 구매누적액, 고객레벨, 레벨업을 위한 추가 구매할 금액) 를 구매누적액 큰 순으로 출력
--    출력 결과는 0행 이상 
SELECT HIPOINT FROM CUSGRADE WHERE CGNAME=H.CGNAME;
SELECT CID, CTEL, CNAME, CPOINT, CBUY, CGNAME;


-- 3. 물품구입
--    고객id(번호)와 물품구매가격을 입력받아 구매 처리.
--    (1) 구매누적금액에 금번 구매금액이 누적
--    (2) 금번 구매누적금액의 5%포인트가 누적
--    (3) 변경될 구매누적금액에 따라 고객의 레벨이 상향조정될 경우 고객 레벨이 상향 



-- 4. 고객 등급별 출력
--    어떤 레벨을 원하는지 데이터베이스의 레벨이름을 출력하며 특정 레벨명을 입력받는다.
--    해당 레벨 고객정보(ID, 전화, 이름, 포인트, 구매누적액, 고객레벨, 레벨업을 위한 추가 구
--    매할 금액)를 구매누적액 큰 순으로 출력



-- 5. 전체 출력
--    전체 고객정보(ID, 전화, 이름, 포인트, 구매누적액, 고객레벨, 레벨업을 위한 추가 구매할
--    금액)를 구매누적액 큰 순으로 출력



-- 6. 회원탈퇴 ? 전화번호를 입력받아 탈퇴처리


















