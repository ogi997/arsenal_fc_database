CREATE VIEW ALL_RESULTS AS
SELECT db_arsenal.match.id, db_arsenal.match.goals_scored, db_arsenal.match.goals_received, db_arsenal.match.date, rival.name as RivalName, seasone.year, compatition.name as CompatitionName, db_arsenal.match.home
FROM db_arsenal.match
INNER JOIN rival on rival.id = db_arsenal.match.rival_id
INNER JOIN seasone on seasone.id = db_arsenal.match.seasone_id_for_match
INNER JOIN compatition on compatition.id = db_arsenal.match.game_id;