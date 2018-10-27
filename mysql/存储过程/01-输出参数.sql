CREATE PROCEDURE proce_out(OUT count int)  
    BEGIN   
    SELECT count;   
    SET count=2;   
    SELECT count;   
    END
;
set @count = 1;
call proce_out(@count);
select @count;
