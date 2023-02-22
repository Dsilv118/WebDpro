-- BOARD TABLE DROP & CREATE
DROP TABLE BOARD;

CREATE TABLE BOARD(
    NUM     NUMBER(5,0) PRIMARY KEY, -- 글번호
    WRITER  VARCHAR2(30) NOT NULL,   -- 글 작성자
    SUBJECT VARCHAR2(100) NOT NULL,  -- 글 제목
    CONTENT VARCHAR2(100) NOT NULL,  -- 본문 내용
    EMAIL   VARCHAR2(30),            -- 작성자 이메일
    READCOUNT NUMBER(5) DEFAULT 0,   -- 글 HIT수 (조회수)
    PW      VARCHAR2(30) NOT NULL,   -- 글 삭제시 쓸 비밀번호
    REF     NUMBER(5,0) NOT NULL,    -- 글 그룹(원글의 경우 글 번호로/답변글일 경우 원글의 REF로)
    RE_STEP NUMBER(3) NOT NULL,      -- 글 그룹 내 출력 순서(원글 0)
    RE_INDENT NUMBER(3) NOT NULL,    -- 글 LIST 출력시 글 제목 들여쓰기 정도(원글=0)
    IP      VARCHAR2(30) NOT NULL,   -- 글 작성시 컴퓨터 IP 주소
    RDATE   DATE DEFAULT SYSDATE     -- 글 쓴 시점(날짜 + 시간)  
);

SELECT * FROM BOARD;

-- 1. 글 갯수
SELECT COUNT(*) FROM BOARD;

-- 2. 글 목록(글 그룹이 최신인 글이 위로)
SELECT * FROM BOARD ORDER BY REF DESC;

-- 2. 글목록 (topN구문)
SELECT ROWNUM RN, A.* FROM (SELECT * FROM BOARD ORDER BY REF DESC) A; -- 전단계
SELECT *
    FROM (SELECT ROWNUM RN, A.* FROM (SELECT * FROM BOARD ORDER BY REF DESC) A)
    WHERE RN BETWEEN 11 AND 20; -- 완성 (DAO에 들어갈 SQL)

-- 3. 글 쓰기(원글 쓰기) - 글쓴이, 글제목, 글본문, 이메일, PW
    -- 글 번호를 생성
    SELECT NVL(MAX(NUM), 0)+1 FROM BOARD;
    
INSERT INTO BOARD (NUM, WRITER, SUBJECT, CONTENT, EMAIL, PW, REF, RE_STEP, RE_INDENT, IP)
    VALUES ((SELECT NVL(MAX(NUM), 0)+1 FROM BOARD), '홍길동', '제목1', '본문', NULL, '111',
            (SELECT NVL(MAX(NUM), 0)+1 FROM BOARD), 0, 0, '195.241.0.1');
            
INSERT INTO BOARD (NUM, WRITER, SUBJECT, CONTENT, EMAIL, PW, REF, RE_STEP, RE_INDENT, IP)
    VALUES ((SELECT NVL(MAX(NUM), 0)+1 FROM BOARD), '지길동', '제목2', '본문', NULL, '111',
            (SELECT NVL(MAX(NUM), 0)+1 FROM BOARD), 0, 0, '195.241.0.1');

-- 4. 글 번호로 글 상세보기 내용(DTO) 가져오기
SELECT * FROM BOARD WHERE NUM=2;

-- 5. 조회수 올리기
UPDATE BOARD SET READCOUNT = READCOUNT + 1 WHERE NUM=2;
SELECT * FROM BOARD ORDER BY REF DESC;

-- 6. 글 수정
UPDATE BOARD SET SUBJECT = '수정된 제목 1',
                 CONTENT = '수정된 본문\n방가',
                 EMAIL   = 'hong@hong.com',
                 PW      = '111',
                 IP      = '123.221.2.1'
    WHERE NUM = 1;

-- 7. 글 삭제(비밀번호를 맞게 입력한 경우만 삭제)
DELETE FROM BOARD WHERE NUM = 1 AND PW = '111';

-- 데이터 조작
DELETE FROM BOARD;

-- 조회수 조작
UPDATE BOARD SET READCOUNT = 11 WHERE NUM=1;
SELECT * FROM BOARD ORDER BY REF DESC;

COMMIT;

SELECT * FROM BOARD;




















