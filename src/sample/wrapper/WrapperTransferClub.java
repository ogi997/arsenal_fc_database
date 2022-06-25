package sample.wrapper;

import sample.Util.DBUtil;
import sample.model.Rival;
import sample.model.TransferClub;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WrapperTransferClub {

    private static final String SQL_SELECT_TRANSFER_CLUB = "SELECT * FROM transfer_club WHERE id=?";

    public static TransferClub selectTransferClubById(Integer id) {
        TransferClub retValue = null;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            c = DBUtil.getConnection();
            Object[] values = {id};
            ps = DBUtil.prepareStatement(c, SQL_SELECT_TRANSFER_CLUB, false, values);
            rs = ps.executeQuery();

            if(rs.next()){
                retValue = new TransferClub(rs.getInt(1), rs.getString(2));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.close(rs, ps, c);
        }
        return retValue;
    }
}
