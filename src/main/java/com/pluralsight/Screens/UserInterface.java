package com.pluralsight.Screens;

import com.pluralsight.FileManager.OrderFileManager;
import com.pluralsight.Checkout.Orders;
import com.pluralsight.Items.Chips;
import com.pluralsight.util.Console;

import java.util.List;

public class UserInterface {

    static Orders orderList = new Orders();

    //HOME SCREEN
    public void homeScreen() {

        String options = """
                 🥪🥪 Welcome to DELI-cious!! 🥪🥪
                 Please select from the following choices:
                1 - New Order
                0 - Exit
                
                >>\s""";

        int selection;

        do {
            try {
                selection = Console.PromptForInt(options);
                switch (selection) {
                    case 1 -> orderScreen();
                    case 0 -> System.exit(0);
                    default -> System.out.println("Invalid entry. Please try again.");
                }
            } catch (Exception e){
                System.out.println("Invalid entry. Please try again." + e.getMessage());
            }
        } while (true);
    }


    //ORDER SCREEN
    public void orderScreen() {

        String options = """
                Please select from the following choices:
                1 - Add Sandwich
                2 - Add Drink
                3 - Add Chips
                4 - Checkout
                0 - Cancel Order
                
                >>\s""";

        int orderSelection;

        do {
            try {
                orderSelection = Console.PromptForInt(options);
                switch (orderSelection) {
                    case 1 -> new SandwichInterface().processAddSandwich();
                    case 2 -> new DrinksInterface().processAddDrinks();
                    case 3 -> new ChipsInterface().processAddChips();
                    case 4 -> processCheckout();
                    case 0 -> {
                        return;
                    }
                    default -> System.out.println("Invalid entry. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Invalid entry. Please try again." + e.getMessage());
            }
        } while (true);
    }

    //CHECKOUT
    public void processCheckout(){

        System.out.println(orderList.toString());

        // Write order summary to receipt file
        OrderFileManager.writeOrderReceipt(orderList.toString());


    }

}
