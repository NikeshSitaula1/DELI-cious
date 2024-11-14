package com.pluralsight.FileManager;

import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class OrderFileManager {

    public static void writeOrderReceipt(String order){

        //DIRECTORY PATH WHERE THE RECEIPTS WILL BE STORED
        String dirPath = "src/main/java/com/pluralsight/Receipts/";
        File directory = new File(dirPath);

        //ENSURES DIRECTORY EXISTS
        if (!directory.exists()) {
            directory.mkdirs();
        }

        try {
            LocalDateTime localDateTime = LocalDateTime.now();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
            String filename = dirPath + localDateTime.format(formatter) + ".txt";

            BufferedWriter bw = new BufferedWriter(new FileWriter(filename));

            bw.write(order);
            bw.close();

        } catch (IOException e){
            System.out.println("Error while saving Transactions: " + e.getMessage());
        }
    }
}