/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algos_data;

/**
 *
 * @author Joseph
 */
public class BinarySearch {
    
    // TODO: Make unit tests...
    // perform binary search on the given array with the given high and low
    public boolean BinarySearch(int[] arr, int high, int low, int given) {
        
        // mid point we will use for ref for Bin search parition
        int mid = (high + low)/2;
        //TODO: check that high is not >= size of array or low < 0
        
        // we have not found the item
        if (arr[high] < arr[low]) {
            return false;
        }
        // we have found the element
        else if (arr[mid] == given){
            return true;
        }
        // look into the top half
        else if (given > arr[mid]) {
            BinarySearch(arr, mid, high, given);
        }
        // look in the bottom half
        else if (given < arr[mid]) {
            BinarySearch(arr, low, mid, given);
        }
        else {
            //Don't know why it would get here
            throw new IllegalArgumentException("ERROR: Binary Search");
        }
        
        // Should not get here either
        return false;
    }
            
    
}
