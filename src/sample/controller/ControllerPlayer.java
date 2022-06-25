package sample.controller;

import sample.model.Player;
import sample.wrapper.WrapperPlayer;

import java.util.List;

public class ControllerPlayer {

    public List<Player> getAll() { return WrapperPlayer.selectAll(); }
    public Player getPlayerById(Integer id) {
        return WrapperPlayer.getPlayerById(id);
    }
    public Integer deletePlayer(Integer id) {
        return WrapperPlayer.delete(id);
    }
    public Integer insertPlayer(Player player) {
        return WrapperPlayer.insert(player);
    }
    public Integer updatePlayer(Player player) {
        return WrapperPlayer.update(player);
    }
}
