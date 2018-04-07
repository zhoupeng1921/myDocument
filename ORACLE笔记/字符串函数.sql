

LOWER(ENAME)
------------
smith
allen
ward
jones
martin
blake
clark
king
turner
james
ford
miller

12 rows selected


UPPER(ENAME)
------------
SMITH
ALLEN
WARD
JONES
MARTIN
BLAKE
CLARK
KING
TURNER
JAMES
FORD
MILLER

12 rows selected


UPPER(ENAME) LENGTH(ENAME)
------------ -------------
SMITH                    5
ALLEN                    5
WARD                     4
JONES                    5
MARTIN                   6
BLAKE                    5
CLARK                    5
KING                     4
TURNER                   6
JAMES                    5
FORD                     4
MILLER                   6

12 rows selected


UPPER(ENAME) LENGTH(ENAME) SUBSTR(ENAME,2,1)
------------ ------------- -----------------
SMITH                    5 M
ALLEN                    5 L
WARD                     4 A
JONES                    5 O
MARTIN                   6 A
BLAKE                    5 L
CLARK                    5 L
KING                     4 I
TURNER                   6 U
JAMES                    5 A
FORD                     4 O
MILLER                   6 I

12 rows selected


EMPNO ENAME      JOB         MGR HIREDATE          SAL      COMM DEPTNO
----- ---------- --------- ----- ----------- --------- --------- ------
 7369 SMITH      CLERK      7902 1980/12/17     800.00               20
 7499 ALLEN      SALESMAN   7698 1981/2/20     1600.00    300.00     30
 7566 JONES      MANAGER    7839 1981/4/2      2975.00               20
 7698 BLAKE      MANAGER    7839 1981/5/1      2850.00               30
 7782 CLARK      MANAGER    7839 1981/6/9      2450.00               10
 7900 JAMES      CLERK      7698 1981/12/3      950.00               30

6 rows selected


SUBSTR(ENAME,1,3)
-----------------
SMI
ALL
WAR
JON
MAR
BLA
CLA
KIN
TUR
JAM
FOR
MIL

12 rows selected


UPPER(SUBSTR(ENAME,1,1)) LOWER(SUBSTR(ENAME,2,LENGTH(EN
------------------------ ------------------------------
S                        mith
A                        llen
W                        ard
J                        ones
M                        artin
B                        lake
C                        lark
K                        ing
T                        urner
J                        ames
F                        ord
M                        iller

12 rows selected


UPPER(SUBSTR(ENAME,1,1))||LOWE
------------------------------
Smith
Allen
Ward
Jones
Martin
Blake
Clark
King
Turner
James
Ford
Miller

12 rows selected


REPLACE(ENAME,'A','A')
----------------------
SMITH
aLLEN
WaRD
JONES
MaRTIN
BLaKE
CLaRK
KING
TURNER
JaMES
FORD
MILLER

12 rows selected


INSTR(ENAME,'A')
----------------
               0
               1
               2
               0
               2
               3
               3
               0
               0
               2
               0
               0

12 rows selected


ENAME      INSTR(ENAME,'A')
---------- ----------------
SMITH                     0
ALLEN                     1
WARD                      2
JONES                     0
MARTIN                    2
BLAKE                     3
CLARK                     3
KING                      0
TURNER                    0
JAMES                     2
FORD                      0
MILLER                    0

12 rows selected

