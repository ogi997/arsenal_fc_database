package sample.model;

import java.sql.Date;
import java.util.Objects;

public class BestOfTheBest {
    private Integer id;
    private String name;
    private Date date_birth;
    private String status;
    private String country;

    public BestOfTheBest(Integer id, String name, Date date_birth, String status, String country) {
        this.id = id;
        this.name = name;
        this.date_birth = date_birth;
        this.status = status;
        this.country = country;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BestOfTheBest that = (BestOfTheBest) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "BestOfTheBest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date_birth=" + date_birth +
                ", status='" + status + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
