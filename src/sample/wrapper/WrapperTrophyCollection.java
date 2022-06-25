package sample.wrapper;

import sample.Util.DBUtil;
import sample.model.Rival;
import sample.model.TrophyCollection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class WrapperTrophyCollection {

    private static final String SQL_SELECT_ALL = "SELECT * FROM trophy_collection";

    public static List<TrophyCollection> selectAll() {
        List<TrophyCollection> retValue = new ArrayList<>();
        Connection c = null;
        Statement s = null;
        ResultSet rs = null;

        try {
            c = DBUtil.getConnection();
            s = c.createStatement();
            rs = s.executeQuery(SQL_SELECT_ALL);

            while(rs.next()) {
                retValue.add(new TrophyCollection(rs.getInt(1), rs.getDate(2), rs.getInt(3), rs.getInt(4)));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.close(rs, s, c);
        }
        return retValue;
    }

}
