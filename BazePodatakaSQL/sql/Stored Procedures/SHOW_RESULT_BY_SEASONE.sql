delimiter $$
CREATE PROCEDURE SHOW_RESULT_BY_SEASONE(in year varchar(45))
BEGIN
	SELECT *
	FROM ALL_RESULTS
	WHERE ALL_RESULTS.year = year;
END$$
delimiter ;