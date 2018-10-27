 create procedure proce_while()
    begin
     declare count int;
     set count = 0;
     while count < 5 do
     insert into onecolumn values(count);
     set count = count + 1;
     end while;
     end