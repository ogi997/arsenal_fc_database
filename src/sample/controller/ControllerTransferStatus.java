package sample.controller;

import sample.model.TransferStatus;
import sample.wrapper.WrapperTransferStatus;

public class ControllerTransferStatus {

    public TransferStatus getTransferStatusById(Integer id) {
        return WrapperTransferStatus.selectTransferStatusById(id);
    }
}
