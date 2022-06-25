package sample.wrapper;

import sample.Util.DBUtil;
import sample.model.FamousLevel;
import sample.model.Manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WrapperFamousLevel {
    private static final String SQL_SELECT_FAMOUS_LEVEL = "SELECT * FROM famous_level WHERE id=?";

    public static FamousLevel getFamousLevelById(Integer id) {
        FamousLevel retValue = null;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            c = DBUtil.getConnection();
            Object[] values = {id};
            ps = DBUtil.prepareStatement(c, SQL_SELECT_FAMOUS_LEVEL, false, values);
            rs = ps.executeQuery();

            if(rs.next()){
                retValue = new FamousLevel(rs.getInt(1), rs.getString(2));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.close(rs, ps, c);
        }
        return retValue;
    }
}
