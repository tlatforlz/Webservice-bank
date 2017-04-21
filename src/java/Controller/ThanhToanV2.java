/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.CHITIETDATHANG_DAO;
import DAO.DONDATHANG_DAO;
import DAO.GIOHANG_DAO;
import DAO.KHACHHANG_DAO;
import DAO.SANPHAM_DAO;
import DTO.CHITIETDATHANG;
import DTO.DONDATHANG;
import DTO.GIOHANG;
import DTO.KHACHHANG;
import DTO.SANPHAM;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
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
public class ThanhToanV2 extends HttpServlet {

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
        String shipfirstname = request.getParameter("shipfirstname");
        String shiplastname = request.getParameter("shiplastname");
        String shipstreet = request.getParameter("shipstreet");
        String shipregion = request.getParameter("shipregion");
        String shipphone = request.getParameter("shipphone");
        String address = request.getParameter("address");
        String ordercomment = request.getParameter("ordercomment");
        String method = request.getParameter("method");
        String Email = (String) request.getSession().getAttribute("Email");
        KHACHHANG_DAO kh_dp = new KHACHHANG_DAO();
        KHACHHANG kh = kh_dp.getKhachHang(Email);

        GIOHANG_DAO gh_dp = new GIOHANG_DAO();
        ArrayList<GIOHANG> list_gh = new ArrayList<GIOHANG>();

        String MaDonHang = request.getParameter("madonhang");

        CHITIETDATHANG_DAO ct_dp = new CHITIETDATHANG_DAO();

        DONDATHANG_DAO dh_dp = new DONDATHANG_DAO();
        DONDATHANG dh = dh_dp.getDonDatHang(MaDonHang);
        CHITIETDATHANG_DAO ct_cp = new CHITIETDATHANG_DAO();
        ArrayList<CHITIETDATHANG> list_ct = ct_cp.getListCT(MaDonHang);
        for (CHITIETDATHANG ct : list_ct) {
            GIOHANG gh = new GIOHANG();
            gh.setMaKhachHang(kh.getMaKhachHang());
            gh.setMaSanPham(ct.getTb_sanpham_MaSanPham());
            gh.setSoLuong(ct.getSoLuong());
            list_gh.add(gh);
        }
        request.getSession().setAttribute("DonDatHang", dh);
        request.getSession().setAttribute("DanhSachChiTiet", list_ct);
        RequestDispatcher rd = request.getRequestDispatcher("nganhang.jsp");
        rd.forward(request, response);

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
            Logger.getLogger(ThanhToanV2.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ThanhToanV2.class.getName()).log(Level.SEVERE, null, ex);
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
