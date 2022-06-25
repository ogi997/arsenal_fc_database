delimiter $$
CREATE PROCEDURE SHOW_FIRST_TEAM(in pID int)
BEGIN
	SELECT person.name, player.number, position.description, player_role.role, country.name as Country 
	FROM first_team
	INNER JOIN person on person.id = first_team.player_id_for_ft or person.id = first_team.manager_id_for_ft
	INNER JOIN country on country.id = person.country_id_person
	left outer join player on person.id = player.person_id
	left outer JOIN position on position.id = player.position_id
	left outer JOIN player_role on player_role.id = player.player_role_id
	WHERE first_team.match_id = 1;
END$$
delimiter ;