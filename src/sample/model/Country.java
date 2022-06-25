package sample.model;

import java.util.Objects;

public class Country {
    private Integer idCountry;
    private String name;

    public Country() {
    }

    public Country(Integer idCountry) {
        this.idCountry = idCountry;
    }

    public Country(String name) {
        this.name = name;
    }

    public Country(Integer idCountry, String name) {
        this.idCountry = idCountry;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return Objects.equals(idCountry, country.idCountry);
    }

    public Integer getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(Integer idCountry) {
        this.idCountry = idCountry;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCountry);
    }

    @Override
    public String toString() {
        return "Country{" +
                "idCountry=" + idCountry +
                ", name='" + name + '\'' +
                '}';
    }
}
