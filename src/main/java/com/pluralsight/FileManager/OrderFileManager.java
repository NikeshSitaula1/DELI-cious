package com.pluralsight.FileManager;

import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class OrderFileManager {

    public static void writeOrderReceipt(String order){

        try {
            LocalDateTime localDateTime = LocalDateTime.now();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
            String filename = localDateTime.format(formatter) + ".txt";
            //File folderPath = new File("C:\\Users\\Nike\\Pluralsight\\java-development\\Capstones\\DELI-cious\\src\\main\\java\\com\\pluralsight\\Receipts");

            BufferedWriter bw = new BufferedWriter(new FileWriter(filename));

            bw.write(order);
            bw.close();

        } catch (IOException e){
            System.out.println("Error while saving Transactions: " + e.getMessage());
        }
    }
}
