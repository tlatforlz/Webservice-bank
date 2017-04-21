/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author tranl
 */
public class CHITIETDATHANG {
    private int ID;
    private String MaChiTiet;
    private int SoLuong;
    private int DonGia;
    private String tb_dondathang_MaDonDatHang;
    private String tb_sanpham_MaSanPham;
    
    public CHITIETDATHANG() {
    }

    public CHITIETDATHANG(int ID, String MaChiTiet, int SoLuong, int DonGia, String tb_dondathant_MaDonDatHang, String tn_sanpham_MaSanPham) {
        this.ID = ID;
        this.MaChiTiet = MaChiTiet;
        this.SoLuong = SoLuong;
        this.DonGia = DonGia;
        this.tb_dondathang_MaDonDatHang = tb_dondathant_MaDonDatHang;
        this.tb_sanpham_MaSanPham = tn_sanpham_MaSanPham;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getMaChiTiet() {
        return MaChiTiet;
    }

    public void setMaChiTiet(String MaChiTiet) {
        this.MaChiTiet = MaChiTiet;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public int getDonGia() {
        return DonGia;
    }

    public void setDonGia(int DonGia) {
        this.DonGia = DonGia;
    }

    public String getTb_dondathang_MaDonDatHang() {
        return tb_dondathang_MaDonDatHang;
    }

    public void setTb_dondathang_MaDonDatHang(String tb_dondathant_MaDonDatHang) {
        this.tb_dondathang_MaDonDatHang = tb_dondathant_MaDonDatHang;
    }

    public String getTb_sanpham_MaSanPham() {
        return tb_sanpham_MaSanPham;
    }

    public void setTb_sanpham_MaSanPham(String tn_sanpham_MaSanPham) {
        this.tb_sanpham_MaSanPham = tn_sanpham_MaSanPham;
    }
    
}
