--------------------------------- MVC_MEMBER -----------------------------------
------------------------- MemberDao 에 들어갈 Query -----------------------------
    -- 1. id 중복체크
SELECT * FROM MVC_MEMBER WHERE MID='park';

    -- 1-1. 회원 EMAIL 중복체크
SELECT * FROM MVC_MEMBER WHERE MEMAIL='gayun@naver.com';

    -- 2. join 
INSERT INTO MVC_MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)
    VALUES ('bbb', '111', '임길동', 'limg@limg.com', 'noimg.png', '1998-05-28', '서울 강서구');  
    
    -- 3. login check
SELECT * FROM MVC_MEMBER WHERE MID='aaa' AND MPW='111';

    -- 4. id로 MemberDto 가져오기
SELECT * FROM MVC_MEMBER WHERE MID='aaa';

    -- 5. 회원정보수정
UPDATE MVC_MEMBER SET MPW    = '333',
                      MNAME  = '수길동',
                      MEMAIL = 'SUSU@SU.COM',
                      MPHOTO = 'NOIMG.JPG',
                      MBIRTH = '1995-12-21',
                      MADDRESS = '부산 강서구'
    WHERE MID = 'aaa';
    
    -- 6. 회원 리스트 보기(top-N)
    -- 6-1. 회원 리스트 보기 
SELECT * FROM MVC_MEMBER ORDER BY MRDATE DESC; -- 신입 회원순서 / 1단계

SELECT ROWNUM RW, A.* FROM (SELECT * FROM MVC_MEMBER ORDER BY MRDATE DESC) A; -- / 2단계

SELECT * 
    FROM (SELECT ROWNUM RW, A.* FROM (SELECT * FROM MVC_MEMBER ORDER BY MRDATE DESC) A) -- / 3단계
    WHERE RW BETWEEN 10 AND 12;
    
    -- 6-2. 전체 등록된 회원수
SELECT COUNT(*) CNT FROM MVC_MEMBER;
    
    -- 7. 회원탈퇴
DELETE FROM MVC_MEMBER WHERE MID = 'aaa';

SELECT * FROM MVC_MEMBER;

COMMIT;

------------------------------- FILEBOARD --------------------------------------
-------------------------- BoardDao에 들어갈 Query ------------------------------
    -- 1. 글 목록(startRow ~ endRow)
SELECT * 
    FROM (SELECT ROWNUM RW, A.* FROM (SELECT F.*, MNAME 
                                        FROM FILEBOARD F, MVC_MEMBER M 
                                        WHERE F.mID = M.mID
                                        ORDER BY fGROUP DESC, fSTEP) A)
    WHERE RW BETWEEN 1 AND 2;
    
    -- 1-1. 등록된 글 갯수
SELECT COUNT(*) CN FROM FILEBOARD;

    -- 2. 원글쓰기 (insert)
INSERT INTO FILEBOARD (fID, mID, fTITLE, fCONTENT, fFILENAME, fRDATE, fHIT, fGROUP, fSTEP, fINDENT, fIP)
    VALUES (FILE_SEQ.NEXTVAL, 'gayun', '제목이야', '본문이야', 'noimage.png', '2023-03-15', 0, FILE_SEQ.CURRVAL, 0, 0, '129-221-32-1');
    
    -- 3. hit 1회 올리기
UPDATE FILEBOARD 
    SET fHIT = fHIT + 1
    WHERE fID = '1';
    
    -- 4. 글번호(fid)로 글 전체 내용(BoardDto) 가져오기 (글 상세보기)
SELECT F.*, MNAME 
    FROM FILEBOARD F, MVC_MEMBER M 
    WHERE F.mID = M.mID AND fID = 1;

    -- 5. 글 수정하기(fid, ftitle, fcontent, ffilename, frdate(sysdate), fip 수정)
UPDATE FILEBOARD SET fTITLE = '수정된 제목이야',
                     fCONTENT = '수정된 본문이야',
                     fFILENAME = 'filename.jpg',
                     frdate = '2023-03-14',
                     fIP = '999-999-99-99'
    WHERE fID = '1'; 
    
    -- 6. 글 삭제하기(fid로)
DELETE FROM FILEBOARD
    WHERE fID = '1';
    
    -- 7. 답변글 쓰기 전 작업 (원글의 fgroup과 같고, 원글의 fstep보다 크면 fstep을 하나 증가하기)
UPDATE FILEBOARD 
    SET fSTEP = fSTEP + 1
    WHERE fGROUP = '2' AND fSTEP > 0;
    
    -- 8. 답변글 쓰기
INSERT INTO FILEBOARD (fID, mID, fTITLE, fCONTENT, fFILENAME, fRDATE, fHIT, fGROUP, fSTEP, fINDENT, fIP)
    VALUES (FILE_SEQ.NEXTVAL, 'gayun', '제목이야', '본문이야', 'noimage.png', '2023-03-15', 0, 2, 0, 0, '129-221-32-1');   
    
    -- 9. 회원탈퇴시 탈퇴하는 회원(mid)이 쓴 글 모두 삭제하기 (return값 void)
DELETE FROM FILEBOARD 
    WHERE mID = 'park';
    
COMMIT;

ROLLBACK;

----------------------------------- ADMIN --------------------------------------
-------------------------- AdminDao에 들어갈 Query ------------------------------
    -- 1. admin 로그인
SELECT * FROM ADMIN WHERE aID = 'admin' AND aPW = '1';

    -- 2. 로그인 후 세션에 넣을 용도 admin aid로 AdminDto
SELECT * FROM ADMIN WHERE aID = 'admin';  

COMMIT;













