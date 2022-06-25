package sample.model;

import java.util.Objects;

public class Foot {
    private Integer idFoot;
    private String level;

    public Foot() {
    }

    public Foot(Integer idFoot) {
        this.idFoot = idFoot;
    }

    public Foot(String level) {
        this.level = level;
    }

    public Foot(Integer idFoot, String level) {
        this.idFoot = idFoot;
        this.level = level;
    }

    public Integer getIdFoot() {
        return idFoot;
    }

    public void setIdFoot(Integer idFoot) {
        this.idFoot = idFoot;
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
        Foot foot = (Foot) o;
        return Objects.equals(idFoot, foot.idFoot);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFoot);
    }

    @Override
    public String toString() {
        return "Foot{" +
                "idFoot=" + idFoot +
                ", level='" + level + '\'' +
                '}';
    }
}
