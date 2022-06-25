package sample.model;

import java.sql.Date;
import java.util.Objects;

public class Match {
    private Integer idMatch;
    private Integer rival_id;
    private Integer goals_scored;
    private Integer goals_received;
    private Integer seasone_id_for_match;
    private Integer game_id;
    private Date date;
    private Short home;

    public Match() {
    }

    public Match(Integer idMatch) {
        this.idMatch = idMatch;
    }

    public Match(Integer rival_id, Integer goals_scored, Integer goals_received, Integer seasone_id_for_match, Integer game_id, Date date, Short home) {
        this.rival_id = rival_id;
        this.goals_scored = goals_scored;
        this.goals_received = goals_received;
        this.seasone_id_for_match = seasone_id_for_match;
        this.game_id = game_id;
        this.date = date;
        this.home = home;
    }

    public Match(Integer idMatch, Integer rival_id, Integer goals_scored, Integer goals_received, Integer seasone_id_for_match, Integer game_id, Date date, Short home) {
        this.idMatch = idMatch;
        this.rival_id = rival_id;
        this.goals_scored = goals_scored;
        this.goals_received = goals_received;
        this.seasone_id_for_match = seasone_id_for_match;
        this.game_id = game_id;
        this.date = date;
        this.home = home;
    }

    public Integer getIdMatch() {
        return idMatch;
    }

    public void setIdMatch(Integer idMatch) {
        this.idMatch = idMatch;
    }

    public Integer getRival_id() {
        return rival_id;
    }

    public void setRival_id(Integer rival_id) {
        this.rival_id = rival_id;
    }

    public Integer getGoals_scored() {
        return goals_scored;
    }

    public void setGoals_scored(Integer goals_scored) {
        this.goals_scored = goals_scored;
    }

    public Integer getGoals_received() {
        return goals_received;
    }

    public void setGoals_received(Integer goals_received) {
        this.goals_received = goals_received;
    }

    public Integer getSeasone_id_for_match() {
        return seasone_id_for_match;
    }

    public void setSeasone_id_for_match(Integer seasone_id_for_match) {
        this.seasone_id_for_match = seasone_id_for_match;
    }

    public Integer getGame_id() {
        return game_id;
    }

    public void setGame_id(Integer game_id) {
        this.game_id = game_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Short getHome() {
        return home;
    }

    public void setHome(Short home) {
        this.home = home;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Match match = (Match) o;
        return Objects.equals(idMatch, match.idMatch);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMatch);
    }

    @Override
    public String toString() {
        return "Match{" +
                "idMatch=" + idMatch +
                ", rival_id=" + rival_id +
                ", goals_scored=" + goals_scored +
                ", goals_received=" + goals_received +
                ", seasone_id_for_match=" + seasone_id_for_match +
                ", game_id=" + game_id +
                ", date=" + date +
                ", home=" + home +
                '}';
    }
}
