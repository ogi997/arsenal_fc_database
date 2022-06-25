package sample.controller;

import sample.model.Match;
import sample.wrapper.WrapperFirstTeam;

public class ControllerFirstTeam {

    public Integer deleteFirstTeam(Integer id) {
        return WrapperFirstTeam.delete(id);
    }
    public Integer addFirstTeam(Match match) {
        return WrapperFirstTeam.insert(match);
    }
}
