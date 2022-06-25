package sample.model;

import java.util.Objects;

public class FirstTeam {
    private Integer idFirstTeam;
    private Integer match_id;
    private Integer player_id_for_ft;

    public FirstTeam() {
    }

    public FirstTeam(Integer idFirstTeam) {
        this.idFirstTeam = idFirstTeam;
    }

    public FirstTeam(Integer match_id, Integer player_id_for_ft) {
        this.match_id = match_id;
        this.player_id_for_ft = player_id_for_ft;
    }

    public FirstTeam(Integer idFirstTeam, Integer match_id, Integer player_id_for_ft) {
        this.idFirstTeam = idFirstTeam;
        this.match_id = match_id;
        this.player_id_for_ft = player_id_for_ft;
    }

    public Integer getIdFirstTeam() {
        return idFirstTeam;
    }

    public void setIdFirstTeam(Integer idFirstTeam) {
        this.idFirstTeam = idFirstTeam;
    }

    public Integer getMatch_id() {
        return match_id;
    }

    public void setMatch_id(Integer match_id) {
        this.match_id = match_id;
    }

    public Integer getPlayer_id_for_ft() {
        return player_id_for_ft;
    }

    public void setPlayer_id_for_ft(Integer player_id_for_ft) {
        this.player_id_for_ft = player_id_for_ft;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FirstTeam firstTeam = (FirstTeam) o;
        return Objects.equals(idFirstTeam, firstTeam.idFirstTeam);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFirstTeam);
    }

    @Override
    public String toString() {
        return "FirstTeam{" +
                "idFirstTeam=" + idFirstTeam +
                ", match_id=" + match_id +
                ", player_id_for_ft=" + player_id_for_ft +
                '}';
    }
}
