package sample.controller;

import sample.model.AllDerby;
import sample.wrapper.WrapperAllDerby;

import java.util.List;

public class ControllerAllDerby {

    public List<AllDerby> getAll() {
        return WrapperAllDerby.selectAll();
    }
    public List<AllDerby> getDerbyByDerbyLevel(String derbyLevel) {
        return WrapperAllDerby.selectDerbyByDerbyLevel(derbyLevel);
    }
}
