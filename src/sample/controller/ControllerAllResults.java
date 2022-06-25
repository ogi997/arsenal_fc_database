package sample.controller;

import sample.model.AllResults;
import sample.model.ShowFirstTeam;
import sample.wrapper.WrapperAllResults;

import java.util.List;

public class ControllerAllResults {

    public List<AllResults> getAll() {
        return WrapperAllResults.selectAll();
    }
    public List<AllResults> getResultsBySeason(String year) {
        return WrapperAllResults.selectResultBySeason(year);
    }
    public List<ShowFirstTeam> getFirstTeamByMatchId(Integer id) {
        return WrapperAllResults.selectFirstTeamByMatchId(id);
    }
}
