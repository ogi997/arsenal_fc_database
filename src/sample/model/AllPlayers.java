package sample.model;

import java.sql.Date;
import java.util.Objects;

public class AllPlayers {
    private Integer id;
    private String name;
    private Date date_birth;
    private String status;
    private String description;
    private String role;
    private String Position;
    private String country;

    public AllPlayers(Integer id, String name, Date date_birth, String status, String description, String role, String position, String country) {
        this.id = id;
        this.name = name;
        this.date_birth = date_birth;
        this.status = status;
        this.description = description;
        this.role = role;
        this.Position = position;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String position) {
        Position = position;
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
        AllPlayers that = (AllPlayers) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "AllPlayers{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date_birth=" + date_birth +
                ", status='" + status + '\'' +
                ", description='" + description + '\'' +
                ", role='" + role + '\'' +
                ", Position='" + Position + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
