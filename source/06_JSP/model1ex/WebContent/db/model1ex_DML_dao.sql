-- CustomerDao(아이디 중복 체크, 회원가입, 로그인, pk로 dto 가져오기(상세보기), top-N 리스트, 등록된 회원수)

-- 1. 아이디 중복 체크 
SELECT COUNT(*) FROM CUSTOMER WHERE cID='aaa';

-- 2. 회원가입
INSERT INTO CUSTOMER (cID, cPW, cNAME, cTEL, cEMAIL, cADDRESS, cGENDER, cBIRTH)
    VALUES ('ggg', '777', '최길동', null, 'jang@jang.com', '서울시 도봉구', 'f', '2021-01-18');
    
-- 3. 로그인
SELECT * FROM CUSTOMER WHERE cID='aaa' AND cPW='111';

-- 4. 상세보기
SELECT * FROM CUSTOMER WHERE cID='aaa';

-- 5. TOP-N 리스트
    -- 등록된 회원수
    SELECT COUNT(*) FROM CUSTOMER;
    -- TOP-N 구문 (페이징)
    SELECT ROWNUM RW, A.* FROM (SELECT * FROM CUSTOMER ORDER BY cRDATE) A; -- 전단계
    SELECT * 
        FROM (SELECT ROWNUM RW, A.* FROM (SELECT * FROM CUSTOMER ORDER BY cRDATE) A)
        WHERE RW BETWEEN 1 AND 2; -- DAO

-- 6. 회원정보수정
UPDATE CUSTOMER SET cPW = '123',
                    cNAME = '양길동',
                    cTEL = '010-9876-5432',
                    cEMAIL = 'DDD@DDD.DD',
                    cADDRESS = '인천',
                    cGENDER = 'm',
                    cBIRTH = null
    WHERE cID='bbb';
-- FileboardDao(top-N 리스트, 글 갯수, 글 쓰기(원글, 답변글(2개 query)), 조회(hit)수 올리기, 글 상세보기, 글 수정, 글 삭제)

-- 1. TOP-N 리스트
    -- 등록된 글 갯수
    SELECT COUNT(*) FROM FILEBOARD;
    -- TOP-N 구문 (페이징)
    SELECT ROWNUM RW, A.* FROM (SELECT F.*, cNAME, cEMAIL 
                                    FROM CUSTOMER C, FILEBOARD F 
                                    WHERE C.cID = F.cID ORDER BY fREF DESC, fRE_STEP) A; -- 전단계
    SELECT *
        FROM (SELECT ROWNUM RW, A.* FROM (SELECT F.*, cNAME, cEMAIL 
                                              FROM CUSTOMER C, FILEBOARD F 
                                              WHERE C.cID = F.cID ORDER BY fREF DESC, fRE_STEP) A)
        WHERE RW BETWEEN 1 AND 2; -- DAO

-- 2. 글 쓰기 
    -- 원글
    INSERT INTO FILEBOARD (fNUM, cID, fSUBJECT, fCONTENT, fFILENAME, fPW, fHIT, fREF, fRE_STEP, fRE_LEVEL, fIP)
        VALUES (FN_SEQ.NEXTVAL, 'aaa', '제목1', '본문1', '1.docx', '111', '10', FN_SEQ.CURRVAL, 0, 0, '154.637.3.8');
    -- 답변글 전단계
    UPDATE FILEBOARD SET fRE_STEP = fRE_STEP + 1
        WHERE fREF='1' AND fRE_STEP > '1';
    -- 답변글
    INSERT INTO FILEBOARD (fNUM, cID, fSUBJECT, fCONTENT, fFILENAME, fPW, fHIT, fREF, fRE_STEP, fRE_LEVEL, fIP)
        VALUES ((SELECT NVL(MAX(NUM), 0)+1 FROM FILEBOARD), 'ccc', '제목2-1', '본문2-1', null, '111', '3', 2, 1, 1, '154.637.3.8');
        
-- 3. 조회수 올리기 
UPDATE FILEBOARD SET fHIT = fHIT + 1 
    WHERE cID = 'aaa';
    
-- 4. 글 상세보기
SELECT * FROM FILEBOARD WHERE fNUM = '2';

-- 5. 글 수정
UPDATE FILEBOARD SET fSUBJECT = '수정된 제목',
                     fCONTENT = '수정된 본문',
                     fFILENAME = '2.docx',
                     fPW = '111'
    WHERE fNUM = '1';
    
-- 6. 글 삭제
DELETE FROM FILEBOARD WHERE cID = 'aaa' AND fPW = '111';

-- BookDao(top-N 리스트, 책 갯수, 책 등록, 책 상세보기)

-- 1. TOP-N 리스트
    -- 등록된 책 갯수
    SELECT COUNT(*) FROM BOOK;
    -- TOP-N 구문
    SELECT ROWNUM RW, A.* FROM (SELECT * FROM BOOK ORDER BY bRDATE) A; -- 전단계
    SELECT * 
        FROM (SELECT ROWNUM RW, A.* FROM (SELECT * FROM BOOK ORDER BY bRDATE) A)
        WHERE RW BETWEEN 1 AND 8; -- DAO
        
-- 2. 책 등록 
INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMAGE1, bIMAGE2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '작은 아씨들',2000,'114.jpg','noImg.png','좋다 ',10);
    
-- 3. 책 상세보기
SELECT * FROM BOOK WHERE bID = '3';
























