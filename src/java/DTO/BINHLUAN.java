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
public class BINHLUAN {
    private int ID;

    private String MaBinhLuan;
    private String TieuDe;
    private String NoiDung;
    private int tb_sanpham_ID;
    private int tb_khachhang_ID;
    private Date NgayDang;
    
    public BINHLUAN() {
    }

    public BINHLUAN(int ID, String MaBinhLuan, String TieuDe, String NoiDung, int tb_sanpham_ID, int tb_khachhang_ID, Date NgayDang) {
        this.ID = ID;
        this.MaBinhLuan = MaBinhLuan;
        this.TieuDe = TieuDe;
        this.NoiDung = NoiDung;
        this.tb_sanpham_ID = tb_sanpham_ID;
        this.tb_khachhang_ID = tb_khachhang_ID;
        this.NgayDang = NgayDang;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getMaBinhLuan() {
        return MaBinhLuan;
    }

    public void setMaBinhLuan(String MaBinhLuan) {
        this.MaBinhLuan = MaBinhLuan;
    }

    public String getTieuDe() {
        return TieuDe;
    }

    public void setTieuDe(String TieuDe) {
        this.TieuDe = TieuDe;
    }

    public String getNoiDung() {
        return NoiDung;
    }

    public void setNoiDung(String NoiDung) {
        this.NoiDung = NoiDung;
    }

    public int getTb_sanpham_ID() {
        return tb_sanpham_ID;
    }

    public void setTb_sanpham_ID(int tb_sanpham_ID) {
        this.tb_sanpham_ID = tb_sanpham_ID;
    }

    public int getTb_khachhang_ID() {
        return tb_khachhang_ID;
    }

    public void setTb_khachhang_ID(int tb_khachhang_ID) {
        this.tb_khachhang_ID = tb_khachhang_ID;
    }

    public Date getNgayDang() {
        return NgayDang;
    }

    public void setNgayDang(Date NgayDang) {
        this.NgayDang = NgayDang;
    }

    
    
    
}
