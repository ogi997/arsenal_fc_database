package sample.controller;

import sample.model.Match;
import sample.wrapper.WrapperMatch;

public class ControllerMatch {

    public Integer deleteMatch(Integer id) {
        return WrapperMatch.delete(id);
    }

    public Integer addMatch(Match match) {
        return WrapperMatch.insert(match);
    }
    public Match getMatchById(Integer id) {
        return WrapperMatch.getMatchById(id);
    }
    public Integer updateMatch(Match match) {
        return WrapperMatch.update(match);
    }
}
