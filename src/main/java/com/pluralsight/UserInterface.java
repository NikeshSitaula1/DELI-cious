package com.pluralsight;

import com.pluralsight.FileManager.OrderFileManager;
import com.pluralsight.Sandwich.Toppings;
import com.pluralsight.checkout.Orders;
import com.pluralsight.items.Chips;
import com.pluralsight.items.Drinks;
import com.pluralsight.items.Sandwich;
import com.pluralsight.util.Console;

import java.util.List;

public class UserInterface {

    private Orders orderList = new Orders();


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
                    case 1 -> processAddSandwich();
                    case 2 -> processAddDrinks();
                    case 3 -> processAddChips();
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


    //ADD SANDWICH
    public void processAddSandwich() {

        String options = """
                Please select from the following choices:
                1 - Make your own Custom Sandwich
                2 - Choose one of your Signature Sandwich
                0 - Cancel Order
                
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


    public void processCustomSandwich() {

        Sandwich sandwich = new Sandwich();
        List<String> breadOptions = sandwich.getBreadOptions();

        //SANDWICH BREAD
        String sandwichBread;
        do{
            try{
                System.out.println("\uD83C\uDF5E Please select your bread: ");
                for (int i = 0; i < breadOptions.size(); i++){
                    System.out.println((i + 1) + ". " + breadOptions.get(i));
                }
                System.out.println("0. Cancel Order");

                int breadChoice = Console.PromptForInt(">> ");

                if (breadChoice == 0) {
                    System.out.println("Order canceled. Returning to main menu.");
                    return;
                } else if (breadChoice >= 1 && breadChoice <= breadOptions.size()) {
                    sandwichBread = breadOptions.get(breadChoice - 1);
                    sandwich.setSandwichBread(sandwichBread);
                    System.out.println("You selected: " + sandwichBread);
                    break;
                } else {
                    System.out.println("Invalid selection. Please try again.");
                }
            }catch (Exception e){
                System.out.println("Invalid selection. Please try again.");
            }
        }while(true);

        //SIZES
        String sandwichSize;
        do {
            sandwichSize = Console.PromptForString("Choose Sandwich Size: (4\", 8\", 12\"): ");
            sandwich.setSandwichSize(sandwichSize);

            // Check if the size was set successfully
            if (sandwichSize.equals(sandwich.getSandwichSize())) {
                System.out.println("You selected: " + sandwichSize);
                break;
            } else {
                System.out.println("Please try again.");
            }
        } while (true);

        //TOPPINGS
        processAddToppings(sandwich);

        //TOASTED
        String isToasted;
        do {
            isToasted = Console.PromptForString("Would you like the sandwich toasted? (Yes/No): ");
            if (isToasted.equalsIgnoreCase("Yes") || isToasted.equalsIgnoreCase("y")) {
                sandwich.setToasted("Yes");
                System.out.println("You selected: Toasted");
                break;
            } else if (isToasted.equalsIgnoreCase("No") || isToasted.equalsIgnoreCase("n")) {
                sandwich.setToasted("No");
                System.out.println("You selected: Not Toasted");
                break;
            } else {
                System.out.println("Invalid selection. Please enter 'Yes' or 'No'.");
            }
        } while (true);


    //ADD SANDWICH TO ORDER LIST
        orderList.addItems(sandwich);
        System.out.println("Sandwich added successfully!!");

    }


    public void processSignatureSandwich(){

    }

    ///ADD TOPPINGS
    public void processAddToppings(Sandwich sandwich){

        Toppings topping = new Toppings();

        boolean isExtra;

        //FOR MEAT
       do{
           System.out.println("Choose a meat topping:");
           List<String> meatOptions = topping.getMeatOptions();  // Get meat options list
           for (int i = 0; i < meatOptions.size(); i++) {
               System.out.println((i + 1) + " - " + meatOptions.get(i));
           }
           System.out.println("0 - Skip Meat");

           int meatChoice = Console.PromptForInt(">> ");
           if (meatChoice == 0) {
               break;
           }

           if (meatChoice >= 1 && meatChoice <= meatOptions.size()) {
               String selectedMeat = meatOptions.get(meatChoice - 1);

               while (true) {
                   String response = Console.PromptForString("Would you like extra " + selectedMeat + "? (Yes/No): ");
                   if (response.equalsIgnoreCase("Yes") || response.equalsIgnoreCase("Y")) {
                       isExtra = true;
                       break;
                   } else if (response.equalsIgnoreCase("No") || response.equalsIgnoreCase("N")) {
                       isExtra = false;
                       break;
                   } else {
                       System.out.println("Invalid selection. Please enter 'Yes' or 'No'.");
                   }
               }
               Toppings meatTopping = new Toppings(selectedMeat, "Meat", isExtra);
               sandwich.addTopping(meatTopping);
               break; // Goes to the next topping option
           } else {
               System.out.println("Invalid selection. Please try again.");
           }
       }while (true);

        //FOR CHEESE
        do {
            System.out.println("Choose a cheese topping:");
            List<String> cheeseOptions = topping.getCheeseOptions();  // Get cheese options list
            for (int i = 0; i < cheeseOptions.size(); i++) {
                System.out.println((i + 1) + " - " + cheeseOptions.get(i));
            }
            System.out.println("0 - Skip Cheese");

            int cheeseChoice = Console.PromptForInt(">> ");
            if (cheeseChoice == 0) {
                break;  // Skip cheese if the user chooses to
            }

            if (cheeseChoice >= 1 && cheeseChoice <= cheeseOptions.size()) {
                String selectedCheese = cheeseOptions.get(cheeseChoice - 1);

                while (true) {
                    String response = Console.PromptForString("Would you like extra " + selectedCheese + "? (Yes/No): ");
                    if (response.equalsIgnoreCase("Yes") || response.equalsIgnoreCase("Y")) {
                        isExtra = true;
                        break;
                    } else if (response.equalsIgnoreCase("No") || response.equalsIgnoreCase("N")) {
                        isExtra = false;
                        break;
                    } else {
                        System.out.println("Invalid selection. Please enter 'Yes' or 'No'.");
                    }
                }
                Toppings cheeseTopping = new Toppings(selectedCheese, "Cheese", isExtra);
                sandwich.addTopping(cheeseTopping);
                break;  // Goes to the next topping option
            } else {
                System.out.println("Invalid selection. Please try again.");
            }
        } while (true);

        //FOR OTHER TOPPINGS

        //FOR SAUCES



    }


    //ADD DRINKS
    public void processAddDrinks() {

        Drinks drink = new Drinks();

        // DRINK FLAVOR
        List<String> drinkFlavorList = drink.getDrinkFlavorList();
        String drinkFlavor;

        do{
            try{
                System.out.println("Select your drink from the menu option:");
                for (int i = 0; i < drinkFlavorList.size(); i++) {
                    System.out.println((i + 1) + ". " + drinkFlavorList.get(i));
                }
                System.out.println("0. Cancel Order");

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
            }catch (Exception e){
                System.out.println("Invalid selection. Please try again");
            }
        }while (true);

        drink.setDrinkFlavor(drinkFlavor);
        System.out.println(drinkFlavor + " added");


        //DRINK SIZE
        String drinkSize;

        do {
            try {
                System.out.println("Select drink size:");
                System.out.println("1. Small");
                System.out.println("2. Medium");
                System.out.println("3. Large");
                System.out.println("0. Cancel Order");

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

        drink.setDrinkSize(drinkSize);
        System.out.println("Drink size: " + drinkSize);


        //ADD DRINKS IN THE ORDER LIST
        orderList.addItems(drink);
        System.out.println("Drinks added successfully!!");
    }


    //ADD CHIPS
    public void processAddChips() {

        Chips chip = new Chips();

        //CHIPS TYPE
        List<String> chipsTypeList = chip.getChipsTypeList();
        String chipsType;

        do{
            try{
                System.out.println("Select Chips from the menu option:");
                for (int i = 0; i < chipsTypeList.size(); i++) {
                    System.out.println((i + 1) + ". " + chipsTypeList.get(i));
                }
                System.out.println("0. Cancel Order");

                int chipsChoice = Console.PromptForInt(">> ");

                if (chipsChoice == 0) {
                    System.out.println("Order canceled. Returning to main menu.");
                    return;
                } else if (chipsChoice >= 1 && chipsChoice <= chipsTypeList.size()) {
                    chipsType = chipsTypeList.get(chipsChoice - 1);
                    System.out.println("You selected: " + chipsType);
                    break;
                } else {
                    System.out.println("Invalid selection. Please try again.");
                }
            }catch (Exception e){
                System.out.println("Invalid selection. Please try again");
            }
        }while (true);

        chip.setChipType(chipsType);

        orderList.addItems(chip);
        System.out.println("Chip successfully added");
    }

    //CHECKOUT
    public void processCheckout(){

        System.out.println(orderList.toString());

        // Write order summary to receipt file
        OrderFileManager.writeOrderReceipt(orderList.toString());
    }

}
