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
public class GIOHANG {
    private int ID;
    private String MaKhachHang;
    private String MaSanPham;
    private int SoLuong;

    public GIOHANG() {
    }

    
    public GIOHANG(int ID, String MaKhachHang, String MaSanPham, int SoLuong) {
        this.ID = ID;
        this.MaKhachHang = MaKhachHang;
        this.MaSanPham = MaSanPham;
        this.SoLuong = SoLuong;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getMaKhachHang() {
        return MaKhachHang;
    }

    public void setMaKhachHang(String MaKhachHang) {
        this.MaKhachHang = MaKhachHang;
    }

    public String getMaSanPham() {
        return MaSanPham;
    }

    public void setMaSanPham(String MaSanPham) {
        this.MaSanPham = MaSanPham;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }
    
    
}
