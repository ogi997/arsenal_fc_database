package sample.wrapper;

import sample.Util.DBUtil;
import sample.model.AllTrophy;
import sample.model.Famous;
import sample.model.FamousPersons;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class WrapperFamousPersons {
    private static final String SQL_SELECT_ALL = "SELECT * FROM FAMOUS_PERSONS";
    public static List<FamousPersons> selectAll() {
        List<FamousPersons> retValue = new ArrayList<>();
        Connection c = null;
        Statement s = null;
        ResultSet rs = null;

        try {
            c = DBUtil.getConnection();
            s = c.createStatement();
            rs = s.executeQuery(SQL_SELECT_ALL);

            while(rs.next()) {
                retValue.add(new FamousPersons(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getString(4), rs.getString(5), rs.getString(6)));
            }

        }catch (SQLException e){
            System.out.println("Ovdje");
            e.printStackTrace();
        }finally {
            DBUtil.close(rs, s, c);
        }
        return retValue;
    }
}
