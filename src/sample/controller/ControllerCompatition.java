package sample.controller;

import sample.model.Compatition;
import sample.wrapper.WrapperCompatition;

import java.util.List;

public class ControllerCompatition {

    public Compatition getCompatitionById(Integer id) {
        return WrapperCompatition.selectCompatitionById(id);
    }
    public List<Compatition> getAll() {
        return WrapperCompatition.selectAll();
    }
    public Integer getIdByName(String name) {
        return WrapperCompatition.selectIdByName(name);
    }
}
