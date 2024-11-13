package com.pluralsight.Screens;

import com.pluralsight.Items.Drinks;
import com.pluralsight.util.Console;
import java.util.List;
import static com.pluralsight.Screens.UserInterface.orderList;

public class DrinksInterface {
    //ADD DRINKS
    public void processAddDrinks() {

        String drinkFlavor;
        String drinkSize;

        // DRINK FLAVOR SELECTION
        List<String> drinkFlavorList = new Drinks().getDrinkFlavorList();  //GET DRINK FLAVOR LIST

        do {
            try {
                System.out.println("Select your drink flavor from the menu:");
                for (int i = 0; i < drinkFlavorList.size(); i++) {
                    System.out.println((i + 1) + ". " + drinkFlavorList.get(i));
                }
                System.out.println("0 - Cancel Order");

                int flavorChoice = Console.PromptForInt(">> ");

                if (flavorChoice == 0) {
                    System.out.println("Order canceled. Returning to main menu.");
                    return;
                }
                if (flavorChoice >= 1 && flavorChoice <= drinkFlavorList.size()) {
                    drinkFlavor = drinkFlavorList.get(flavorChoice - 1);
                    System.out.println("You selected: " + drinkFlavor);
                    break;
                } else {
                    System.out.println("Invalid selection. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Invalid selection. Please try again.");
            }
        } while (true);

        //DRINK SIZE SELECTION
        do {
            try {
                System.out.println("Select drink size:");
                System.out.println("1 - Small");
                System.out.println("2 - Medium");
                System.out.println("3 - Large");
                System.out.println("0 - Cancel Order");

                int sizeChoice = Console.PromptForInt(">> ");

                if (sizeChoice == 0) {
                    System.out.println("Order canceled. Returning to main menu.");
                    return;
                } else if (sizeChoice == 1) {
                    drinkSize = "Small";
                    break;
                } else if (sizeChoice == 2) {
                    drinkSize = "Medium";
                    break;
                } else if (sizeChoice == 3) {
                    drinkSize = "Large";
                    break;
                } else {
                    System.out.println("Invalid selection. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        } while (true);

        //CREATE DRINKS WITH FLAVOR AND SIZE THEN ADDS TO ORDER
        Drinks drink = new Drinks(drinkFlavor, drinkSize);
        orderList.addItems(drink);
        System.out.println(drinkFlavor + " (" + drinkSize + ") added to order.");
    }
}
