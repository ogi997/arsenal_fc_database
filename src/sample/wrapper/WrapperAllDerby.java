package sample.wrapper;

import sample.Util.DBUtil;
import sample.model.AllDerby;
import sample.model.AllResults;
import sample.model.Manager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WrapperAllDerby {

    private static final String SQL_SELECT_ALL = "SELECT * FROM ALL_DERBY";

    public static List<AllDerby> selectDerbyByDerbyLevel(String derbyLevel) {
        List<AllDerby> retValue = new ArrayList<>();

        String query = "{ call SHOW_SPECIFIC_DERBY(?) }";
        Connection c = null;
//        Statement s = null;
        CallableStatement stmt = null;
        ResultSet rs = null;

        try {
            c = DBUtil.getConnection();
            stmt = c.prepareCall(query);
            stmt.setString(1 , derbyLevel);
//            s = c.createStatement();
            rs = stmt.executeQuery();

            while(rs.next()) {
                retValue.add(new AllDerby(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getDate(6), rs.getInt(7), rs.getInt(8)));
            }

        }catch (SQLException e){
            System.out.println("Ovdje");
            e.printStackTrace();
        }finally {
//            DBUtil.close(rs, c);
            try {
                assert c != null;
                c.close();
                assert stmt != null;
                stmt.close();
                assert rs != null;
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }

        return retValue;
    }

    public static List<AllDerby> selectAll() {
        List<AllDerby> retValue = new ArrayList<>();
        Connection c = null;
        Statement s = null;
        ResultSet rs = null;

        try {
            c = DBUtil.getConnection();
            s = c.createStatement();
            rs = s.executeQuery(SQL_SELECT_ALL);

            while(rs.next()) {
                retValue.add(new AllDerby(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getDate(6), rs.getInt(7), rs.getInt(8)));
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
