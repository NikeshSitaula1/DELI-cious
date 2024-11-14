package com.pluralsight.Screens;

import com.pluralsight.Items.Drinks;
import com.pluralsight.Util.Console;
import java.util.List;
import static com.pluralsight.Screens.UserInterface.orderList;

public class DrinksInterface {
    //ADD DRINKS
    public void processAddDrinks() {
        String drinkFlavor;
        String drinkSize;

        ///DRINK FLAVOR SELECTION
        List<String> drinkFlavorList = new Drinks().getDrinkFlavorList();  //GET DRINK FLAVOR LIST

        do {
            try {
                System.out.println("==========================================");
                System.out.println("         🥤 Choose Your Drink Flavor 🥤   ");
                System.out.println("==========================================");

                //GETS OPTIONS FROM THE DRINK FLAVOR LIST
                for (int i = 0; i < drinkFlavorList.size(); i++) {
                    System.out.println("   " + (i + 1) + " - " + drinkFlavorList.get(i));
                }
                System.out.println("   0 - Cancel Order");
                System.out.println("==========================================");

                int flavorChoice = Console.PromptForInt(">> ");

                if (flavorChoice == 0) {
                    System.out.println("Order canceled. Returning to main menu.");
                    return;
                }
                //CONDITION IS MORE THAN 1 AND LESS THAN DRINK FLAVOR LIST, GET INDEX THAT'S -1 OF NUMBER YOU CHOOSE
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

        ///DRINK SIZE SELECTION
        do {
            try {
                System.out.println("""
                   ==========================================
                            🥤 Select Drink Size 🥤
                   ==========================================
                   1 - Small
                   2 - Medium
                   3 - Large
                   0 - Cancel Order
                   ==========================================""");

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

        ///CREATE DRINKS WITH FLAVOR AND SIZE THEN SAVE IT TO CONSTRUCTOR AND ADD TO ORDER
        Drinks drink = new Drinks(drinkFlavor, drinkSize);
        orderList.addItems(drink);
        System.out.println(drinkFlavor + " (" + drinkSize + ") added to order.");
    }
}
