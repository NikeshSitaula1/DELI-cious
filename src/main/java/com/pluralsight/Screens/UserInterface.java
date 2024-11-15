
package com.pluralsight.Screens;

import com.pluralsight.FileManager.OrderFileManager;
import com.pluralsight.Checkout.Orders;
import com.pluralsight.Util.Console;

public class UserInterface {

    static Orders orderList = new Orders();

    //HOME SCREEN
    public void homeScreen() {

        String options = """
         =================================================
                🥪🥪 Welcome to DELI-cious!! 🥪🥪
         =================================================
            Please select from the following choices:
            1 - New Order
            0 - Exit
         =================================================
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
            } catch (Exception e) {
                System.out.println("Invalid entry. Please try again." + e.getMessage());
            }
        } while (true);
    }


    // ORDER SCREEN
    public void orderScreen() {

        String options = """
        =================================================
                         Order Menu
        =================================================
            Please select from the following choices:
            1 - Add Sandwich
            2 - Add Drink
            3 - Add Chips
            4 - Checkout
            0 - Cancel Order
        =================================================
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
                        orderList.clearOrder();
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
    public void processCheckout() {

        System.out.println("""
                
                =================================================
                               ORDER SUMMARY
                =================================================
                """);
        System.out.println(orderList.toString());


        String options = """
        =================================================
                        CHECKOUT
        =================================================
            Please select from the following choices:
            1 - Confirm Checkout
            2 - Cancel Order
            0 - Back
        =================================================
        >>\s""";


        int selection;
        do {
            try {
                selection = Console.PromptForInt(options);

                if (selection == 1) {
                    //CONFIRM CHECKOUT
                    //WRITES ORDER LISTS INTO A FILE AFTER TURNING IT INTO STRING
                    OrderFileManager.writeOrderReceipt(orderList.toString());
                    System.out.println("Order confirmed and receipt saved.");
                    System.out.println("Thank you for your purchase!!");
                    orderList.clearOrder();
                    homeScreen(); //RETURN TO HOME SCREEN AFTER CHECKOUT
                    return;

                } else if (selection == 2) {
                    //CANCEL ORDER GOES BACK TO HOME SCREEN
                    System.out.println("Order cancelled. Returning to home screen.");
                    orderList.clearOrder();
                    homeScreen();
                    return;

                } else if (selection == 0) {
                    //GO BACK TO ORDER SCREEN
                    return;

                } else {
                    System.out.println("Invalid selection. Please try again.");
                }

            } catch (Exception e) {
                System.out.println("Invalid selection. Please try again." + e.getMessage());
            }
        } while (true);
    }
}
