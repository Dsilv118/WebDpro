-- [VIII] Sequence : 순차번호 생성기. 대부분 인위적인 PK 사용 용도

DROP SEQUENCE FRIEND_SEQ;

CREATE SEQUENCE FRIEND_SEQ
    START WITH 1      -- 안쓰면 1부터 시작
    INCREMENT BY 1    -- 안쓰면 1씩 증가
    MAXVALUE 9999     -- 최대값
    MINVALUE 1        -- 최소값
    NOCACHE        
    NOCYCLE;
SELECT FRIEND_SEQ.NEXTVAL FROM DUAL; -- 다음 순차번호
SELECT FRIEND_SEQ.CURRVAL FROM DUAL; -- 시퀀스의 현재 값

DROP SEQUENCE FRIEND_SQ;

CREATE SEQUENCE FRIEND_SQ MAXVALUE 9999 NOCACHE NOCYCLE;

DROP TABLE FRIEND;

CREATE TABLE FRIEND(
    NUM NUMBER(4) PRIMARY KEY, -- 시퀀스 이용
    NAME VARCHAR2(30) NOT NULL,
    TEL VARCHAR2(20) UNIQUE, -- UNIQUE : 유일한 필드값, NULL 허용
    ADDRESS VARCHAR2(250),
    LAST_MODIFIED DATE DEFAULT SYSDATE -- 최종 수정일
);
DESC FRIEND;

INSERT INTO FRIEND (NUM, NAME, TEL, ADDRESS)
    VALUES (FRIEND_SQ.NEXTVAL, '홍길동', NULL, '서울시 서대문구'); -- 여러번 실행 가능
--INSERT INTO FRIEND (NUM, NAME, TEL, ADDRESS)
--    VALUES (FRIEND_SQ.NEXTVAL, NULL, '010-9999-9999', '서울시 마포구'); -- 에러 (NOT NULL)
INSERT INTO FRIEND (NUM, NAME, TEL, ADDRESS)
    VALUES (FRIEND_SQ.NEXTVAL, '신길동', '010-8888-8888', '서울시 강서구');
--INSERT INTO FRIEND (NUM, NAME, TEL, ADDRESS)
--    VALUES (FRIEND_SQ.NEXTVAL, '김길동', '010-8888-8888', '서울시 영등포구'); -- 에러 (UNIQUE)
INSERT INTO FRIEND (NUM, NAME, TEL, ADDRESS)
    VALUES (FRIEND_SQ.NEXTVAL, '임길동', '010-2312-3124', '서울시 강동구');
SELECT * FROM FRIEND;

    -- EX. 초기값이 101부터 최대값 999,999까지 1씩 증가하는 TEST_SEQ 시퀀스를 생성하고 시퀀스 수를 사용하시오
CREATE SEQUENCE TEST_SEQ 
    START WITH 101
    MAXVALUE 999999
    NOCACHE
    NOCYCLE;
SELECT TEST_SEQ.NEXTVAL FROM DUAL;
SELECT TEST_SEQ.CURRVAL FROM DUAL;

-- 총 연습문제

DROP SEQUENCE MEMBER_MNO_SQ;
DROP TABLE MEMBER;
DROP TABLE MEMBER_LEVEL;

CREATE TABLE MEMBER_LEVEL (
    LEVELNO   NUMBER(1) PRIMARY KEY,
    LEVELNAME VARCHAR2(10) NOT NULL
);
DESC MEMBER_LEVEL;

CREATE TABLE MEMBER (
    mNO     NUMBER(3) PRIMARY KEY,
    mNAME   VARCHAR2(20) NOT NULL,
    mPW     VARCHAR2(50) CHECK(LENGTH(mPW) BETWEEN 1 AND 8),
    mMAIL   VARCHAR2(100) UNIQUE,
    mPOINT  NUMBER(8) CHECK(mPOINT>=0),
    mRDATE  DATE DEFAULT SYSDATE,
    LEVELNO NUMBER(1),
    FOREIGN KEY(LEVELNO) REFERENCES MEMBER_LEVEL(LEVELNO)    
);
DESC MEMBER;

CREATE SEQUENCE MEMBER_MNO_SQ
    MAXVALUE 999
    MINVALUE 1
    NOCACHE
    NOCYCLE;

INSERT INTO MEMBER_LEVEL VALUES (-1, 'black');
INSERT INTO MEMBER_LEVEL VALUES (0, '일반');
INSERT INTO MEMBER_LEVEL VALUES (1, '실버');
INSERT INTO MEMBER_LEVEL VALUES (2, '골드');
SELECT * FROM MEMBER_LEVEL;

INSERT INTO MEMBER VALUES (MEMBER_MNO_SQ.NEXTVAL, '홍길동', 'aa', 'hong@hong.com', 0, '22/03/10', 0);
INSERT INTO MEMBER VALUES (MEMBER_MNO_SQ.NEXTVAL, '신길동', 'bb', 'sin@sin.com', 1000, '22/04/01', 1);
SELECT * FROM MEMBER;

SELECT mNO, mNAME, TO_CHAR(mRDATE, 'YYYY-MM-DD') mRDATE, mMAIL, mPOINT point, LEVELNAME || '고객' levelname
    FROM MEMBER_LEVEL ML, MEMBER MB
    WHERE ML.LEVELNO=MB.LEVELNO;
    

-- DB 설계 주문서 ORSQ

DROP SEQUENCE CARTSQ; 
DROP SEQUENCE ORDSQ;
DROP SEQUENCE ORSQ; 
DROP TABLE ORDERDETAIL;
DROP TABLE ORDERS;
DROP TABLE CART;
DROP TABLE MEMBER;
DROP TABLE PRODUCT;


