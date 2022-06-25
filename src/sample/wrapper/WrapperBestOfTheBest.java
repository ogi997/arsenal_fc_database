package sample.wrapper;

import sample.Util.DBUtil;
import sample.model.AllTrophy;
import sample.model.BestOfTheBest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class WrapperBestOfTheBest {

    private static final String SQL_SELECT_ALL = "SELECT * FROM BEST_OF_THE_BEST";

    public static List<BestOfTheBest> selectAll() {
        List<BestOfTheBest> retValue = new ArrayList<>();
        Connection c = null;
        Statement s = null;
        ResultSet rs = null;

        try {
            c = DBUtil.getConnection();
            s = c.createStatement();
            rs = s.executeQuery(SQL_SELECT_ALL);

            while(rs.next()) {
                retValue.add(new BestOfTheBest(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getString(4), rs.getString(5)));
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
