package sample.controller;

import sample.model.TransferHistory;
import sample.wrapper.WrapperTransferHistory;

import java.util.List;

public class ControllerTransferHistory {

    public List<TransferHistory> getAll() {
        return WrapperTransferHistory.selectAll();
    }
}
