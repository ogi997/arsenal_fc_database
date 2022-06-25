package sample.model;

import java.util.Objects;

public class Player {
    private Integer person_id;
    private Integer number;
    private Integer foot_id;
    private Integer position_id;
    private Integer player_role_id;

    public Player() {
    }

    public Player(Integer person_id) {
        this.person_id = person_id;
    }

    public Player(Integer number, Integer foot_id, Integer position_id, Integer player_role_id) {
        this.number = number;
        this.foot_id = foot_id;
        this.position_id = position_id;
        this.player_role_id = player_role_id;
    }

    public Player(Integer person_id, Integer number, Integer foot_id, Integer position_id, Integer player_role_id) {
        this.person_id = person_id;
        this.number = number;
        this.foot_id = foot_id;
        this.position_id = position_id;
        this.player_role_id = player_role_id;
    }

    public Integer getPerson_id() {
        return person_id;
    }

    public void setPerson_id(Integer person_id) {
        this.person_id = person_id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getFoot_id() {
        return foot_id;
    }

    public void setFoot_id(Integer foot_id) {
        this.foot_id = foot_id;
    }

    public Integer getPosition_id() {
        return position_id;
    }

    public void setPosition_id(Integer position_id) {
        this.position_id = position_id;
    }

    public Integer getPlayer_role_id() {
        return player_role_id;
    }

    public void setPlayer_role_id(Integer player_role_id) {
        this.player_role_id = player_role_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(person_id, player.person_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(person_id);
    }

    @Override
    public String toString() {
        return "Player{" +
                "person_id=" + person_id +
                ", number=" + number +
                ", foot_id=" + foot_id +
                ", position_id=" + position_id +
                ", player_role_id=" + player_role_id +
                '}';
    }
}
