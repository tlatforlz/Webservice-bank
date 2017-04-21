/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.BINHLUAN_DAO;
import DAO.KHACHHANG_DAO;
import DAO.SANPHAM_DAO;
import DTO.BINHLUAN;
import DTO.KHACHHANG;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
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
public class ThemBinhLuan extends HttpServlet {

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
        String Email = (String) request.getSession().getAttribute("Email");
        if (Email == null) {
            RequestDispatcher rd = request.getRequestDispatcher("ThongTinTaiKhoan?KhachHang=null");
            rd.forward(request, response);
        } else {
            String NoiDung_f = request.getParameter("detail");
            String TieuDe_f = request.getParameter("title");
            String NoiDung = new String(NoiDung_f.getBytes("ISO-8859-1"), "UTF-8");
            String TieuDe = new String(TieuDe_f.getBytes("ISO-8859-1"), "UTF-8");
            String ID_s = request.getParameter("product_id");
            int ID = Integer.parseInt(ID_s);
            SANPHAM_DAO sp_dp = new SANPHAM_DAO();
           String product_ma = request.getParameter("product_ma");
            KHACHHANG_DAO kh_dp = new KHACHHANG_DAO();
            KHACHHANG kh = kh_dp.getKhachHang(Email);

            int ID_kh = kh.getID();
            
            BINHLUAN_DAO bl_dp = new BINHLUAN_DAO();
            BINHLUAN bl = new BINHLUAN();
            bl.setTieuDe(TieuDe);

            bl.setNoiDung(NoiDung);
            bl.setTb_sanpham_ID(ID);
            bl.setTb_khachhang_ID(ID_kh);
            bl.setMaBinhLuan("MBL" + (bl_dp.getCount() + 1));
            bl_dp.Insert_BinhLuan(bl);
            RequestDispatcher rd = request.getRequestDispatcher("ChiTietSanPham?MaSanPham=" + product_ma);
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
            Logger.getLogger(ThemBinhLuan.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(ThemBinhLuan.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ThemBinhLuan.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(ThemBinhLuan.class.getName()).log(Level.SEVERE, null, ex);
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
