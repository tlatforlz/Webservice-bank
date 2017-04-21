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
public class LOAINHANVIEN {
    private int ID;
    private String MaLoaiNhanVien;
    private String TenLoaiNhanVien;
    private String Quyen;

    public LOAINHANVIEN() {
    }

    public LOAINHANVIEN(int ID, String MaLoaiNhanVien, String TenLoaiNhanVien, String Quyen) {
        this.ID = ID;
        this.MaLoaiNhanVien = MaLoaiNhanVien;
        this.TenLoaiNhanVien = TenLoaiNhanVien;
        this.Quyen = Quyen;
    }

    
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getMaLoaiNhanVien() {
        return MaLoaiNhanVien;
    }

    public void setMaLoaiNhanVien(String MaLoaiNhanVien) {
        this.MaLoaiNhanVien = MaLoaiNhanVien;
    }

    public String getTenLoaiNhanVien() {
        return TenLoaiNhanVien;
    }

    public void setTenLoaiNhanVien(String TenLoaiNhanVien) {
        this.TenLoaiNhanVien = TenLoaiNhanVien;
    }

    public String getQuyen() {
        return Quyen;
    }

    public void setQuyen(String Quyen) {
        this.Quyen = Quyen;
    }
    
    
}
