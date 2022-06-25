package sample.controller;

import sample.model.PlayerRole;
import sample.wrapper.WrapperPlayerRole;

import java.util.List;

public class ControllerPlayerRole {

    public PlayerRole getPlayerRoleById(Integer id) { return WrapperPlayerRole.getPlayerRoleById(id); }
    public List<PlayerRole> getAll() {
        return WrapperPlayerRole.selectAll();
    }
    public PlayerRole getIdByPlayerRole(String name) {
        return WrapperPlayerRole.getIdPlayerRole(name);
    }
}
