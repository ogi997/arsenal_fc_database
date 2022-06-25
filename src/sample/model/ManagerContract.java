package sample.model;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

public class ManagerContract {
    private Integer manager_id;
    private String name;
    private Date date_birth;
    private Date signed;
    private Date expired;
    private BigDecimal market_value;
    private BigDecimal salary_week;

    public ManagerContract(Integer manager_id, String name, Date date_birth, Date signed, Date expired, BigDecimal market_value, BigDecimal salary_week) {
        this.manager_id = manager_id;
        this.name = name;
        this.date_birth = date_birth;
        this.signed = signed;
        this.expired = expired;
        this.market_value = market_value;
        this.salary_week = salary_week;
    }

    public Integer getManager_id() {
        return manager_id;
    }

    public void setManager_id(Integer manager_id) {
        this.manager_id = manager_id;
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
        ManagerContract that = (ManagerContract) o;
        return Objects.equals(manager_id, that.manager_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(manager_id);
    }

    @Override
    public String toString() {
        return "ManagerContract{" +
                "manager_id=" + manager_id +
                ", name='" + name + '\'' +
                ", date_birth=" + date_birth +
                ", signed=" + signed +
                ", expired=" + expired +
                ", market_value=" + market_value +
                ", salary_week=" + salary_week +
                '}';
    }
}
