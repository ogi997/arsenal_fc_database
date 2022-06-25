package sample.wrapper;

import sample.Util.DBUtil;
import sample.model.AllResults;
import sample.model.Country;
import sample.model.Foot;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WrapperFoot {

    private static final String SQL_SELECT_FOOT = "SELECT * FROM foot WHERE id=?";
    private static final String SQL_SELECT_ALL = "SELECT * FROM foot";

    private static final String SQL_GET_ID = "SELECT * FROM foot WHERE description=?";

    public static Foot getIdFoot(String name) {
        Foot retValue = null;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            c = DBUtil.getConnection();
            Object[] values = {name};
            ps = DBUtil.prepareStatement(c, SQL_GET_ID, false, values);
            rs = ps.executeQuery();

            if(rs.next()){
                retValue = new Foot(rs.getInt(1), rs.getString(2));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.close(rs, ps, c);
        }
        return retValue;
    }

    public static List<Foot> selectAll() {
        List<Foot> retValue = new ArrayList<>();
        Connection c = null;
        Statement s = null;
        ResultSet rs = null;

        try {
            c = DBUtil.getConnection();
            s = c.createStatement();
            rs = s.executeQuery(SQL_SELECT_ALL);

            while(rs.next()) {
                retValue.add(new Foot(rs.getInt(1), rs.getString(2)));
            }

        }catch (SQLException e){
            System.out.println("Ovdje");
            e.printStackTrace();
        }finally {
            DBUtil.close(rs, s, c);
        }
        return retValue;
    }

    public static Foot getFootById(Integer id) {
        Foot retValue = null;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            c = DBUtil.getConnection();
            Object[] values = {id};
            ps = DBUtil.prepareStatement(c, SQL_SELECT_FOOT, false, values);
            rs = ps.executeQuery();

            if(rs.next()){
                retValue = new Foot(rs.getInt(1), rs.getString(2));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.close(rs, ps, c);
        }
        return retValue;
    }
}
