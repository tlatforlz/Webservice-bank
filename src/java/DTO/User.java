/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author tranl
 */
@XmlRootElement(name = "User")
@XmlAccessorType (XmlAccessType.FIELD)
public class User {
    private int ID;
    private String SoThe;
    private String MatKhau;
    private String TenTaiKhoan;
    private String NgayTaoThe;
    private int SoDu;

    public User() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getSoThe() {
        return SoThe;
    }

    public void setSoThe(String SoThe) {
        this.SoThe = SoThe;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

    public String getTenTaiKhoan() {
        return TenTaiKhoan;
    }

    public void setTenTaiKhoan(String TenTaiKhoan) {
        this.TenTaiKhoan = TenTaiKhoan;
    }

    public String getNgayTaoThe() {
        return NgayTaoThe;
    }

    public void setNgayTaoThe(String NgayTaoThe) {
        this.NgayTaoThe = NgayTaoThe;
    }

    public int getSoDu() {
        return SoDu;
    }

    public void setSoDu(int SoDu) {
        this.SoDu = SoDu;
    }
       
}

