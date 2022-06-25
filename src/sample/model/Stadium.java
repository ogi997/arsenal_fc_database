package sample.model;

import java.sql.Date;
import java.util.Objects;

public class Stadium {
    private Integer idStadium;
    private String name;
    private Integer capacity;
    private Date date_built;
    private Integer length;
    private Integer width;

    public Stadium() {
    }

    public Stadium(Integer idStadium) {
        this.idStadium = idStadium;
    }

    public Stadium(String name, Integer capacity, Date date_built, Integer length, Integer width) {
        this.name = name;
        this.capacity = capacity;
        this.date_built = date_built;
        this.length = length;
        this.width = width;
    }

    public Stadium(Integer idStadium, String name, Integer capacity, Date date_built, Integer length, Integer width) {
        this.idStadium = idStadium;
        this.name = name;
        this.capacity = capacity;
        this.date_built = date_built;
        this.length = length;
        this.width = width;
    }

    public Integer getIdStadium() {
        return idStadium;
    }

    public void setIdStadium(Integer idStadium) {
        this.idStadium = idStadium;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Date getDate_built() {
        return date_built;
    }

    public void setDate_built(Date date_built) {
        this.date_built = date_built;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stadium stadium = (Stadium) o;
        return Objects.equals(idStadium, stadium.idStadium);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idStadium);
    }

    @Override
    public String toString() {
        return "Stadium{" +
                "idStadium=" + idStadium +
                ", name='" + name + '\'' +
                ", capacity=" + capacity +
                ", date_built=" + date_built +
                ", length=" + length +
                ", width=" + width +
                '}';
    }
}
