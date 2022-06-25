package sample.model;

import java.util.Objects;

public class FamousLevel {
    private Integer idFamousLevel;
    private String level;

    public FamousLevel() {
    }

    public FamousLevel(Integer idFamousLevel) {
        this.idFamousLevel = idFamousLevel;
    }

    public FamousLevel(String level) {
        this.level = level;
    }

    public FamousLevel(Integer idFamousLevel, String level) {
        this.idFamousLevel = idFamousLevel;
        this.level = level;
    }

    public Integer getIdFamousLevel() {
        return idFamousLevel;
    }

    public void setIdFamousLevel(Integer idFamousLevel) {
        this.idFamousLevel = idFamousLevel;
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
        FamousLevel that = (FamousLevel) o;
        return Objects.equals(idFamousLevel, that.idFamousLevel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFamousLevel);
    }

    @Override
    public String toString() {
        return "FamousLevel{" +
                "idFamousLevel=" + idFamousLevel +
                ", level='" + level + '\'' +
                '}';
    }
}
