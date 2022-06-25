package sample.wrapper;

import sample.Util.DBUtil;
import sample.model.AllTransfers;
import sample.model.AllTrophy;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class WrapperAllTrophy {

    private static final String SQL_SELECT_ALL = "SELECT * FROM ALL_TROPHY";

    public static List<AllTrophy> selectAll() {
        List<AllTrophy> retValue = new ArrayList<>();
        Connection c = null;
        Statement s = null;
        ResultSet rs = null;

        try {
            c = DBUtil.getConnection();
            s = c.createStatement();
            rs = s.executeQuery(SQL_SELECT_ALL);

            while(rs.next()) {
                retValue.add(new AllTrophy(rs.getInt(1), rs.getString(2), rs.getString(3)));
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
