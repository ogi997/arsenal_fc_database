CREATE VIEW ALL_PLAYERS AS
SELECT person.id, person.name, person.date_birth, person.status, foot.description, player_role.role, position.description as Position, country.name as country
FROM player
INNER JOIN person on player.person_id = person.id
INNER JOIN foot on player.foot_id = foot.id
INNER JOIN position on player.position_id = position.id
INNER JOIN player_role on player.player_role_id = player_role.id
INNER JOIN country on person.country_id_person = country.id