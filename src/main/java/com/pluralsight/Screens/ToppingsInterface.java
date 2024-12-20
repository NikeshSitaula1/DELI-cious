
package com.pluralsight.Screens;

import com.pluralsight.Sandwich.Toppings;
import com.pluralsight.Util.Console;

import java.util.List;

public class ToppingsInterface {

    //ADD TOPPINGS
    public void processAddToppings(List<Toppings> toppingsList) {
        Toppings topping = new Toppings();
        boolean isExtra;

        //MEAT TOPPINGS
        do {
            try {
                System.out.println("""
            ==========================================
                   Choose a meat topping:
            ==========================================""");

                List<String> meatOptions = topping.getMeatOptions();

                //gets options from the meat toppings list
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

                    //If yes, boolean IsExtra is true
                    String extraMeatChoice =  Console.PromptForString("Would you like extra " + selectedMeat + "? (Yes/No): ");
                    isExtra = extraMeatChoice.equalsIgnoreCase("Yes") || extraMeatChoice.equalsIgnoreCase("Y");

                    toppingsList.add(new Toppings(selectedMeat, "Meat", isExtra));
                    break;
                } else {
                    System.out.println("Invalid selection. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Invalid selection. Please try again.");
            }
        } while (true);

        //CHEESE TOPPINGS
        do {
            try {
                System.out.println("""
            ==========================================
                   Choose a cheese topping:
            ==========================================""");
                List<String> cheeseOptions = topping.getCheeseOptions();

                //gets options from the cheese toppings list
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

                    //If yes, boolean IsExtra is true
                    String extraCheeseChoice =  Console.PromptForString("Would you like extra " + selectedCheese + "? (Yes/No): ");
                    isExtra = extraCheeseChoice.equalsIgnoreCase("Yes") || extraCheeseChoice.equalsIgnoreCase("Y");


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
            =============================================
                   Choose a regular topping: (Max 4)
            =============================================""");
                List<String> regularOptions = topping.getRegularOptions();

                //GETS OPTIONS FROM REGULAR TOPPINGS LIST
                for (int i = 0; i < regularOptions.size(); i++) {
                    System.out.printf("   %d - %s%n", i + 1, regularOptions.get(i));
                }
                System.out.println("""
               0 - Done
            =============================================""");

                int regularChoice = Console.PromptForInt(">> ");

                if (regularChoice == 0) {
                    break;
                }

                //CONDITION IS MORE THAN 1 AND LESS THAN REGULAR TOPPINGS LIST, GET INDEX THAT'S -1 OF NUMBER YOU CHOOSE
                if (regularChoice >= 1 && regularChoice <= regularOptions.size()) {
                    String selectedRegular = regularOptions.get(regularChoice - 1);

                    toppingsList.add(new Toppings(selectedRegular, "Regular"));
                    System.out.println(selectedRegular + " added.");

                    //MAX OF MAX REGULAR TOPPINGS COUNT VARIABLE CAN BE CHOSEN, AFTER THAT, IT WILL AUTOMATICALLY LEAVE THE OPTION
                    if (++regularToppingCount >= maxRegularToppingsCount) {
                        System.out.println("Maximum of " + maxRegularToppingsCount + " regular toppings reached.");
                        break;
                    }

                    //IT WILL LOOP BACK TO CHOOSING REGULAR TOPPINGS, IF YES, LOOP TILL MAX REGULAR TOPPINGS COUNT
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

        //SAUCES
        int sauceCount = 0;
        int maxSauceCount = 4;
        do {
            try {
                System.out.println("""
            ==========================================
               Choose a sauce items: (Max 4)
            ==========================================""");

                List<String> sauceOptions = topping.getSauceOptions();

                //GETS OPTIONS FROM SAUCE LIST
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

                //CONDITION IS MORE THAN 1 AND LESS THAN SAUCE LIST, GET INDEX THAT'S -1 OF NUMBER YOU CHOOSE
                if (sauceChoice >= 1 && sauceChoice <= sauceOptions.size()) {
                    String selectedSauce = sauceOptions.get(sauceChoice - 1);

                    toppingsList.add(new Toppings(selectedSauce, "Sauce"));
                    System.out.println(selectedSauce + " added.");

                    //MAX OF MAX SAUCE COUNT VARIABLE CAN BE CHOSEN, AFTER THAT, IT WILL AUTOMATICALLY LEAVE THE OPTION
                    if (++sauceCount >= maxSauceCount) {
                        System.out.println("Maximum of " + maxSauceCount + " sauces reached.");
                        return;
                    }

                    //IT WILL LOOP BACK TO CHOOSING SAUCE, IF YES, LOOP TILL MAX SAUCE COUNT
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
