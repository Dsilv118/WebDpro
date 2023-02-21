-- SEQUESNCE와 Table drop & create

DROP TABLE FRIEND;
DROP SEQUENCE FRIEND_NO_SEQ;

CREATE SEQUENCE FRIEND_NO_SEQ
    MAXVALUE 999
    NOCYCLE
    NOCACHE;

CREATE TABLE FRIEND(
    NUM   NUMBER(3) PRIMARY KEY,
    NAME VARCHAR2(18) NOT NULL,
    TEL  VARCHAR2(15)
);

-- 친구 추가 QUERY
INSERT INTO FRIEND (NUM, NAME, TEL)
    VALUES (FRIEND_NO_SEQ.NEXTVAL, '박길동', '010-2222-2222');
    
-- 친구 목록 출력 QUERY
SELECT * FROM FRIEND;

-- 친구 검색 QUERY
SELECT * FROM FRIEND WHERE NAME LIKE '%'||'박'||'%' AND TEL LIKE '%'||'10'||'%';

COMMIT;
