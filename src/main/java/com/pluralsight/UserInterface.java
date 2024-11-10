package com.pluralsight;

import com.pluralsight.Sandwich.Toppings;
import com.pluralsight.items.Chips;
import com.pluralsight.items.Sandwich;
import com.pluralsight.util.Console;

import java.util.List;

public class UserInterface {

    // HOME SCREEN
    public void homeScreen() {

        String options = """
                Please select from the following choices:
                1 - New Order
                0 - Exit
                
                >>\s""";

        int selection;

        do {
            try {
                System.out.println("Welcome to DELI-cious!!");
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


    // ORDER SCREEN
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
                    case 5 -> displaySandwich(); /// DELETE LATER
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

//todo START DOING THIS FIRST, GIVE TOPPING VARIABLE TO ADD TO YOUR TOPPING CONSTRUCTOR
    // ADD SANDWICH
    public void processAddSandwich() {





        String options = """
                Please select from the following choices:
                1 - Select your Bread
                2 - Sandwich Size
                3 - Toppings
                4 - Would you like the sandwich toasted
                0 - Cancel Order
                
                >>\s""";


        String sandwichBread = Console.PromptForString("Select your bread: ");
        String sandwichSize = Console.PromptForString("Sandwich size: ");
        String sandwichTopping = Console.PromptForString("Toppings: ");// need more for this

        String toppingName = Console.PromptForString();

        Toppings toppings = new Toppings ();





    }

    // ADD DRINKS
    public void processAddDrinks() {

        String drinkSize  = Console.PromptForString("Drink size: ");
        String drinkFlavor = Console.PromptForString("Drink Flavor: ");

    }


    // ADD CHIPS
    public void processAddChips() {

        String chipType  = Console.PromptForString("Type of chips: ");


    }


    //CHECKOUT
    public void processCheckout(){

    }


    // TESTING
    public void displaySandwich(){

        Toppings cheeseToppings = new Toppings("steak", "meat", true);
        Toppings meatTopping = new Toppings("Salami","meat", false);
        Toppings cheeseTopping2 = new Toppings("Cheddar","cheese", false);
        Toppings regularTopping = new Toppings("Lettuce","Regular", false);



        Sandwich sandwich = new Sandwich("ham sandwich", 1, "8", "Mac&Cheese", "true");

        sandwich.addTopping(cheeseTopping2);
        sandwich.addTopping(cheeseToppings);
        sandwich.addTopping(meatTopping);
        sandwich.addTopping(regularTopping);

        System.out.println(sandwich);

        // 7 + 2 + 1 + 2 + 1.50 = 13.5

    }

}
