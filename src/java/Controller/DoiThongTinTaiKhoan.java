/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.KHACHHANG_DAO;
import DTO.KHACHHANG;
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
public class DoiThongTinTaiKhoan extends HttpServlet {

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
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String email = request.getParameter("email");
        String phone_number = request.getParameter("phone_number");
        String current_password = request.getParameter("current_password");
        String password = request.getParameter("password");
        String confirmation = request.getParameter("confirmation");

        String email_session = (String) request.getSession().getAttribute("Email");
        KHACHHANG_DAO kh_dp = new KHACHHANG_DAO();
        KHACHHANG kh = kh_dp.getKhachHang(email_session);

        boolean checkEmail = kh_dp.CheckEmail(email);
        boolean checkPhone = kh_dp.CheckPhone(phone_number);
        boolean checkPhone_dup = kh.getSoDienThoai().equals(phone_number);
        if (checkPhone == true) {
            if (checkPhone_dup == false) {
                checkPhone = true;
            } else {
                checkPhone = false;
            }
        }
        if ((checkEmail == true && email.equals(email_session) == false) && (checkPhone == true)) {
            request.setAttribute("email-error", "error");
            request.setAttribute("phone-error", "error");
            request.setAttribute("email-duplicate", email);
            request.setAttribute("phone-duplicate", phone_number);
            request.setAttribute("KhachHang", kh);
            request.setAttribute("password-error", "");
            RequestDispatcher rd = request.getRequestDispatcher("ChiTietKhachHangThongTinTaiKhoan.jsp");
            rd.forward(request, response);
        } else if (checkPhone == true) {
            request.setAttribute("email-error", "");
            request.setAttribute("phone-error", "error");
            request.setAttribute("email-duplicate", email);
            request.setAttribute("phone-duplicate", phone_number);
            request.setAttribute("KhachHang", kh);
            request.setAttribute("password-error", "");
            RequestDispatcher rd = request.getRequestDispatcher("ChiTietKhachHangThongTinTaiKhoan.jsp");
            rd.forward(request, response);
        } else if ((checkEmail == true && email.equals(email_session) == false)) {
            request.setAttribute("email-error", "error");
            request.setAttribute("phone-error", "");
            request.setAttribute("email-duplicate", email);
            request.setAttribute("phone-duplicate", phone_number);
            request.setAttribute("KhachHang", kh);
            request.setAttribute("password-error", "");
            RequestDispatcher rd = request.getRequestDispatcher("ChiTietKhachHangThongTinTaiKhoan.jsp");
            rd.forward(request, response);
        }
        if (!"".equals(current_password) && kh.getMatKhau().equals(current_password) == false) {
            request.setAttribute("email-error", "");
            request.setAttribute("phone-error", "");
            request.setAttribute("email-duplicate", email);
            request.setAttribute("phone-duplicate", phone_number);
            request.setAttribute("KhachHang", kh);
            request.setAttribute("password-error", "error");
            RequestDispatcher rd = request.getRequestDispatcher("ChiTietKhachHangThongTinTaiKhoan.jsp");
            rd.forward(request, response);
        }
        String lastname_utf8 = new String(lastname.getBytes("ISO-8859-1"), "UTF-8");
        String firstname_utf8 = new String(firstname.getBytes("ISO-8859-1"), "UTF-8");
        kh.setHoKhachHang(lastname_utf8);
        kh.setTenKhachHang(firstname_utf8);
        kh.setEmail(email);
        kh.setMaKhachHang(password);
        kh.setSoDienThoai(phone_number);
        request.setAttribute("email-error", "success");
        request.setAttribute("phone-error", "");
        request.setAttribute("email-duplicate", email);
        request.setAttribute("phone-duplicate", phone_number);
        request.setAttribute("KhachHang", kh);
        request.setAttribute("password-error", "");
        request.getSession().setAttribute("Email", email);
        kh_dp.UpdateKhachHang(kh);
        RequestDispatcher rd = request.getRequestDispatcher("ChiTietKhachHangThongTinTaiKhoan.jsp");
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
            Logger.getLogger(DoiThongTinTaiKhoan.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(DoiThongTinTaiKhoan.class.getName()).log(Level.SEVERE, null, ex);
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
