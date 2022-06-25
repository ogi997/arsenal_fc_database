package sample.model;

import java.util.Objects;

public class Seasone {
    private Integer idSeasone;
    private String year;

    public Seasone() {
    }

    public Seasone(Integer idSeasone) {
        this.idSeasone = idSeasone;
    }

    public Seasone(String year) {
        this.year = year;
    }

    public Seasone(Integer idSeasone, String year) {
        this.idSeasone = idSeasone;
        this.year = year;
    }

    public Integer getIdSeasone() {
        return idSeasone;
    }

    public void setIdSeasone(Integer idSeasone) {
        this.idSeasone = idSeasone;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seasone seasone = (Seasone) o;
        return Objects.equals(idSeasone, seasone.idSeasone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSeasone);
    }

    @Override
    public String toString() {
        return "Seasone{" +
                "idSeasone=" + idSeasone +
                ", year='" + year + '\'' +
                '}';
    }
}
