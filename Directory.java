// File Name: Directory.java
// Date Edited: 03/14/2024
// Name: Keegan Baker
// Project: CS 145 Lab 6
// Purpose: This program will create a binary search tree that can be modified and displayed 
//          by the user.
//////////////////////////////////////////////////////////////////////////////////////////////////

import java.util.Scanner;

public class Directory {
    public static void main(String[] args) {
        
        // tree manager object inserted here


        Scanner sc = new Scanner(System.in);
        char command = 0;

        do {
            // command list
            System.out.println("\n==============================");
            System.out.println("\t1 - Add");
            System.out.println("\t2 - Delete");
            System.out.println("\t3 - Search");
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

            break;

            case '2':
            case 'D':
            case 'd':
                // Delete entry

            break;

            case '3':
            case 'S':
            case 's':
                // Search/display

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
                System.out.println(
                "\n************************" + 
                "*************************");
                
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