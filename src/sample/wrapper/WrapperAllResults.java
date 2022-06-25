package sample.wrapper;

import sample.Util.DBUtil;
import sample.model.AllPlayers;
import sample.model.AllResults;
import sample.model.AllTransfers;
import sample.model.ShowFirstTeam;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WrapperAllResults {

    private static final String SQL_SELECT_ALL = "SELECT * FROM ALL_RESULTS";

    public static List<ShowFirstTeam> selectFirstTeamByMatchId(Integer id) {
        List<ShowFirstTeam> retValue = new ArrayList<>();

        String query = "{ call SHOW_FIRST_TEAM(?) }";
        Connection c = null;
//        Statement s = null;
        CallableStatement stmt = null;
        ResultSet rs = null;

        try {
            c = DBUtil.getConnection();
            stmt = c.prepareCall(query);
            stmt.setInt(1 , id);
//            s = c.createStatement();
            rs = stmt.executeQuery();

            while(rs.next()) {
                retValue.add(new ShowFirstTeam(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5)));
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

    public static List<AllResults> selectResultBySeason(String year) {
        List<AllResults> retValue = new ArrayList<>();

        String query = "{ call SHOW_RESULT_BY_SEASONE(?) }";
        Connection c = null;
//        Statement s = null;
        CallableStatement stmt = null;
        ResultSet rs = null;

        try {
            c = DBUtil.getConnection();
            stmt = c.prepareCall(query);
            stmt.setString(1 , year);
//            s = c.createStatement();
            rs = stmt.executeQuery();

            while(rs.next()) {
                retValue.add(new AllResults(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getShort(8) == 1 ? "Home" : "Away"));
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

    public static List<AllResults> selectAll() {
        List<AllResults> retValue = new ArrayList<>();
        Connection c = null;
        Statement s = null;
        ResultSet rs = null;

        try {
            c = DBUtil.getConnection();
            s = c.createStatement();
            rs = s.executeQuery(SQL_SELECT_ALL);

            while(rs.next()) {
                retValue.add(new AllResults(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getShort(8) == 1 ? "Home" : "Away"));
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
