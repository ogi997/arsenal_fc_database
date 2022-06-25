package sample.model;

import java.sql.Date;
import java.util.Objects;

public class AllManagers {
    private Integer id;
    private String name;
    private String date_birth;
    private String status;
    private String country;
    private String winPercent;

    public AllManagers(Integer id, String name, Date date_birth, String status, String country, Double winPercent) {
        this.id = id;
        this.name = name;
        this.date_birth = String.valueOf(date_birth);
        this.status = status;
        this.country = country;
        this.winPercent = String.valueOf(winPercent);
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

    public String getDate_birth() {
        return date_birth;
    }

    public void setDate_birth(String date_birth) {
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

    public String getWinPercent() {
        return winPercent;
    }

    public void setWinPercent(String winPercent) {
        this.winPercent = winPercent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AllManagers that = (AllManagers) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "AllManagers{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date_birth=" + date_birth +
                ", status='" + status + '\'' +
                ", country='" + country + '\'' +
                ", winPercent='" + winPercent + '\'' +
                '}';
    }
}
