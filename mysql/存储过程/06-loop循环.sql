create procedure proce_loop()
     begin
     declare count int;
     set count = 20;
     loop_lable:loop
     insert into onecolumn values(count);
     set count = count + 1;
     if(count >=25) then 
     leave loop_lable;
     end if;
     end loop;
     end