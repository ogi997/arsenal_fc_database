CREATE VIEW MANAGERS_CONTRACT AS
SELECT contract_manager.manager_id, person.name, person.date_birth, contract.signed, contract.expired, contract.market_value, contract.salary_week 
FROM contract_manager
INNER JOIN person on contract_manager.manager_id = person.id
INNER JOIN contract on contract_manager.contract_id_for_manager = contract.id;