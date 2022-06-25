package sample.controller;

import sample.model.Rival;
import sample.wrapper.WrapperRival;

import java.util.List;

public class ControllerRival {

    public Rival getRivalById(Integer id) { return WrapperRival.selectRivalById(id); }
    public List<Rival> getAll() {
        return WrapperRival.selectAll();
    }
    public Integer getIdByRivalName(String name) {
        return WrapperRival.selectIdByName(name);
    }
}
