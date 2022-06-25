package sample.model;

import java.util.Objects;

public class PlayerRole {
    private Integer idPlayerRole;
    private String role;

    public PlayerRole() {
    }

    public PlayerRole(Integer idPlayerRole) {
        this.idPlayerRole = idPlayerRole;
    }

    public PlayerRole(String role) {
        this.role = role;
    }

    public PlayerRole(Integer idPlayerRole, String role) {
        this.idPlayerRole = idPlayerRole;
        this.role = role;
    }

    public Integer getIdPlayerRole() {
        return idPlayerRole;
    }

    public void setIdPlayerRole(Integer idPlayerRole) {
        this.idPlayerRole = idPlayerRole;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerRole that = (PlayerRole) o;
        return Objects.equals(idPlayerRole, that.idPlayerRole);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPlayerRole);
    }

    @Override
    public String toString() {
        return "PlayerRole{" +
                "idPlayerRole=" + idPlayerRole +
                ", role='" + role + '\'' +
                '}';
    }
}
