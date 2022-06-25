package sample.model;

import java.sql.Date;
import java.util.Objects;

public class Contract {
    private Integer idContract;
    private Date signed;
    private Date expired;
    private Double market_value;
    private Double salary_week;

    public Contract() {
    }

    public Contract(Integer idContract) {
        this.idContract = idContract;
    }

    public Contract(Date signed, Date expired, Double market_value, Double salary_week) {
        this.signed = signed;
        this.expired = expired;
        this.market_value = market_value;
        this.salary_week = salary_week;
    }

    public Contract(Integer idContract, Date signed, Date expired, Double market_value, Double salary_week) {
        this.idContract = idContract;
        this.signed = signed;
        this.expired = expired;
        this.market_value = market_value;
        this.salary_week = salary_week;
    }

    public Integer getIdContract() {
        return idContract;
    }

    public void setIdContract(Integer idContract) {
        this.idContract = idContract;
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

    public Double getMarket_value() {
        return market_value;
    }

    public void setMarket_value(Double market_value) {
        this.market_value = market_value;
    }

    public Double getSalary_week() {
        return salary_week;
    }

    public void setSalary_week(Double salary_week) {
        this.salary_week = salary_week;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contract contract = (Contract) o;
        return Objects.equals(idContract, contract.idContract);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idContract);
    }

    @Override
    public String toString() {
        return "Contract{" +
                "idContract=" + idContract +
                ", signed=" + signed +
                ", expired=" + expired +
                ", market_value=" + market_value +
                ", salary_week=" + salary_week +
                '}';
    }
}
