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
public class CHITIETPHIEUNHAP {
    private int ID;
    private String MaPhieuNhap;
    private String MaSanPham;
    private int DonGiaNhap;
    private int SoLuong;
    private int tb_phieunhap_ID;
    private String tb_phieunhap_MaPhieuNhap;

    public CHITIETPHIEUNHAP() {
    }

    public CHITIETPHIEUNHAP(int ID, String MaPhieuNhap, String MaSanPham, int DonGiaNhap, int SoLuong, int tb_phieunhap_ID, String tb_phieunhap_MaPhieuNhap) {
        this.ID = ID;
        this.MaPhieuNhap = MaPhieuNhap;
        this.MaSanPham = MaSanPham;
        this.DonGiaNhap = DonGiaNhap;
        this.SoLuong = SoLuong;
        this.tb_phieunhap_ID = tb_phieunhap_ID;
        this.tb_phieunhap_MaPhieuNhap = tb_phieunhap_MaPhieuNhap;
    }

    
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getMaPhieuNhap() {
        return MaPhieuNhap;
    }

    public void setMaPhieuNhap(String MaPhieuNhap) {
        this.MaPhieuNhap = MaPhieuNhap;
    }

    public String getMaSanPham() {
        return MaSanPham;
    }

    public void setMaSanPham(String MaSanPham) {
        this.MaSanPham = MaSanPham;
    }

    public int getDonGiaNhap() {
        return DonGiaNhap;
    }

    public void setDonGiaNhap(int DonGiaNhap) {
        this.DonGiaNhap = DonGiaNhap;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public int getTb_phieunhap_ID() {
        return tb_phieunhap_ID;
    }

    public void setTb_phieunhap_ID(int tb_phieunhap_ID) {
        this.tb_phieunhap_ID = tb_phieunhap_ID;
    }

    public String getTb_phieunhap_MaPhieuNhap() {
        return tb_phieunhap_MaPhieuNhap;
    }

    public void setTb_phieunhap_MaPhieuNhap(String tb_phieunhap_MaPhieuNhap) {
        this.tb_phieunhap_MaPhieuNhap = tb_phieunhap_MaPhieuNhap;
    }
    
    
}
