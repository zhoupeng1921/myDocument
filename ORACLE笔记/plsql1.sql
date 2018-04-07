SQL> begin
  2  dbms_output.put_line('Hello');
  3  end;
  4  /

PL/SQL 过程已成功完成。

SQL> set serveroutput on;
SQL> begin
  2  dbms_output.put_line('Hello');
  3  end;
  4  /
Hello                                                                           

PL/SQL 过程已成功完成。

SQL> --执行一个plsql块
SQL> ;
  1  begin
  2  dbms_output.put_line('Hello');
  3* end;
SQL> declare
  2  v_ename varchar2(5);
  3  begin
  4  select ename into v_ename from emp where emp = &aa;
  5  dbms_output.put_line('用户名：'||v_ename);
  6  end;
  7  /
输入 aa 的值:  7788
原值    4: select ename into v_ename from emp where emp = &aa;
新值    4: select ename into v_ename from emp where emp = 7788;
select ename into v_ename from emp where emp = 7788;
                                         *
第 4 行出现错误: 
ORA-06550: 第 4 行, 第 42 列: 
PL/SQL: ORA-00904: "EMP": 标识符无效
ORA-06550: 第 4 行, 第 1 列: 
PL/SQL: SQL Statement ignored 


SQL> declare
  2  v_ename varchar2(5);
  3  begin
  4  select ename into v_ename from emp where empno = &aa;
  5  dbms_output.put_line('用户名：'||v_ename);
  6  end;
  7  /
输入 aa 的值:  7788
原值    4: select ename into v_ename from emp where empno = &aa;
新值    4: select ename into v_ename from emp where empno = 7788;
用户名：SCOTT                                                                   

PL/SQL 过程已成功完成。

SQL> spool off;
