package sample.wrapper;

import sample.Util.DBUtil;
import sample.model.AllTrophy;
import sample.model.ManagerContract;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class WrapperManagerContract {

    private static final String SQL_SELECT_ALL = "SELECT * FROM MANAGERS_CONTRACT";

    public static List<ManagerContract> selectAll() {
        List<ManagerContract> retValue = new ArrayList<>();
        Connection c = null;
        Statement s = null;
        ResultSet rs = null;

        try {
            c = DBUtil.getConnection();
            s = c.createStatement();
            rs = s.executeQuery(SQL_SELECT_ALL);

            while(rs.next()) {
                retValue.add(new ManagerContract(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getDate(4), rs.getDate(5), rs.getBigDecimal(6), rs.getBigDecimal(7)));
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
