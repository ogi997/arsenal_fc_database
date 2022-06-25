package sample.wrapper;

import sample.Util.DBUtil;
import sample.model.Rival;
import sample.model.TransferHistory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class WrapperTransferHistory {

    private static final String SQL_SELECT_ALL = "SELECT * FROM transfer_history";

    public static List<TransferHistory> selectAll() {
        List<TransferHistory> retValue = new ArrayList<>();
        Connection c = null;
        Statement s = null;
        ResultSet rs = null;

        try {
            c = DBUtil.getConnection();
            s = c.createStatement();
            rs = s.executeQuery(SQL_SELECT_ALL);

            while(rs.next()) {
                retValue.add(new TransferHistory(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDouble(4), rs.getInt(5), rs.getInt(6)));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.close(rs, s, c);
        }
        return retValue;
    }
}
