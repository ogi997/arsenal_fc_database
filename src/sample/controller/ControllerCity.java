package sample.controller;

import sample.model.City;
import sample.wrapper.WrapperCity;


public class ControllerCity {

    public City getCityById(Integer id) {
        return WrapperCity.getCityById(id);
    }
}
