-- TABLE DROP & CREATE 

DROP TABLE MEMBER;
CREATE TABLE MEMBER(
    ID      VARCHAR2(30) PRIMARY KEY,
    PW      VARCHAR2(30) NOT NULL,
    NAME    VARCHAR2(30) NOT NULL,
    PHONE1  VARCHAR2(5),
    PHONE2  VARCHAR2(5),
    PHONE3  VARCHAR2(5),
    GENDER  VARCHAR2(1),
    EMAIL   VARCHAR2(30),
    BIRTH   DATE,
    ADDRESS VARCHAR2(200),
    RDATE   DATE NOT NULL -- 가입일
);
SELECT * FROM MEMBER;

-- 1. 회원가입시 id 중복체크 : public int confirmId(String id)
-- SELECT COUNT(*) FROM MEMBER WHERE ID='aaa'; <-- 이방법도 가능.
SELECT * FROM MEMBER WHERE ID='ccc';

-- 2. 회원가입 : public int joinMember(MemberDto dto)
INSERT INTO MEMBER 
    (ID, PW, NAME, PHONE1, PHONE2, PHONE3, GENDER, EMAIL, BIRTH, ADDRESS, RDATE)
    VALUES
        ('zzz','111', '임길동', '010', '676', '7387', 'm', 'lim212@naver.com', '1998-01-18', '인천', SYSDATE);
        
-- 3. 로그인 : public int loginCheck(String id, String pw)
SELECT ID, PW FROM MEMBER WHERE ID='aaa';

-- 4. ID로 dto 가져오기 : 로그인 성공시 session에 setAttribute / 회원정보 수정시 회원정보 가져오기
--                    : public MemberDto getMember(String id)
SELECT * FROM MEMBER WHERE ID='zzz';

-- 5. 회원정보수정 : public int modifyMember(MemberDto dto)
UPDATE MEMBER SET PW='111', 
                  NAME='홍길동',
                  PHONE1='031',
                  PHONE2='3241',
                  PHONE3='2213',
                  GENDER='f',
                  EMAIL='kil@hong@com',
                  BIRTH='1995-01-18',
                  ADDRESS='경기도 안양'
    WHERE ID='aaa';
COMMIT;


















