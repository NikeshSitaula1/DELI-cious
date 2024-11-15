# 🥪 DELI-CIOUS Application 🥪

## Project Overview

YearUp Capstone 2, a Java-based ordering system designed for a deli shop. This project allows users to create custom or 
signature sandwiches, add drinks, chips, and manage their orders seamlessly through a console-based interface. 

# Table of Contents

- [File Structure](#File-Structure)
- [Application Demo](#Application-Demo)
- [Getting Started](#Getting-Started)
- [Screenshots](#Screenshots)
- [Interesting code](#Interesting-Code)


---

## File Structure

- User Interface to Order: User interface classes will ask for input and store it in the order class. 
Order File Manager would then write the stored content into text file.

![UserInterfaceToDiagram](https://imgur.com/a/7LkDrNR)

- Sandwiches, Drinks and Chips are saved in Items class, as they are extended towards Items with Inheritance. Signature sandwich is extend to Sandwich. 
Topping is not extended, as topping is not a sandwich, rather sandwich has toppings 

![ItemsInItemsClass](https://imgur.com/a/LKRTfEY)

- Order will collect the Items as list, which would be the main data to write in the Receipt with File Manager. 

![ItemsCollectedInOrders](https://imgur.com/a/ttDaWQn)

---

## Application Demo

-Some Demos:

### User Interface

- Home Screen

![HomeScreen](https://raw.githubusercontent.com/NikeshSitaula1/DELI-cious/refs/heads/main/images/1.%20homescreen.png)

- Order Screen

![OrderScreen](https://raw.githubusercontent.com/NikeshSitaula1/DELI-cious/refs/heads/main/images/2.%20orderscreen.png)

### Menus

- Sandwich Options:

![SandwichOptions](https://raw.githubusercontent.com/NikeshSitaula1/DELI-cious/refs/heads/main/images/4.%20sandwich%20options.png)

- Drink Options

![DrinkOptions](https://raw.githubusercontent.com/NikeshSitaula1/DELI-cious/refs/heads/main/images/10.%20drink%20screen.png)

- Chips Options

![ChipsOptions](https://raw.githubusercontent.com/NikeshSitaula1/DELI-cious/refs/heads/main/images/11.%20chips%20screen.png)

### Receipts

![Receipts](https://raw.githubusercontent.com/NikeshSitaula1/DELI-cious/refs/heads/main/images/14.%20receipt.png)

---

## Getting Started

### Prerequisites
- Java Development Kit (JDK) 11 or higher
- Text Editor or IDE (IntelliJ IDEA)
- Build System - Maven

### Installation
1. **Clone the repository** to your local machine:
    ```bash
   git clone https://github.com/NikeshSitaula1/AccountingLedgerApplication.git
2. Navigate to the project directory:
    ```bash
   cd AcoountingLedgerApplication
3. Run the Application using an IDE

---



---
## Interesting Code


![Arraylist.size()+1](https://i.imgur.com/bYS9L1Z.png)
![Constructed ID](https://i.imgur.com/8FPaKlz.png)



I have created an instance variable, id for my Ledger class, thinking it would be
necessary for this project. However, I later realized that the application did not
require the id field. So, I did not want to create a function to call the id, but
leaving it alone would mean my object not working as it is tied to it. As such, instead of removing the id,
I decided to auto generate ids based on current size of the transactions list with ```transactions.size() + 1```.This
allowed me to keep track of entries, allowing each new entry to get a unique. incremental id automatically.
The problem of doing this way tho, is that, if an item is deleted from the transactions list, it will no
longer remain sequential and there will be unused ids.

- Latest update replaces the arraylist.size() + 1 to get an automatic ID with UUID, a much better way to get a unique ID.
- Thank you to all the feedback on my presentation for this update. 