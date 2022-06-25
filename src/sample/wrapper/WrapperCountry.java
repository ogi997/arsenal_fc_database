package sample.wrapper;

import sample.Util.DBUtil;
import sample.model.Account;
import sample.model.AllPlayers;
import sample.model.Country;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WrapperCountry {
    private static final String SQL_SELECT_ALL = "SELECT * FROM country";
    private static final String SQL_SELECT_COUNTRY = "SELECT * FROM country WHERE id=?";
    private static final String SQL_UPDATE = "UPDATE country SET name=? WHERE id=?";
    private static final String SQL_DELETE_COUNTRY = "DELETE FROM country WHERE id=?";
    private static final String SQL_INSERT = "INSERT INTO country (name) VALUES (?)";

    private static final String SQL_GET_ID = "SELECT * FROM country WHERE name=?";

    public static Country getIdCountry(String name) {
        Country retValue = null;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            c = DBUtil.getConnection();
            Object[] values = {name};
            ps = DBUtil.prepareStatement(c, SQL_GET_ID, false, values);
            rs = ps.executeQuery();

            if(rs.next()){
                retValue = new Country(rs.getInt(1), rs.getString(2));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.close(rs, ps, c);
        }
        return retValue;
    }


    public static int insert(Country country) {
        int retValue = 0;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            c = DBUtil.getConnection();
            Object[] values = {country.getName()};
            ps = DBUtil.prepareStatement(c, SQL_INSERT, true, values);
            retValue = ps.executeUpdate();
//            if(retValue != 0){
//                rs = ps.getGeneratedKeys();
//                if(rs.next())
//                    account.setIdAccount(rs.getInt(1));
//            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return  retValue;
    }

    public static int update(Country country) {
        int retValue = 0;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            c = DBUtil.getConnection();
            Object[] values = {country.getName(), country.getIdCountry()};
            ps = DBUtil.prepareStatement(c, SQL_UPDATE, false, values);
            retValue = ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.close(rs, ps, c);
        }
        return retValue;
    }

    public static Integer deleteCountryById(Integer id) {
        int retValue = 0;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            c = DBUtil.getConnection();
            Object[] values = {id};
            ps = DBUtil.prepareStatement(c, SQL_DELETE_COUNTRY, true, values);
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

    public static List<Country> selectAll() {
        List<Country> retValue = new ArrayList<>();
        Connection c = null;
        Statement s = null;
        ResultSet rs = null;

        try {
            c = DBUtil.getConnection();
            s = c.createStatement();
            rs = s.executeQuery(SQL_SELECT_ALL);

            while(rs.next()) {
                retValue.add(new Country(rs.getInt(1), rs.getString(2)));
            }

        }catch (SQLException e){
            System.out.println("Ovdje");
            e.printStackTrace();
        }finally {
            DBUtil.close(rs, s, c);
        }
        return retValue;
    }


    public static Country getCountryById(Integer id) {
        Country retValue = null;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            c = DBUtil.getConnection();
            Object[] values = {id};
            ps = DBUtil.prepareStatement(c, SQL_SELECT_COUNTRY, false, values);
            rs = ps.executeQuery();

            if(rs.next()){
                retValue = new Country(rs.getInt(1), rs.getString(2));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.close(rs, ps, c);
        }
        return retValue;
    }
}
