package sample.controller;

import sample.model.FamousPersons;
import sample.wrapper.WrapperFamousPersons;

import java.util.List;

public class ControllerFamousPersons {

    public List<FamousPersons> getAll() {
        return WrapperFamousPersons.selectAll();
    }
}
