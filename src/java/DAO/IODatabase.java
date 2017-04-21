/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kirito-IIS3437
 */
public class IODatabase {

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private PreparedStatement ps;

//    Hàm khởi tạo
    public IODatabase() {    
    }

//    Hàm kiểm tra kết nối
    public void conn() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/db_cuahangdochoi?zeroDateTimeBehavior=convertToNull&useUnicode=yes&characterEncoding=UTF-8";
            connection = DriverManager.getConnection(url, "root", "root");
            statement = connection.createStatement();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public PreparedStatement io_prepare(String sql) throws SQLException {
        PreparedStatement pstatement = connection.prepareStatement(sql);
        return pstatement;
    }
//    Hàm lấy ra kết quả của hàm select

    
    public void executeQuery(String sql) throws SQLException{  
        statement.executeUpdate(sql);
    }
    
    public ResultSet getResultSet(String sqlCommand) {
        try {
            resultSet = statement.executeQuery(sqlCommand);
            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void executeUpdata(String sqlCommand, int[] indexs, ArrayList<String> values) {
        try {
            ps = connection.prepareStatement(sqlCommand);
            for (int i = 0; i < values.size(); i++) {
                ps.setString(indexs[i], values.get(i));
            }
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void executeUpdata1(String sqlCommand, int[] indexs, ArrayList<Integer> values) {
        try {
            ps = connection.prepareStatement(sqlCommand);
            for (int i = 0; i < values.size(); i++) {
                ps.setInt(indexs[i], values.get(i));
            }
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

//    Đóng kết nối
    public void close() {
        try {
            connection.close();
            if (statement != null) {
                statement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
            if (ps != null) {
                ps.close();
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

//    Lấy ra kêt nối
    public Connection getConnection() {
        return connection;
    }

//    Set kết nối
    public void setConnection(Connection connection) {
        this.connection = connection;
    }

//    Lấy statement
    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }

    public ResultSet getResultSet() {
        return resultSet;
    }

    public void setResultSet(ResultSet resultSet) {
        this.resultSet = resultSet;
    }

    public PreparedStatement getPs() {
        return ps;
    }

    public void setPs(PreparedStatement ps) {
        this.ps = ps;
    }
}
