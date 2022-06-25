package sample.model;

import java.util.Objects;

public class TransferHistory {
    private Integer idTransferHistory;
    private Integer player_id;
    private Integer transfer_status_id;
    private Double price;
    private Integer seasone_id;
    private Integer transfer_club_id;

    public TransferHistory() {
    }

    public TransferHistory(Integer player_id) {
        this.player_id = player_id;
    }

    public TransferHistory(Integer player_id, Integer transfer_status_id, Double price, Integer seasone_id, Integer transfer_club_id) {
        this.player_id = player_id;
        this.transfer_status_id = transfer_status_id;
        this.price = price;
        this.seasone_id = seasone_id;
        this.transfer_club_id = transfer_club_id;
    }

    public TransferHistory(Integer idTransferHistory, Integer player_id, Integer transfer_status_id, Double price, Integer seasone_id, Integer transfer_club_id) {
        this.idTransferHistory = idTransferHistory;
        this.player_id = player_id;
        this.transfer_status_id = transfer_status_id;
        this.price = price;
        this.seasone_id = seasone_id;
        this.transfer_club_id = transfer_club_id;
    }

    public Integer getIdTransferHistory() {
        return idTransferHistory;
    }

    public void setIdTransferHistory(Integer idTransferHistory) {
        this.idTransferHistory = idTransferHistory;
    }

    public Integer getPlayer_id() {
        return player_id;
    }

    public void setPlayer_id(Integer player_id) {
        this.player_id = player_id;
    }

    public Integer getTransfer_status_id() {
        return transfer_status_id;
    }

    public void setTransfer_status_id(Integer transfer_status_id) {
        this.transfer_status_id = transfer_status_id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getSeasone_id() {
        return seasone_id;
    }

    public void setSeasone_id(Integer seasone_id) {
        this.seasone_id = seasone_id;
    }

    public Integer getTransfer_club_id() {
        return transfer_club_id;
    }

    public void setTransfer_club_id(Integer transfer_club_id) {
        this.transfer_club_id = transfer_club_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransferHistory that = (TransferHistory) o;
        return Objects.equals(idTransferHistory, that.idTransferHistory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTransferHistory);
    }

    @Override
    public String toString() {
        return "TransferHistory{" +
                "idTransferHistory=" + idTransferHistory +
                ", player_id=" + player_id +
                ", transfer_status_id=" + transfer_status_id +
                ", price=" + price +
                ", seasone_id=" + seasone_id +
                ", transfer_club_id=" + transfer_club_id +
                '}';
    }
}
