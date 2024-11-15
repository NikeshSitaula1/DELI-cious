
package com.pluralsight.Screens;

import com.pluralsight.Items.Sandwich;
import com.pluralsight.Sandwich.SignatureSandwiches;
import com.pluralsight.Sandwich.Toppings;
import com.pluralsight.Util.Console;

import java.util.ArrayList;
import java.util.List;
import static com.pluralsight.Screens.UserInterface.orderList;

public class SandwichInterface {

    //ADD SANDWICH
    public void processAddSandwich() {

        String options = """
        =================================================
            Please select from the following choices:
            1 - Make your own Custom Sandwich
            2 - Choose one of our Signature Sandwiches
            0 - Cancel Order
        =================================================
        >>\s""";

        int sandwichSelection;
        try {
            sandwichSelection = Console.PromptForInt(options);
            switch (sandwichSelection) {
                case 1 -> processCustomSandwich();
                case 2 -> processSignatureSandwich();
                case 0 -> {
                    return;
                }
                default -> System.out.println("Invalid entry. Please try again.");
            }
        } catch (Exception e) {
            System.out.println("Invalid entry. Please try again." + e.getMessage());
        }
    }

    //CUSTOM SANDWICH PROCESSING
    public void processCustomSandwich() {
        List<String> breadOptions = new Sandwich().getBreadOptions();  // Assuming non-static list accessible by instance
        String sandwichBread;
        String sandwichSize;
        String isToasted;
        List<Toppings> toppingsList = new ArrayList<>();

        ///SANDWICH BREAD SELECTION
        do {
            try {
                System.out.println("""
            ==========================================
                   🍞 Please select your bread 🍞
            ==========================================""");

                //gets options from the bread options list
                for (int i = 0; i < breadOptions.size(); i++) {
                    System.out.printf("   %d - %s%n", i + 1, breadOptions.get(i));
                }

                System.out.println("""
               0 - Cancel Order
            ==========================================""");

                int breadChoice = Console.PromptForInt(">> ");

                if (breadChoice == 0) {
                    System.out.println("Order canceled. Returning to main menu.");
                    return;
                    //condition is more than 1 and less than bread options list, get the index that's -1 of number you choose
                } else if (breadChoice >= 1 && breadChoice <= breadOptions.size()) {
                    sandwichBread = breadOptions.get(breadChoice - 1);
                    System.out.println("You selected: " + sandwichBread);
                    break;
                } else {
                    System.out.println("Invalid selection. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Invalid selection. Please try again.");
            }
        } while (true);

        ///SANDWICH SIZE SELECTION
        do {
            sandwichSize = Console.PromptForString("""
                        Choose Sandwich Size:
                        4.  4" ($5.50)
                        8.  8" ($7.00)
                        12. 12"($8.50))
                    ==========================================
                    >>\s""");
            if (sandwichSize.equals("4") || sandwichSize.equals("8") || sandwichSize.equals("12")) {
                System.out.println("You selected: " + sandwichSize);
                break;
            } else {
                System.out.println("Invalid size. Please enter 4\", 8\", or 12\".");
            }
        } while (true);

        ///add toppings from topping list
        new ToppingsInterface().processAddToppings(toppingsList);

        ///TOASTED OPTION SELECTION
        do {
            isToasted = Console.PromptForString("Would you like the sandwich toasted? (Yes/No): ");
            if (isToasted.equalsIgnoreCase("Yes") || isToasted.equalsIgnoreCase("y")) {
                isToasted = "Yes";
                System.out.println("You selected: Toasted");
                break;
            } else if (isToasted.equalsIgnoreCase("No") || isToasted.equalsIgnoreCase("n")) {
                isToasted = "No";
                System.out.println("You selected: Not Toasted");
                break;
            } else {
                System.out.println("Invalid selection. Please enter 'Yes' or 'No'.");
            }
        } while (true);

        //create sandwich object that will save the values in the constructor
        Sandwich sandwich = new Sandwich(sandwichBread, sandwichSize, toppingsList, isToasted);

        //add sandwich to the order list
        orderList.addItems(sandwich);
        System.out.println("Sandwich added successfully!");
    }


    public void processSignatureSandwich() {

        String options = """
        =================================================
        Please choose of the Signature sandwiches:
            1 - BLT
            2 - Philly Cheese Steak
            0 - Cancel Order
        =================================================
        >>\s""";

        int signatureSandwichSelection;

        try {
            signatureSandwichSelection = Console.PromptForInt(options);
            if (signatureSandwichSelection == 1) {
                SignatureSandwiches blt = SignatureSandwiches.createBLT();
                orderList.addItems(blt);  //added blt to order
                System.out.println("BLT added to your order.");

            } else if (signatureSandwichSelection == 2) {
                SignatureSandwiches phillyCheeseSteak = SignatureSandwiches.createPhillyCheeseSteak();
                orderList.addItems(phillyCheeseSteak);  //added philly cheese steak to order
                System.out.println("Philly Cheese Steak added to your order.");

            } else if (signatureSandwichSelection == 0) {
                System.out.println("Returning to previous menu.");
                return;

            } else {
                System.out.println("Invalid entry. Please try again.");
            }
        } catch (Exception e) {
            System.out.println("Invalid entry. Please try again." + e.getMessage());
        }
    }
}
