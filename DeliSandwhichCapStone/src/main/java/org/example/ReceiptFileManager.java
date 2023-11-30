/*
package org.example;


import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ReceiptFileManager{

    private String fileName;
    private ReceiptFileManager receipt;



    public ReceiptFileManager(String fileName) {
        this.fileName = fileName;
    }

    public void createReceipt(String[] items, double[] prices, double totalPrice, ArrayList<RegularToppings> regularTList, ArrayList<String> sauceList, ArrayList<Drink> drinks, ArrayList<Chips> chips) {

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
            writer.write("Item/Price\n");

            // Write items and prices

            writer.write("Item,Price\n");

            for (int i = 0; i < items.length; i++) {
                writer.write(items[i] + "," + prices[i] + "\n");
            }


            boolean hasRegularToppings = !regularTList.isEmpty();
            boolean hasSauces = !sauceList.isEmpty();
            boolean hasDrinks = !drinks.isEmpty();
            boolean hasChips = !chips.isEmpty();

            if (hasRegularToppings || hasSauces || hasDrinks || hasChips) {
                writer.write("\n---Additional Details---\n");
            }

            // Write regular toppings
            if (hasRegularToppings) {
                writer.write("Regular Toppings:\n");
                for (RegularToppings topping : regularTList) {
                    writer.write(topping.getToppingName() + "\n");
                }
            }

            // Write sauces
            if (hasSauces) {
                writer.write("Sauces:\n");
                for (String sauce : sauceList) {
                    writer.write(sauce + "\n");
                }
            }

            // Write drinks
            if (hasDrinks) {
                writer.write("Drinks:\n");
                for (Drink drink : drinks) {
                    writer.write("Size: " + drink.getSize() + "\n\n");
                }
            }

            // Write chips
            if (hasChips) {
                writer.write("Chips:\n");
                for (Chips chip : chips) {
                    writer.write(chip.getBrand() + "\n\n");
                }
            }

            writer.write("Total Price:" + totalPrice + "\n\n");

            writer.write("Total Price:," + totalPrice + "\n");
            writer.write("\n");


            System.out.println("Receipt details added to file: " + fileName);
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the receipt file.");
            e.printStackTrace();
        }
    }


    public ArrayList<String> getReceipt() {
        ArrayList<String> receipt = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                receipt.add(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the receipt file.");
            e.printStackTrace();
        }

        return receipt;
    }
}

}*/

