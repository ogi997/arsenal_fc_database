package sample.model;

import java.util.Objects;

public class Rival {
    private Integer idRival;
    private String name;
    private Integer stadium_id_for_rival;
    private Integer city_id;

    public Rival() {
    }

    public Rival(Integer idRival) {
        this.idRival = idRival;
    }

    public Rival(String name, Integer stadium_id_for_rival, Integer city_id) {
        this.name = name;
        this.stadium_id_for_rival = stadium_id_for_rival;
        this.city_id = city_id;
    }

    public Rival(Integer idRival, String name, Integer stadium_id_for_rival, Integer city_id) {
        this.idRival = idRival;
        this.name = name;
        this.stadium_id_for_rival = stadium_id_for_rival;
        this.city_id = city_id;
    }

    public Integer getIdRival() {
        return idRival;
    }

    public void setIdRival(Integer idRival) {
        this.idRival = idRival;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStadium_id_for_rival() {
        return stadium_id_for_rival;
    }

    public void setStadium_id_for_rival(Integer stadium_id_for_rival) {
        this.stadium_id_for_rival = stadium_id_for_rival;
    }

    public Integer getCity_id() {
        return city_id;
    }

    public void setCity_id(Integer city_id) {
        this.city_id = city_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rival rival = (Rival) o;
        return Objects.equals(idRival, rival.idRival);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRival);
    }

    @Override
    public String toString() {
        return "Rival{" +
                "idRival=" + idRival +
                ", name='" + name + '\'' +
                ", stadium_id_for_rival=" + stadium_id_for_rival +
                ", city_id=" + city_id +
                '}';
    }
}
