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
public class DONDATHANG {

    private int ID;
    private String MaDonDatHang;
    private Date NgayDat;
    private Date NgayGiao;
    private int TinhTrangGiao;
    private int DaThanhToan;
    private int PhiVanChuyen;
    private int DaXoa;
    private int DaHuy;
    private int TongTien;
    private String tb_khachhang_MaKhachHang;
    private String DiaChiGiaoHang;

    public String getDiaChiGiaoHang() {
        return DiaChiGiaoHang;
    }

    public void setDiaChiGiaoHang(String DiaChiGiaoHang) {
        this.DiaChiGiaoHang = DiaChiGiaoHang;
    }

    public DONDATHANG() {
    }

    public DONDATHANG(int ID, String MaDonDatHang, Date NgayDat, Date NgayGiao, int TinhTrangGiao, int DaThanhToan, int PhiVanChuyen, int DaXoa, int DaHuy, int TongTien, String tb_khachhang_MaKhachHang, String DiaChiGiaoHang) {
        this.ID = ID;
        this.MaDonDatHang = MaDonDatHang;
        this.NgayDat = NgayDat;
        this.NgayGiao = NgayGiao;
        this.TinhTrangGiao = TinhTrangGiao;
        this.DaThanhToan = DaThanhToan;
        this.PhiVanChuyen = PhiVanChuyen;
        this.DaXoa = DaXoa;
        this.DaHuy = DaHuy;
        this.TongTien = TongTien;

        this.tb_khachhang_MaKhachHang = tb_khachhang_MaKhachHang;
        this.DiaChiGiaoHang = DiaChiGiaoHang;
    }

    public void Show() {
        System.out.println("ID : " + ID);
        System.out.println("MaDonDatHang : " + MaDonDatHang);
        System.out.println("NgayDat : " + NgayDat.toString());
        System.out.println("NgayGiao : " + NgayGiao);
        System.out.println("TinhTrangGiao : " + TinhTrangGiao);
        System.out.println("DaThanhToan : " + DaThanhToan);
        System.out.println("PhiVanChuyen : " + PhiVanChuyen);
        System.out.println("DaXoa : " + DaXoa);
        System.out.println("DaHuy : " + DaHuy);
        System.out.println("TongTien : " + TongTien);
        System.out.println("tb_khachhang_MaKhachHang : " + tb_khachhang_MaKhachHang);
        System.out.println("DiaChiGiaoHang : " + DiaChiGiaoHang);
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getMaDonDatHang() {
        return MaDonDatHang;
    }

    public void setMaDonDatHang(String MaDonDatHang) {
        this.MaDonDatHang = MaDonDatHang;
    }

    public Date getNgayDat() {
        return NgayDat;
    }

    public void setNgayDat(Date NgayDat) {
        this.NgayDat = NgayDat;
    }

    public Date getNgayGiao() {
        return NgayGiao;
    }

    public void setNgayGiao(Date NgayGiao) {
        this.NgayGiao = NgayGiao;
    }

    public int getTinhTrangGiao() {
        return TinhTrangGiao;
    }

    public void setTinhTrangGiao(int TinhTrangGiao) {
        this.TinhTrangGiao = TinhTrangGiao;
    }

    public int getDaThanhToan() {
        return DaThanhToan;
    }

    public void setDaThanhToan(int DaThanhToan) {
        this.DaThanhToan = DaThanhToan;
    }

    public int getPhiVanChuyen() {
        return PhiVanChuyen;
    }

    public void setPhiVanChuyen(int PhiVanChuyen) {
        this.PhiVanChuyen = PhiVanChuyen;
    }

    public int getDaXoa() {
        return DaXoa;
    }

    public void setDaXoa(int DaXoa) {
        this.DaXoa = DaXoa;
    }

    public int getDaHuy() {
        return DaHuy;
    }

    public void setDaHuy(int DaHuy) {
        this.DaHuy = DaHuy;
    }

    public int getTongTien() {
        return TongTien;
    }

    public void setTongTien(int TongTien) {
        this.TongTien = TongTien;
    }

    public String getTb_khachhang_MaKhachHang() {
        return tb_khachhang_MaKhachHang;
    }

    public void setTb_khachhang_MaKhachHang(String tb_khachhang_MaKhachHang) {
        this.tb_khachhang_MaKhachHang = tb_khachhang_MaKhachHang;
    }

}
