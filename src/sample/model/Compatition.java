package sample.model;

import java.util.Objects;

public class Compatition {
    private Integer idCompatition;
    private String name;

    public Compatition() {
    }

    public Compatition(Integer idCompatition) {
        this.idCompatition = idCompatition;
    }

    public Compatition(String name) {
        this.name = name;
    }

    public Compatition(Integer idCompatition, String name) {
        this.idCompatition = idCompatition;
        this.name = name;
    }

    public Integer getIdCompatition() {
        return idCompatition;
    }

    public void setIdCompatition(Integer idCompatition) {
        this.idCompatition = idCompatition;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Compatition that = (Compatition) o;
        return Objects.equals(idCompatition, that.idCompatition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCompatition);
    }

    @Override
    public String toString() {
        return "Compatition{" +
                "idCompatition=" + idCompatition +
                ", name='" + name + '\'' +
                '}';
    }
}
