/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.LOAISANPHAM;
import DTO.NHASANXUAT;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author tranl
 */
public class NHASANXUAT_DAO {

    public ArrayList<NHASANXUAT> getNhaSanXuat() throws SQLException {
        IODatabase io = new IODatabase();
        io.conn();
        String sql = "select * from tb_nhasanxuat";
        ResultSet rs = io.getResultSet(sql);
        ArrayList<NHASANXUAT> list = new ArrayList<NHASANXUAT>();
        try {
            while (rs.next()) {
                int ID = rs.getInt("ID");
                String MaNSX = rs.getString("MaNSX");
                String TenNSX = rs.getString("TenNSX");
                String QuocGia = rs.getString("QuocGia");
                String ThongTin = rs.getString("ThongTin");
                NHASANXUAT sp = new NHASANXUAT(ID, MaNSX, TenNSX, QuocGia, ThongTin);
                list.add(sp);
            }
        } catch (SQLException e) {
        }
        io.close();
        return list;
    }

    public ArrayList<NHASANXUAT> getSoLuong() throws SQLException {
        ArrayList<NHASANXUAT> list = new ArrayList<NHASANXUAT>();
        IODatabase io = new IODatabase();
        io.conn();
        list =  this.getNhaSanXuat();
        for(NHASANXUAT sp : list){
            String sql = "SELECT count(id) FROM db_cuahangdochoi.tb_sanpham where tb_nhasanxuat_MaNSX = '" + sp.getMaNSX() + "';";
            ResultSet rs = io.getResultSet(sql);
            if(rs.next()){
                sp.setSoLuong(rs.getInt(1));
            }
        }
        io.close();
        return list;
    }
}
