package sample.model;

import java.sql.Date;
import java.util.Objects;

public class AllResults {
    private Integer id;
    private Integer goals_scored;
    private Integer goals_received;
    private Date date;
    private String RivalName;
    private String year;
    private String CompatitionName;
    private String home;

    public AllResults(Integer id, Integer goals_scored, Integer goals_received, Date date, String rivalName, String year, String compatitionName, String home) {
        this.id = id;
        this.goals_scored = goals_scored;
        this.goals_received = goals_received;
        this.date = date;
        this.RivalName = rivalName;
        this.year = year;
        this.CompatitionName = compatitionName;
        this.home = home;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getRivalName() {
        return RivalName;
    }

    public void setRivalName(String rivalName) {
        RivalName = rivalName;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getCompatitionName() {
        return CompatitionName;
    }

    public void setCompatitionName(String compatitionName) {
        CompatitionName = compatitionName;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AllResults that = (AllResults) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "AllResults{" +
                "id=" + id +
                ", goals_scored=" + goals_scored +
                ", goals_received=" + goals_received +
                ", date=" + date +
                ", RivalName='" + RivalName + '\'' +
                ", year='" + year + '\'' +
                ", CompatitionName='" + CompatitionName + '\'' +
                ", home=" + home +
                '}';
    }
}
