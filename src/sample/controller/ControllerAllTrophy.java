package sample.controller;

import sample.model.AllTrophy;
import sample.wrapper.WrapperAllTrophy;

import java.util.List;

public class ControllerAllTrophy {

    public List<AllTrophy> getAll() {
        return WrapperAllTrophy.selectAll();
    }
}
