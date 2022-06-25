package sample.controller;

import sample.model.ManagerContract;
import sample.wrapper.WrapperManagerContract;

import java.util.List;

public class ControllerManagerContract {
    public List<ManagerContract> getAll() {
        return WrapperManagerContract.selectAll();
    }
}
