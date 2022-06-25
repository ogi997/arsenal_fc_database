delimiter $$
CREATE PROCEDURE SHOW_SPECIFIC_DERBY(in pDerbyLevel varchar(45))
BEGIN 
	SELECT * 
	FROM ALL_DERBY
	WHERE ALL_DERBY.level = pDerbyLevel;
END$$
delimiter ;
