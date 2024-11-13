package com.pluralsight.Screens;

import com.pluralsight.Items.Chips;
import com.pluralsight.util.Console;

import java.util.List;

import static com.pluralsight.Screens.UserInterface.orderList;

public class ChipsInterface {
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
}
