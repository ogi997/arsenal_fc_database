package sample.controller;

import sample.model.Person;
import sample.wrapper.WrapperPerson;

import java.util.List;

public class ControllerPerson {

    public List<Person> getAll() { return WrapperPerson.selectAll(); }
    public Person getPersonById(Integer id) { return WrapperPerson.getPersonById(id); }
    public Integer deletePerson(Integer id) {
        return WrapperPerson.delete(id);
    }
    public Integer insertPerson(Person person) {
        return WrapperPerson.insert(person);
    }
    public Integer updatePerson(Person person) {
        return WrapperPerson.update(person);
    }

}
