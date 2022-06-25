package sample.wrapper;

import sample.Util.DBUtil;
import sample.model.City;
import sample.model.Stadium;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WrapperCity {

    private static final String SQL_SELECT_CITY = "SELECT * FROM city WHERE id=?";

    public static City getCityById(Integer id) {
        City retValue = null;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            c = DBUtil.getConnection();
            Object[] values = {id};
            ps = DBUtil.prepareStatement(c, SQL_SELECT_CITY, false, values);
            rs = ps.executeQuery();

            if(rs.next()){
                retValue = new City(rs.getInt(1), rs.getString(2), rs.getInt(3));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.close(rs, ps, c);
        }
        return retValue;
    }
}
