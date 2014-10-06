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
    public int[] quicksort(int[] lst, int begin, int end) {
        // Make sure the begin and end are within bounds
        if ((begin < 0) || (end >= lst.length)) {
            throw new IllegalArgumentException("ERROR: Invalid begin/end bounds");
        }
        // if the length is 0 or 1 it is sorted
        else if (lst.length < 2) {
            return lst;
        }
        // choose a pivot -> as first element (naive approach)
        // TODO: improve pivot choice w/ helper
        
        if (begin < end) {
            int piv = begin;
            // Partition the given array
            piv = quickPartition(lst, begin, end, piv);
        
            // Quick sort everything below the pivot
            quicksort(lst, begin, piv - 1);
            // quiclsort everything above the pivot
            quicksort(lst, piv + 1 , end);
        }
        
        // return sorted array
        return lst;
    }
    
    // Returns the index of the pivot, after we have quicksorted
    int quickPartition(int[] lst, int begin, int end, int piv) {
        
        int pivVal = lst[piv];      // Value of the pivot
        int curIndex = begin;       // CurIndex we are comparing
        
        // if the pivot is the currentIndex to start, move to the next one 
        if (curIndex == piv) {
            curIndex++;
        }
        // Make sure the begin and end are within bounds
        if ((begin < 0) || (end >= lst.length)) {
            throw new IllegalArgumentException("ERROR: Invalid begin/end bounds");
        }
        // if the length is 0 or 1 it is sorted
        else if (lst.length < 2) {
            return 0;
        }
        
        
        // Loop to the from begin to end
        while(curIndex <= end) {
           // if the index we are comparing is to the right of the current pivot
            if (curIndex < piv) {
                // swap if t
                if (lst[curIndex] >= pivVal) {
                // Swap values, increase piv index
                lst[piv] = lst[curIndex];
                lst[curIndex] = pivVal;
                piv++;
               }
            }
            // if the index is to the left of the pivot
            else if (curIndex > piv) {
               // swap if they are not in correct order
               if (lst[curIndex] < pivVal) {
                // Swap smaller value with one after piv
                int temp = lst[piv + 1];
                lst[piv + 1] = lst[curIndex];
                lst[curIndex] = temp;

                // swap piv with that and increment pivot
                lst[piv] = lst[piv + 1];
                lst[piv + 1] = pivVal;
                piv++;                 
               }
            }
           
            // Move onto the next index to check
            curIndex++;
        }   
        // return the pivots final location
        return piv;
    }
    
}
