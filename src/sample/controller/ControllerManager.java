package sample.controller;

import sample.model.Manager;
import sample.wrapper.WrapperManager;

import java.util.List;

public class ControllerManager {

    public List<Manager> getAll() { return WrapperManager.selectAll(); }
    public Manager getManagerById(Integer id) { return WrapperManager.getManagerById(id); }
    public Double getWinPercentByManagerId(Integer id) {
        return WrapperManager.selectWinPercentByManagerId(id);
    }
}
