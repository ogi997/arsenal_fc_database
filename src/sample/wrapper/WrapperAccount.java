package sample.wrapper;

import sample.Util.DBUtil;
import sample.model.Account;
import sample.model.City;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WrapperAccount {
    private static final String SQL_SELECT_ALL = "SELECT * FROM account";
    private static final String SQL_INSERT = "INSERT INTO account (username, password) VALUES (?, ?)";
    private static final String SQL_UPDATE = "UPDATE account SET username=?, Password=? WHERE id=?";
    private static final String SQL_USER_EXIST = "SELECT * FROM account WHERE username=? AND password=?";
    private static final String SQL_DELETE = "DELETE FROM account WHERE id=?";

    public static int delete(Account account) {
        int retValue = 0;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            c = DBUtil.getConnection();
            Object[] values = {account.getIdAccount()};
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


    public static Account userExist(Account account) {
        Account retValue = null;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            c = DBUtil.getConnection();
            Object[] values = {account.getUsername(), account.getPassword()};
            ps = DBUtil.prepareStatement(c, SQL_USER_EXIST, false, values);
            rs = ps.executeQuery();

            if(rs.next()){
                retValue = new Account(rs.getInt(1), rs.getString(2), rs.getString(3));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.close(rs, ps, c);
        }
        return retValue;
    }


    public static List<Account> selectAll() {
        List<Account> retValue = new ArrayList<>();
        Connection c = null;
        Statement s = null;
        ResultSet rs = null;
        
        try {
            c = DBUtil.getConnection();
            s = c.createStatement();
            rs = s.executeQuery(SQL_SELECT_ALL);
            
            while(rs.next()) {
                retValue.add(new Account(rs.getInt("id"), rs.getString("username"), rs.getString("password")));
            }
            
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.close(rs, s, c);
        }
        return retValue;
    }

    public static int insert(Account account) {
        int retValue = 0;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            c = DBUtil.getConnection();
            Object[] values = {account.getUsername(), account.getPassword()};
            ps = DBUtil.prepareStatement(c, SQL_INSERT, true, values);
            retValue = ps.executeUpdate();
            if(retValue != 0){
                rs = ps.getGeneratedKeys();
                if(rs.next())
                    account.setIdAccount(rs.getInt(1));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return  retValue;
    }

    public static List<Account> selectBy(Account account) {
        List<Account> retVal = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            c = DBUtil.getConnection();
            String query = SQL_SELECT_ALL + "WHERE true";
            List<Object> pom = new ArrayList<>();
            if(account.getIdAccount() != null) {
                query += " AND id=?";
                pom.add(account.getIdAccount());
            }
            if(account.getUsername() != null) {
                query += " AND username=?";
            }
            ps = DBUtil.prepareStatement(c, query, false, pom);
            rs = ps.executeQuery();
            while(rs.next()){
                retVal.add(new Account(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.close(rs, ps, c);
        }
        return retVal;
    }

    public static int update(Account account) {
        int retValue = 0;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            c = DBUtil.getConnection();
            Object[] values = {account.getUsername(), account.getPassword(), account.getIdAccount()};
            ps = DBUtil.prepareStatement(c, SQL_UPDATE, false, values);
            retValue = ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.close(rs, ps, c);
        }
        return retValue;
    }
}
