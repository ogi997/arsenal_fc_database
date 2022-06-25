package sample.controller;

import sample.model.TrophyCollection;
import sample.wrapper.WrapperTrophyCollection;

import java.util.List;

public class ControllerTrophyCollection {

    public List<TrophyCollection> getAll() {
        return WrapperTrophyCollection.selectAll();
    }
}
