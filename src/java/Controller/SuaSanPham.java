/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.SANPHAM_DAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Random;
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
public class SuaSanPham extends HttpServlet {

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
            throws ServletException, IOException, SQLException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        String MaSanPham = request.getParameter("MaSanPham");

        String name_utf8 = request.getParameter("sp_name");
        String sp_Name = new String(name_utf8.getBytes("ISO-8859-1"), "UTF-8");

        String sp_Loai[] = request.getParameterValues("sp_loai");
        String sp_NhaSanXuat = request.getParameter("sp_nhasanxuat");

        String mota_utf8 = request.getParameter("sp_mota");

        String sp_MoTa = new String(mota_utf8.getBytes("ISO-8859-1"), "UTF-8");
        String sp_GiaTien = request.getParameter("sp_giatien");
        String sp_GiamGia = request.getParameter("sp_giamgia");
        String sp_AnhChinh = request.getParameter("link-image");
        String sp_ListAnh = request.getParameter("link-image-full");

        String[] ListAnh = sp_ListAnh.split(",");
        SANPHAM_DAO sp_dao = new SANPHAM_DAO();

        // xoa san pham
        // xoa danh sach loai
        // xoa kho anh
        sp_dao.XoaKhoAnh(MaSanPham);
        sp_dao.XoaLoaiSanPham(MaSanPham);
        sp_dao.XoaSanPham(MaSanPham);

        // insert lai
        sp_dao.insert_SP(MaSanPham, sp_Name, Integer.parseInt(sp_GiaTien), Integer.parseInt(sp_GiamGia), sp_MoTa, sp_NhaSanXuat);       
        sp_dao.insert_LoaiSanPham(sp_Loai, MaSanPham);
        sp_dao.insert_khoAnh(MaSanPham, sp_AnhChinh, ListAnh);
//        request.setAttribute("sp_name", sp_Name);
//        request.setAttribute("sp_loai", sp_Loai);
//        request.setAttribute("sp_nhasanxuat", sp_NhaSanXuat);
//        request.setAttribute("sp_mota", sp_MoTa);
//        request.setAttribute("sp_giatien", sp_GiaTien);
//        request.setAttribute("sp_giamgia", sp_GiamGia);
//        request.setAttribute("sp_anhchinh", sp_AnhChinh);
//        request.setAttribute("sp_listanh", ListAnh);

        RequestDispatcher rd = request.getRequestDispatcher("web-admin/DanhSachSanPham.jsp");
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
            Logger.getLogger(SuaSanPham.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(SuaSanPham.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(SuaSanPham.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(SuaSanPham.class.getName()).log(Level.SEVERE, null, ex);
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
