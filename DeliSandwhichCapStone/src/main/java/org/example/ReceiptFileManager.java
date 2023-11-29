/*
package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptFileManager {
    private String fileName;

     public ReceiptFileManager(String fileName) {
        this.fileName = fileName;
    }
    ReceiptFileManager receipt =  new ReceiptFileManager("src/main/resources/Receipt.csv");

    public void createReceipt(String[] items, double[] prices, double totalPrice) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            LocalDateTime currentDateTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

            writer.write("Receipt\n");
            writer.write("Date:," + currentDateTime.format(formatter) + "\n");
            writer.write("Item,Price\n");

            for (int i = 0; i < items.length; i++) {
                writer.write(items[i] + "," + prices[i] + "\n");
            }

            writer.write("Total Price:," + totalPrice + "\n");
            writer.write("\n");

            System.out.println("Receipt details added to file: " + fileName);
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the receipt file.");
            e.printStackTrace();
        }
    }
}*/
