package sample.model;

import java.sql.Date;
import java.util.Objects;

public class FootballClub {
    private Integer idFootballClub;
    private Integer stadium_id_for_fc;
    private String address;
    private String contract;
    private Date founded;
    private String owner;
    private String name;
    private String nick_name;
    private Integer city_id_for_fc;
    private Double value;

    public FootballClub() {
    }

    public FootballClub(Integer idFootballClub) {
        this.idFootballClub = idFootballClub;
    }

    public FootballClub(Integer stadium_id_for_fc, String address, String contract, Date founded, String owner, String name, String nick_name, Integer city_id_for_fc, Double value) {
        this.stadium_id_for_fc = stadium_id_for_fc;
        this.address = address;
        this.contract = contract;
        this.founded = founded;
        this.owner = owner;
        this.name = name;
        this.nick_name = nick_name;
        this.city_id_for_fc = city_id_for_fc;
        this.value = value;
    }

    public FootballClub(Integer idFootballClub, Integer stadium_id_for_fc, String address, String contract, Date founded, String owner, String name, String nick_name, Integer city_id_for_fc, Double value) {
        this.idFootballClub = idFootballClub;
        this.stadium_id_for_fc = stadium_id_for_fc;
        this.address = address;
        this.contract = contract;
        this.founded = founded;
        this.owner = owner;
        this.name = name;
        this.nick_name = nick_name;
        this.city_id_for_fc = city_id_for_fc;
        this.value = value;
    }

    public Integer getIdFootballClub() {
        return idFootballClub;
    }

    public void setIdFootballClub(Integer idFootballClub) {
        this.idFootballClub = idFootballClub;
    }

    public Integer getStadium_id_for_fc() {
        return stadium_id_for_fc;
    }

    public void setStadium_id_for_fc(Integer stadium_id_for_fc) {
        this.stadium_id_for_fc = stadium_id_for_fc;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }

    public Date getFounded() {
        return founded;
    }

    public void setFounded(Date founded) {
        this.founded = founded;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNick_name() {
        return nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
    }

    public Integer getCity_id_for_fc() {
        return city_id_for_fc;
    }

    public void setCity_id_for_fc(Integer city_id_for_fc) {
        this.city_id_for_fc = city_id_for_fc;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FootballClub that = (FootballClub) o;
        return Objects.equals(idFootballClub, that.idFootballClub);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFootballClub);
    }

    @Override
    public String toString() {
        return "FootballClub{" +
                "idFootballClub=" + idFootballClub +
                ", stadium_id_for_fc=" + stadium_id_for_fc +
                ", address='" + address + '\'' +
                ", contract='" + contract + '\'' +
                ", founded=" + founded +
                ", owner='" + owner + '\'' +
                ", name='" + name + '\'' +
                ", nick_name='" + nick_name + '\'' +
                ", city_id_for_fc=" + city_id_for_fc +
                ", value=" + value +
                '}';
    }
}
