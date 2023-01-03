-- -- [XI] 인덱스 : 조회를 빠르게 하는 인덱스
SELECT * FROM USER_INDEXES;

DROP TABLE EMP01;
CREATE TABLE EMP01 AS SELECT * FROM EMP; -- EMP테이블과 같은 내용의 EMP01;
SELECT * FROM EMP01; -- 14행
INSERT INTO EMP01 SELECT * FROM EMP01; -- ★데이터 뻥튀기 1번(28행) 2번(56행)
SELECT TO_CHAR(COUNT(*), '9,999,999') FROM EMP01;
INSERT INTO EMP01 SELECT * FROM EMP01; -- ★ 11번 (11만개)
INSERT INTO EMP01 (EMPNO, ENAME, DEPTNO) VALUES (1111, 'HONG', 40);
INSERT INTO EMP01 SELECT * FROM EMP01; -- 1번(22만) 2번(44만) 3번(90번)
SELECT TO_CHAR(COUNT(*), '9,999,999') FROM EMP01;
-- 인덱스 생성 전 조회 
SELECT * FROM EMP01 WHERE ENAME='HONG'; -- ※ 인덱스 생성 전 조회 시간(91만) 0.025초
-- 인덱스 생성
CREATE INDEX IDX_EMP01_ENAME ON EMP01(ENAME); -- 0.659초 
-- 인덱스 생성 후 조회 
SELECT * FROM EMP01 WHERE ENAME='HONG'; -- ※ 인덱스 생성 후 조회 시간(91만) 0.002초
COMMIT;
INSERT INTO EMP01 SELECT * FROM EMP01; -- 인덱스 생성 후 91만 -> 182만으로 INSERT 시간 : 35.25초
SELECT TO_CHAR(COUNT(*), '9,999,999') FROM EMP01;
ROLLBACK; -- 14.19초
DROP INDEX IDX_EMP01_ENAME;
INSERT INTO EMP01 SELECT * FROM EMP01; -- 인덱스 제거후 91만 -> 182만으로 INSERT 시간 : 4.355초

SELECT * FROM USER_INDEXES WHERE TABLE_NAME='EMP01';
DROP TABLE EMP01; -- 테이블을 지우면해당 테이블의 인덱스는 자동 삭제


