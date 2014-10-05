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
    boolean insert(int val) {
        // check if we already store this value (Heaps only store one of each val)
        if (values.containsKey(val)) {
            return false;
        }
        // insert Node at the next position and call balance on it
        //else ()
        return true;
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
    
    // TODO: Decrease-Key
    
    // Navigate to node to next at...
    
    // Balance the Heap
    void balanceUp(int index) {
        // TODO: Index should be in scope of size -1
        
        // Keep looping until at root node
        while(index != 0) {
            
            // Get the parent Index
            int parent = getParent(index);
            
            // if the child is greater than the parent swap values
            if (binHeap.get(index) < binHeap.get(parent)) {
                // capture temp value
                Integer tempPar = binHeap.get(parent);
                // Set parent value to child value
                binHeap.set(parent, binHeap.get(index));
                binHeap.set(index, tempPar);
                
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
            Integer curVal = binHeap.get(curIndex);
            Integer leftChild = binHeap.get(2 * curIndex + 1);
            Integer rightChild = binHeap.get(2 * curIndex + 2);
            
            if (curVal < leftChild){
                if (curVal < rightChild) {
                    // it is balanced
                    return;
                }
                else {
                    // swap with right
                    binHeap.set(curIndex, rightChild);
                    binHeap.set(2 * curIndex + 2, curVal);
                    curIndex = 2 * curIndex + 2;
                }
            } // only less than right child
            else if (curVal < rightChild){
                    // swap with left
                    binHeap.set(curIndex, leftChild);
                    binHeap.set(2 * curIndex + 1, curVal);
                    curIndex = 2 * curIndex + 1;
                }
            else // Both are smaller, but the smallest one at the top 
            {
                if (leftChild < rightChild) {
                    // swap the left
                    binHeap.set(curIndex, leftChild);
                    binHeap.set(2 * curIndex + 1, curVal);
                    curIndex = 2 * curIndex + 1;
                }
                else {
                    // swap with right
                    binHeap.set(curIndex, rightChild);
                    binHeap.set(2 * curIndex + 2, curVal);
                    curIndex = 2 * curIndex + 2;
                }
            }
        }
        // Special case on even sized arraylist
        // TODO: can I cover this in for loop
        // TODO: can I abstract this
        if (heapSize % 2 == 0){
            // compare the last element and it's parent
            int last = heapSize - 1;
            int parent = getParent(last);
            
            if (binHeap.get(last) < binHeap.get(parent)) {
                // capture temp value
                Integer tempPar = binHeap.get(parent);
                // Set parent value to child value
                binHeap.set(parent, binHeap.get(last));
                binHeap.set(last, tempPar);
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
}
