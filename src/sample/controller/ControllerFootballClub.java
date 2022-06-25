package sample.controller;

import sample.model.FootballClub;
import sample.wrapper.WrapperFootballClub;


public class ControllerFootballClub {

    public FootballClub getAll() {
        return WrapperFootballClub.selectAll();
    }
}
