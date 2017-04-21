/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.ArrayList;

/**
 *
 * @author tranl
 */
public class test {

    class path{
        private int n;
        private int m;
        private ArrayList<String> list;

        public path(int n, int m, ArrayList<String> list) {
            this.n = n;
            this.m = m;
            this.list = list;
        }

        public int getN() {
            return n;
        }

        public void setN(int n) {
            this.n = n;
        }

        public int getM() {
            return m;
        }

        public void setM(int m) {
            this.m = m;
        }

        public ArrayList<String> getList() {
            return list;
        }

        public void setList(ArrayList<String> list) {
            this.list = list;
        }
    }
    
    public static int countdir(path p){
        if(p.getM() < p.getN()){
            for(int i = 0; i < p.getList().size(); i++){
                String[] list = p.getList().get(i).split("/");
                
            }
        }
        return 0;
    }
    public static void main(String[] args){
       
    }
}
