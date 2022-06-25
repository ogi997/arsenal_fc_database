package sample.model;

import java.util.Objects;

public class Famous {
    private Integer idFamous;
    private Integer famous_level_id;
    private Integer person_id_for_famous;

    public Famous() {
    }

    public Famous(Integer idFamous) {
        this.idFamous = idFamous;
    }

    public Famous(Integer famous_level_id, Integer person_id_for_famous) {
        this.famous_level_id = famous_level_id;
        this.person_id_for_famous = person_id_for_famous;
    }

    public Famous(Integer idFamous, Integer famous_level_id, Integer person_id_for_famous) {
        this.idFamous = idFamous;
        this.famous_level_id = famous_level_id;
        this.person_id_for_famous = person_id_for_famous;
    }

    public Integer getIdFamous() {
        return idFamous;
    }

    public void setIdFamous(Integer idFamous) {
        this.idFamous = idFamous;
    }

    public Integer getFamous_level_id() {
        return famous_level_id;
    }

    public void setFamous_level_id(Integer famous_level_id) {
        this.famous_level_id = famous_level_id;
    }

    public Integer getPerson_id_for_famous() {
        return person_id_for_famous;
    }

    public void setPerson_id_for_famous(Integer person_id_for_famous) {
        this.person_id_for_famous = person_id_for_famous;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Famous famous = (Famous) o;
        return Objects.equals(idFamous, famous.idFamous) &&
                Objects.equals(famous_level_id, famous.famous_level_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFamous, famous_level_id);
    }

    @Override
    public String toString() {
        return "Famous{" +
                "idFamous=" + idFamous +
                ", famous_level_id=" + famous_level_id +
                ", person_id_for_famous=" + person_id_for_famous +
                '}';
    }
}
