/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.rest;

import Model.AllMark;
import Model.ListMark;
import Model.Student;
import Model.User;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author tranl
 */
@Path("generic")
public class GenericResource {

    @Context
    private UriInfo context;

    public GenericResource() {
    }

    @Path("/checkUser")
    @GET    
    @Produces(MediaType.TEXT_PLAIN)
    public String checkUser(
            @QueryParam("SoThe") String SoThe,
            @QueryParam("MatKhau") String MatKhau,
            @QueryParam("TenTaiKhoan") String TenTaiKhoan,
            @QueryParam("NgayTaoThe") String NgayTaoThe,
            @QueryParam("SoTien") int SoTien,
            @QueryParam("MaThanhToan") String MaThanhToan) throws SQLException, ClassNotFoundException {

        User us = new User();
        us.setSoThe(SoThe);
        us.setMatKhau(MatKhau);
        us.setTenTaiKhoan(TenTaiKhoan);
        us.setNgayTaoThe(NgayTaoThe);

        boolean check = DBUtils.checkThongTin(us);
        if (check == true) {
            boolean checkSoDu = DBUtils.CheckSoDu(SoThe, SoTien);
            if (checkSoDu == true) {
                us = DBUtils.returnUser(SoThe);
                us.setSoDu(us.getSoDu()- SoTien);
                DBUtils.updateUser(us);
                DBUtils.updateHistory(us, MaThanhToan, "Thanh Toan", SoTien);
                return "true";
            }
        }
        return "false";
    }

    @Path("/returnMoney")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String Cancellation(@QueryParam("MaThanhToan") String MaThanhToan) throws SQLException, ClassNotFoundException{
        String result = "true";
        DBUtils.addMoney(MaThanhToan);
        return result;
    }
    
    
    @Path("/getUser")
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public User checkLogin(
            @QueryParam("SoThe") String SoThe) throws SQLException, ClassNotFoundException {
        User us = DBUtils.returnUser(SoThe);
        return us;
    }

    @Path("/checkRest")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String checkRest() {
        return "Hello Check RestFul";
    }

    @Path("/studentInformation")
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Student studentInformation(
            @QueryParam("studentcode") String studentCode) {
        Student st = new Student();
        try {
            st = DBUtils.informationStudent(studentCode);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GenericResource.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GenericResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return st;
    }

    @Path("/studentMark")
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public ListMark studentMark(
            @QueryParam("studentcode") String studentCode,
            @QueryParam("semester") String Semester,
            @QueryParam("year") String Year) {

        ListMark arr = new ListMark();
        try {
            arr = DBUtils.studentMark(studentCode, Semester, Year);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GenericResource.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GenericResource.class.getName()).log(Level.SEVERE, null, ex);
        }

        return arr;
    }

    @Path("/studentMarkMax")
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public ListMark studentMarkMax(
            @QueryParam("studentcode") String studentCode
    ) {
        ListMark arr = new ListMark();
        try {
            arr = DBUtils.studentMarkMax(studentCode);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(GenericResource.class.getName()).log(Level.SEVERE, null, ex);
        }

        return arr;
    }

    @Path("/viewallsemesters")
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public AllMark viewAllSemesters(
            @QueryParam("studentcode") String studentCode
    ) {
        AllMark arr = new AllMark();
        try {
            //arr = DBUtils.studentMarkMax(studentCode);
            arr = DBUtils.viewAllSemesters(studentCode);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(GenericResource.class.getName()).log(Level.SEVERE, null, ex);
        }

        return arr;
    }
}
