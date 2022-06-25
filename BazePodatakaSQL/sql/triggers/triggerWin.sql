#DROP trigger pobjeda;
CREATE TRIGGER pobjeda
AFTER INSERT
ON db_arsenal.match
FOR EACH ROW
UPDATE db_arsenal.manager
INNER JOIN person on id = person_id
SET games_won = IF(new.goals_scored > new.goals_received, games_won + 1, games_won + 0)
WHERE manager.person_id = db_arsenal.person.id AND db_arsenal.person.status = 'ACTIVE';