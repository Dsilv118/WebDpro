-- 프로그램 요구사항에 필요한 DML

-- 기능별 query 작성 (1, 2, 3)
-- 1.
INSERT INTO PERSON 
    VALUES (PSQ.NEXTVAL, '아무개', (SELECT JNO FROM JOB WHERE JNAME='가수'), 
            50,50,50);

ROLLBACK;
-- 2.
SELECT ROWNUM || '등' RW, A.*
    FROM (SELECT PNAME, JNAME, KOR, ENG, MAT, KOR+ENG+MAT SCR
                FROM PERSON P, JOB J
                WHERE P.JNO=J.JNO AND JNAME='배우'
                ORDER BY SCR DESC) A;

-- 3.
SELECT ROWNUM || '등' RW, A.*
    FROM (SELECT PNAME, JNAME, KOR, ENG, MAT, KOR+ENG+MAT SCR
                FROM PERSON P, JOB J
                WHERE P.JNO=J.JNO
                ORDER BY SCR DESC) A;

-- 
SELECT JNAME FROM JOB;

