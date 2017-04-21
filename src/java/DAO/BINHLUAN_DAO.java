/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.BINHLUAN;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tranl
 */
public class BINHLUAN_DAO {

    public void Insert_BinhLuan(BINHLUAN bl) throws SQLException, ParseException {
        IODatabase io = new IODatabase();
        io.conn();
        String sql = "INSERT INTO tb_binhluan(MaBinhLuan, TieuDe, NoiDung, tb_sanpham_ID, tb_khachhang_ID) VALUES(?,?,?,?,?)";
        PreparedStatement st = io.io_prepare(sql);
        st.setString(1, bl.getMaBinhLuan());
        st.setString(2, bl.getTieuDe());
        st.setString(3, bl.getNoiDung());
        st.setInt(4, bl.getTb_sanpham_ID());
        st.setInt(5, bl.getTb_khachhang_ID());
        st.executeUpdate();
        io.close();
    }

    public int getCount() throws SQLException {
        int count = 0;
        IODatabase io = new IODatabase();
        io.conn();
        String sql = "SELECT COUNT(ID) FROM tb_binhluan";
        ResultSet rs = io.getResultSet(sql);
        if (rs.next()) {
            count = rs.getInt(1);
        }
        io.close();
        return count;
    }

    public ArrayList<BINHLUAN> getBinhLuan(int ID) {
        IODatabase io = new IODatabase();
        io.conn();
        ArrayList<BINHLUAN> list = new ArrayList<BINHLUAN>();
        String sql = "select * from tb_binhluan where tb_sanpham_id = " + ID + " order by NgayDang desc";
        ResultSet rs = io.getResultSet(sql);
        try {
            while(rs.next()){
                int ID_bl = rs.getInt("ID");
                String MaBinhLuan = rs.getString("MaBinhLuan");
                String TieuDe = rs.getString("TieuDe");
                String NoiDung = rs.getString("NoiDung");
                int ID_sp = rs.getInt("tb_sanpham_ID");
                int ID_kh = rs.getInt("tb_khachhang_ID");
                BINHLUAN bl = new BINHLUAN();
                bl.setID(ID_bl);
                bl.setMaBinhLuan(MaBinhLuan);
                bl.setTieuDe(TieuDe);
                bl.setNoiDung(NoiDung);
                bl.setTb_sanpham_ID(ID_sp);
                bl.setTb_khachhang_ID(ID_kh);
                
                list.add(bl);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BINHLUAN_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        io.close();
        return list;
    }
    
    
    public ArrayList<BINHLUAN> getBinhLuanAll() {
        IODatabase io = new IODatabase();
        io.conn();
        ArrayList<BINHLUAN> list = new ArrayList<BINHLUAN>();
        String sql = "select * from tb_binhluan order by NgayDang";
        ResultSet rs = io.getResultSet(sql);
        try {
            while(rs.next()){
                int ID_bl = rs.getInt("ID");
                String MaBinhLuan = rs.getString("MaBinhLuan");
                String TieuDe = rs.getString("TieuDe");
                String NoiDung = rs.getString("NoiDung");
                int ID_sp = rs.getInt("tb_sanpham_ID");
                int ID_kh = rs.getInt("tb_khachhang_ID");
                Date NgayDang = rs.getDate("NgayDang");
                BINHLUAN bl = new BINHLUAN();
                bl.setID(ID_bl);
                bl.setMaBinhLuan(MaBinhLuan);
                bl.setTieuDe(TieuDe);
                bl.setNoiDung(NoiDung);
                bl.setTb_sanpham_ID(ID_sp);
                bl.setTb_khachhang_ID(ID_kh);
                bl.setNgayDang(NgayDang);
                list.add(bl);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BINHLUAN_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        io.close();
        return list;
    }
    
    public void XoaBinhLuan(int ID) throws SQLException{
        IODatabase io = new IODatabase();
        io.conn();
        String sql = "DELETE FROM `db_cuahangdochoi`.`tb_binhluan` WHERE ID = " + ID;
        io.getStatement().executeUpdate(sql);
        
        io.close();
        
    }
}
