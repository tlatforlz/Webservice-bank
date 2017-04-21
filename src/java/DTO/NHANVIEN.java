/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.Date;

/**
 *
 * @author tranl
 */
public class NHANVIEN {
    private int ID;
    private String MaNhanVien;
    private String TaiKhoan;
    private String MatKhau;
    private String MatKhauCapHai;
    private String Email;
    private String DiaChi;
    private String SoDienThoai;
    private Date NgaySinh;
   
    private String tb_loainhanvien_MaLoaiNhanVien;

    public NHANVIEN() {
    }

    public NHANVIEN(int ID, String MaNhanVien, String TaiKhoan, String MatKhau, String MatKhauCapHai, String Email, String DiaChi, String SoDienThoai, Date NgaySinh, String tb_loainhanvien_MaLoaiNhanVien) {
        this.ID = ID;
        this.MaNhanVien = MaNhanVien;
        this.TaiKhoan = TaiKhoan;
        this.MatKhau = MatKhau;
        this.MatKhauCapHai = MatKhauCapHai;
        this.Email = Email;
        this.DiaChi = DiaChi;
        this.SoDienThoai = SoDienThoai;
        this.NgaySinh = NgaySinh;
       
        this.tb_loainhanvien_MaLoaiNhanVien = tb_loainhanvien_MaLoaiNhanVien;
    }

    
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getMaNhanVien() {
        return MaNhanVien;
    }

    public void setMaNhanVien(String MaNhanVien) {
        this.MaNhanVien = MaNhanVien;
    }

    public String getTaiKhoan() {
        return TaiKhoan;
    }

    public void setTaiKhoan(String TaiKhoan) {
        this.TaiKhoan = TaiKhoan;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

    public String getMatKhauCapHai() {
        return MatKhauCapHai;
    }

    public void setMatKhauCapHai(String MatKhauCapHai) {
        this.MatKhauCapHai = MatKhauCapHai;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getSoDienThoai() {
        return SoDienThoai;
    }

    public void setSoDienThoai(String SoDienThoai) {
        this.SoDienThoai = SoDienThoai;
    }

    public Date getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(Date NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public String getTb_loainhanvien_MaLoaiNhanVien() {
        return tb_loainhanvien_MaLoaiNhanVien;
    }

    public void setTb_loainhanvien_MaLoaiNhanVien(String tb_loainhanvien_MaLoaiNhanVien) {
        this.tb_loainhanvien_MaLoaiNhanVien = tb_loainhanvien_MaLoaiNhanVien;
    }
    
    
}
