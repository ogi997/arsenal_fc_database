package sample.wrapper;

import sample.Util.DBUtil;
import sample.model.Foot;
import sample.model.Position;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WrapperPosition {

    private static final String SQL_SELECT_POSITION = "SELECT * FROM position WHERE id=?";
    private static final String SQL_SELECT_ALL = "SELECT * FROM position";

    private static final String SQL_GET_ID = "SELECT * FROM position WHERE description=?";

    public static Position getIdPosition(String name) {
        Position retValue = null;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            c = DBUtil.getConnection();
            Object[] values = {name};
            ps = DBUtil.prepareStatement(c, SQL_GET_ID, false, values);
            rs = ps.executeQuery();

            if(rs.next()){
                retValue = new Position(rs.getInt(1), rs.getString(2));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.close(rs, ps, c);
        }
        return retValue;
    }

    public static List<Position> selectAll() {
        List<Position> retValue = new ArrayList<>();
        Connection c = null;
        Statement s = null;
        ResultSet rs = null;

        try {
            c = DBUtil.getConnection();
            s = c.createStatement();
            rs = s.executeQuery(SQL_SELECT_ALL);

            while(rs.next()) {
                retValue.add(new Position(rs.getInt(1), rs.getString(2)));
            }

        }catch (SQLException e){
            System.out.println("Ovdje");
            e.printStackTrace();
        }finally {
            DBUtil.close(rs, s, c);
        }
        return retValue;
    }


    public static Position getPositionById(Integer id) {
        Position retValue = null;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            c = DBUtil.getConnection();
            Object[] values = {id};
            ps = DBUtil.prepareStatement(c, SQL_SELECT_POSITION, false, values);
            rs = ps.executeQuery();

            if(rs.next()){
                retValue = new Position(rs.getInt(1), rs.getString(2));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.close(rs, ps, c);
        }
        return retValue;
    }
}
