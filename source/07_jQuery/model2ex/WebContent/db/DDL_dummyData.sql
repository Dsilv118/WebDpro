--------------------------------- MVC_MEMBER ----------------------------------- 
    -- DROP & CREATE
DROP TABLE MVC_MEMBER CASCADE CONSTRAINTS;
CREATE TABLE MVC_MEMBER(
    mID    VARCHAR2(30) PRIMARY KEY,
    mPW    VARCHAR2(30) NOT NULL,
    mNAME  VARCHAR2(30) NOT NULL,
    mEMAIL VARCHAR2(30) UNIQUE,
    mPHOTO VARCHAR2(30) NOT NULL, -- 회원가입시 사진업로드를 안 할시 기본 이미지로(NOIMG.JPG)
    mBIRTH DATE,
    mADDRESS VARCHAR2(300),
    mRDATE DATE DEFAULT SYSDATE NOT NULL    
);
    -- DUMMY DATA
INSERT INTO MVC_MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)
    VALUES ('gayun','1','김가연','gayun@naver.com','gayun.jpg','1972/09/09','광주광역시');
INSERT INTO MVC_MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)
    VALUES ('gico','1','지코','gico@naver.com','gico.jpg','1992/09/14','서울시');
INSERT INTO MVC_MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)
    VALUES ('go','1','고소영','go@naver.com','go.jpg','1972/10/06','서울시');
INSERT INTO MVC_MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)
    VALUES ('ham','1','함소원','ham@naver.com','ham.jpg','1976/06/16','서울시');
INSERT INTO MVC_MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)
    VALUES ('han','1','한지민','han@naver.com','han.jpg','1982/11/05','서울시');
INSERT INTO MVC_MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)
    VALUES ('jang','1','장동건',null,'jang.jpg',null,null);
INSERT INTO MVC_MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)
    VALUES ('jo','1','조현우',null,'jo.jpg',null,null);
INSERT INTO MVC_MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)
    VALUES ('kang','1','강동원',null,'kang.jpg',null,null);
INSERT INTO MVC_MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)
    VALUES ('kim','1','김태희',null,'kim.jpg',null,null);
INSERT INTO MVC_MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)
    VALUES ('lee','1','이선빈',null,'lee.jpg',null,null);
INSERT INTO MVC_MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)
    VALUES ('lim','1','임요한',null,'lim.jpg',null,null);
INSERT INTO MVC_MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)
    VALUES ('park','1','박보검',null,'park.jpg',null,null);
INSERT INTO MVC_MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)
    VALUES ('rain','1','비',null,'rain.jpg',null,null);
INSERT INTO MVC_MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)
    VALUES ('sgy','1','송가연',null,'sgy.jpg',null,null);
INSERT INTO MVC_MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)
    VALUES ('son','1','손흥민',null,'son.jpg',null,null);
INSERT INTO MVC_MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)
    VALUES ('song','1','송중기',null,'song.jpg',null,null);

SELECT * FROM MVC_MEMBER;

COMMIT;

------------------------------- FILEBOARD --------------------------------------
    -- DROP & CREATE TABLE
DROP TABLE FILEBOARD;
CREATE TABLE FILEBOARD (
    fID       NUMBER(6) PRIMARY KEY,
    mID       VARCHAR2(30) REFERENCES MVC_MEMBER(mID),
    fTITLE    VARCHAR2(100) NOT NULL,
    fCONTENT  VARCHAR2(4000),
    fFILENAME VARCHAR2(100) NOT NULL,
    fRDATE    DATE,
    fHIT      NUMBER(6),
    fGROUP    NUMBER(6),
    fSTEP     NUMBER(6),
    fINDENT   NUMBER(6),
    fIP       VARCHAR2(30)
);
CREATE SEQUENCE FILE_SEQ
    MAXVALUE 999999
    NOCACHE
    NOCYCLE;

    -- DUMMY DATA (원글과 답변)
INSERT INTO FILEBOARD (fID, mID, fTITLE, fCONTENT, fFILENAME, fRDATE, fHIT, fGROUP, fSTEP, fINDENT, fIP)
    VALUES (FILE_SEQ.NEXTVAL, 'gayun', '제목이야', '본문이야', 'noimage.png', '2023-03-15', 0, FILE_SEQ.CURRVAL, 0, 0, '129-221-32-1');
INSERT INTO FILEBOARD (fID, mID, fTITLE, fCONTENT, fFILENAME, fRDATE, fHIT, fGROUP, fSTEP, fINDENT, fIP)
    VALUES (FILE_SEQ.NEXTVAL, 'park', '제목2이야', null, 'noimage.png', '2023-03-15', 0, FILE_SEQ.CURRVAL, 0, 0, '492-291-42-4');
INSERT INTO FILEBOARD (fID, mID, fTITLE, fCONTENT, fFILENAME, fRDATE, fHIT, fGROUP, fSTEP, fINDENT, fIP)
    VALUES (FILE_SEQ.NEXTVAL, null, '제목3이야', '본문2이야', 'noimage.png', '2023-03-15', 0, FILE_SEQ.CURRVAL, 0, 0, '849-951-85-5');
INSERT INTO FILEBOARD (fID, mID, fTITLE, fCONTENT, fFILENAME, fRDATE, fHIT, fGROUP, fSTEP, fINDENT, fIP)
    VALUES (FILE_SEQ.NEXTVAL, 'kim', '제목2의 답변이야', null, 'noimage.png', '2023-03-15', 0, 2, 1, 1, '432-54-23-1');
    
SELECT * FROM FILEBOARD;

COMMIT;

----------------------------------- ADMIN --------------------------------------
    -- DROP & CREATE TABLE
DROP TABLE ADMIN;
CREATE TABLE ADMIN (
    aID   VARCHAR2(30) PRIMARY KEY,
    aPW   VARCHAR2(30) NOT NULL,
    aNAME VARCHAR2(30) NOT NULL
);

    -- DUMMY DATA 
INSERT INTO ADMIN VALUES ('admin', '1', '김관리');

SELECT * FROM ADMIN;

COMMIT;
















