package sample.wrapper;

import sample.Util.DBUtil;
import sample.model.Account;
import sample.model.AllDerby;
import sample.model.Manager;
import sample.model.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WrapperManager {

    private static final String SQL_SELECT_ALL = "SELECT * FROM manager";
    private static final String SQL_SELECT_MANAGER = "SELECT * FROM manager WHERE person_id=?";

    public static Double selectWinPercentByManagerId(Integer managerId) {
        Double retValue = null;

        String query = "{ call WIN_PROCENT_OF_MANAGER(?) }";
        Connection c = null;
//        Statement s = null;
        CallableStatement stmt = null;
        ResultSet rs = null;

        try {
            c = DBUtil.getConnection();
            stmt = c.prepareCall(query);
            stmt.setInt(1 , managerId);
//            s = c.createStatement();
            rs = stmt.executeQuery();

            while(rs.next()) {
                retValue = rs.getDouble(1);
                //retValue.add(new AllDerby(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getDate(6), rs.getInt(7), rs.getInt(8)));
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

    public static Manager getManagerById(Integer id) {
        Manager retValue = null;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            c = DBUtil.getConnection();
            Object[] values = {id};
            ps = DBUtil.prepareStatement(c, SQL_SELECT_MANAGER, false, values);
            rs = ps.executeQuery();

            if(rs.next()){
                retValue = new Manager(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getInt(6));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.close(rs, ps, c);
        }
        return retValue;
    }

    public static List<Manager> selectAll() {
        List<Manager> retValue = new ArrayList<>();
        Connection c = null;
        Statement s = null;
        ResultSet rs = null;

        try {
            c = DBUtil.getConnection();
            s = c.createStatement();
            rs = s.executeQuery(SQL_SELECT_ALL);

            while(rs.next()) {
                retValue.add(new Manager(rs.getInt(1),rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getInt(6)));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.close(rs, s, c);
        }
        return retValue;
    }
}
