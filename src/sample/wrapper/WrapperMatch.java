package sample.wrapper;

import sample.Util.DBUtil;
import sample.model.Account;
import sample.model.Country;
import sample.model.Match;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WrapperMatch {
    private static final String SQL_DELETE = "DELETE FROM db_arsenal.match WHERE id=?";

    private static final String SQL_UPDATE = "UPDATE db_arsenal.match SET rival_id=?, goals_scored=?, goals_received=?, seasone_id_for_match=?, game_id=?, date=?, home=? WHERE id=?";

    public static int update(Match match) {
        int retValue = 0;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            c = DBUtil.getConnection();
            Object[] values = {match.getRival_id(), match.getGoals_scored(), match.getGoals_received(), match.getSeasone_id_for_match(), match.getGame_id(), match.getDate(), match.getHome(), match.getIdMatch()};
            ps = DBUtil.prepareStatement(c, SQL_UPDATE, false, values);
            retValue = ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.close(rs, ps, c);
        }
        return retValue;
    }

    private static final String SQL_ADD_MATCH = "INSERT INTO `match` (`rival_id`, `goals_scored`, `goals_received`, `seasone_id_for_match`, `game_id`, `date`, `home`) VALUES (?, ?, ?, ?, ?, ?, ?)";

    private static final String SQL_SELECT_MATCH = "SELECT * FROM db_arsenal.match WHERE id=?";
    public static Match getMatchById(Integer id) {
        Match retValue = null;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            c = DBUtil.getConnection();
            Object[] values = {id};
            ps = DBUtil.prepareStatement(c, SQL_SELECT_MATCH, false, values);
            rs = ps.executeQuery();

            if(rs.next()){
                retValue = new Match(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getDate(7), rs.getShort(8));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.close(rs, ps, c);
        }
        return retValue;
    }


    public static int insert(Match match) {
        int retValue = 0;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            c = DBUtil.getConnection();
            Object[] values = {match.getRival_id(), match.getGoals_scored(), match.getGoals_received(), match.getSeasone_id_for_match(), match.getGame_id(), match.getDate(), match.getHome()};
            ps = DBUtil.prepareStatement(c, SQL_ADD_MATCH, true, values);
            retValue = ps.executeUpdate();
            if(retValue != 0){
                rs = ps.getGeneratedKeys();
                if(rs.next())
                    match.setIdMatch(rs.getInt(1));
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
