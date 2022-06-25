package sample.model;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

public class PlayerContract {
    private Integer player_id_for_contract;
    private String name;
    private Date date_birth;
    private Date signed;
    private Date expired;
    private BigDecimal market_value;
    private BigDecimal salary_week;

    public PlayerContract(Integer player_id_for_contract, String name, Date date_birth, Date signed, Date expired, BigDecimal market_value, BigDecimal salary_week) {
        this.player_id_for_contract = player_id_for_contract;
        this.name = name;
        this.date_birth = date_birth;
        this.signed = signed;
        this.expired = expired;
        this.market_value = market_value;
        this.salary_week = salary_week;
    }

    public Integer getPlayer_id_for_contract() {
        return player_id_for_contract;
    }

    public void setPlayer_id_for_contract(Integer player_id_for_contract) {
        this.player_id_for_contract = player_id_for_contract;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate_birth() {
        return date_birth;
    }

    public void setDate_birth(Date date_birth) {
        this.date_birth = date_birth;
    }

    public Date getSigned() {
        return signed;
    }

    public void setSigned(Date signed) {
        this.signed = signed;
    }

    public Date getExpired() {
        return expired;
    }

    public void setExpired(Date expired) {
        this.expired = expired;
    }

    public BigDecimal getMarket_value() {
        return market_value;
    }

    public void setMarket_value(BigDecimal market_value) {
        this.market_value = market_value;
    }

    public BigDecimal getSalary_week() {
        return salary_week;
    }

    public void setSalary_week(BigDecimal salary_week) {
        this.salary_week = salary_week;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerContract that = (PlayerContract) o;
        return Objects.equals(player_id_for_contract, that.player_id_for_contract);
    }

    @Override
    public int hashCode() {
        return Objects.hash(player_id_for_contract);
    }

    @Override
    public String toString() {
        return "PlayerContract{" +
                "player_id_for_contract=" + player_id_for_contract +
                ", name='" + name + '\'' +
                ", date_birth=" + date_birth +
                ", signed=" + signed +
                ", expired=" + expired +
                ", market_value=" + market_value +
                ", salary_week=" + salary_week +
                '}';
    }
}
