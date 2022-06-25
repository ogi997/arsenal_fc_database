package sample.controller;

import sample.model.Derby;
import sample.wrapper.WrapperDerby;

import java.util.List;

public class ControllerDerby {

    public List<Derby> getAll() { return WrapperDerby.selectAll(); }
}
