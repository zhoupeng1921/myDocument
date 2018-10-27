create procedure proce_repeat()
     begin
     declare
     count int;
     set count = 10;
     repeat
     insert into onecolumn values(count);
     set count = count + 1;
     until count >=15 end repeat;
     end