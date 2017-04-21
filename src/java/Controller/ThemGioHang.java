/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.GIOHANG_DAO;
import DAO.KHACHHANG_DAO;
import DAO.SANPHAM_DAO;
import DTO.GIOHANG;
import DTO.KHACHHANG;
import DTO.SANPHAM;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tranl
 */
public class ThemGioHang extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        
        String action = "bla bla";
        try {
            action = request.getParameter("thanhtoan");
        } catch (Exception e) {
            action = "bla bla";
        }
        String MaSanPham = request.getParameter("product");
        String SoLuong_Tem = request.getParameter("qty");
        String Email = (String) request.getSession().getAttribute("Email");

        GIOHANG_DAO gh_dao = new GIOHANG_DAO();
        KHACHHANG_DAO kh_dao = new KHACHHANG_DAO();
        KHACHHANG kh = kh_dao.getKhachHang(Email);
        SANPHAM_DAO sp_dao = new SANPHAM_DAO();
        SANPHAM sp = sp_dao.getSanPham(MaSanPham);

        // get need info
        int SoLuong = Integer.parseInt(SoLuong_Tem);
        int GiaTien = sp.getDonGia();
        String MaKhachHang = kh.getMaKhachHang();

        GIOHANG gh = new GIOHANG();
        gh.setMaKhachHang(MaKhachHang);
        gh.setSoLuong(SoLuong);
        gh.setMaSanPham(MaSanPham);

        gh_dao.ThemVaoInsertGioHang(gh);

        String new_action = "";
        try{
            new_action = new String(action.getBytes("ISO-8859-1"), "UTF-8");
        }catch(Exception e){
            
        }
                
        if (new_action.equals("Thanh Toán")) {
            RequestDispatcher rd = request.getRequestDispatcher("GioHang.jsp");
            rd.forward(request, response);
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ThemGioHang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ThemGioHang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
