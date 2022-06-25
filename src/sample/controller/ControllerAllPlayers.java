package sample.controller;

import sample.model.AllPlayers;
import sample.wrapper.WrapperAllPlayers;

import java.util.List;

public class ControllerAllPlayers {

    public List<AllPlayers> getAll() {
        return WrapperAllPlayers.selectAll();
    }
}
