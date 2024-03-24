 // File Name: TreeNode.java
// Date Edited: 03/14/2024
// Name: Keegan Baker
// Project: CS 145 Lab 6
// Purpose: This class holds data pointers to its parent and children nodes
//////////////////////////////////////////////////////////////////////////////////////////////////
 
 public class TreeNode {
    
    // Data stored in the node
    String firstName;
    String lastName;
    String address;
    String email;
    String phoneNumber;

    // References to the previous, and next nodes in the tree
    TreeNode parent;
    TreeNode leftChild;
    TreeNode rightChild;

    // Constructor initializes the node with data and references
    public TreeNode
    (String firstName, String lastName, String address, String email, 
    String phoneNumber, TreeNode parent, TreeNode leftChild, TreeNode rightChild) {

        // data
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;

        // references
        this.parent = parent;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }


    // Method prints the data in it's node
    public void display() {
        System.out.printf("%s %s%nAdress: %s%nEmail: %s%nPhone Number: %s%n",
        firstName, lastName, address, email, phoneNumber);
    }
 }