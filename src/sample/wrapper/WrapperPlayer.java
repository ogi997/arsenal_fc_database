package sample.wrapper;

import sample.Util.DBUtil;
import sample.model.Manager;
import sample.model.Person;
import sample.model.Player;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WrapperPlayer {

    private static final String SQL_SELECT_ALL = "SELECT * FROM player";
    private static final String SQL_SELECT_MANAGER = "SELECT * FROM player WHERE person_id=?";
    private static final String SQL_DELETE_PLAYER = "DELETE FROM player WHERE person_id=?";
    private static final String SQL_INSERT = "INSERT INTO player (person_id, number, foot_id, position_id, player_role_id) VALUES (?, ?, ?, ?, ?)";

    private static final String SQL_UPDATE_ALL = "UPDATE player SET number=?, foot_id=?, position_id=?, player_role_id=? WHERE person_id=?";

    public static int update(Player player) {
        int retValue = 0;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            c = DBUtil.getConnection();
            Object[] values = {player.getNumber(), player.getFoot_id(), player.getPosition_id(), player.getPlayer_role_id(), player.getPerson_id()};
            ps = DBUtil.prepareStatement(c, SQL_UPDATE_ALL, false, values);
            retValue = ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.close(rs, ps, c);
        }
        return retValue;
    }

    public static int insert(Player player) {
        int retValue = 0;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            c = DBUtil.getConnection();
            Object[] values = {player.getPerson_id(), player.getNumber(), player.getFoot_id(), player.getPosition_id(), player.getPlayer_role_id()};
            ps = DBUtil.prepareStatement(c, SQL_INSERT, true, values);
            retValue = ps.executeUpdate();
            if(retValue != 0){
                rs = ps.getGeneratedKeys();
                if(rs.next())
                    player.setPerson_id(rs.getInt(1));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return  retValue;
    }

    public static int delete(Integer id) {
        int retValue = 0;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            c = DBUtil.getConnection();
            Object[] values = {id};
            ps = DBUtil.prepareStatement(c, SQL_DELETE_PLAYER, true, values);
            retValue = ps.executeUpdate();
            if(retValue != 0){
                rs = ps.getGeneratedKeys();
                if(rs.next())
                    retValue = 1;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return  retValue;
    }

    public static Player getPlayerById(Integer id) {
        Player retValue = null;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            c = DBUtil.getConnection();
            Object[] values = {id};
            ps = DBUtil.prepareStatement(c, SQL_SELECT_MANAGER, false, values);
            rs = ps.executeQuery();

            if(rs.next()){
                retValue = new Player(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.close(rs, ps, c);
        }
        return retValue;
    }

    public static List<Player> selectAll() {
        List<Player> retValue = new ArrayList<>();
        Connection c = null;
        Statement s = null;
        ResultSet rs = null;

        try {
            c = DBUtil.getConnection();
            s = c.createStatement();
            rs = s.executeQuery(SQL_SELECT_ALL);

            while(rs.next()) {
                retValue.add(new Player(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5)));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.close(rs, s, c);
        }
        return retValue;
    }
}
