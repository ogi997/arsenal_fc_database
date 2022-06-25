package sample.controller;

import sample.model.DerbyLevel;
import sample.wrapper.WrapperDerbyLevel;

import java.util.List;

public class ControllerDerbyLevel {

    public List<DerbyLevel> getAll() {
        return WrapperDerbyLevel.selectAll();
    }
    public DerbyLevel getDerbyLevelById(Integer id) {
        return WrapperDerbyLevel.getDerbyLevelById(id);
    }
}
