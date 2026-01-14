/*
 * Name: Marcus Prado 
 * Created: Jan 14th 2026
 * Purpose: Decode and read the exercise17_14.dat file
 */

import java.io.*;
import java.util.*;

public class exercise3_peer {
    public static void main(String[] args) {
        //variables
        Scanner input = new Scanner(System.in);
        String encryptedFile = "";
        String decryptedFile = "";
        
        //User input of file name
        System.out.println("Input encrypted file name: ");
        encryptedFile = input.next();
        System.out.println("Input file name for decrypted message: ");
        decryptedFile = input.next();

        try {
            //Create Input and Output Streams
            BufferedInputStream encrypt = new BufferedInputStream(new FileInputStream("Binary IO/"+encryptedFile));
            BufferedOutputStream decrypt = new BufferedOutputStream(new FileOutputStream("Binary IO/"+decryptedFile));
            
            // Read each byte and write it into output stream
            int value = 0;
            while ((value = encrypt.read()) != -1){
                //Write into output stream 0 if value-5 is negative, else, write into output stream value-5
                if (value-5 < 0){
                    decrypt.write(0);
                } else {
                    decrypt.write(value-5);
                }
            }

            //Close Streams
            encrypt.close();
            decrypt.close();

        } catch (Exception e) {
            System.out.println("Error occured.");
        }
    }   
}