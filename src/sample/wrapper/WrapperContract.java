package sample.wrapper;

import sample.Util.DBUtil;
import sample.model.Contract;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WrapperContract {
    private static final String SQL_SELECT_ALL = "SELECT * FROM contract WHERE id=?";

    public static Contract getContractById(Integer id) {
        Contract retValue = null;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            c = DBUtil.getConnection();
            Object[] values = {id};
            ps = DBUtil.prepareStatement(c, SQL_SELECT_ALL, false, values);
            rs = ps.executeQuery();

            if(rs.next()){
                retValue = new Contract(rs.getInt(1), rs.getDate(2), rs.getDate(3), rs.getDouble(4), rs.getDouble(5));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.close(rs, ps, c);
        }
        return retValue;
    }
}
