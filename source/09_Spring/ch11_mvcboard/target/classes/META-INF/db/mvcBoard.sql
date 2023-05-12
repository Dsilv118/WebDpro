-- TABLE & SEQUENCE DROP
DROP SEQUENCE MVC_BOARD_SEQ;
DROP TABLE MVC_BOARD;
-- TABLE & SEQUENCE CREATE
CREATE TABLE MVC_BOARD (
    BID      NUMBER(6),
    BNAME    VARCHAR2(50) NOT NULL,
    BTITLE   VARCHAR2(100) NOT NULL,
    BCONTENT VARCHAR2(1000),
    BDATE    DATE DEFAULT SYSDATE NOT NULL, -- 작성일
    BHIT     NUMBER(6) DEFAULT 0 NOT NULL,  -- 조회수
    BGROUP   NUMBER(6) NOT NULL, -- 원글이면 BID와 같고, 답변글의 경우 원글의 BGROUP과 같다
    BSTEP    NUMBER(3) NOT NULL, -- 같은 그룹 내 출력 순서
    BINDENT  NUMBER(3) NOT NULL, -- 들여쓰기 정도
    BIP      VARCHAR2(20) NOT NULL, 
    PRIMARY KEY(BID)
);
CREATE SEQUENCE MVC_BOARD_SEQ
    MAXVALUE 999999
    NOCACHE
    NOCYCLE;

-- DUMMY DATA
INSERT INTO MVC_BOARD (BID, BNAME, BTITLE, BCONTENT, BGROUP, BSTEP, BINDENT, BIP)
    VALUES (MVC_BOARD_SEQ.NEXTVAL, '홍길동', '제목', NULL, MVC_BOARD_SEQ.CURRVAL, 0, 0, '192.1.1.3');
INSERT INTO MVC_BOARD (BID, BNAME, BTITLE, BCONTENT, BGROUP, BSTEP, BINDENT, BIP)
    VALUES (MVC_BOARD_SEQ.NEXTVAL, '김길동', '제목', NULL, MVC_BOARD_SEQ.CURRVAL, 0, 0, '192.1.1.4');
    -- 2번글의 답글
INSERT INTO MVC_BOARD (BID, BNAME, BTITLE, BCONTENT, BGROUP, BSTEP, BINDENT, BIP)
    VALUES (MVC_BOARD_SEQ.NEXTVAL, '이길동', '답글', '답글', 2, 1, 1, '127.0.2.1');

SELECT * FROM MVC_BOARD;

-- DAO에 들어갈 QUERY
-- 1. 글 목록(startRow ~ endRow 까지)
SELECT * FROM MVC_BOARD ORDER BY BGROUP DESC, BSTEP;
    -- topN구문
SELECT ROWNUM RW, A.* FROM (SELECT * FROM MVC_BOARD ORDER BY BGROUP DESC, BSTEP) A; -- 전단계

SELECT * 
    FROM (SELECT ROWNUM RW, A.* FROM (SELECT * FROM MVC_BOARD ORDER BY BGROUP DESC, BSTEP) A)
    WHERE RW BETWEEN 2 AND 3;
    
-- 2. 전체 글 갯수
SELECT COUNT(*) FROM MVC_BOARD;

-- 3. 원글 쓰기
INSERT INTO MVC_BOARD (BID, BNAME, BTITLE, BCONTENT, BGROUP, BSTEP, BINDENT, BIP)
    VALUES (MVC_BOARD_SEQ.NEXTVAL, '임길동', '제목', NULL, MVC_BOARD_SEQ.CURRVAL, 0, 0, '192.1.1.5');

-- 4. BID로 조회수 1 올리기
UPDATE MVC_BOARD 
    SET BHIT = BHIT + 1
    WHERE BID = 1;

-- 5. BID로 DTO 가져오기 (글 상세보기, 글 수정 VIEW, 답변글 VIEW)
SELECT * 
    FROM MVC_BOARD
    WHERE BID=1;
    
-- 6. 글 수정하기
UPDATE MVC_BOARD
    SET BNAME = '홍수정',
        BTITLE = '수정된 제목',
        BCONTENT = '수정된 본문',
        BIP = '219.322.21.2'
    WHERE BID = 1;
    
-- 7. 글 삭제하기
DELETE FROM MVC_BOARD
    WHERE BID = 4;

-- 8. 답변글 저장 전 작업 (STEP ⓐ : 예시에서는 2번글의 답변)
UPDATE MVC_BOARD 
    SET BSTEP = BSTEP+1
    WHERE BGROUP = 2 AND BSTEP > 0;
    
-- 9. 답변글 쓰기
SELECT * FROM MVC_BOARD WHERE BID=2;

INSERT INTO MVC_BOARD (BID, BNAME, BTITLE, BCONTENT, BGROUP, BSTEP, BINDENT, BIP)
    VALUES (MVC_BOARD_SEQ.NEXTVAL, '진길동', '답변글2', NULL, 2, 1, 1, '421.221.3.2');

SELECT * FROM MVC_BOARD;

COMMIT;

ROLLBACK;

-- id 중복체크(idConfirm), insert 멤버(join), 로그인 체크(login), id로 dto 가져오기(getMember)
























