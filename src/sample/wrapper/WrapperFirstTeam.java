package sample.wrapper;

import sample.Util.DBUtil;
import sample.model.Account;
import sample.model.Match;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WrapperFirstTeam {

    private static final String SQL_DELETE = "DELETE FROM first_team WHERE match_id=?";

    private static final String SQL_ADD_PLAYER = "";
    private static final String SQL_ADD_MANAGER = "";

    private static final String SQL_ADD_FIRST_TEAM = "INSERT INTO `first_team` (`match_id`, `player_id_for_ft`, `manager_id_for_ft`) VALUES (?, null, 3), (?, 4, null), (?, 5, null), (?, 6, null), (?, 7, null), (?, 8, null), (?, 9, null), (?, 10, null), (?, 11, null), (?, 12, null), (?, 13, null), (?, 14, null)";


    public static int insert(Match match) {
        int retValue = 0;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            c = DBUtil.getConnection();
            Object[] values = {match.getIdMatch(), match.getIdMatch(), match.getIdMatch(), match.getIdMatch(), match.getIdMatch(), match.getIdMatch(), match.getIdMatch(), match.getIdMatch(), match.getIdMatch(), match.getIdMatch(), match.getIdMatch(), match.getIdMatch()};
            ps = DBUtil.prepareStatement(c, SQL_ADD_FIRST_TEAM, true, values);
            retValue = ps.executeUpdate();
            if(retValue != 0){
                rs = ps.getGeneratedKeys();
//                if(rs.next())
//                    match.setIdMatch(rs.getInt(1));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return  retValue;
    }


    public static int delete(Integer id) {
        int retValue = 0;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            c = DBUtil.getConnection();
            Object[] values = {id};
            ps = DBUtil.prepareStatement(c, SQL_DELETE, true, values);
            retValue = ps.executeUpdate();
            if(retValue != 0){
                rs = ps.getGeneratedKeys();
                if(rs.next())
                    retValue = 1;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return  retValue;
    }
}
