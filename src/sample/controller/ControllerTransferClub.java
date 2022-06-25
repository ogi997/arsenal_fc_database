package sample.controller;

import sample.model.TransferClub;
import sample.wrapper.WrapperTransferClub;

public class ControllerTransferClub {

    public TransferClub getTransferClubById(Integer id) {
        return WrapperTransferClub.selectTransferClubById(id);
    }
}
