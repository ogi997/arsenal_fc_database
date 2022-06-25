CREATE VIEW ALL_TRANSFERS AS
SELECT transfer_history.id, person.name, person.date_birth, transfer_status.description, seasone.year, transfer_club.club_name, transfer_history.price
FROM transfer_history
INNER JOIN person on person.id = transfer_history.player_id
INNER JOIN transfer_status on transfer_status.id = transfer_history.transfer_status_id
INNER JOIN seasone on seasone.id = transfer_history.seasone_id
INNER JOIN transfer_club on transfer_club.id = transfer_history.transfer_club_id;