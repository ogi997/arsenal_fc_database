package sample.controller;

import sample.model.BestOfTheBest;
import sample.wrapper.WrapperBestOfTheBest;

import java.util.List;

public class ControllerBestOfTheBest {

    public List<BestOfTheBest> getAll() {
        return WrapperBestOfTheBest.selectAll();
    }
}
