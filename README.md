# 🥪 DELI-CIOUS Application 🥪

## Project Overview

YearUp Capstone 2, a Java-based ordering system designed for a deli shop. This project allows users to create custom or 
signature sandwiches, add drinks, chips, and manage their orders seamlessly through a console-based interface. 

---

# Table of Contents

- [Application Structure](#Application-Structure)
- [Application Demo](#Application-Demo)
- [Getting Started](#Getting-Started)
- [Interesting code](#Interesting-Code)
- [License](#License)


---

## Application Structure

- User Interface to Order: User interface classes will ask for input and store it in the order class. 
Order File Manager would then write the stored content into text file.

![UserInterfaceToDiagram](https://i.imgur.com/riTeBDS.png)

- Sandwiches, Drinks and Chips are saved in Items class, as they are extended towards Items with Inheritance. Signature sandwich is extend to Sandwich. 
Topping is not extended, as topping is not a sandwich, rather sandwich has toppings 

![ItemsInItemsClass](https://i.imgur.com/KTEW7yA.png)

- Order will collect the Items as list, which would be the main data to write in the Receipt with File Manager. 

![ItemsCollectedInOrders](https://i.imgur.com/2eC9DEB.png)

---

## Application Demo

**Some Demos:**

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
- Java Development Kit (JDK) 14 or higher
- Text Editor or IDE (IntelliJ IDEA)
- Build System - Maven

### Installation
1. **Clone the repository** to your local machine:
    ```bash
   git clone https://github.com/NikeshSitaula1/DELI-cious.git
2. Navigate to the project directory:
    ```bash
   cd DELI-cious
3. Run the Application using an IDE and run the `Main` class

---

## Interesting Code

#### for (int i = 0; i < breadOptions.size(); i++) {
#### System.out.printf("   %d - %s%n", i + 1, breadOptions.get(i));
#### }

- A simple but a very effective code to me as I use this code a lot in my capstone. I used List, in this example, breadOptions 
which to print each item. This code loop goes through each index of the breadOptions list, starting from i = 0 and continuing
as long as variable i is less than the size of the list (breadOptions.size()). i++: After each iteration, i increments by 1, moving to 
the next item in the list. It then prints the option i + 1, so it does not start from 0, and gets the current index of i 
from the breadOptions list. If I ever add an item to the list, it will automatically add them and show as an option.

---

## License

This project is licensed under the MIT License.

---
