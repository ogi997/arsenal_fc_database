package sample.model;

import java.sql.Date;
import java.util.Objects;

public class FamousPersons {
    private Integer id;
    private String name;
    private Date date_birth;
    private String status;
    private String country;
    private String level;

    public FamousPersons(Integer id, String name, Date date_birth, String status, String country, String level) {
        this.id = id;
        this.name = name;
        this.date_birth = date_birth;
        this.status = status;
        this.country = country;
        this.level = level;
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

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FamousPersons that = (FamousPersons) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "FamousPersons{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date_birth=" + date_birth +
                ", status='" + status + '\'' +
                ", country='" + country + '\'' +
                ", level='" + level + '\'' +
                '}';
    }
}
