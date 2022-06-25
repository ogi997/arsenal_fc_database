package sample.wrapper;

import sample.Util.DBUtil;
import sample.model.Stadium;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WrapperStadium {
    private static final String SQL_SELECT_STADIUM = "SELECT * FROM stadium WHERE id=?";

    public static Stadium getStadiumById(Integer id) {
        Stadium retValue = null;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
         c = DBUtil.getConnection();
         Object[] values = {id};
         ps = DBUtil.prepareStatement(c, SQL_SELECT_STADIUM, false, values);
         rs = ps.executeQuery();

         if(rs.next()){
             retValue = new Stadium(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDate(4), rs.getInt(5), rs.getInt(6));
         }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.close(rs, ps, c);
        }
        return retValue;
    }
}
