package sample.controller;

import sample.model.FamousLevel;
import sample.wrapper.WrapperFamousLevel;

public class ControllerFamousLevel {

    public FamousLevel getFamousLevelById(Integer id) {
        return WrapperFamousLevel.getFamousLevelById(id);
    }
}
