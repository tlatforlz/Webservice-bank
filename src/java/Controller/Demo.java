/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.CHITIETDATHANG_DAO;
import DAO.DONDATHANG_DAO;
import java.sql.SQLException;
import java.text.ParseException;

/**
 *
 * @author tranl
 */
public class Demo {

    public static void main(String[] args) throws SQLException, ParseException {
        CHITIETDATHANG_DAO ct_dp = new CHITIETDATHANG_DAO();
        DONDATHANG_DAO dh_dp = new DONDATHANG_DAO();
        boolean check = dh_dp.checkDonHang("KH1-22");
        if(check == true){
            System.out.println("Don hang da ton tai");
        }
    }
}
