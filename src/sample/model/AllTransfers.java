package sample.model;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

public class AllTransfers {
    private Integer id;
    private String name;
    private Date date_birth;
    private String description;
    private String year;
    private String club_name;
    private BigDecimal price;

    public AllTransfers(Integer id, String name, Date date_birth, String description, String year, String club_name, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.date_birth = date_birth;
        this.description = description;
        this.year = year;
        this.club_name = club_name;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate_birth() {
        return date_birth;
    }

    public void setDate_birth(Date date_birth) {
        this.date_birth = date_birth;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getClub_name() {
        return club_name;
    }

    public void setClub_name(String club_name) {
        this.club_name = club_name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AllTransfers that = (AllTransfers) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "AllTransfers{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date_birth=" + date_birth +
                ", description='" + description + '\'' +
                ", year='" + year + '\'' +
                ", club_name='" + club_name + '\'' +
                ", price=" + price +
                '}';
    }
}
