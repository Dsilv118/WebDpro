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
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    