package sample.controller;

import sample.model.Seasone;
import sample.wrapper.WrapperSeasone;

import java.util.List;

public class ControllerSeasone {

    public List<Seasone> getAll() {
        return WrapperSeasone.selectAll();
    }
    public Seasone getSeasoneById(Integer id) {
        return WrapperSeasone.selectSeasoneById(id);
    }
    public Integer getIdBySeason(String year) {
        return WrapperSeasone.selectIdByName(year);
    }
}
