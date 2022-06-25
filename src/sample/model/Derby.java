package sample.model;

import java.util.Objects;

public class Derby {
    private Integer idDerby;
    private Integer rival_id;
    private Integer derby_level_id;

    public Derby() {
    }

    public Derby(Integer idDerby) {
        this.idDerby = idDerby;
    }

    public Derby(Integer rival_id, Integer derby_level_id) {
        this.rival_id = rival_id;
        this.derby_level_id = derby_level_id;
    }

    public Derby(Integer idDerby, Integer rival_id, Integer derby_level_id) {
        this.idDerby = idDerby;
        this.rival_id = rival_id;
        this.derby_level_id = derby_level_id;
    }

    public Integer getIdDerby() {
        return idDerby;
    }

    public void setIdDerby(Integer idDerby) {
        this.idDerby = idDerby;
    }

    public Integer getRival_id() {
        return rival_id;
    }

    public void setRival_id(Integer rival_id) {
        this.rival_id = rival_id;
    }

    public Integer getDerby_level_id() {
        return derby_level_id;
    }

    public void setDerby_level_id(Integer derby_level_id) {
        this.derby_level_id = derby_level_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Derby derby = (Derby) o;
        return Objects.equals(idDerby, derby.idDerby);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDerby);
    }

    @Override
    public String toString() {
        return "Derby{" +
                "idDerby=" + idDerby +
                ", rival_id=" + rival_id +
                ", derby_level_id=" + derby_level_id +
                '}';
    }
}
