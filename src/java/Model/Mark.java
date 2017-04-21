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
@XmlRootElement(name = "Mark")
@XmlAccessorType (XmlAccessType.FIELD)
public class Mark {
    private String studentCode;
    private int semester;
    private int year;
    private String subjectCode;
    private String subjectName;
    private float markSubject;

    public Mark() {
    }

    public Mark(String studentCode, int semester, int year, String subjectCode, String subjectName, float markSubject) {
        this.studentCode = studentCode;
        this.semester = semester;
        this.year = year;
        this.subjectCode = subjectCode;
        this.subjectName = subjectName;
        this.markSubject = markSubject;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public float getMarkSubject() {
        return markSubject;
    }

    public void setMarkSubject(float markSubject) {
        this.markSubject = markSubject;
    }
}
