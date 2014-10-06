/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algos_data;

import java.util.ArrayList;
import java.util.Arrays;

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
        
        l2.add(1233132);
        l2.add(1);
        l2.add(23);
        l2.add(55);
        l2.add(66);
        l2.add(34);
        l2.add(45);
       
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
        
        int[] a1 = new int[] { 4, 5, 3, 5, 7, -2, 11, 42, 0};
        int[] a2 = new int[] { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        int[] a3 = new int[] { 9, 8, 7, 6, 5, -1, 4, 3, 2, 1, 0};
        
        System.out.println("MergeSort");
        System.out.println(l1);
        System.out.println(s.mergesort(l1));
        
        System.out.println("MergeSort");
        System.out.println(l2);
        System.out.println(s.mergesort(l2));
        
        System.out.println("\nQuickSort");
        System.out.println(Arrays.toString(a1));
        System.out.println(Arrays.toString(s.quicksort(a1, 0, a1.length - 1)));
                  
        System.out.println("\nQuickSort");
        System.out.println(Arrays.toString(a2));
        System.out.println(Arrays.toString(s.quicksort(a2, 0, a2.length - 1)));
        
        System.out.println("\nQuickSort");
        System.out.println(Arrays.toString(a3));
        System.out.println(Arrays.toString(s.quicksort(a3, 0, a3.length - 1)));
        
        System.out.println("\nHeapSort");
        System.out.println(l2);
        System.out.println(s.heapsort(l2));
    }

    
    
}
