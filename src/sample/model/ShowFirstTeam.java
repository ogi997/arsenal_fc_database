package sample.model;

import java.util.Objects;

public class ShowFirstTeam {
    private String name;
    private Integer number;
    private String description;
    private String role;
    private String country;

    public ShowFirstTeam(String name, Integer number, String description, String role, String country) {
        this.name = name;
        this.number = number;
        this.description = description;
        this.role = role;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
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
        ShowFirstTeam that = (ShowFirstTeam) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "ShowFirstTeam{" +
                "name='" + name + '\'' +
                ", number=" + number +
                ", description='" + description + '\'' +
                ", role='" + role + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
