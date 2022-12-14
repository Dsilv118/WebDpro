-- 테이블, 시퀀스 삭제 및 생성
DROP SEQUENCE CUSEQ;
DROP TABLE CUSTOMER;
DROP TABLE CUSGRADE;

CREATE TABLE CUSGRADE (
    CGID    NUMBER(1) PRIMARY KEY,
    CGNAME  VARCHAR(20),
    LOPOINT NUMBER(9),
    HIPOINT NUMBER(9)
);
SELECT * FROM CUSGRADE;

CREATE TABLE CUSTOMER (
    CID    NUMBER(5) PRIMARY KEY,
    CTEL   VARCHAR2(50),
    CNAME  VARCHAR2(30),
    CPOINT NUMBER(8) DEFAULT 1000,
    CBUY   NUMBER(10) DEFAULT 0,
    CGID   NUMBER(1) DEFAULT 0 NOT NULL,
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
INSERT INTO CUSGRADE VALUES (5, 'VVIP', 5000001, 999999999);
SELECT * FROM CUSGRADE;

INSERT INTO CUSTOMER VALUES (CUSEQ.NEXTVAL, '010-9999-9999', '홍길동', 0, 1000, 1);
INSERT INTO CUSTOMER VALUES (CUSEQ.NEXTVAL, '010-8888-9999', '신길동', 0, 8000000, 5);
INSERT INTO CUSTOMER VALUES (CUSEQ.NEXTVAL, '010-7777-7777', '임길동', 0, 100000, 1);
SELECT * FROM CUSTOMER;
COMMIT;



