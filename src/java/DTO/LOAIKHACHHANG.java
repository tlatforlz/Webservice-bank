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
public class LOAIKHACHHANG {

    private int ID;
    private String MaLoaiKhachHang;
    private String TenLoaiKhachHang;
    private int UuDaiGiamGia;

    public LOAIKHACHHANG(int ID, String MaLoaiKhachHang, String TenLoaiKhachHang, int UuDaiGiamGia) {
        this.ID = ID;
        this.MaLoaiKhachHang = MaLoaiKhachHang;
        this.TenLoaiKhachHang = TenLoaiKhachHang;
        this.UuDaiGiamGia = UuDaiGiamGia;
    }

    public LOAIKHACHHANG() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getMaLoaiKhachHang() {
        return MaLoaiKhachHang;
    }

    public void setMaLoaiKhachHang(String MaLoaiKhachHang) {
        this.MaLoaiKhachHang = MaLoaiKhachHang;
    }

    public String getTenLoaiKhachHang() {
        return TenLoaiKhachHang;
    }

    public void setTenLoaiKhachHang(String TenLoaiKhachHang) {
        this.TenLoaiKhachHang = TenLoaiKhachHang;
    }

    public int getUuDaiGiamGia() {
        return UuDaiGiamGia;
    }

    public void setUuDaiGiamGia(int UuDaiGiamGia) {
        this.UuDaiGiamGia = UuDaiGiamGia;
    }

}
