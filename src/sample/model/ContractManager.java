package sample.model;

import java.util.Objects;

public class ContractManager {
    private Integer manager_id;
    private Integer contract_id_for_manager;

    public ContractManager() {
    }

    public ContractManager(Integer manager_id) {
        this.manager_id = manager_id;
    }

    public ContractManager(Integer manager_id, Integer contract_id_for_manager) {
        this.manager_id = manager_id;
        this.contract_id_for_manager = contract_id_for_manager;
    }

    public Integer getManager_id() {
        return manager_id;
    }

    public void setManager_id(Integer manager_id) {
        this.manager_id = manager_id;
    }

    public Integer getContract_id_for_manager() {
        return contract_id_for_manager;
    }

    public void setContract_id_for_manager(Integer contract_id_for_manager) {
        this.contract_id_for_manager = contract_id_for_manager;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContractManager that = (ContractManager) o;
        return Objects.equals(manager_id, that.manager_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(manager_id);
    }

    @Override
    public String toString() {
        return "ContractManager{" +
                "manager_id=" + manager_id +
                ", contract_id_for_manager=" + contract_id_for_manager +
                '}';
    }
}
