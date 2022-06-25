CREATE VIEW ALL_TROPHY AS
SELECT trophy_collection.id, seasone.year, compatition.name
FROM trophy_collection
INNER JOIN seasone ON seasone.id = trophy_collection.seasone_id_for_trophy
INNER JOIN compatition ON compatition.id = trophy_collection.compatition_id;