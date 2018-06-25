/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enhance.pkgfor.loop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author M Rana Hossain
 */
public class EnhanceForLoop {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double[] array =  {1,2,3,410,20,7,9};
        Arrays.sort(array);
        for(double a : array){
            System.out.println(a);         
        }
         ArrayList <Integer> n = new ArrayList <>();           
                n.add(52);
                n.add(512);
                n.add(152);
                n.add(1152);
                n.add(5112);
                n.add(5222);
                n.add(552);

             Collections.sort(n);
        for(Integer i : n){
                System.out.println(i);
            }
        // TODO code application logic here
    }
    
}
