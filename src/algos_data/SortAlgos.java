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
public class SortAlgos {
    
    // Merge Sort the given values runs  nlogn, uses n^2 space
    // TODO: Abstract to work for <T> or write for strings
    // TODO: Determine the best list structure to use
    ArrayList<Integer> mergesort(ArrayList<Integer> list) {
        
        // number of elements in the list
        int sz = list.size();
        
        // if the size of the list is 0 or 1 it is sorted
        if (sz < 2) {
            return list;
        } 
        // Partitition the list in half, call mergesort on each half
        else {
            // first half
            ArrayList<Integer> l1 = new ArrayList<>(list.subList(0, sz/2));
            // second half
            ArrayList<Integer> l2 = new ArrayList<>(list.subList(sz/2, sz));
            
            // sort each of the lists
            l1 = mergesort(l1);
            l2 = mergesort(l2);
            
            // merge the sorted lists
            return merge(l1, l2);
        }
    }
    
    // merge the two sorted lists together to form one sorted list
    ArrayList<Integer> merge(ArrayList<Integer> l1, ArrayList<Integer> l2) {
        // sorted list we will return
        ArrayList<Integer> sorted = new ArrayList();
        
        // TODO: what if one is empty?
        while ((! l1.isEmpty()) || (! l2.isEmpty())) {
            
            // l1 is empty, add the rest of l2 to sorted
            if (l1.isEmpty()) {
                sorted.addAll(l2);
                l2.removeAll(l2);
            }
            // l2 is empty, add the rest of l1 to sorted
            else if (l2.isEmpty()) {
                sorted.addAll(l1);
                l1.removeAll(l1);
            }
            // Both still contain items, check
            else if (l1.get(0) > l2.get(0)) {
                sorted.add(l2.get(0));
                l2.remove(0);
            }
            else {
                sorted.add(l1.get(0));
                l1.remove(0);
            }
        }
        return sorted;
    }
     
    // Quicksort the given values
    // runs avg nlogn, O(n^2) uses n space
    // TODO: Abstract to work for <T> or write for strings
    // TODO: Determine the best list structure to use
    
    public int[] Quicksort(int[] lst, int begin, int end) {
        
        //TODO: choose a pivot
        // Keep track of where we are and what we are comparing
        // Parition elements arouns pivot -> do that on sublists
        
        // if bigger th
        return lst;
    }
    
}
