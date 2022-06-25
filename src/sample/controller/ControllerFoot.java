package sample.controller;

import sample.model.Foot;
import sample.wrapper.WrapperFoot;

import java.util.List;

public class ControllerFoot {

    public Foot getFootById(Integer id) { return WrapperFoot.getFootById(id); }
    public List<Foot> getAll() {
        return WrapperFoot.selectAll();
    }
    public Foot getIdByFoot(String name) {
        return WrapperFoot.getIdFoot(name);
    }
}

