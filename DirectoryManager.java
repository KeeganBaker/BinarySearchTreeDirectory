// File Name: DirectoryManager.java
// Date Edited: 03/17/2024
// Name: Keegan Baker
// Project: CS 145 Lab 6
// Purpose: This class holds a binary search tree, and houses the functions used to modify
//          and display the BST.
//////////////////////////////////////////////////////////////////////////////////////////////////

import java.util.Scanner;

public class DirectoryManager {
    Scanner sc = new Scanner (System.in);

    TreeNode root; // base of the tree (first node)
    
    // Method adds a new node to the direcotry
    public void add() {

        System.out.print("First name: ");
        String firstName = sc.nextLine();

        System.out.print("Last name: ");
        String lastName = sc.nextLine();
        
        System.out.print("Address: ");
        String address = sc.nextLine();

        System.out.print("Email: ");
        String email = sc.nextLine();

        System.out.print("Phone number: ");
        String phoneNumber = sc.nextLine();

        TreeNode newNode = new TreeNode(firstName, lastName, address, email, 
        phoneNumber, null, null, null);

        // determine where to put the node
        placeNode(newNode);
    }



    // Method navigates tree and places newNode
    public void placeNode (TreeNode newNode) {
        
        if (root == null) {
            root = newNode;
            return;
        }

        TreeNode temp = root;
        while (true) {
            // newNode is later alphabetically
            if (newNode.lastName.compareTo(temp.lastName) < 0) {
                if (temp.rightChild == null) {
                    temp.rightChild = newNode;
                    newNode.parent = temp;
                    return;
                }
                // replace the right child if newNode is earlier alphabetically 
                else if (newNode.lastName.compareTo(temp.rightChild.lastName) > 0) {
                    temp.rightChild.parent = newNode;
                    newNode.rightChild = temp.rightChild;
                    newNode.parent = temp;
                    return;
                }
                temp = temp.rightChild;
            }
            // newNode is sooner alphabetically
            else if (newNode.lastName.compareTo(temp.lastName) > 0) {
                if (temp.leftChild == null) {
                    temp.leftChild = newNode;
                    return;
                }
                else if (newNode.lastName.compareTo(temp.leftChild.lastName) < 0) {
                    temp.leftChild.parent = newNode;
                    newNode.leftChild = temp.leftChild;
                    newNode.parent = temp;
                    return;
                }
                temp = temp.leftChild;
            }
        }
    } // end placeNode



    // User confirmation of deletion
    public void confirmDelete() {

        if (this.root == null) { // message if directory is empty
            System.out.println("***  !! Directory is empty !!  ***");
            System.out.println("***  please create a new entry ***");
            return;
        }


        System.out.print("Enter last name of entry to be deleted: ");
        String lastName = sc.nextLine();
        TreeNode deletedNode = find(lastName);
        if (deletedNode == null) { // contact not found
            return;
        }

        // user confirmation of node to be deleted
        System.out.printf("Delete %s %s from the directory? %nC to confirm: ", 
        deletedNode.firstName, deletedNode.lastName);
        char confirm = sc.next().charAt(0);

        switch (confirm) {
            case 'C':
            case 'c':
            break;
            default:
            return;
        }
        delete(root, lastName);
    }



    // Recursive method to delete a node using given last name
    public TreeNode delete (TreeNode deletedNode, String lName) {
        
        deletedNode = find (lName); // find the deleted node
        
        // case 1: leaf node
        if (deletedNode.leftChild == null && deletedNode.rightChild == null){
            deletedNode = null;
            return deletedNode;
        }

        // case 2: node has one child
        else if (deletedNode.leftChild == null) {
            TreeNode temp1 = deletedNode;
            deletedNode = deletedNode.rightChild;
            deletedNode.parent = temp1.parent;
            return deletedNode;
        }
        else if (deletedNode.rightChild == null) {
            TreeNode temp1 = deletedNode;
            deletedNode = deletedNode.leftChild;
            deletedNode.parent = temp1.parent;
            return deletedNode;
        }

        else {
            // case 3: node has two children
            TreeNode successor = getSuccessor(deletedNode); // find min in right subtree
            changeData(deletedNode, successor); // change data to min in right subtree
            // recursion adjusts the entire right subtree
            deletedNode.rightChild = delete(deletedNode.rightChild, lName);
        }
        return deletedNode;
    }



    // Method changes data between two given nodes (used in deletion)
    public void changeData(TreeNode initialNode, TreeNode newNode) {
        initialNode.firstName = newNode.firstName;
        initialNode.lastName = newNode.lastName;
        initialNode.address = newNode.address;
        initialNode.email = newNode.email;
        initialNode.phoneNumber = newNode.phoneNumber;
    }



    // Method returns the succesor to a deleted node
    public TreeNode getSuccessor (TreeNode node) {
        if (node == null) {
            return node;
        }

        // using the right subtree
        TreeNode temp = node.rightChild;

        // loop will find the lowest of right subtree
        while (temp != null) {
            temp = temp.leftChild;
        }

        return temp; 
    }



    // Method returns a node based on given lastName
    public TreeNode find (String lastName) {
        
        TreeNode temp = root;

        try {
            while (true) {

                // returns when node is found
                if (temp.lastName.equals(lastName)) {
                    return temp;
                }
                // decides if we need to proceed to the left or right child
                if (temp.lastName.compareTo(lastName) < 0) {
                    temp = temp.rightChild;
                }
                else {
                    temp = temp.leftChild;
                }
            }
        } 

        catch (NullPointerException e) {

            // error message if no node is found
            System.out.println("Entry not found...");

            temp = null;
            return temp; // WOMP WOMP
        }
    }



    // Method displays the directory based on chosen order



    // displays directory in order
    public void inOrder(TreeNode node) {

        if (node == null) { // base case
            return;
        }

        // recursion prints left side until left is null, then right
        inOrder(node.leftChild);
        node.display();
        inOrder(node.rightChild);
    }



    // displays the ammount of nodes in a tree
    public void numOfRecords() {
        int a = countRecords(root);
        System.out.println("There are " + a + "entries in the directory.");
    }



    // Method counts the number of nodes in the tree
    public int countRecords(TreeNode node) {

        int count = 0;

        if (node == null) { // base case
            return 0;
        }

        // recursion adds left side until left is null, then right
        countRecords(node.leftChild);
        count++;
        countRecords(node.rightChild);
        return count;
    }
}


