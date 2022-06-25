package sample.controller;

import sample.model.Position;
import sample.wrapper.WrapperPosition;

import java.util.List;

public class ControllerPosition {

    public Position getPositionById(Integer id) { return WrapperPosition.getPositionById(id); }
    public List<Position> getAll() {
        return WrapperPosition.selectAll();
    }
    public Position getIdByPosition(String name){
        return WrapperPosition.getIdPosition(name);
    }
}
