/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algos_data;

/**
 * This allows us to create a Tree
 * if a child is null then it does not have a leaf
 * if a parent is null then it is a root node
 * TODO: Abstract to work for generic type T
 * @author Joseph
 */
public class Node {
    
    // TODO: make private create getter and setters?
    // TODO: construct and empty Node Structure instead of using Null
    // TODO: Abstract to be a n-tree not binary
    Node parent;
    Node leftChild;
    Node rightChild;
    int value;
    boolean empty;
    
    // Constructor for an empty first Node
    public Node() {
        parent = null;
        leftChild = null;
        rightChild = null;
        empty = true;
    }
    // Constructor for the first Node in a tree
    public Node(int val) {
        parent = null;
        leftChild = null;
        rightChild = null;
        value = val;
        empty = false;
    }
    
    // Constructor for adding a new Node to as a child to a parent
    public Node(Node par, int val) {
        parent = par;
        leftChild = null;
        rightChild = null;
        value = val;
        empty = false;
    }
    
    // Constructor when given a parent, leftChild, and right Child
    public Node(Node par, Node lChild, Node rChild, int val) {
        parent = par;
        leftChild = lChild;
        rightChild = rChild;
        value = val;
        empty = false;
    }
    
    // Is this node the root Node?
    boolean isRoot() {
        return (this.parent == null);
    }
    
    // Is this NOde Empty
    boolean isEmpty() {
        return (this.isRoot() && this.empty);
    }
    
    // Is the right Node empty/open
    boolean isRightEmpty() {
        return this.rightChild == null;
    }
    
    // Is the left Node empty/open
    boolean isLeftEmpty() {
        return this.leftChild == null;
    }
    
    
    
    
    
}
