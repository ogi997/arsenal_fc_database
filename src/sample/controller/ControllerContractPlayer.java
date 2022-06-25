package sample.controller;

import sample.model.ContractPlayer;
import sample.wrapper.WrapperContractPlayer;

import java.util.List;

public class ControllerContractPlayer {

    public List<ContractPlayer> getAll() { return WrapperContractPlayer.selectAll(); }
}
