package sample.controller;

import sample.model.AllManagers;
import sample.wrapper.WrapperAllManagers;

import java.util.List;

public class ControllerAllManagers {
    public List<AllManagers> getAll() {
        return WrapperAllManagers.selectAll();
    }
}
