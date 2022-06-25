#sve derby utakmice sa osnovnim informacijama o stadionu protivnika
CREATE VIEW ALL_DERBY AS
SELECT derby.id, rival.name as RivalName, derby_level.level, stadium.name as StadiumName, stadium.capacity, stadium.date_built, stadium.length, stadium.width
from derby
INNER JOIN rival on rival.id = derby.rival_id
INNER JOIN derby_level on derby_level.id = derby.derby_level_id
INNER JOIN stadium on stadium.id = rival.stadium_id_for_rival