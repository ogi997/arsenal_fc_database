CREATE VIEW PLAYERS_CONTRACT AS
SELECT contract_player.player_id_for_contract, person.name, person.date_birth, contract.signed, contract.expired, contract.market_value, contract.salary_week 
FROM contract_player
INNER JOIN person on contract_player.player_id_for_contract = person.id
INNER JOIN contract on contract_player.contract_id = contract.id;