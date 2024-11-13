package com.pluralsight.Screens;

import com.pluralsight.Items.Sandwich;
import com.pluralsight.Sandwich.Toppings;
import com.pluralsight.Util.Console;

import java.util.ArrayList;
import java.util.List;
import static com.pluralsight.Screens.UserInterface.orderList;

public class SandwichInterface {

    // ADD SANDWICH
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

        // SANDWICH BREAD SELECTION
        do {
            try {
                System.out.println("""
            ==========================================
                   🍞 Please select your bread 🍞
            ==========================================""");
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

        // SANDWICH SIZE SELECTION
        do {
            sandwichSize = Console.PromptForString("Choose Sandwich Size: (4\", 8\", 12\"): ");
            if (sandwichSize.equals("4") || sandwichSize.equals("8") || sandwichSize.equals("12")) {
                System.out.println("You selected: " + sandwichSize);
                break;
            } else {
                System.out.println("Invalid size. Please enter 4\", 8\", or 12\".");
            }
        } while (true);

        // ADD TOPPINGS
        processAddToppings(toppingsList);

        // TOASTED OPTION SELECTION
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

        // Create the Sandwich object with all selections
        Sandwich sandwich = new Sandwich(sandwichBread, sandwichSize, toppingsList, isToasted);

        // ADD SANDWICH TO ORDER LIST
        orderList.addItems(sandwich);
        System.out.println("Sandwich added successfully!");
    }


    public void processSignatureSandwich() {
        // Implementation for selecting a signature sandwich
    }


    // ADD TOPPINGS
    public void processAddToppings(List<Toppings> toppingsList) {
        Toppings topping = new Toppings();
        boolean isExtra;

        // MEAT TOPPINGS
        do {
            try {
                System.out.println("""
            ==========================================
                   Choose a meat topping:
            ==========================================""");
                List<String> meatOptions = topping.getMeatOptions();

                for (int i = 0; i < meatOptions.size(); i++) {
                    System.out.printf("   %d - %s%n", i + 1, meatOptions.get(i));
                }
                System.out.println("""
               0 - Skip Meat
            ==========================================""");

                int meatChoice = Console.PromptForInt(">> ");

                if (meatChoice == 0) {
                    break;
                }

                if (meatChoice >= 1 && meatChoice <= meatOptions.size()) {
                    String selectedMeat = meatOptions.get(meatChoice - 1);

                    isExtra = Console.PromptForString("Would you like extra " + selectedMeat + "? (Yes/No): ")
                            .equalsIgnoreCase("Yes");

                    toppingsList.add(new Toppings(selectedMeat, "Meat", isExtra));
                    break;
                } else {
                    System.out.println("Invalid selection. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Invalid selection. Please try again.");
            }
        } while (true);

        // CHEESE TOPPINGS
        do {
            try {
                System.out.println("""
            ==========================================
                   Choose a cheese topping:
            ==========================================""");
                List<String> cheeseOptions = topping.getCheeseOptions();

                for (int i = 0; i < cheeseOptions.size(); i++) {
                    System.out.printf("   %d - %s%n", i + 1, cheeseOptions.get(i));
                }
                System.out.println("""
               0 - Skip Cheese
            ==========================================""");

                int cheeseChoice = Console.PromptForInt(">> ");
                if (cheeseChoice == 0) {
                    break;
                }

                if (cheeseChoice >= 1 && cheeseChoice <= cheeseOptions.size()) {
                    String selectedCheese = cheeseOptions.get(cheeseChoice - 1);

                    isExtra = Console.PromptForString("Would you like extra " + selectedCheese + "? (Yes/No): ")
                            .equalsIgnoreCase("Yes");

                    toppingsList.add(new Toppings(selectedCheese, "Cheese", isExtra));
                    break;
                } else {
                    System.out.println("Invalid selection. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Invalid selection. Please try again.");
            }
        } while (true);

        // REGULAR TOPPINGS
        int regularToppingCount = 0;
        int maxRegularToppingsCount = 4;
        do {
            try {
                System.out.println("""
            ==========================================
                   Choose a regular topping:
            ==========================================""");
                List<String> regularOptions = topping.getRegularOptions();

                for (int i = 0; i < regularOptions.size(); i++) {
                    System.out.printf("   %d - %s%n", i + 1, regularOptions.get(i));
                }
                System.out.println("""
               0 - Done
            ==========================================""");

                int regularChoice = Console.PromptForInt(">> ");

                if (regularChoice == 0) {
                    break;
                }

                if (regularChoice >= 1 && regularChoice <= regularOptions.size()) {
                    String selectedRegular = regularOptions.get(regularChoice - 1);

                    toppingsList.add(new Toppings(selectedRegular, "Regular"));
                    System.out.println(selectedRegular + " added.");

                    if (++regularToppingCount >= maxRegularToppingsCount) {
                        System.out.println("Maximum of " + maxRegularToppingsCount + " regular toppings reached.");
                        break;
                    }

                    String addAnotherRegularTopping = Console.PromptForString("Would you like to add another regular topping? (Yes/No): ");

                    if (!addAnotherRegularTopping.equalsIgnoreCase("Yes") && !addAnotherRegularTopping.equalsIgnoreCase("Y")) {
                        break;
                    }
                } else {
                    System.out.println("Invalid selection. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Invalid selection. Please try again.");
            }
        } while (true);

        // SAUCES
        int sauceCount = 0;
        int maxSauceCount = 4;
        do {
            try {
                System.out.println("""
            ==========================================
               Choose from the following sauce items:
            ==========================================""");

                List<String> sauceOptions = topping.getSauceOptions();

                for (int i = 0; i < sauceOptions.size(); i++) {
                    System.out.printf("   %d - %s%n", i + 1, sauceOptions.get(i));
                }
                System.out.println("""
               0 - Done
            ==========================================""");

                int sauceChoice = Console.PromptForInt(">> ");

                if (sauceChoice == 0) {
                    return;
                }

                if (sauceChoice >= 1 && sauceChoice <= sauceOptions.size()) {
                    String selectedSauce = sauceOptions.get(sauceChoice - 1);

                    toppingsList.add(new Toppings(selectedSauce, "Sauce"));
                    System.out.println(selectedSauce + " added.");

                    if (++sauceCount >= maxSauceCount) {
                        System.out.println("Maximum of " + maxSauceCount + " sauces reached.");
                        return;
                    }

                    String addAnotherSauce = Console.PromptForString("Would you like to add another sauce? (Yes/No): ");

                    if (!addAnotherSauce.equalsIgnoreCase("Yes") && !addAnotherSauce.equalsIgnoreCase("Y")) {
                        return;
                    }

                } else {
                    System.out.println("Invalid selection. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Invalid selection. Please try again.");
            }
        } while (true);
    }

}
