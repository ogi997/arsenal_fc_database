delimiter $$
CREATE PROCEDURE SHOW_TRANSFERS_BY_SEASONE(in year varchar(45))
BEGIN
	SELECT * 
	FROM ALL_TRANSFERS
	WHERE ALL_TRANSFERS.year = year;
END$$
delimiter ;