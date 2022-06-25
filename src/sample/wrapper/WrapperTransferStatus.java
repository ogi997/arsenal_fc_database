package sample.wrapper;

import sample.Util.DBUtil;
import sample.model.TransferClub;
import sample.model.TransferStatus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WrapperTransferStatus {

    private static final String SQL_SELECT_TRANSFER_STATUS = "SELECT * FROM transfer_status WHERE id=?";

    public static TransferStatus selectTransferStatusById(Integer id) {
        TransferStatus retValue = null;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            c = DBUtil.getConnection();
            Object[] values = {id};
            ps = DBUtil.prepareStatement(c, SQL_SELECT_TRANSFER_STATUS, false, values);
            rs = ps.executeQuery();

            if(rs.next()){
                retValue = new TransferStatus(rs.getInt(1), rs.getString(2));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.close(rs, ps, c);
        }
        return retValue;
    }
}
