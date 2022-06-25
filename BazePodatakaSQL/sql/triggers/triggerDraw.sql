#DROP trigger nerjeseno;
CREATE TRIGGER nerjeseno
AFTER INSERT
ON db_arsenal.match
FOR EACH ROW
UPDATE db_arsenal.manager
INNER JOIN person on id = person_id
SET games_draw = IF(new.goals_scored = new.goals_received, games_draw + 1, games_draw + 0)
WHERE manager.person_id = db_arsenal.person.id AND db_arsenal.person.status = 'ACTIVE';