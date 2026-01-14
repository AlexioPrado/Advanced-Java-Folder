/**
 * @author Marcus Alexio Prado
 * Date: January 12th 2026
 * Project: Writing random integers to a created text file
 * 
 */

import java.io.*;

/**
 * Exercise 1: Write 100 random integers to a text file
 * 
 * Requirements:
 * - Create a file named Exercise17_01.txt if it does not exist
 * - If the file already exists, APPEND new data (don't overwrite)
 * - Write 100 integers created randomly (use Math.random())
 * - Integers should be separated by a space
 * - Use text I/O (PrintWriter)
 * 
 * @author Marcus Alexio Prado
 * Date: January 12th 2026
 * 
 */

public class exercise1_starter {
    
    public static void main(String[] args) throws IOException {
        try {
            // TODO: Create a File object for "Exercise17_01.txt"
            FileOutputStream text = new FileOutputStream("Binary IO/exercise17_01.txt");

            // TODO: Generate and write 100 random integers
            for (int i = 0 ; i < 100 ; i++) {
                // Random integer between 0 and 99
                int randomInt = (int)(Math.random() * 100);
                text.write((randomInt + " ").getBytes());
            }
            
            // TODO: Close the file
            text.close();

            System.out.println("100 random integers written to Exercise17_01.txt");
        } catch (Exception e) {
            System.out.println("An error occurred.");
        }
    }
}