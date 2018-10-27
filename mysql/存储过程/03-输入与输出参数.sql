CREATE PROCEDURE proce_inout(INOUT count int)  
    BEGIN   
    SELECT count;   
    SET count=2;   
    SELECT count;   
    END
;
set @count = 1;
call proce_inout(@count);
select @count;
