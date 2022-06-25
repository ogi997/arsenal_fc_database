delimiter $$
CREATE PROCEDURE WIN_PROCENT_OF_MANAGER(in pID int)
begin
	SELECT games_won / (games_won + games_draw + games_lost) * 100 as WinProcent
	FROM manager
    where manager.person_id = pID;
end$$
delimiter ;

#CALL neko_ime(1, @rez);
#select @rez;