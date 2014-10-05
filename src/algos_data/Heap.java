/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package algos_data;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * This will represent a Heap data structure
 * The first implementation will be a binary Heap
 * and it will be highest priority based
 * TODO: Fib Heap
 * @author Joseph
 */
public class Heap {
    
    // TODO: always want to know where the last element is
    // TODO: Should this be in an array?
    ArrayList<Integer> binHeap = new ArrayList();
    // Current Number of items stored in the Bin Heap
    // This should be the size of the hashmap... (Needed?)
    int size = 0;
    
    // TODO: HashMap to prevent adding duplicates
    // Update on add or delete
    HashMap<Integer, Integer> values = new HashMap();
    
    // Insert into the Heap
    boolean insert(Integer val) {
        // check if we already store this value (Heaps only store one of each val)
        if (values.containsKey(val)) {
            return false;
        }
        // insert Node at the next position and call balance on it
        else {
            binHeap.add(val);
            // Balance up from the one we added
            balanceUp(binHeap.size() - 1);
            values.put(val, 1);
            return true;
        }
        
    }
    
    // Delete-min from Heap
    void deleteMin() {
        // If empty, no min
        // TODO: maybe through and exception
        if (this.isEmpty()) {
            throw new IllegalArgumentException("ERROR: Heap is empty");
        }
        else {
            
            int lastElement = binHeap.size() - 1;
            // Put the last element at the head
            binHeap.set(0, binHeap.get(lastElement));
            
            // Delete the last element
            binHeap.remove(lastElement);
            
            // Rebalance
            balanceDown();       
        }
    }
    
    // Merge Heap's
    
    // Find the minimum element
    int getMin() {
        if (!this.isEmpty()) {
            return binHeap.get(0);
        }
        // Throw exception
        else
        {
            throw new IllegalArgumentException("ERROR: Heap is empty");
        }
    }
    
    // return a sorted list from the heap
    ArrayList<Integer> sort() {
        
        ArrayList<Integer> copy = binHeap;
        ArrayList<Integer> sorted = new ArrayList();
        
        while (!binHeap.isEmpty()) {
            sorted.add(getMin());
            deleteMin();
        }
        
        // replace what we destroyed
        binHeap = copy;
        
        // Return sorted
        return sorted;
    }
    
    // Balance the Heap
    void balanceUp(int index) {
        // TODO: Index should be in scope of size -1
        
        // Keep looping until at root node
        while(index != 0) {
            
            // Get the parent Index
            int parent = getParent(index);
            
            // if the child is greater than the parent swap values
            if (binHeap.get(index) < binHeap.get(parent)) {
                // swap index and parent
                swap(index, parent); 
                // Update the index to new location and continue up
                index = parent;   
            }
            // The Heap is balanced/sorted
            else {
                return;
            }    
        }  
    }
    
    // Balance the heap from top down
    void balanceDown() {
        
        // Start at the top and balance down
        int curIndex = 0;
        
        int heapSize = binHeap.size();
        
        // Loop while in the bounds of the children!
        // TODO: can I abstract and shorten?
        while (2 * curIndex + 1 <= heapSize) {
            Integer curVal = binHeap.get(curIndex);    // value at current index
            int leftInd = 2 * curIndex + 1;            // index of left child
            int rightInd = 2 * curIndex + 2;           // index of right child
            Integer leftChild = binHeap.get(leftInd);  // value of left child
            Integer rightChild = binHeap.get(rightInd); // value of right child
            
            
            if (curVal < leftChild){
                if (curVal < rightChild) {
                    // it is balanced
                    return;
                } // right is smaller, but left is not
                else {
                    // swap with right
                    swap(curIndex, rightInd);
                    curIndex = rightInd;
                }
            } // only left value is smaller than current
            else if (curVal < rightChild){
                // swap with left
                swap(curIndex, leftInd);    
                curIndex = leftInd;
                }
            else // Both are smaller, but the smallest one at the top 
            {
                // left is smaller than right
                if (leftChild < rightChild) {
                    // swap the left
                    swap(curIndex, leftInd);    
                    curIndex = leftInd;
                }
                // right is smaller than left
                else {
                    // swap with right
                    swap(curIndex, rightInd);
                    curIndex = rightInd;
                }
            }
        }
        // Special case on even sized arraylist
        // TODO: can I cover this in for loop
        if (heapSize % 2 == 0){
            // compare the last element and it's parent
            int last = heapSize - 1;
            int parent = getParent(last);
            
            if (binHeap.get(last) < binHeap.get(parent)) {
                // swap the parent and last element
                swap(last, parent);
            }
            
        }
        
    }
    
    // Is this heap empty
    boolean isEmpty() {
        return binHeap.isEmpty();
    }
    
    // Gets the location (index) of the parent of this element
    int getParent(int index) {
        if ((index % 2) == 0) {
               return (index/2 - 1);
            }
            else { 
               return index/2 ;
            }
    }
    
    // TODO: MAKE SWAP FUNCTION (make sure within range)
    void swap(int index1, int index2) {
        
        // temp store 
        Integer i2 = binHeap.get(index2);
        
        // swap values
        binHeap.set(index2, binHeap.get(index1));
        binHeap.set(index1, i2);
    }
    
}
