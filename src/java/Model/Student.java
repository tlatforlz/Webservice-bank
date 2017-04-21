/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author tranl
 */
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
/**
 *
 * @author tranl
 */
@XmlRootElement(name = "Student")
@XmlAccessorType (XmlAccessType.FIELD)
public class Student {

    private String studentCode;
    private String studentName;
    private String studentClass;
    private String studentDepartment;
    private String studentFaculty;
    private String traning_system;
    private String course;

    public Student() {
    }

    public Student(String studentCode, String studentName, String studentClass, String studentDepartment, String studentFaculty, String traning_system, String course) {
        this.studentCode = studentCode;
        this.studentName = studentName;
        this.studentClass = studentClass;
        this.studentDepartment = studentDepartment;
        this.studentFaculty = studentFaculty;
        this.traning_system = traning_system;
        this.course = course;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public String getStudentDepartment() {
        return studentDepartment;
    }

    public void setStudentDepartment(String studentDepartment) {
        this.studentDepartment = studentDepartment;
    }

    public String getStudentFaculty() {
        return studentFaculty;
    }

    public void setStudentFaculty(String studentFaculty) {
        this.studentFaculty = studentFaculty;
    }

    public String getTraning_system() {
        return traning_system;
    }

    public void setTraning_system(String traning_system) {
        this.traning_system = traning_system;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
    
    
}
