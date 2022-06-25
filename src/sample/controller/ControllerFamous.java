package sample.controller;

import sample.model.Famous;
import sample.wrapper.WrapperFamous;

import java.util.List;

public class ControllerFamous {

    public List<Famous> getAll() {
        return WrapperFamous.selectAll();
    }
}
