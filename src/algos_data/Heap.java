/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package algos_data;
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
    Node binHeap = new Node();
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
        // Move the top to the last spot, remove, rebalance tree top down
    }
    
    // Merge Heap's
    
    // Find the minimum element
    void getMin() {
        // return the top element if it is not an empty heap
    }
    
    // TODO: Decrease-Key
    
    // Navigate to node to next at...
    
    // Balance the Heap
    void balanceUp(Node n) {
        // an empty Node is balanced
        if (n.isEmpty()) {
            return;
        }
        
        while(!n.parent.isRoot()) {
            // compare to parent
            if (n.value < n.parent.value) {
                // TODO: this might be pointer based and then be broken
                // Want to make a duplicate
                Node tempNode = n.parent;
                // set n to parent (assing correct children)
                n.parent.leftChild = n.leftChild;
                n.parent.rightChild = n.rightChild;
                n.parent.parent = n;
                
                // TODO: one of these will be n. make it parent... 
                // should always have a left (because Heaps are balanced)
                if (tempNode.leftChild.value == n.value) {
                    n.leftChild = n.parent;
                    n.rightChild = tempNode.rightChild;
                    n.parent = tempNode.parent;
                }
                else {
                    n.leftChild = tempNode.leftChild;
                    n.rightChild = n.parent;
                    n.parent = tempNode.parent;
                } 
            }
            // Heap is balanced
            else {
                return;
            }
        }
    }
    
    // Balance the heap from top down
    void balanceDown(Node n) {
        
    }
    
    // Is this heap empty
    boolean isEmpty() {
        return binHeap.isEmpty();
    }
    
}
