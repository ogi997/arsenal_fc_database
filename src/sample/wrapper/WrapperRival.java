package sample.wrapper;

import sample.Util.DBUtil;
import sample.model.Account;
import sample.model.Country;
import sample.model.Rival;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WrapperRival {

    private static final String SQL_SELECT_ALL = "SELECT * FROM rival";
    private static final String SQL_SELECT_RIVAL = "SELECT * FROM rival WHERE id=?";

    private static final String SQL_SELECT_ID = "SELECT * FROM rival WHERE name=?";

    public static Integer selectIdByName(String name) {
        Integer retValue = null;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            c = DBUtil.getConnection();
            Object[] values = {name};
            ps = DBUtil.prepareStatement(c, SQL_SELECT_ID, false, values);
            rs = ps.executeQuery();

            if(rs.next()){
                retValue = rs.getInt(1);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.close(rs, ps, c);
        }
        return retValue;
    }

    public static Rival selectRivalById(Integer id) {
        Rival retValue = null;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            c = DBUtil.getConnection();
            Object[] values = {id};
            ps = DBUtil.prepareStatement(c, SQL_SELECT_RIVAL, false, values);
            rs = ps.executeQuery();

            if(rs.next()){
                retValue = new Rival(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.close(rs, ps, c);
        }
        return retValue;
    }


    public static List<Rival> selectAll() {
        List<Rival> retValue = new ArrayList<>();
        Connection c = null;
        Statement s = null;
        ResultSet rs = null;

        try {
            c = DBUtil.getConnection();
            s = c.createStatement();
            rs = s.executeQuery(SQL_SELECT_ALL);

            while(rs.next()) {
                retValue.add(new Rival(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4)));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.close(rs, s, c);
        }
        return retValue;
    }
}
