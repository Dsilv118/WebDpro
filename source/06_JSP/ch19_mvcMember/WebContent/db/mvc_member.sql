-- DROP TABLE 
DROP TABLE MVC_MEMBER;

-- CREATE TABLE
CREATE TABLE MVC_MEMBER(
    MID    VARCHAR2(30) PRIMARY KEY,
    MPW    VARCHAR2(30) NOT NULL,
    MNAME  VARCHAR2(30) NOT NULL,
    MEMAIL VARCHAR2(30),
    MPHOTO VARCHAR2(30) NOT NULL,
    MBIRTH DATE,
    MADDRESS VARCHAR2(300),
    MRDATE DATE DEFAULT SYSDATE NOT NULL
);
-- DUMMY DATA
INSERT INTO MVC_MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)
    VALUES ('aaa', '111', '홍길동', 'hong@hong.com', 'noimg.png', '1998-01-18', '경기도 수원');
INSERT INTO MVC_MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)
    VALUES ('bbb', '111', '임길동', 'limg@limg.com', 'noimg.png', '1998-05-28', '서울 강서구');
INSERT INTO MVC_MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)
    VALUES ('ccc', '111', '김길동', null, 'noimg.png', '1991-12-18', '서울 양천구');
INSERT INTO MVC_MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)
    VALUES ('ddd', '111', '조길동', 'cho@cho.com', 'noimg.png', '1995-04-05', '서울 도봉구');

SELECT * FROM MVC_MEMBER;

COMMIT;
-- DAO에 들어갈 QUERY
    -- 1. id 중복체크
SELECT COUNT(*) FROM MVC_MEMBER WHERE MID='aaa';

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
DELETE FROM MVC_MEMBER WHERE MID = 'ffff';

SELECT * FROM MVC_MEMBER;

COMMIT;
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    