-- ���α׷� �䱸���׿� �ʿ��� DML

-- ��ɺ� query �ۼ� (1, 2, 3)
-- 1.
INSERT INTO PERSON 
    VALUES (PSQ.NEXTVAL, '�ƹ���', (SELECT JNO FROM JOB WHERE JNAME='����'), 
            50,50,50);

ROLLBACK;
-- 2.
SELECT ROWNUM || '��' RW, A.*
    FROM (SELECT PNAME, JNAME, KOR, ENG, MAT, KOR+ENG+MAT SCR
                FROM PERSON P, JOB J
                WHERE P.JNO=J.JNO AND JNAME='���'
                ORDER BY SCR DESC) A;

-- 3.
SELECT ROWNUM || '��' RW, A.*
    FROM (SELECT PNAME, JNAME, KOR, ENG, MAT, KOR+ENG+MAT SCR
                FROM PERSON P, JOB J
                WHERE P.JNO=J.JNO
                ORDER BY SCR DESC) A;

-- 
SELECT JNAME FROM JOB;

