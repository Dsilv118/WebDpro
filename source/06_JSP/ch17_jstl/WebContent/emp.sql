-- EmpDao에 들어갈 query

-- 전체 리스트 public ArrayList<EmpDto> getListEmp()
SELECT * FROM EMP;

-- 이름과 job으로 검색한 리스트 public ArrayList<EmpDto> getListEmp(String Name, String Job)
SELECT * FROM EMP 
    WHERE ENAME LIKE '%'||TRIM(UPPER('d'))||'%' 
          AND JOB LIKE '%'||UPPER(TRIM('d'))||'%';