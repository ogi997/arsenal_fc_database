CREATE VIEW BEST_OF_THE_BEST AS
SELECT person.id, person.name, person.date_birth, person.status, country.name as country 
FROM person
INNER JOIN country on person.country_id_person = country.id
WHERE best_team=1;