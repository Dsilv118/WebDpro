-- SEQUENCE & TABLE DROP/CREATE
DROP TABLE MEMBER CASCADE CONSTRAINTS;
DROP TABLE BOOK CASCADE CONSTRAINTS;
DROP SEQUENCE BOOK_SQ;
CREATE TABLE MEMBER(
    mID VARCHAR2(100) PRIMARY KEY,
    mPW VARCHAR2(100) NOT NULL,
    mNAME VARCHAR2(100) NOT NULL,
    mMAIL VARCHAR2(100) NOT NULL,
    mPOST VARCHAR2(100), -- 우편번호
    mADDR VARCHAR2(100) -- 주소
);
CREATE SEQUENCE BOOK_SQ MAXVALUE 99999999 NOCYCLE NOCACHE;
CREATE TABLE BOOK(
    bNUM NUMBER(8) PRIMARY KEY,                     -- 책번호
    bTITLE VARCHAR2(100) NOT NULL,                  -- 책이름
    bWRITER VARCHAR2(100) NOT NULL,                 -- 저자
    bRDATE  DATE DEFAULT SYSDATE NOT NULL,          -- 출판일
    bIMG1 VARCHAR2(1000) DEFAULT 'noImg.png' NOT NULL, -- 책이미지1
    bIMG2 VARCHAR2(1000) DEFAULT 'noImg.png' NOT NULL, -- 책이미지2
    bINFO VARCHAR2(4000)                            -- 책소개
);
-- DUMMY DATA INSERT
INSERT INTO MEMBER VALUES ('aaa','1','홍길동','hong@naver.com','12345','서울');

INSERT INTO BOOK 
  VALUES (BOOK_SQ.NEXTVAL, 'SPRING','김작가',SYSDATE-1, 'noImg.png','noImg.png','스프링개념서');
INSERT INTO BOOK (bNUM, bTITLE, bWRITER, bRDATE, bIMG1, bINFO)
    VALUES (BOOK_SQ.NEXTVAL, 'JSP','박제이',SYSDATE-2, 'noImg.png','jsp 개념서');
INSERT INTO BOOK (bNUM, bTITLE, bWRITER, bRDATE, bIMG2, bINFO)
    VALUES (BOOK_SQ.NEXTVAL, 'ORACLE','홍작가',SYSDATE-3, 'noImg.png','스프링개념서2');
INSERT INTO BOOK (bNUM, bTITLE, bWRITER, bRDATE, bINFO)
    VALUES (BOOK_SQ.NEXTVAL, 'JAVA','이자바',SYSDATE-4, '스프링개념서3');
COMMIT;

SELECT * FROM SALGRADE;
SELECT * FROM EMP;

DROP TABLE THEATER_SEAT;
DROP TABLE THEATER_RES;
DROP TABLE THEATER;
CREATE TABLE THEATER (
    thCODE NUMBER(4) PRIMARY KEY,
    thNAME VARCHAR2(50) NOT NULL,
    thDATE TIMESTAMP NOT NULL,
    thTIME VARCHAR2(10) NOT NULL,
    thLOC VARCHAR2(50) NOT NULL,
    thSEAT VARCHAR2(2) NOT NULL,
    thPRICE NUMBER(9) NOT NULL
);
CREATE TABLE THEATER_RES (
    thrCODE VARCHAR2(20) PRIMARY KEY, 
    mID VARCHAR2(40) NOT NULL,
    thCODE NUMBER(3) NOT NULL REFERENCES THEATER(thCODE),
    thrCNT NUMBER(3),
    thrORDERDATE TIMESTAMP NOT NULL,
    thrTOTPRICE NUMBER(1)
);
CREATE TABLE THEATER_SEAT (
    SEATCODE VARCHAR2(4) PRIMARY KEY,
    thrCODE VARCHAR2(20) NOT NULL REFERENCES THEATER_RES(thrCODE)
);
CREATE SEQUENCE THCODE_SEQ 
    NOCACHE
    NOCYCLE;
CREATE SEQUENCE THRCODE_SEQ 
    NOCACHE
    NOCYCLE;
    
INSERT INTO THEATER 
    VALUES (THCODE_SEQ.NEXTVAL, '돌고래 쇼', SYSDATE, '40', '익스트림 존', 20, 43000);  

INSERT INTO THEATER_RES
    VALUES ('23080101', 'aaa', 1, 2, SYSDATE, 0);
    
SELECT * FROM THEATER_RES;

INSERT INTO THEATER_SEAT
    VALUES ('a1', '23080101');
INSERT INTO THEATER_SEAT
    VALUES ('a2', '23080101');
    
SELECT * 
    FROM THEATER_RES TR, THEATER_SEAT TS
    WHERE TR.thrCODE = TS.thrCODE;