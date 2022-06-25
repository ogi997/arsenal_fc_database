package sample.model;

import java.util.Objects;

public class ContractPlayer {
    private Integer player_id_for_contract;
    private Integer contract_id;

    public ContractPlayer() {
    }

    public ContractPlayer(Integer player_id_for_contract) {
        this.player_id_for_contract = player_id_for_contract;
    }

    public ContractPlayer(Integer player_id_for_contract, Integer contract_id) {
        this.player_id_for_contract = player_id_for_contract;
        this.contract_id = contract_id;
    }

    public Integer getPlayer_id_for_contract() {
        return player_id_for_contract;
    }

    public void setPlayer_id_for_contract(Integer player_id_for_contract) {
        this.player_id_for_contract = player_id_for_contract;
    }

    public Integer getContract_id() {
        return contract_id;
    }

    public void setContract_id(Integer contract_id) {
        this.contract_id = contract_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContractPlayer that = (ContractPlayer) o;
        return Objects.equals(player_id_for_contract, that.player_id_for_contract);
    }

    @Override
    public int hashCode() {
        return Objects.hash(player_id_for_contract);
    }

    @Override
    public String toString() {
        return "ContractPlayer{" +
                "player_id_for_contract=" + player_id_for_contract +
                ", contract_id=" + contract_id +
                '}';
    }
}
