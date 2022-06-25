package sample.model;

import java.util.Objects;

public class Position {
    private Integer idPosition;
    private String description;

    public Position() {
    }

    public Position(String description) {
        this.description = description;
    }

    public Position(Integer idPosition, String description) {
        this.idPosition = idPosition;
        this.description = description;
    }

    public Integer getIdPosition() {
        return idPosition;
    }

    public void setIdPosition(Integer idPosition) {
        this.idPosition = idPosition;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return Objects.equals(idPosition, position.idPosition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPosition);
    }

    @Override
    public String toString() {
        return "Position{" +
                "idPosition=" + idPosition +
                ", description=" + description +
                '}';
    }
}
