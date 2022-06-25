package sample.controller;

import sample.model.PlayerContract;
import sample.wrapper.WrapperPlayerContract;

import java.util.List;

public class ControllerPlayerContract {
    public List<PlayerContract> getAll() {
        return WrapperPlayerContract.selectAll();
    }

}
