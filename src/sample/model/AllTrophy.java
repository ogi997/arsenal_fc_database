package sample.model;

import java.util.Objects;

public class AllTrophy {
    private Integer id;
    private String year;
    private String name;

    public AllTrophy(Integer id, String year, String name) {
        this.id = id;
        this.year = year;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
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
        AllTrophy allTrophy = (AllTrophy) o;
        return Objects.equals(id, allTrophy.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "AllTrophy{" +
                "id=" + id +
                ", year='" + year + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
