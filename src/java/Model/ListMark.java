/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author tranl
 */
@XmlRootElement(name = "Arraylistmark")
@XmlAccessorType(XmlAccessType.FIELD)
public class ListMark {
    @XmlElement(name = "Mark")
    private ArrayList<Mark> arr;

    public ListMark() {
        this.arr = new ArrayList<Mark>();
    }

    
    public ListMark(ArrayList<Mark> arr) {
        this.arr = arr;
    }

    public ArrayList<Mark> getArr() {
        return arr;
    }

    public void setArr(ArrayList<Mark> arr) {
        this.arr = arr;
    }

}
