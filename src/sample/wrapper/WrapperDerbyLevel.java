package sample.wrapper;

import sample.Util.DBUtil;
import sample.model.Country;
import sample.model.DerbyLevel;
import sample.model.Seasone;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WrapperDerbyLevel {
    private static final String SQL_SELECT_ALL = "SELECT * FROM derby_level";
    private static final String SQL_SELECT_DERBY_LEVEL = "SELECT * FROM derby_level WHERE id=?";

    public static List<DerbyLevel> selectAll() {
        List<DerbyLevel> retValue = new ArrayList<>();
        Connection c = null;
        Statement s = null;
        ResultSet rs = null;

        try {
            c = DBUtil.getConnection();
            s = c.createStatement();
            rs = s.executeQuery(SQL_SELECT_ALL);

            while(rs.next()) {
                retValue.add(new DerbyLevel(rs.getInt(1), rs.getString(2)));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.close(rs, s, c);
        }
        return retValue;
    }

    public static DerbyLevel getDerbyLevelById(Integer id) {
        DerbyLevel retValue = null;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            c = DBUtil.getConnection();
            Object[] values = {id};
            ps = DBUtil.prepareStatement(c, SQL_SELECT_DERBY_LEVEL, false, values);
            rs = ps.executeQuery();

            if(rs.next()){
                retValue = new DerbyLevel(rs.getInt(1), rs.getString(2));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.close(rs, ps, c);
        }
        return retValue;
    }
}
