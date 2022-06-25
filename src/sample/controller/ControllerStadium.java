package sample.controller;

import sample.model.Stadium;
import sample.wrapper.WrapperStadium;

public class ControllerStadium {

    public Stadium getStadiumById(Integer id) {
        return WrapperStadium.getStadiumById(id);
    }
}
