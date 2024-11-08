package com.pluralsight;

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


    // ADD SANDWICH
    public void processAddSandwich() {

        String sandwichBread = Console.PromptForString("Select your bread: ");
        String sandwichSize = Console.PromptForString("Sandwich size: ");
        String sandwichTopping = Console.PromptForString("Toppings: "); // need more for this

        //Topping topping = new Topping

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

}
