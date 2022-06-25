CREATE VIEW FAMOUS_PERSONS AS
SELECT famous.id, person.name, person.date_birth, person.status, country.name as country, famous_level.level
FROM famous
INNER JOIN famous_level on famous_level.id = famous.famous_level_id
INNER JOIN person on person.id = famous.person_id_for_famous
INNER JOIN country on country.id = person.country_id_person;