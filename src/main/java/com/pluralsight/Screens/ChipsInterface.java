package com.pluralsight.Screens;

import com.pluralsight.Items.Chips;
import com.pluralsight.Util.Console;

import java.util.List;

import static com.pluralsight.Screens.UserInterface.orderList;

public class ChipsInterface {

    //ADD CHIPS
    public void processAddChips() {
        String chipsType;

        //CHIPS TYPE SELECTION
        List<String> chipsTypeList = new Chips().getChipsTypeList();  // Get list of available chips types

        do {
            try {
                System.out.println("==========================================");
                System.out.println("        🥔 Select Your Chips 🥔           ");
                System.out.println("==========================================");

                for (int i = 0; i < chipsTypeList.size(); i++) {
                    System.out.println("   " + (i + 1) + " - " + chipsTypeList.get(i));
                }
                System.out.println("   0 - Cancel Order");
                System.out.println("==========================================");

                int chipsChoice = Console.PromptForInt(">> ");

                if (chipsChoice == 0) {
                    System.out.println("Order canceled. Returning to main menu.");
                    return;
                } else if (chipsChoice >= 1 && chipsChoice <= chipsTypeList.size()) {
                    chipsType = chipsTypeList.get(chipsChoice - 1);
                    System.out.println("You selected: " + chipsType);

                    // CREATE CHIPS WITH THE SELECTED TYPE
                    Chips chip = new Chips(chipsType);
                    orderList.addItems(chip);  // Add the chip to the order list
                    System.out.println("Chips successfully added to your order.");
                    break;
                } else {
                    System.out.println("Invalid selection. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Invalid selection. Please try again.");
            }
        } while (true);
    }
}
