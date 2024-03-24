// File Name: Directory.java
// Date Edited: 03/17/2024
// Name: Keegan Baker
// Project: CS 145 Lab 6
// Purpose: This program acts as an interface to allow the user to modify, and display a
//          binary search tree directory.
//////////////////////////////////////////////////////////////////////////////////////////////////

import java.util.Scanner;

public class Directory {

    public static void main(String[] args) {
        
        // uses class SearchTreeManager to manipulate data structure
        DirectoryManager tree = new DirectoryManager();
        Scanner sc = new Scanner(System.in);
        char command = 0;

        do {
            // command list
            System.out.println("\n==============================");
            System.out.println("\t1 - Add");
            System.out.println("\t2 - Delete");
            System.out.println("\t3 - Display");
            System.out.println("\t4 - Edit");
            System.out.println("\t5 - List # of records");
            System.out.println("\t0 - Quit");
            System.out.println("==============================");
            System.out.print("Enter a command: ");

            //user input
            String commandString = sc.next();
            command = commandString.charAt(0);
            switch (command) {
            case '1':
            case 'A':
            case 'a':
                // Add entry
                System.out.println();
                tree.add();
            break;

            case '2':
            case 'D':
            case 'd':
                // Delete entry
                System.out.println();
                tree.confirmDelete();
            break;

            case '3':
            case 'S':
            case 's':
                // Display
                System.out.println();
                if (tree.root == null) { // message if directory is empty
                    System.out.println("***  !! Directory is empty !!  ***");
                    System.out.println("***  please create a new entry ***");
                    break;
                }
                tree.inOrder(tree.root);
            break;

            case '4':
            case 'E':
            case 'e':
                // Edit

            break;

            case '5':
            case 'V':
            case 'v':
                // List # of records
                System.out.println();
                tree.numOfRecords();
            break;

            case '0':
            case 'Q':
            case 'q':
                // quit the program
                System.out.println("Goodbye!\n");
            break;

            // Case for tests 
            // case 't':
            //     
            // break;

            default: 
                System.out.println("!! INVALID COMMAND -- TRY AGAIN !!");
            }
        } while (command != '0' && command != 'q' && command != 'Q');
        sc.close();
    }
}