package sample.controller;

import sample.model.Contract;
import sample.wrapper.WrapperContract;

public class ControllerContract {

    public Contract getContractById(Integer id) { return WrapperContract.getContractById(id); }
}
