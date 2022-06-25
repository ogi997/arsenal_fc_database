CREATE VIEW ALL_MANAGERS AS
SELECT person.id, person.name, person.date_birth, person.status, country.name as country
FROM manager
INNER JOIN person on manager.person_id = person.id
INNER JOIN country on person.country_id_person = country.id