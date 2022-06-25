package sample.wrapper;

import sample.Util.DBUtil;
import sample.model.Derby;
import sample.model.Rival;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class WrapperDerby {

    private static final String SQL_SELECT_ALL = "SELECT * FROM derby";

    public static List<Derby> selectAll() {
        List<Derby> retValue = new ArrayList<>();
        Connection c = null;
        Statement s = null;
        ResultSet rs = null;

        try {
            c = DBUtil.getConnection();
            s = c.createStatement();
            rs = s.executeQuery(SQL_SELECT_ALL);

            while(rs.next()) {
                retValue.add(new Derby(rs.getInt(1), rs.getInt(2), rs.getInt(3)));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.close(rs, s, c);
        }
        return retValue;
    }
}
