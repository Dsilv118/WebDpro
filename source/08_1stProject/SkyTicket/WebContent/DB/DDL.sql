--------------------------- DROP TABLE & SEQUENCE ------------------------------
DROP SEQUENCE MEMBER_SEQ;
DROP TABLE MEMBER_TICKET;
DROP SEQUENCE AT_SEQ;
DROP TABLE AIRLINE_TICKET;
DROP TABLE CITY;
DROP SEQUENCE PL_SEQ;
DROP TABLE PLANE;
DROP SEQUENCE BOARD_SEQ;
DROP TABLE BOARD;
DROP TABLE MEMBER;
DROP TABLE ADMIN;

-------------------------- CREATE TABLE & SEQUENCE ------------------------------
------------------------------ MEMBER & ADMIN ----------------------------------
CREATE TABLE ADMIN (
    adID VARCHAR2(50) PRIMARY KEY,
    adPW VARCHAR2(50) NOT NULL, 
    adNAME VARCHAR2(20) NOT NULL,
    adTEL VARCHAR2(30) NOT NULL
);
CREATE TABLE MEMBER (
    mID     VARCHAR2(50) PRIMARY KEY,
    mPW     VARCHAR2(50) NOT NULL,
    mkNAME  VARCHAR2(50) NOT NULL,
    meNAME  VARCHAR2(20) NOT NULL,
    mTEL    VARCHAR2(30) NOT NULL,
    mEMAIL  VARCHAR2(100) NOT NULL,
    mBIRTH  DATE NOT NULL, 
    mGENDER VARCHAR2(1) NOT NULL,
    mNATION VARCHAR2(10) NOT NULL
);

---------------------------------- AIRLINE -------------------------------------
CREATE TABLE CITY (
    ctNAME VARCHAR2(100) PRIMARY KEY, 
    ctCODE VARCHAR2(10) NOT NULL UNIQUE
);
CREATE TABLE PLANE (
    pLNUM    NUMBER(4) PRIMARY KEY,
    pLNAME   VARCHAR2(50) NOT NULL,
    pLCOM    VARCHAR2(50) NOT NULL,
    pLCOMNUM VARCHAR2(10) NOT NULL,
    pLSEAT   NUMBER(3) NOT NULL
);
CREATE SEQUENCE PL_SEQ
    START WITH 300
    MAXVALUE 9999
    NOCACHE
    NOCYCLE;
CREATE TABLE AIRLINE_TICKET (
    atID    NUMBER(5) PRIMARY KEY,
    ACTNAME VARCHAR2(100) REFERENCES CITY(ctNAME) NOT NULL,
    DCTNAME VARCHAR2(100) REFERENCES CITY(ctNAME) NOT NULL,
    pLNUM   NUMBER(3) REFERENCES PLANE(pLNUM) NOT NULL UNIQUE,
    atPRICE NUMBER(8) NOT NULL,
    atATIME TIMESTAMP NOT NULL,
    atDTIME TIMESTAMP NOT NULL,
    atPHOTO VARCHAR2(100) NOT NULL
);
CREATE SEQUENCE AT_SEQ 
    MAXVALUE 99999
    NOCACHE
    NOCYCLE;
CREATE TABLE MEMBER_TICKET (
    rvNUM     NUMBER(11) PRIMARY KEY,
    atID      NUMBER(5) REFERENCES AIRLINE_TICKET(atID) NOT NULL,
    mID       VARCHAR2(50) REFERENCES MEMBER(mID) NOT NULL,
    mtSERVICE VARCHAR2(100) NOT NULL
);
CREATE SEQUENCE MEMBER_SEQ
    MAXVALUE 999
    NOCACHE
    NOCYCLE;

---------------------------------- BOARD ---------------------------------------
CREATE TABLE BOARD (
    bID       NUMBER(5) PRIMARY KEY,
    mID       VARCHAR2(50) NOT NULL REFERENCES MEMBER(mID),
    bSUBJECT  VARCHAR2(100) NOT NULL,
    bCONTENT  VARCHAR2(4000) NOT NULL,
    bFILE     VARCHAR2(100) NOT NULL,
    bIP       VARCHAR2(30) NOT NULL,
    BGROUP    NUMBER(3) NOT NULL,
    BSTEP     NUMBER(3) NOT NULL,
    BINDENT   NUMBER(3) NOT NULL,
    bRDATE    DATE DEFAULT SYSDATE
);
CREATE SEQUENCE BOARD_SEQ 
    MAXVALUE 99999
    NOCACHE
    NOCYCLE;











