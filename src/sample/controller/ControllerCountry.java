package sample.controller;

import sample.model.City;
import sample.model.Country;
import sample.wrapper.WrapperCity;
import sample.wrapper.WrapperCountry;

import java.sql.Wrapper;
import java.util.List;

public class ControllerCountry {

    public List<Country> getAll() {
        return WrapperCountry.selectAll();
    }
    public Country getCountryById(Integer id) {
        return WrapperCountry.getCountryById(id);
    }
    public Integer deleteCountryById(Integer id) {
        return WrapperCountry.deleteCountryById(id);
    }
    public Integer updateCountry(Country country) {
        return WrapperCountry.update(country);
    }
    public Integer insertCountry(Country country) {
        return WrapperCountry.insert(country);
    }
    public Country getIdOfVountry(String name) {
        return WrapperCountry.getIdCountry(name);
    }
}
