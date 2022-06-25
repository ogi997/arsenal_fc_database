package sample.wrapper;

import sample.Util.DBUtil;
import sample.model.ManagerContract;
import sample.model.Player;
import sample.model.PlayerContract;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WrapperPlayerContract {
    private static final String SQL_SELECT_ALL = "SELECT * FROM PLAYERS_CONTRACT";
//    private static final String SQL_DELETE_PLAYER = "DELETE FROM contract_player WHERE player_id_for_contract=?";


    public static List<PlayerContract> selectAll() {
        List<PlayerContract> retValue = new ArrayList<>();
        Connection c = null;
        Statement s = null;
        ResultSet rs = null;

        try {
            c = DBUtil.getConnection();
            s = c.createStatement();
            rs = s.executeQuery(SQL_SELECT_ALL);

            while(rs.next()) {
                retValue.add(new PlayerContract(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getDate(4), rs.getDate(5), rs.getBigDecimal(6), rs.getBigDecimal(7)));
            }

        }catch (SQLException e){
            System.out.println("Ovdje");
            e.printStackTrace();
        }finally {
            DBUtil.close(rs, s, c);
        }
        return retValue;
    }
}
