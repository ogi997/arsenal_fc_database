package sample.wrapper;

import sample.Util.DBUtil;
import sample.model.ContractManager;
import sample.model.ContractPlayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class WrapperContractPlayer {

    private static final String SQL_SELECT_ALL = "SELECT * FROM contract_player";

    public static List<ContractPlayer> selectAll() {
        List<ContractPlayer> retValue = new ArrayList<>();
        Connection c = null;
        Statement s = null;
        ResultSet rs = null;

        try {
            c = DBUtil.getConnection();
            s = c.createStatement();
            rs = s.executeQuery(SQL_SELECT_ALL);

            while(rs.next()) {
                retValue.add(new ContractPlayer(rs.getInt(1), rs.getInt(2)));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.close(rs, s, c);
        }
        return retValue;
    }
}
