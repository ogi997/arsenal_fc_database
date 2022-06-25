package sample.controller;

import sample.model.AllTransfers;
import sample.wrapper.WrapperAllTransfers;

import java.util.List;

public class ControllerAllTransfers {

    public List<AllTransfers> getAll() {
        return WrapperAllTransfers.selectAll();
    }
    public List<AllTransfers> getTransferBySeason(String season) {
        return WrapperAllTransfers.selectTransferBySeason(season);
    }
}
