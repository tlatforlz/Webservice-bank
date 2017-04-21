/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author tranl
 */
public class NHANVIEN_DAO {
    public boolean Login(String username, String password) throws SQLException{
        boolean check = false;
        IODatabase io = new IODatabase();
        io.conn();
        
        String sql = "SELECT COUNT(ID) FROM tb_nhanvien WHERE TaiKhoan = '" + username + "' and MatKhau = '" + password + "'";
        ResultSet rs = io.getResultSet(sql);
        if(rs.next()){
            int count = rs.getInt(1);
            if(count == 1){
                check = true;
            }
        }
        io.close();
        return check;
    }
}
