# UnusualSpends Design

## OOMD Design For Unsual money spend using credit card By comparing categories.

## Classes:
1. `CustomerDetails`
2. `TrassactionManager`
3. `Spents`
4. `categories`
   
## Interfaces:
1. `AlertMeassage`


## States Of each classes:
1.  `CustomerDetails`:String customerName(private),String Email(private).
2.  `TransactionManager`:Long AccountNumber(private).
3.  `Spents`:Long AmountSpent(private),Date DateOfSpent(public),String NameOfProduct(public),Long priceOfProduct(public)
4.  `categories`:Enum TypesOfCategory(public).
5.  `AlertMeaage`:String MessageToSent(private),String reciversaddress(private).(polymorphism)
    

## Behaviors of CustomerDetails Class

### 1. `CustomerDetails`:

1.1. `getUserName()`: String
   Returns the user's name.

1.2. `getEmail()`: String
   Returns the user's email address.

## Behaviors of TransactionManager Class

### 2. `TransactionManager`:

2.1. `getTransactionOfCurrentMonth()`: Long
   Returns the total transaction amount for the current month.

2.2. `getTransactionOfPreviousMonth()`: Long
   Returns the total transaction amount for the previous month.

2.3. `getTransactionAnalysisByBothMonth()`: Long
   Returns the difference in transaction amounts between the current and previous months.

## Behaviors of Spents Class

### 3. `Spents`:

3.1. `getSpentsByCategory()`: Long
   Returns the total transaction amount spent in the current month.

3.2. `getSpentByMonthsAndDate()`: Long
   Returns the total transaction amount spent in the previous month.

## Behaviors of categories Enum

### 4. `categories` (Enum TypesOfCategory):
   Enumerates types of spending categories.

## Behaviors of Interface Of AlertMessage Class

### 5. `AlertMessage`:

5.1. `setMessage(message: String)`: void
   Sets the message content to be sent.

5.2. `setReceiverAddress(address: String)`: void
   Sets the recipient's address for the message.

5.3. `sendMessage()`: void
   Sends the message to the specified recipient, supporting implementations for both email and regular message.
