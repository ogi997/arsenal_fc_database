package sample.wrapper;

import sample.Util.DBUtil;
import sample.model.Foot;
import sample.model.Player;
import sample.model.PlayerRole;
import sample.model.Position;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WrapperPlayerRole {

    private static final String SQL_SELECT_PLAYER_ROLE = "SELECT * FROM player_role WHERE id=?";
    private static final String SQL_SELECT_ALL = "SELECT * FROM player_role";

    private static final String SQL_GET_ID = "SELECT * FROM player_role WHERE role=?";

    public static PlayerRole getIdPlayerRole(String name) {
        PlayerRole retValue = null;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            c = DBUtil.getConnection();
            Object[] values = {name};
            ps = DBUtil.prepareStatement(c, SQL_GET_ID, false, values);
            rs = ps.executeQuery();

            if(rs.next()){
                retValue = new PlayerRole(rs.getInt(1), rs.getString(2));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.close(rs, ps, c);
        }
        return retValue;
    }

    public static List<PlayerRole> selectAll() {
        List<PlayerRole> retValue = new ArrayList<>();
        Connection c = null;
        Statement s = null;
        ResultSet rs = null;

        try {
            c = DBUtil.getConnection();
            s = c.createStatement();
            rs = s.executeQuery(SQL_SELECT_ALL);

            while(rs.next()) {
                retValue.add(new PlayerRole(rs.getInt(1), rs.getString(2)));
            }

        }catch (SQLException e){
            System.out.println("Ovdje");
            e.printStackTrace();
        }finally {
            DBUtil.close(rs, s, c);
        }
        return retValue;
    }
    public static PlayerRole getPlayerRoleById(Integer id) {
        PlayerRole retValue = null;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            c = DBUtil.getConnection();
            Object[] values = {id};
            ps = DBUtil.prepareStatement(c, SQL_SELECT_PLAYER_ROLE, false, values);
            rs = ps.executeQuery();

            if(rs.next()){
                retValue = new PlayerRole(rs.getInt(1), rs.getString(2));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.close(rs, ps, c);
        }
        return retValue;
    }
}
