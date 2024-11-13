package com.pluralsight.Screens;

import com.pluralsight.Items.Sandwich;
import com.pluralsight.Sandwich.Toppings;
import com.pluralsight.util.Console;
import java.util.List;
import static com.pluralsight.Screens.UserInterface.orderList;

public class SandwichInterface {


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
            try{
                System.out.println("Choose a meat topping:");
                List<String> meatOptions = topping.getMeatOptions();  //GET MEAT OPTIONS LIST


                for (int i = 0; i < meatOptions.size(); i++) {
                    System.out.println((i + 1) + " - " + meatOptions.get(i));
                }
                System.out.println("0 - Skip Meat");

                int meatChoice = Console.PromptForInt(">> ");

                if (meatChoice == 0) {
                    break; //SKIPS MEAT IF THE USER CHOOSES TO
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
                    break; //GOES TO THE NEXT TOPPING OPTION
                } else {
                    System.out.println("Invalid selection. Please try again.");
                }
            }catch(Exception e){
                System.out.println("Invalid selection. Please try again.");
            }

        }while (true);

        //FOR CHEESE
        do {
            try{
                System.out.println("Choose a cheese topping:");
                List<String> cheeseOptions = topping.getCheeseOptions();  //GET CHEESE OPTIONS LIST


                for (int i = 0; i < cheeseOptions.size(); i++) {
                    System.out.println((i + 1) + " - " + cheeseOptions.get(i));
                }
                System.out.println("0 - Skip Cheese");

                int cheeseChoice = Console.PromptForInt(">> ");
                if (cheeseChoice == 0) {
                    break;  //SKIP CHEESE IF THE USER CHOOSES TO
                }

                if (cheeseChoice >= 1 && cheeseChoice <= cheeseOptions.size()) {
                    String selectedCheese = cheeseOptions.get(cheeseChoice - 1);

                    while (true) {
                        String responseForCheese = Console.PromptForString("Would you like extra " + selectedCheese + "? (Yes/No): ");
                        if (responseForCheese.equalsIgnoreCase("Yes") || responseForCheese.equalsIgnoreCase("Y")) {
                            isExtra = true;
                            break;
                        } else if (responseForCheese.equalsIgnoreCase("No") || responseForCheese.equalsIgnoreCase("N")) {
                            isExtra = false;
                            break;
                        } else {
                            System.out.println("Invalid selection. Please enter 'Yes' or 'No'.");
                        }
                    }
                    Toppings cheeseTopping = new Toppings(selectedCheese, "Cheese", isExtra);
                    sandwich.addTopping(cheeseTopping);
                    break;  //GOES TO THE NEXT TOPPING OPTION
                } else {
                    System.out.println("Invalid selection. Please try again.");
                }
            }catch (Exception e){
                System.out.println("Invalid selection. Please try again.");
            }

        } while (true);

        //FOR OTHER TOPPINGS
        int regularToppingCount = 0;
        int maxRegularToppingsCount = 4;
        do {
            try{
                System.out.println("Choose a regular topping:");
                List<String> regularOptions = topping.getRegularOptions();  // Get regular toppings list

                for (int i = 0; i < regularOptions.size(); i++) {
                    System.out.println((i + 1) + " - " + regularOptions.get(i));
                }
                System.out.println("0 - Done");

                int regularChoice = Console.PromptForInt(">> ");

                if (regularChoice == 0) {
                    break;  //GOES TO NEXT CHOICE
                }

                if (regularChoice >= 1 && regularChoice <= regularOptions.size()) {
                    String selectedRegular = regularOptions.get(regularChoice - 1);

                    Toppings regularTopping = new Toppings(selectedRegular, "Regular");
                    sandwich.addTopping(regularTopping);
                    System.out.println(selectedRegular + " added.");


                    //INCREMENTS TILL IT REACHES MAX REGULAR TOPPINGS NUMBER
                    if (++regularToppingCount >= maxRegularToppingsCount) {
                        System.out.println("Maximum of " + maxRegularToppingsCount + " regular toppings reached.");
                        break;  //STOPS ADDING REGULAR TOPPINGS ONCE THE LIMIT IS REACHED
                    }

                    String addAnotherRegularTopping = Console.PromptForString("Would you like to add another regular topping? (Yes/No): ");

                    if (!addAnotherRegularTopping.equalsIgnoreCase("Yes") && !addAnotherRegularTopping.equalsIgnoreCase("Y")) {
                        break;  //EXIT LOOP IF THE USER DOES NOT WANT TO ADD ANOTHER TOPPING
                    }
                } else {
                    System.out.println("Invalid selection. Please try again.");
                }
            }catch (Exception e){
                System.out.println("Invalid selection. Please try again.");
            }

        } while (true);

        //FOR SAUCES
        int regularSauceCount = 0;
        int maxSauceCount = 4;
        do {
            try{
                System.out.println("Choose from the following sauce items:");
                List<String> sauceOptions = topping.getSauceOptions();  //GET SAUCE OPTIONS LIST

                for (int i = 0; i < sauceOptions.size(); i++) {
                    System.out.println((i + 1) + " - " + sauceOptions.get(i));
                }
                System.out.println("0 - Done");

                int sauceChoice = Console.PromptForInt(">> ");

                if (sauceChoice == 0) {
                    return;  //EXITS IF USER IS DONE WITH SAUCE
                }

                if (sauceChoice >= 1 && sauceChoice <= sauceOptions.size()) {
                    String selectedSauce = sauceOptions.get(sauceChoice - 1);

                    Toppings sauce = new Toppings(selectedSauce, "Sauce");
                    sandwich.addTopping(sauce);
                    System.out.println(selectedSauce + " added.");

                    if (++regularSauceCount >= maxSauceCount) {
                        System.out.println("Maximum of " + maxSauceCount + " sauces reached.");
                        return;  //STOPS ADDING REGULAR TOPPINGS ONCE THE LIMIT IS REACHED
                    }

                    String addAnotherSauce = Console.PromptForString("Would you like to add another sauce? (Yes/No): ");

                    if (!addAnotherSauce.equalsIgnoreCase("Yes") && !addAnotherSauce.equalsIgnoreCase("Y")) {
                        return;  //EXIT LOOP AND RETURNS TO SANDWICH MENU IF THE USER DOES NOT WANT TO ADD SAUCE
                    }

                } else {
                    System.out.println("Invalid selection. Please try again.");
                }
            }catch (Exception e){
                System.out.println("Invalid selection. Please try again.");
            }
        } while (true);
    }
}
