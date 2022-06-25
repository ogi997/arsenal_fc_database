package sample.controller;

import sample.model.Contract;
import sample.model.ContractManager;
import sample.wrapper.WrapperContractManager;

import java.util.List;

public class ControllerContractManager {

    public List<ContractManager> getAll() { return WrapperContractManager.selectAll(); }
}
