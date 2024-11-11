package com.pluralsight;

import com.pluralsight.FileManager.OrderFileManager;
import com.pluralsight.Sandwich.Toppings;
import com.pluralsight.checkout.Orders;
import com.pluralsight.items.Sandwich;
import com.pluralsight.util.Console;

import java.util.List;

public class UserInterface {

    private Orders orderList = new Orders();

    Sandwich sandwich = new Sandwich();

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
                    case 5 -> displaySandwich(); ///DELETE LATER
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

        String options = """
                Please select from the following choices:
                1 - Make your own Custom Sandwich
                2 - Choose one of your Signature Sandwich
                0 - Cancel Order
                
                >>\s""";

        int sandwichSelection;

        do {
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
        } while (true);
    }


    //todo START DOING THIS FIRST, GIVE TOPPING VARIABLE TO ADD TO YOUR TOPPING CONSTRUCTOR
    public void processCustomSandwich() {

        List<String> breadOptions = sandwich.getBreadOptions();

        // SANDWICH BREAD
        String sandwichBread;
        do{
            try{
                System.out.println("Please select your bread: ");
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
                    System.out.println("You selected: " + sandwichBread);
                    break;
                } else {
                    System.out.println("Invalid selection. Please try again.");
                }
            }catch (Exception e){
                System.out.println("Invalid selection. Please try again.");
            }
        }while(true);

        // SIZES
        String sandwichSize = Console.PromptForString("""
                Choose Sandwich Size: (4" , 8", 12"):\s""");
        sandwich.setSandwichSize(sandwichSize);

        // TOPPINGS
        processAddToppings();

        // TOASTED
        boolean toasted = Console.PromptForYesNo("Would you like the sandwich toasted? ");
        String isToasted = toasted ? "Yes" : "No";

        sandwich.setSandwichBread(sandwichBread);
        sandwich.setToasted(isToasted);



        orderList.addItems(sandwich);
        System.out.println("Sandwich added successfully!!");

    }



    public void processSignatureSandwich(){

    }

    // ADD TOPPINGS
    public void processAddToppings(){


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
        OrderFileManager.writeOrderReceipt("Testing");
    }


    // TESTING
    public void displaySandwich(){

        Toppings cheeseToppings = new Toppings("steak", "meat", true);
        Toppings meatTopping = new Toppings("Salami","meat", false);
        Toppings cheeseTopping2 = new Toppings("Cheddar","cheese", false);
        Toppings regularTopping = new Toppings("Lettuce","Regular", false);



        Sandwich sandwich = new Sandwich("ham sandwich", 2, "8", "Mac&Cheese", "true");

        sandwich.addTopping(cheeseTopping2);
        sandwich.addTopping(cheeseToppings);
        sandwich.addTopping(meatTopping);
        sandwich.addTopping(regularTopping);

        System.out.println(sandwich);

        // 7 + 2 + 1 + 2 + 1.50 = 13.5

    }

}
