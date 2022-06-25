package sample.model;

import java.util.Objects;

public class TransferStatus {
    private Integer idTransferStatus;
    private String description;

    public TransferStatus() {
    }

    public TransferStatus(Integer idTransferStatus) {
        this.idTransferStatus = idTransferStatus;
    }

    public TransferStatus(String description) {
        this.description = description;
    }

    public TransferStatus(Integer idTransferStatus, String description) {
        this.idTransferStatus = idTransferStatus;
        this.description = description;
    }

    public Integer getIdTransferStatus() {
        return idTransferStatus;
    }

    public void setIdTransferStatus(Integer idTransferStatus) {
        this.idTransferStatus = idTransferStatus;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransferStatus that = (TransferStatus) o;
        return Objects.equals(idTransferStatus, that.idTransferStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTransferStatus);
    }

    @Override
    public String toString() {
        return "TransferStatus{" +
                "idTransferStatus=" + idTransferStatus +
                ", description='" + description + '\'' +
                '}';
    }
}
