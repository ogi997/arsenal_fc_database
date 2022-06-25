package sample.wrapper;

import sample.Util.DBUtil;
import sample.model.Compatition;
import sample.model.Rival;
import sample.model.Seasone;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WrapperCompatition {

    private static final String SQL_SELECT_COMPATITION = "SELECT * FROM compatition WHERE id=?";
    private static final String SQL_SELECT_ALL = "SELECT * FROM compatition";

    private static final String SQL_SELECT_ID = "SELECT * FROM compatition WHERE name=?";

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

    public static List<Compatition> selectAll() {
        List<Compatition> retValue = new ArrayList<>();
        Connection c = null;
        Statement s = null;
        ResultSet rs = null;

        try {
            c = DBUtil.getConnection();
            s = c.createStatement();
            rs = s.executeQuery(SQL_SELECT_ALL);

            while(rs.next()) {
                retValue.add(new Compatition(rs.getInt(1), rs.getString(2)));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.close(rs, s, c);
        }
        return retValue;
    }

    public static Compatition selectCompatitionById(Integer id) {
        Compatition retValue = null;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            c = DBUtil.getConnection();
            Object[] values = {id};
            ps = DBUtil.prepareStatement(c, SQL_SELECT_COMPATITION, false, values);
            rs = ps.executeQuery();

            if(rs.next()){
                retValue = new Compatition(rs.getInt(1), rs.getString(2));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.close(rs, ps, c);
        }
        return retValue;
    }
}
