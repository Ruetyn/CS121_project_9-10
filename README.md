# CS121_project_9-10
```
classDiagram
class HasMenu {
    + menu(): String
    + start(): void
}

class CheckingAccount {
    - balance: double
    + CheckingAccount()
    + CheckingAccount(Balance)
    + main()void
    + menu()String
    + start()String
    + getBalance()double
    + getBalanceString()String
    + setBalance(balance)void
    + checkBalance()void
    - getDouble()double
    + makeDeposit()void
    + makeWithdrawal()void
}

class SavingsAccount {
    - interestRate: double
    + main(*)
    + calcinterest()void
    + setInterestRate()void
    + getInterestRate()void
}

class Customer {
    - checking: CheckingAccount
    - savings: SavingsAccount
    + main()void
    + Customer()
    + start()void
    + menu()String
    + changePIN()void
    + getReport()(abstract)String
}

class User {
    - userName: String
    - PIN: String
    + login()boolean
    + login(userName, PIN)boolean
    + setUserName(userName)void
    + getUserName()String
    + setPIN(PIN)void
    + getPIN()String
    + getReport()(abstract)String
}

SavingsAccount --|> CheckingAccount
Customer --|> User
CheckingAccount ..|> HasMenu
User ..|> HasMenu
```

## HasMenu
HasMenu Interface
```
Define an interface named HasMenu
menu() that returns a string showing options to the user
start() that runs the menu system
```

## CheckingAccount
CheckingAccount()
```
Define a class named CheckingAccount that implements HasMenu
Create a variable called balance to hold a double number

Constructor with no parameters:
  set balance to 0.0

Constructor with balance parameter:
  set balance to the given balance

Define menu method:
  return a text menu with options to exit, check balance, deposit, or withdraw

Define start method:
  create a scanner to get user input
  set keepGoing to true
  while keepGoing is true:
    show the menu and ask for a choice
    if choice is 0:
      set keepGoing to false  
    elif choice is 1:
      call checKBalance
    elif choice is 2
      call makeDeposit
    elif choice is 3:
      call makeWithdrawal
    else:
      print "Invalid option"

Define getBalance method:
  return the balance

Define getBalanceString method:
  return the balance formatted as money with two decimal places

Define setBalance method:
  set balance to the given value

Define checkBalance method:
  print "Your balance is: " + call getBalanceString

Define getDouble method:
  try to read a number from the user
  if it fails, print an error and return 0.0\

Define makeDeposit method:
  ask the user for an amount
  if the amount is positive:
    add it to balance
    print a success message
  else:
    print "Invalid deposit ammount"

Define makeWithdrawal method:
  ask the user for an amount
  if the amount is greater than 0 and less than or equal to balance:
    subtract it from balance
    print a success message
  else:
    print "Invalid withdrawal amount"
```

## SavingsAccount
SavingsAccount()
```
Define a class called SavingsAccount that extends CheckingAccount
Create a variable called interestRate to hold a double number

Constructor with no parameters:
  call the parent constructor to set balance to 0
  set interestRate to 0.01

Constructor with balance and interest rate parameters:
  call the parent constructor to set balance to the given value
  set interestRate to the given rate

Define calcInterest method:
  calculate the interest as balance times interestRate
  add interest to balance
  print how much interest was added

Define setInterestRate method:
  set interesstRate to the given value

Define getInerestRate method:
  return the interestRate
```

## User (Abstract)
User()
```
Define an abstract class named User that implements HasMenu and Serializable
Create variables userName and PIN as Strings

Define the login method with no parameters:
  set a boolean varaible result to false
  create a new scanner object to read user input
  print "Enter Username: "
  read the entered username and store it in enteredUserName
  print "Enter PIN: "
  read the entered PIN and store it in enteredPIN
  compare userName to enteredUserName and store the result in a boolean correctUser
  compare PIN to enteredPIN and store the result in a boolean correctPIN
  if both correctUser and correctPIN are false
    print "Incorrect username and PIN"
  elif correctUser is false and correctPIN is true
    print "Incorrect username"
  elif correctUser is true and corretPIN is false
    print "Incorrect PIN"
  else:
    print "Login successful"
    set result to ture
  return result

Define the login method that takes two string parameters:
  set boolean variable result to false
  if stored userName equals given userName and stored PIN equals given PIN:
    set result to true
  return result

Define setUserName method:
  set userName to the given value

Define getUserName method:
  return userName

Define setPIN method:
  set PIN to the given value

Define getPIN method:
  return PIN

Define an abstract getReport method that will be written by subclasses
```

## Customer
Customer()
```
Define a class named Customer that extends User
Create variables checking as a CheckingAccount and savings as a SavingsAccount

Constructor with no parameters:
  create a new CheckingAccount and a new SavingsAccount
  set userName to "Alice"
  set PIN to "0000"

Constructor with userName and PIN parameters:
  call the no parameter constructor
  set userName to the given userName
  set PIN to the given PIN

Define start method:
  create a scanner to get input
  set keepGoing to true
  while keepGoing is true:
    show the menu
    get the user's choice
    if choice is 0:
      set keepGoing to false
    elif choice is 1:
      call checking.start
    elif choice is 2:
      call savings.start
    elif choice is 3:
      call changePIN
    else:
      print "Invalid option"

Define menu method:
  return a text menu with options exit, checkins, savings, or change PIN

Define changePIN method:
  ask the user for a new PIN
  set PIN to the new value
  print "PIN changed successfully"

Define getReport method:
  return a string with the userName, checking balance, savings balance, and interest rate
```
