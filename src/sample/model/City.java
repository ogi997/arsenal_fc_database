package sample.model;

import java.util.Objects;

public class City {
    private Integer idCity;
    private String name;
    private Integer country_id_for_city;

    public City() {
    }

    public City(Integer idCity) {
        this.idCity = idCity;
    }

    public City(String name, Integer country_id_for_city) {
        this.name = name;
        this.country_id_for_city = country_id_for_city;
    }

    public City(Integer idCity, String name, Integer country_id_for_city) {
        this.idCity = idCity;
        this.name = name;
        this.country_id_for_city = country_id_for_city;
    }

    public Integer getIdCity() {
        return idCity;
    }

    public void setIdCity(Integer idCity) {
        this.idCity = idCity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCountry_id_for_city() {
        return country_id_for_city;
    }

    public void setCountry_id_for_city(Integer country_id_for_city) {
        this.country_id_for_city = country_id_for_city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return Objects.equals(idCity, city.idCity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCity);
    }

    @Override
    public String toString() {
        return "City{" +
                "idCity=" + idCity +
                ", name='" + name + '\'' +
                ", country_id_for_city=" + country_id_for_city +
                '}';
    }
}
