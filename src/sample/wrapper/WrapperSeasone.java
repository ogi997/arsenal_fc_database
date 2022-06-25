package sample.wrapper;

import sample.Util.DBUtil;
import sample.model.Player;
import sample.model.Rival;
import sample.model.Seasone;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WrapperSeasone {

    private static final String SQL_SELECT_ALL = "SELECT * FROM seasone";
    private static final String SQL_SELECT_SEASON = "SELECT * FROM seasone WHERE id=?";

    private static final String SQL_SELECT_ID = "SELECT * FROM seasone WHERE year=?";

    public static Integer selectIdByName(String year) {
        Integer retValue = null;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            c = DBUtil.getConnection();
            Object[] values = {year};
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

    public static List<Seasone> selectAll() {
        List<Seasone> retValue = new ArrayList<>();
        Connection c = null;
        Statement s = null;
        ResultSet rs = null;

        try {
            c = DBUtil.getConnection();
            s = c.createStatement();
            rs = s.executeQuery(SQL_SELECT_ALL);

            while(rs.next()) {
                retValue.add(new Seasone(rs.getInt(1), rs.getString(2)));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.close(rs, s, c);
        }
        return retValue;
    }

    public static Seasone selectSeasoneById(Integer id) {
        Seasone retValue = null;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            c = DBUtil.getConnection();
            Object[] values = {id};
            ps = DBUtil.prepareStatement(c, SQL_SELECT_SEASON, false, values);
            rs = ps.executeQuery();

            if(rs.next()){
                retValue = new Seasone(rs.getInt(1), rs.getString(2));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.close(rs, ps, c);
        }
        return retValue;
    }
}
