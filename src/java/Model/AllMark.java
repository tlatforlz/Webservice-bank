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
 * 
 *
 */
@XmlRootElement(name = "AllMark")
@XmlAccessorType(XmlAccessType.FIELD)
public class AllMark {
    @XmlElement(name="Arraylistmark")
    private ArrayList<ListMark> arr;

    public AllMark() {
        this.arr = new ArrayList<ListMark>();
    }

    public AllMark(ArrayList<ListMark> arr) {
        this.arr = arr;
    }

    public ArrayList<ListMark> getArr() {
        return arr;
    }

    public void setArr(ArrayList<ListMark> arr) {
        this.arr = arr;
    }
    
    
}
