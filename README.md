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



---

## Application Demo

### Home Screen


### Ledger Menu
- **A) All**: Display all entries.
- **D) Deposits**: Show only deposits.
- **P) Payments**: Show only payments.
- **R) Reports**: Access predefined reports or custom search.
- **H) Home**: Return to the home page.

### Reports Menu
- **1) Month To Date**
- **2) Previous Month**
- **3) Year To Date**
- **4) Previous Year**
- **5) Search by Vendor**
- **0) Back**

Transactions are saved to and read from [transactions.csv](https://github.com/NikeshSitaula1/AccountingLedgerApplication/blob/main/transactions.csv)

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

## Screenshots

### Home Screen
Screenshot of Home Screen.
Can use either numbers or the Letters on the [ ] to choose an option.
![HomeScreen](https://i.imgur.com/vvxyLvJ.png)

### Ledger Screen
Screenshot of Ledger Screen and the number 3
that has been entered on the home screen to open the ledger screen
![LedgerScreen](https://i.imgur.com/DdKtMj0.png)

### Report Screen
Screenshot of Report Screen and the number 4 that has been entered
on the ledger screen to open the report screen
![ReportScreen](https://i.imgur.com/zkOztXU.png)


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