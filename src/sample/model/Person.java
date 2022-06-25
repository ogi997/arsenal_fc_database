package sample.model;

import java.sql.Date;
import java.util.Objects;

public class Person {
    private Integer idPerson;
    private String name;
    private Date date_birth;
    private Integer country_id_person;
    private Short best_team;
    private String status;

    public Person() {
    }

    public Person(Integer idPerson) {
        this.idPerson = idPerson;
    }

    public Person(String name, Date date_birth, Integer country_id_person, Short best_team, String status) {
        this.name = name;
        this.date_birth = date_birth;
        this.country_id_person = country_id_person;
        this.best_team = best_team;
        this.status = status;
    }

    public Person(Integer idPerson, String name, Date date_birth, Integer country_id_person, Short best_team, String status) {
        this.idPerson = idPerson;
        this.name = name;
        this.date_birth = date_birth;
        this.country_id_person = country_id_person;
        this.best_team = best_team;
        this.status = status;
    }

    public Integer getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(Integer idPerson) {
        this.idPerson = idPerson;
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

    public Integer getCountry_id_person() {
        return country_id_person;
    }

    public void setCountry_id_person(Integer country_id_person) {
        this.country_id_person = country_id_person;
    }

    public Short getBest_team() {
        return best_team;
    }

    public void setBest_team(Short best_team) {
        this.best_team = best_team;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(idPerson, person.idPerson);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPerson);
    }

    @Override
    public String toString() {
        return "Person{" +
                "idPerson=" + idPerson +
                ", name='" + name + '\'' +
                ", date_birth=" + date_birth +
                ", country_id_person=" + country_id_person +
                ", best_team=" + best_team +
                ", status='" + status + '\'' +
                '}';
    }
}
