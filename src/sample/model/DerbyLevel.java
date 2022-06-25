package sample.model;

import java.util.Objects;

public class DerbyLevel {
    private Integer idDerbyLevel;
    private String level;

    public DerbyLevel() {
    }

    public DerbyLevel(Integer idDerbyLevel) {
        this.idDerbyLevel = idDerbyLevel;
    }

    public DerbyLevel(String level) {
        this.level = level;
    }

    public DerbyLevel(Integer idDerbyLevel, String level) {
        this.idDerbyLevel = idDerbyLevel;
        this.level = level;
    }

    public Integer getIdDerbyLevel() {
        return idDerbyLevel;
    }

    public void setIdDerbyLevel(Integer idDerbyLevel) {
        this.idDerbyLevel = idDerbyLevel;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DerbyLevel that = (DerbyLevel) o;
        return Objects.equals(idDerbyLevel, that.idDerbyLevel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDerbyLevel);
    }

    @Override
    public String toString() {
        return "DerbyLevel{" +
                "idDerbyLevel=" + idDerbyLevel +
                ", level='" + level + '\'' +
                '}';
    }
}
