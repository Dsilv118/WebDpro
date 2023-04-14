-- ★ ★ ★ ★ ★ book.xml ★ ★ ★ ★ ★ --
-- id = mainList (신간도서 순 bookList)
SELECT * FROM BOOK ORDER BY bRDATE DESC;

-- id = bookList (startRow~endRow까지 bookList) 출력 순서 : bTITLE 기준
SELECT * 
    FROM (SELECT ROWNUM RW, A.* FROM (SELECT * FROM BOOK ORDER BY bTITLE DESC)A )
    WHERE RW BETWEEN 1 AND 3;
    
-- id = totCntBook (등록된 책 갯수)
SELECT COUNT(*) FROM BOOK;

-- id = getDetailBook (책 번호로 dto 가져오기)
SELECT * FROM BOOK WHERE bNUM = 1;

-- id = registerBook (책 등록)
INSERT INTO BOOK (bNUM, bTITLE, bWRITER, bRDATE, bIMG1, bIMG2, bINFO)
    VALUES (BOOK_SQ.NEXTVAL, 'JAVA','이자바',SYSDATE, 'NOIMG.JPG', 'NOIMG.JPG', '자바심화서');
INSERT INTO BOOK (bNUM, bTITLE, bWRITER, bRDATE, bIMG1, bINFO)
    VALUES (BOOK_SQ.NEXTVAL, 'JAVA','이자바',SYSDATE, 'NOIMG.JPG', '자바심화서');
INSERT INTO BOOK (bNUM, bTITLE, bWRITER, bRDATE, bIMG2, bINFO)
    VALUES (BOOK_SQ.NEXTVAL, 'JAVA','이자바',SYSDATE, 'NOIMG.JPG', '자바심화서');
INSERT INTO BOOK (bNUM, bTITLE, bWRITER, bRDATE, bINFO)
    VALUES (BOOK_SQ.NEXTVAL, 'JAVA','이자바',SYSDATE, '자바심화서');
    
-- id = modifyBook (책 수정)
UPDATE BOOK 
    SET bTITLE = 'SPRING2',
        bWRITER = '임작가',
        bRDATE = SYSDATE,
        bimg1 = 'noimg',
        bimg2 = 'noimg',
        bINFO = '스프링 개념서'
    WHERE bNUM = 1;
    
-- ★ ★ ★ ★ ★  member.xml ★ ★ ★ ★ ★ --
-- id = idConfirm (mid가 id인 데이터 갯수)
SELECT COUNT(*) FROM MEMBER WHERE MID = 'aaa';

-- id = joinMember (회원가입)
INSERT INTO MEMBER (mID, mPW, mNAME, mMAIL, mPOST, mADDR)
    VALUES ('aaa','1','홍길동','hong@naver.com','12345','서울');
    
-- id = getDetailMember (mid로 Member Dto 가져오기)
SELECT * FROM MEMBER WHERE MID = 'aaa';

-- id = modifyMember(회원정보 수정)
UPDATE MEMBER 
    SET mPW = '2',
        mNAME = '왕길동',
        mMAIL = 'wang@naver.com',
        mPOST = '12345',
        mADDR = '서울'
    WHERE mID = 'aaa';
        
        
        
        
        