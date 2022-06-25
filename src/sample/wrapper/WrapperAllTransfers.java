package sample.wrapper;

import sample.Util.DBUtil;
import sample.model.AllDerby;
import sample.model.AllResults;
import sample.model.AllTransfers;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WrapperAllTransfers {

    private static final String SQL_SELECT_ALL = "SELECT * FROM ALL_TRANSFERS";

    public static List<AllTransfers> selectTransferBySeason(String season) {
        List<AllTransfers> retValue = new ArrayList<>();

        String query = "{ call SHOW_TRANSFERS_BY_SEASONE(?) }";
        Connection c = null;
//        Statement s = null;
        CallableStatement stmt = null;
        ResultSet rs = null;

        try {
            c = DBUtil.getConnection();
            stmt = c.prepareCall(query);
            stmt.setString(1 , season);
//            s = c.createStatement();
            rs = stmt.executeQuery();

            while(rs.next()) {
//                System.out.println(rs.getInt(1) + rs.getString(2)+ rs.getDate(3)+ rs.getString(4)+ rs.getString(5)+ rs.getString(6)+ rs.getBigDecimal(7));
                retValue.add(new AllTransfers(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getBigDecimal(7)));
            }

        }catch (SQLException e){
            System.out.println("Ovdje");
            e.printStackTrace();
        }finally {
//            DBUtil.close(rs, c);
            try {
                assert c != null;
                c.close();
                assert stmt != null;
                stmt.close();
                assert rs != null;
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }

        return retValue;
    }


    public static List<AllTransfers> selectAll() {
        List<AllTransfers> retValue = new ArrayList<>();
        Connection c = null;
        Statement s = null;
        ResultSet rs = null;

        try {
            c = DBUtil.getConnection();
            s = c.createStatement();
            rs = s.executeQuery(SQL_SELECT_ALL);

            while(rs.next()) {
                retValue.add(new AllTransfers(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getBigDecimal(7)));
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
