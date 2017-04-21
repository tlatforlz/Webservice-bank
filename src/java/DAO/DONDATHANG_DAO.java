/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.DONDATHANG;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author tranl
 */
public class DONDATHANG_DAO {

    public int countDDH() throws SQLException {
        int SoLuong = 0;
        IODatabase io = new IODatabase();
        io.conn();
        String sql = "SELECT MAX(ID) FROM tb_dondathang";
        ResultSet rs = io.getResultSet(sql);
        if (rs.next()) {
            SoLuong = rs.getInt(1);
        }
        io.close();
        return SoLuong;
    }

    public void InsertDDH(DONDATHANG ddh) throws SQLException {
        IODatabase io = new IODatabase();
        io.conn();
        String sql = "INSERT INTO tb_dondathang(MaDonDatHang, TongTien, tb_khachhang_MaKhachHang, DiaChiGiaoHang, DaThanhToan) VALUES (?,?,?,?,?)";
        PreparedStatement stm = io.io_prepare(sql);
        stm.setString(1, ddh.getMaDonDatHang());
        stm.setInt(2, ddh.getTongTien());
        stm.setString(3, ddh.getTb_khachhang_MaKhachHang());
        stm.setString(4, ddh.getDiaChiGiaoHang());
        stm.setInt(5, ddh.getDaThanhToan());
        stm.executeUpdate();
        io.close();
    }

    public DONDATHANG getDonDatHang(String MaDonDatHang) throws SQLException {
        DONDATHANG dh = new DONDATHANG();
        IODatabase io = new IODatabase();
        io.conn();
        String sql = "SELECT * FROM tb_dondathang WHERE MaDonDatHang = '" + MaDonDatHang + "'";
        ResultSet rs = io.getResultSet(sql);
        if (rs.next()) {
            int ID = rs.getInt("ID");

            Date NgayDat = rs.getTimestamp("NgayDat");
            Date NgayGiao = rs.getDate("NgayGiao");
            int TinhTrangGiao = rs.getInt("TinhTrangGiao");
            int DaThanhToan = rs.getInt("DaThanhToan");
            int PhiVanChuyen = rs.getInt("PhiVanChuyen");
            int DaXoa = rs.getInt("DaXoa");
            int DaHuy = rs.getInt("DaHuy");
            int TongTien = rs.getInt("TongTien");
            String DiaChiGiaoHang = rs.getString("DiaChiGiaoHang");

            dh.setID(ID);
            dh.setMaDonDatHang(MaDonDatHang);
            dh.setTinhTrangGiao(TinhTrangGiao);
            dh.setNgayDat(NgayDat);
            dh.setNgayGiao(NgayGiao);
            dh.setDaHuy(DaHuy);
            dh.setDaThanhToan(DaThanhToan);
            dh.setPhiVanChuyen(PhiVanChuyen);
            dh.setDaXoa(DaXoa);
            dh.setTongTien(TongTien);
            dh.setDiaChiGiaoHang(DiaChiGiaoHang);
        }
        io.close();
        return dh;
    }

    public ArrayList<DONDATHANG> getListDDH(String MaKhachHang) throws SQLException {
        ArrayList<DONDATHANG> list = new ArrayList<DONDATHANG>();
        IODatabase io = new IODatabase();
        io.conn();
        String sql = "SELECT * FROM tb_dondathang WHERE tb_khachhang_MaKhachHang = '" + MaKhachHang + "'";
        ResultSet rs = io.getResultSet(sql);
        while (rs.next()) {
            int ID = rs.getInt("ID");
            String MaDonDatHang = rs.getString("MaDonDatHang");
            Date NgayDat = rs.getTimestamp("NgayDat");
            Date NgayGiao = rs.getDate("NgayGiao");
            int TinhTrangGiao = rs.getInt("TinhTrangGiao");
            int DaThanhToan = rs.getInt("DaThanhToan");
            int PhiVanChuyen = rs.getInt("PhiVanChuyen");
            int DaXoa = rs.getInt("DaXoa");
            int DaHuy = rs.getInt("DaHuy");
            int TongTien = rs.getInt("TongTien");
            String DiaChiGiaoHang = rs.getString("DiaChiGiaoHang");
            DONDATHANG dh = new DONDATHANG();
            dh.setID(ID);
            dh.setMaDonDatHang(MaDonDatHang);
            dh.setTinhTrangGiao(TinhTrangGiao);
            dh.setNgayDat(NgayDat);
            dh.setNgayGiao(NgayGiao);
            dh.setDaHuy(DaHuy);
            dh.setDaThanhToan(DaThanhToan);
            dh.setPhiVanChuyen(PhiVanChuyen);
            dh.setDaXoa(DaXoa);
            dh.setTongTien(TongTien);
            dh.setDiaChiGiaoHang(DiaChiGiaoHang);
            list.add(dh);
        }
        io.close();
        return list;
    }

    public void XoaDonHang(String MaDonHang) throws SQLException {
        IODatabase io = new IODatabase();
        io.conn();
        String sql = "UPDATE tb_dondathang SET DaHuy = 1 WHERE MaDonDatHang = '" + MaDonHang + "'";
        io.getStatement().executeUpdate(sql);
        io.close();
    }

    public boolean checkDonHang(String MaDonHang) throws SQLException {
        IODatabase io = new IODatabase();
        io.conn();
        String sql = "SELECT COUNT(ID) FROM tb_dondathang WHERE MaDonDatHang = '" + MaDonHang + "'";
        ResultSet rs = io.getResultSet(sql);
        boolean check = false;
        if (rs.next()) {
            int count = rs.getInt(1);
            if (count != 0) {
                check = true;
            }
        }
        io.close();
        return check;
    }
    
    public void updateThanhToan(String MaDonHang) throws SQLException{
        IODatabase io = new IODatabase();
        io.conn();
        String sql = "UPDATE tb_dondathang SET DaThanhToan = 1 WHERE MaDonDatHang = '" + MaDonHang + "'";
        io.getStatement().executeUpdate(sql);
        io.close();
    }
}
