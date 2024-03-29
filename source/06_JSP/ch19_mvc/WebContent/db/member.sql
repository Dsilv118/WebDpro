-- drop table
DROP TABLE MEMBER;
-- create table 
CREATE TABLE MEMBER (
    ID VARCHAR2(30) PRIMARY KEY,
    PW VARCHAR2(30) NOT NULL,
    NAME VARCHAR2(30) NOT NULL,
    BIRTH DATE,
    RDATE DATE DEFAULT SYSDATE NOT NULL
);
-- dummy data 
INSERT INTO MEMBER (ID, PW, NAME, BIRTH)
    VALUES ('aaa', '111', '홍길동', TO_DATE('1992-12-07', 'YYYY-MM-DD'));
-- dao에 필요한 query
-- 1. 회원 리스트 출력
SELECT * FROM MEMBER;
-- 2. 회원가입
INSERT INTO MEMBER (ID, PW, NAME, BIRTH)
    VALUES ('bbb', '111', '홍길동', '1998-12-07');
    
COMMIT;