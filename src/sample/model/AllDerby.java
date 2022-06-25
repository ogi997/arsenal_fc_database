package sample.model;

import java.sql.Date;
import java.util.Objects;

public class AllDerby {
    private Integer id;
    private String RivalName;
    private String level;
    private String StadiumName;
    private Integer Capacity;
    private Date date_built;
    private Integer length;
    private Integer width;

    public AllDerby(Integer id, String rivalName, String level, String stadiumName, Integer capacity, Date date_built, Integer length, Integer width) {
        this.id = id;
       this.RivalName = rivalName;
        this.level = level;
        this.StadiumName = stadiumName;
        this.Capacity = capacity;
        this.date_built = date_built;
        this.length = length;
        this.width = width;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCapacity() {
        return Capacity;
    }

    public void setCapacity(Integer capacity) {
        Capacity = capacity;
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

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getStadiumName() {
        return StadiumName;
    }

    public void setStadiumName(String stadiumName) {
        StadiumName = stadiumName;
    }

    public String getRivalName() {
        return RivalName;
    }

    public void setRivalName(String rivalName) {
        RivalName = rivalName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AllDerby allDerby = (AllDerby) o;
        return Objects.equals(id, allDerby.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "AllDerby{" +
                "id=" + id +
                ", Capacity=" + Capacity +
                ", date_built=" + date_built +
                ", length=" + length +
                ", width=" + width +
                ", level='" + level + '\'' +
                ", StadiumName='" + StadiumName + '\'' +
                ", RivalName='" + RivalName + '\'' +
                '}';
    }
}