CREATE TABLE PRODUCT (
    pCODE VARCHAR2(5) PRIMARY KEY,
    pNAME VARCHAR2(100) NOT NULL UNIQUE,
    PRICE NUMBER(10) CHECK(PRICE>=0),
    AVS   NUMBER(8)
);
DESC PRODUCT;

CREATE TABLE MEMBER (
    mID   VARCHAR2(100) PRIMARY KEY,
    mNAME VARCHAR2(15) NOT NULL,
    mADDR VARCHAR2(100),
    mTEL  VARCHAR2(30) UNIQUE,
    mMAIL VARCHAR2(100) NOT NULL UNIQUE
);
DESC MEMBER;

CREATE TABLE CART (
    cNO   NUMBER(3) PRIMARY KEY,
    mID   VARCHAR2(100) NOT NULL,
    pCODE VARCHAR2(5) NOT NULL,
    pNAME VARCHAR2(100) NOT NULL UNIQUE,
    PRICE NUMBER(10) NOT NULL CHECK(PRICE>=0),
    QTY   NUMBER(4) CHECK(QTY>0) NOT NULL,
    COST  NUMBER(10) CHECK(COST>0),
    FOREIGN KEY (mID) REFERENCES MEMBER(mID),
    FOREIGN KEY (pCODE) REFERENCES PRODUCT(pCODE)
);
DESC CART;

CREATE TABLE ORDERS (
    oNO   VARCHAR2(9) PRIMARY KEY,
    oDATE DATE DEFAULT SYSDATE,
    mID VARCHAR2(100) NOT NULL,
    oNAME VARCHAR2(15) NOT NULL,
    oADDR VARCHAR2(100) NOT NULL,
    oTEL VARCHAR2(30) NOT NULL,
    FOREIGN KEY (mID) REFERENCES MEMBER(mID)
);
DESC ORDERS;

CREATE TABLE ORDERDETAIL (
    PONUM NUMBER(3) PRIMARY KEY,
    pCODE VARCHAR2(5) NOT NULL,
    pNAME VARCHAR2(100) NOT NULL UNIQUE,
    PRICE NUMBER(10) NOT NULL,
    QTY   NUMBER(4) NOT NULL CHECK(QTY>0),
    COST  NUMBER(10) NOT NULL, CHECK(COST>0),
    FOREIGN KEY (pCODE) REFERENCES PRODUCT(pCODE)
);
DESC ORDERDETAIL;

CREATE SEQUENCE CARTSQ
    MAXVALUE 999
    NOCACHE;
    
CREATE SEQUENCE ORSQ
    MAXVALUE 999
    NOCACHE;
    
CREATE SEQUENCE ORDSQ
    MAXVALUE 999
    NOCACHE;

INSERT INTO PRODUCT VALUES ('A1', '맥주', 3000, 100);
INSERT INTO PRODUCT VALUES ('B1', '땅콩', 3000, 50);
INSERT INTO PRODUCT VALUES ('A2', '마스크', 2000, 300);
INSERT INTO PRODUCT VALUES ('B2', '오징어', 5000, 30);
INSERT INTO PRODUCT VALUES ('C1', '소독약', 7000, 20);
SELECT * FROM PRODUCT;

INSERT INTO MEMBER VALUES ('abc', '홍길동', NULL, '010-9999-9999', 'hong@hong.com');
INSERT INTO MEMBER VALUES ('def', '김김동', '경기도 수원시', NULL, 'KIM@KIM.com');
SELECT * FROM MEMBER;

INSERT INTO CART VALUES (CARTSQ.NEXTVAL, 'abc', 'A1', '맥주', 3000, 3, 9000); 
INSERT INTO CART VALUES (CARTSQ.NEXTVAL, 'abc', 'B1', '땅콩', 3000, 1, 3000);
INSERT INTO CART VALUES (CARTSQ.NEXTVAL, 'def', 'A2', '마스크', 200, 20, 4000); 
INSERT INTO CART VALUES (CARTSQ.NEXTVAL, 'def', 'B2', '오징어', 5000, 2, 10000);
INSERT INTO CART VALUES (CARTSQ.NEXTVAL, 'def', 'C1', '소독약', 7000, 1, 7000); 
SELECT * FROM CART;

INSERT INTO ORDERS VALUES (TO_CHAR(SYSDATE, 'RRMMDD') || TRIM(TO_CHAR(ORSQ.NEXTVAL, '000')), NULL, 'abc', '홍길동', '서울시 서대문구 대현동', '010-9999-9999');
INSERT INTO ORDERS VALUES (TO_CHAR(SYSDATE, 'RRMMDD') || TRIM(TO_CHAR(ORSQ.NEXTVAL, '000')), NULL, 'def', '김김동', '경기도 수원시', '010-8888-8888');
SELECT * FROM ORDERS;

INSERT INTO ORDERDETAIL VALUES (ORDSQ.NEXTVAL, 'A1', '맥주', 3000, 3, 3000*3);
UPDATE PRODUCT
    SET AVS=(SELECT AVS-QTY FROM PRODUCT P, ORDERDETAIL O WHERE P.pNAME=O.pNAME);
INSERT INTO ORDERDETAIL VALUES (ORDSQ.NEXTVAL, 'B1', '땅콩', 3000, 1, 3000*1);
UPDATE PRODUCT
    SET AVS=(SELECT AVS-QTY FROM PRODUCT P, ORDERDETAIL O WHERE P.pNAME=O.pNAME);
-- (SELECT AVS FROM PRODUCT P, ORDERDETAIL O WHERE P.pNAME=O.pNAME) - (SELECT QTY FROM PRODUCT P, ORDERDETAIL O WHERE P.pNAME=O.pNAME)
DELETE FROM CART;
SELECT * FROM ORDERDETAIL;
















