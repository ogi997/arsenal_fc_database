package sample.model;

import java.sql.Date;
import java.util.Objects;

public class TrophyCollection {
    private Integer idTrophyCollection;
    private Date date;
    private Integer seasone_id_for_trophy;
    private Integer compatition_id;

    public TrophyCollection() {
    }

    public TrophyCollection(Integer idTrophyCollection) {
        this.idTrophyCollection = idTrophyCollection;
    }

    public TrophyCollection(Date date, Integer seasone_id_for_trophy, Integer compatition_id) {
        this.date = date;
        this.seasone_id_for_trophy = seasone_id_for_trophy;
        this.compatition_id = compatition_id;
    }

    public TrophyCollection(Integer idTrophyCollection, Date date, Integer seasone_id_for_trophy, Integer compatition_id) {
        this.idTrophyCollection = idTrophyCollection;
        this.date = date;
        this.seasone_id_for_trophy = seasone_id_for_trophy;
        this.compatition_id = compatition_id;
    }

    public Integer getIdTrophyCollection() {
        return idTrophyCollection;
    }

    public void setIdTrophyCollection(Integer idTrophyCollection) {
        this.idTrophyCollection = idTrophyCollection;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getSeasone_id_for_trophy() {
        return seasone_id_for_trophy;
    }

    public void setSeasone_id_for_trophy(Integer seasone_id_for_trophy) {
        this.seasone_id_for_trophy = seasone_id_for_trophy;
    }

    public Integer getCompatition_id() {
        return compatition_id;
    }

    public void setCompatition_id(Integer compatition_id) {
        this.compatition_id = compatition_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrophyCollection that = (TrophyCollection) o;
        return Objects.equals(idTrophyCollection, that.idTrophyCollection);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTrophyCollection);
    }

    @Override
    public String toString() {
        return "TrophyCollection{" +
                "idTrophyCollection=" + idTrophyCollection +
                ", date=" + date +
                ", seasone_id_for_trophy=" + seasone_id_for_trophy +
                ", compatition_id=" + compatition_id +
                '}';
    }
}
