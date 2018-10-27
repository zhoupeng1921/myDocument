CREATE PROCEDURE proce_in(IN count int)  
    BEGIN   
    SELECT count;   
    SET count=2;   
    SELECT count;   
    END
		
set @count = 1;
call proce_in(@count);
select @count;