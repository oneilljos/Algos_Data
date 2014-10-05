/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algos_data;

import java.util.ArrayList;

/**
 *
 * @author Joseph
 */
public class Algos_Data {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    
    
        SortAlgos s = new SortAlgos();

        ArrayList<Integer>  l1 = new ArrayList();
        ArrayList<Integer>  l2 = new ArrayList();
        ArrayList<Integer>  l3 = new ArrayList();
        ArrayList<Integer>  l4 = new ArrayList();

        int i = 0;
        while ( i < 3 ) {
            l1.add(1);
            l1.add(23);
            l1.add(34);
            l1.add(45);
            l1.add(55);
            l1.add(66);

            i++;
        }
        
        System.out.println(l1);
        System.out.println(s.mergesort(l1));
    }

    
    
}
