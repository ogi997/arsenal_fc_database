package sample.wrapper;

import sample.Util.DBUtil;
import sample.model.Famous;
import sample.model.Manager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class WrapperFamous {
    private static final String SQL_SELECT_ALL = "SELECT * FROM famous";

    public static List<Famous> selectAll() {
        List<Famous> retValue = new ArrayList<>();
        Connection c = null;
        Statement s = null;
        ResultSet rs = null;

        try {
            c = DBUtil.getConnection();
            s = c.createStatement();
            rs = s.executeQuery(SQL_SELECT_ALL);

            while(rs.next()) {
                retValue.add(new Famous(rs.getInt(1), rs.getInt(2), rs.getInt(3)));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.close(rs, s, c);
        }
        return retValue;
    }
}
