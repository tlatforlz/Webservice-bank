/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.rest;

import Model.AllMark;
import Model.ListMark;
import Model.Mark;
import Model.Student;
import Model.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author tranl
 */
public class DBUtils {

    public static Connection makeConnection() throws ClassNotFoundException {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //jdbc:mysql://localhost:3306/db_student?zeroDateTimeBehavior=convertToNull
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_nganhang?zeroDateTimeBehavior=convertToNull", "root", "root");
            return con;
        } catch (SQLException ex) {
        }
        return null;
    }

    public static boolean checkThongTin(User us) throws ClassNotFoundException, SQLException {
        Connection con = makeConnection();
        boolean check = false;
        String sql = "select count(ID) from tb_taikhoan WHERE SoThe = '" + us.getSoThe() + "' and MatKhau = '" + us.getMatKhau() + "' and TenTaiKhoan = '" + us.getTenTaiKhoan() + "' and NgayTaoThe = '" + us.getNgayTaoThe() + "'";
        PreparedStatement stm = con.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();
        if (rs.next()) {
            int count = rs.getInt(1);
            if (count == 1) {
                check = true;
            }
        }
        con.close();
        return check;
    }

    public static User returnUser(String SoThe) throws ClassNotFoundException, SQLException {
        Connection con = makeConnection();
        String sql = "SELECT * FROM tb_taikhoan WHERE SoThe = '" + SoThe + "'";
        PreparedStatement stm = con.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();
        User us = new User();
        if (rs.next()) {
            int ID = rs.getInt("ID");
            String MatKhau = rs.getString("MatKhau");
            String TenTaiKhoan = rs.getString("TenTaiKhoan");
            String NgayTaoThe = rs.getString("NgayTaoThe");
            int SoDu = rs.getInt("SoDu");
            us.setID(ID);
            us.setSoThe(SoThe);
            us.setMatKhau(MatKhau);
            us.setNgayTaoThe(NgayTaoThe);
            us.setTenTaiKhoan(TenTaiKhoan);
            us.setSoDu(SoDu);
        }
        con.close();
        return us;
    }

    public static boolean CheckSoDu(String SoThe, int SoTien) throws ClassNotFoundException, SQLException {
        boolean check = false;
        User us = returnUser(SoThe);
        check = us.getSoDu() - SoTien >= 50000;
        return check;
    }

    public static void updateUser(User us) throws ClassNotFoundException, SQLException {
        Connection con = makeConnection();
        String sql = "update tb_taikhoan set SoDu = '" + us.getSoDu() + "' WHERE ID = " + us.getID();
        PreparedStatement stm = con.prepareStatement(sql);
        stm.executeUpdate();
        con.close();
    }

    public static void updateHistory(User us, String MaGiaoDich, String LoaiGiaoDich, int SoTien) throws ClassNotFoundException, SQLException {
        Connection con = makeConnection();
        String sql = "INSERT INTO tb_lichsugiaodich(SoTaiKhoan,MaGiaoDich,LoaiGiaoDich,SoTien) VALUES (?,?,?,?)";
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, us.getSoThe());
        stm.setString(2, MaGiaoDich);
        stm.setString(3, LoaiGiaoDich);
        stm.setInt(4, SoTien);
        stm.executeUpdate();
        con.close();
    }

    public static int getMoney(String MaGiaoDich) throws ClassNotFoundException, SQLException {
        Connection con = makeConnection();
        String sql = "SELECT * FROM tb_lichsugiaodich WHERE MaGiaoDich = '" + MaGiaoDich + "'";
        PreparedStatement stm = con.prepareStatement(sql);
        ResultSet rs = stm.executeQuery(sql);
        int SoTien = 0;
        if (rs.next()) {
            SoTien = rs.getInt("SoTien");
        }
        con.close();
        return SoTien;
    }

    public static String getSoThe(String MaGiaoDich) throws ClassNotFoundException, SQLException {
        Connection con = makeConnection();
        String sql = "SELECT * FROM tb_lichsugiaodich WHERE MaGiaoDich = '" + MaGiaoDich + "'";
        PreparedStatement stm = con.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();
        String SoThe = "";
        if (rs.next()) {
            SoThe = rs.getString("SoTaiKhoan");
        }
        con.close();
        return SoThe;
    }

    public static void addMoney(String MaGiaoDich) throws SQLException, ClassNotFoundException {
        Connection con = makeConnection();
        int SoTien = getMoney(MaGiaoDich);
        User us = returnUser(getSoThe(MaGiaoDich));
        updateHistory(us, MaGiaoDich, "Huy don hang", SoTien);
        String sql = "UPDATE tb_taikhoan SET SoDu = " + (us.getSoDu() + SoTien) + " WHERE SoThe = '" + us.getSoThe() + "'";
        PreparedStatement stm = con.prepareStatement(sql);
        stm.executeUpdate();
        con.close();

    }

    public static boolean checkLogin(String username, String password) throws ClassNotFoundException, SQLException {
        Connection con = makeConnection();
        PreparedStatement stm = null;
        ResultSet rs = null;
        String sql = "select * from tb_student where student_code = ? and password = ?";
        stm = con.prepareStatement(sql);
        stm.setString(1, username);
        stm.setString(2, password);
        rs = stm.executeQuery();
        if (rs.next()) {
            return true;
        }
        return false;
    }

    public static Student informationStudent(String studentCode) throws ClassNotFoundException, SQLException {
        Connection con = makeConnection();
        PreparedStatement stm = null;
        ResultSet rs = null;
        String sql = "select * from tb_student where student_code = ?";
        stm = con.prepareStatement(sql);
        stm.setString(1, studentCode);
        rs = stm.executeQuery();
        Student st = new Student();
        if (rs.next()) {
            String studentName = rs.getString("lastname");
            String studentClass = rs.getString("class");
            String department = rs.getString("department");
            String faculty = rs.getString("faculty");
            String traning_system = rs.getString("training_system");
            String course = rs.getString("course");

            st.setCourse(course);
            st.setStudentClass(studentClass);
            st.setStudentCode(studentCode);
            st.setStudentDepartment(department);
            st.setStudentFaculty(faculty);
            st.setStudentName(studentName);
            st.setTraning_system(traning_system);
        }
        return st;
    }

    public static ListMark studentMark(String studentCode, String Semester, String Year) throws ClassNotFoundException, SQLException {
        ArrayList<Mark> arr = new ArrayList<Mark>();
        Connection con = makeConnection();
        PreparedStatement stm = null;
        ResultSet rs = null;
        String sql = "select * from tb_studentmark where student_code = ? and Semester = ? and Year_course = ?";
        stm = con.prepareStatement(sql);
        stm.setString(1, studentCode);
        stm.setString(2, Semester);
        stm.setString(3, Year);
        rs = stm.executeQuery();
        while (rs.next()) {
            String subjectCode = rs.getString("Subject_code");
            String subject = rs.getString("Subject_name");
            float mark = rs.getFloat("mark");
            Mark st = new Mark(studentCode, Integer.parseInt(Semester), Integer.parseInt(Year), subjectCode, subject, mark);
            arr.add(st);
        }
        ListMark temp = new ListMark(arr);
        return temp;

    }

    public static ListMark studentMarkMax(String studentCode) throws ClassNotFoundException, SQLException {
        ArrayList<Mark> arr = new ArrayList<Mark>();
        Connection con = makeConnection();
        PreparedStatement stm = null;
        ResultSet rs = null;
        String sql = "select max(Semester), max(Year_course) from tb_studentmark where student_code = ?";
        stm = con.prepareStatement(sql);
        stm.setString(1, studentCode);

        rs = stm.executeQuery();
        String max_Semester = "";
        String max_Yearcourse = "";
        if (rs.next()) {
            max_Semester = rs.getString(1);
            max_Yearcourse = rs.getString(2);
        }
        ListMark temp = DBUtils.studentMark(studentCode, max_Semester, max_Yearcourse);
        return temp;

    }

    public static AllMark viewAllSemesters(String studentCode) throws ClassNotFoundException, SQLException {
        AllMark arr = new AllMark();
        Connection con = makeConnection();
        PreparedStatement stm = null;
        ResultSet rs = null;
        String sql = "select distinct Semester, Year_course from tb_studentmark where student_code = ?";
        stm = con.prepareStatement(sql);
        stm.setString(1, studentCode);
        rs = stm.executeQuery();
        while (rs.next()) {
            String semester = rs.getString(1);
            String year = rs.getString(2);
            ListMark st = DBUtils.studentMark(studentCode, semester, year);
            arr.getArr().add(st);
        }
        return arr;
    }
}
