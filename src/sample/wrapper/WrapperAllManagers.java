package sample.wrapper;

import sample.Util.DBUtil;
import sample.controller.ControllerManager;
import sample.model.AllDerby;
import sample.model.AllManagers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class WrapperAllManagers {

    private static final String SQL_SELECT_ALL = "SELECT * FROM ALL_MANAGERS";

    public static List<AllManagers> selectAll() {
        List<AllManagers> retValue = new ArrayList<>();
        ControllerManager cm = new ControllerManager();
        Connection c = null;
        Statement s = null;
        ResultSet rs = null;

        try {
            c = DBUtil.getConnection();
            s = c.createStatement();
            rs = s.executeQuery(SQL_SELECT_ALL);

            while(rs.next()) {
                Double winPercent = cm.getWinPercentByManagerId(rs.getInt(1));
                retValue.add(new AllManagers(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getString(4), rs.getString(5), winPercent));
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
