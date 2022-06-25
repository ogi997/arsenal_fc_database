package sample.wrapper;

import sample.Util.DBUtil;
import sample.model.Account;
import sample.model.Country;
import sample.model.Person;
import sample.model.Rival;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WrapperPerson {

    private static final String SQL_SELECT_ALL = "SELECT * FROM person";
    private static final String SQL_SELECT_PERSON = "SELECT * FROM person WHERE id=?";
//    private static final String SQL_DELETE_PERSON = "DELETE FROM person WHERE id=?";
    private static final String SQL_UPDATE = "UPDATE person SET status=? WHERE id=?";
    private static final String SQL_INSERT = "INSERT INTO person (name, date_birth, country_id_person, best_team, status) VALUES (?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE_ALL = "UPDATE person SET name=?, date_birth=?, country_id_person=?, best_team=?, status=? WHERE id=?";

    public static int update(Person person) {
        int retValue = 0;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            c = DBUtil.getConnection();
            Object[] values = {person.getName(), person.getDate_birth(), person.getCountry_id_person(), person.getBest_team(), "ACTIVE", person.getIdPerson()};
            ps = DBUtil.prepareStatement(c, SQL_UPDATE_ALL, false, values);
            retValue = ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.close(rs, ps, c);
        }
        return retValue;
    }

    public static int insert(Person person) {
        int retValue = 0;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            c = DBUtil.getConnection();
            Object[] values = {person.getName(), person.getDate_birth(), person.getCountry_id_person(), person.getBest_team(), "ACTIVE"};
            ps = DBUtil.prepareStatement(c, SQL_INSERT, true, values);
            retValue = ps.executeUpdate();
            if(retValue != 0){
                rs = ps.getGeneratedKeys();
                if(rs.next())
                    person.setIdPerson(rs.getInt(1));
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
            Object[] values = {"INACTIVE", id};
            ps = DBUtil.prepareStatement(c, SQL_UPDATE, true, values);
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

    public static Person getPersonById(Integer id) {
        Person retValue = null;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            c = DBUtil.getConnection();
            Object[] values = {id};
            ps = DBUtil.prepareStatement(c, SQL_SELECT_PERSON, false, values);
            rs = ps.executeQuery();

            if(rs.next()){
                retValue = new Person(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getInt(4), rs.getShort(5), rs.getString(6));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.close(rs, ps, c);
        }
        return retValue;
    }

    public static List<Person> selectAll() {
        List<Person> retValue = new ArrayList<>();
        Connection c = null;
        Statement s = null;
        ResultSet rs = null;

        try {
            c = DBUtil.getConnection();
            s = c.createStatement();
            rs = s.executeQuery(SQL_SELECT_ALL);

            while(rs.next()) {
                retValue.add(new Person(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getInt(4), rs.getShort(5), rs.getString(6)));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.close(rs, s, c);
        }
        return retValue;
    }
}
