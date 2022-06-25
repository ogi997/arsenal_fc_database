package sample.model;

import java.util.Objects;

public class Manager {
    private Integer person_id;
    private Integer league_wins;
    private Integer cup_wins;
    private Integer games_won;
    private Integer games_draw;
    private Integer games_lost;


    public Manager() {
    }

    public Manager(Integer person_id) {
        this.person_id = person_id;
    }

    public Manager(Integer league_wins, Integer cup_wins, Integer games_won, Integer games_draw, Integer games_lost) {
        this.league_wins = league_wins;
        this.cup_wins = cup_wins;
        this.games_won = games_won;
        this.games_draw = games_draw;
        this.games_lost = games_lost;
    }

    public Manager(Integer person_id, Integer league_wins, Integer cup_wins, Integer games_won, Integer games_draw, Integer games_lost) {
        this.person_id = person_id;
        this.league_wins = league_wins;
        this.cup_wins = cup_wins;
        this.games_won = games_won;
        this.games_draw = games_draw;
        this.games_lost = games_lost;
    }


    public Integer getPerson_id() {
        return person_id;
    }

    public void setPerson_id(Integer person_id) {
        this.person_id = person_id;
    }

    public Integer getLeague_wins() {
        return league_wins;
    }

    public void setLeague_wins(Integer league_wins) {
        this.league_wins = league_wins;
    }

    public Integer getCup_wins() {
        return cup_wins;
    }

    public void setCup_wins(Integer cup_wins) {
        this.cup_wins = cup_wins;
    }

    public Integer getGames_won() {
        return games_won;
    }

    public void setGames_won(Integer games_won) {
        this.games_won = games_won;
    }

    public Integer getGames_draw() {
        return games_draw;
    }

    public void setGames_draw(Integer games_draw) {
        this.games_draw = games_draw;
    }

    public Integer getGames_lost() {
        return games_lost;
    }

    public void setGames_lost(Integer games_lost) {
        this.games_lost = games_lost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manager manager = (Manager) o;
        return Objects.equals(person_id, manager.person_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(person_id);
    }

    @Override
    public String toString() {
        return "Manager{" +
                "person_id=" + person_id +
                ", league_wins=" + league_wins +
                ", cup_wins=" + cup_wins +
                ", games_won=" + games_won +
                ", games_draw=" + games_draw +
                ", games_lost=" + games_lost +
                '}';
    }
}
