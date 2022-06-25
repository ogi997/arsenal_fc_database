package sample.wrapper;

import sample.Util.DBUtil;
import sample.model.Account;
import sample.model.Contract;
import sample.model.ContractManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class WrapperContractManager {

    private static final String SQL_SELECT_ALL = "SELECT * FROM contract_manager";

    public static List<ContractManager> selectAll() {
        List<ContractManager> retValue = new ArrayList<>();
        Connection c = null;
        Statement s = null;
        ResultSet rs = null;

        try {
            c = DBUtil.getConnection();
            s = c.createStatement();
            rs = s.executeQuery(SQL_SELECT_ALL);

            while(rs.next()) {
                retValue.add(new ContractManager(rs.getInt(1), rs.getInt(2)));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.close(rs, s, c);
        }
        return retValue;
    }
}
