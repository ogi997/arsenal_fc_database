package sample.wrapper;

import sample.Util.DBUtil;
import sample.model.Account;
import sample.model.FootballClub;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class WrapperFootballClub {
    private static final String SQL_SELECT_ALL = "SELECT * FROM football_club";

    public static FootballClub selectAll() {
        FootballClub fc = null;

        Connection c = null;
        Statement s = null;
        ResultSet rs = null;

        try {
            c = DBUtil.getConnection();
            s = c.createStatement();
            rs = s.executeQuery(SQL_SELECT_ALL);

            if(rs.next()) {
                fc = new FootballClub(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getDate(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9), rs.getDouble(10));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.close(rs, s, c);
        }

        return fc;
    }
}
