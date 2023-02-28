-- 회원(CUSTOMER)테이블 dummy data 먼저 - 6개(aaa, bbb, ccc, ddd, eee, fff)
INSERT INTO CUSTOMER (cID, cPW, cNAME, cTEL, cEMAIL, cADDRESS, cGENDER, cBIRTH)
    VALUES ('aaa', '111', '홍길동', '010-1111-1111', 'hong@hong.com', '서울시 양천구', 'f', null);
INSERT INTO CUSTOMER (cID, cPW, cNAME, cTEL, cEMAIL, cADDRESS, cGENDER, cBIRTH)
    VALUES ('bbb', '222', '임길동', '010-2222-2222', 'lim@lim.com', '서울시 강서구', 'm', '2020-05-27');
INSERT INTO CUSTOMER (cID, cPW, cNAME, cTEL, cEMAIL, cADDRESS, cGENDER, cBIRTH)
    VALUES ('ccc', '333', '박길동', '010-3333-3333', 'park@park.com', null, 'f', null);
INSERT INTO CUSTOMER (cID, cPW, cNAME, cTEL, cEMAIL, cADDRESS, cGENDER, cBIRTH)
    VALUES ('ddd', '444', '김길동', '010-4444-4444', 'kim@kim.com', '서울시 용산구', null, null);
INSERT INTO CUSTOMER (cID, cPW, cNAME, cTEL, cEMAIL, cADDRESS, cGENDER, cBIRTH)
    VALUES ('eee', '555', '이길동', '010-5555-5555', null, '서울시 중랑구', 'f', '2019-02-12');
INSERT INTO CUSTOMER (cID, cPW, cNAME, cTEL, cEMAIL, cADDRESS, cGENDER, cBIRTH)
    VALUES ('fff', '666', '장길동', null, 'jang@jang.com', '서울시 도봉구', 'f', '2021-01-18');
    
SELECT * FROM CUSTOMER;

-- 파일 첨부 게시판(FileBoard)테이블 dummy data - 3개(글1, 글2, 글2-1) - 하나는 첨부파일(1.docx)이 있는 거
INSERT INTO FILEBOARD (fNUM, cID, fSUBJECT, fCONTENT, fFILENAME, fPW, fHIT, fREF, fRE_STEP, fRE_LEVEL, fIP)
    VALUES (FN_SEQ.NEXTVAL, 'aaa', '제목1', '본문1', '1.docx', '111', '10', FN_SEQ.CURRVAL, 0, 0, '154.637.3.8');
INSERT INTO FILEBOARD (fNUM, cID, fSUBJECT, fCONTENT, fFILENAME, fPW, fHIT, fREF, fRE_STEP, fRE_LEVEL, fIP)
    VALUES (FN_SEQ.NEXTVAL, 'bbb', '제목2', '본문2', null, '111', '5', FN_SEQ.CURRVAL, 0, 0, '154.637.3.8');
INSERT INTO FILEBOARD (fNUM, cID, fSUBJECT, fCONTENT, fFILENAME, fPW, fHIT, fREF, fRE_STEP, fRE_LEVEL, fIP)
    VALUES (FN_SEQ.NEXTVAL, 'ccc', '제목2-1', '본문2-1', null, '111', '3', 2, 1, 1, '154.637.3.8');
    
SELECT * FROM FILEBOARD;

-- 도서(BOOK)테이블 dummy data    
INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMAGE1, bIMAGE2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '내일의 부',16000,'100.jpg','noImg.png','좋아',10);
INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMAGE1, bIMAGE2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '3층 서기실의 암호',20000,'101.jpg','noImg.png','태영호 증언',10);
INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMAGE1, bIMAGE2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '당신이 글을 쓰면 좋겠습니다',14000,'102.jpg','noImg.png','좋아',5);
INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMAGE1, bIMAGE2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '울트라러닝',16000,'103.jpg','noImg.png','좋아',5);
INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMAGE1, bIMAGE2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '내가 왔다',11500,'104.jpg','noImg.png','좋아',10);
INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMAGE1, bIMAGE2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '나의 서툰 위로가 너에게 닿기를',13000,'105.jpg','noImg.png','좋아',30);
INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMAGE1, bIMAGE2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '아직 멀었다는 말',13500,'106.jpg','noImg.png','좋아',10);
INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMAGE1, bIMAGE2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '소금 지방 산열',33000,'107.jpg','noImg.png','좋아',10);
INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMAGE1, bIMAGE2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '디레버리징',20000,'108.jpg','noImg.png','좋아',10);
INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMAGE1, bIMAGE2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '너와 나의 암호말',18000,'109.jpg','noImg.png','좋아',5);
INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMAGE1, bIMAGE2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '오늘도 펭수, 내일도 펭수',17000,'110.jpg','noImg.png','좋아',10);
INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMAGE1, bIMAGE2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '지적대화를 위한 넓고 얕은 지식2',1600,'111.jpg','noImg.png','좋아',30);
INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMAGE1, bIMAGE2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '트렌드코리아 2020',2000,'112.jpg','noImg.png','2020 트렌드 키워드 ',15);
INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMAGE1, bIMAGE2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '여행의 이유',1800,'113.jpg','noImg.png','김영하의 여행 경험',10);
INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMAGE1, bIMAGE2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '작은 아씨들',2000,'114.jpg','noImg.png','좋다 ',10);
    
SELECT * FROM BOOK;

COMMIT;