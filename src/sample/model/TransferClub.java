package sample.model;

import java.util.Objects;

public class TransferClub {
    private Integer idTransferClub;
    private String club_name;

    public TransferClub() {
    }

    public TransferClub(Integer idTransferClub) {
        this.idTransferClub = idTransferClub;
    }

    public TransferClub(String club_name) {
        this.club_name = club_name;
    }

    public TransferClub(Integer idTransferClub, String club_name) {
        this.idTransferClub = idTransferClub;
        this.club_name = club_name;
    }

    public Integer getIdTransferClub() {
        return idTransferClub;
    }

    public void setIdTransferClub(Integer idTransferClub) {
        this.idTransferClub = idTransferClub;
    }

    public String getClub_name() {
        return club_name;
    }

    public void setClub_name(String club_name) {
        this.club_name = club_name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransferClub that = (TransferClub) o;
        return Objects.equals(idTransferClub, that.idTransferClub);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTransferClub);
    }

    @Override
    public String toString() {
        return "TransferClub{" +
                "idTransferClub=" + idTransferClub +
                ", club_name='" + club_name + '\'' +
                '}';
    }
}
