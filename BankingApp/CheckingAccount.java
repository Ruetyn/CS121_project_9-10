import java.util.*;

public class CheckingAccount implements HasMenu {
	private double balance;

	public CheckingAccount() {
		this.balance = 0.0;
	} // end CheckingAccount

	public CheckingAccount(double balance) {
		this.balance = balance;
	} // end CheckingAccount(double)	

	public static void main(String[] args) {
		CheckingAccount account = new CheckingAccount();
		account.start();
	} // end main()

	@Override
	public String menu() {
		return "\n--- Checking Account Menu ---\n" + "0) Exit\n" + "1) Check Balance\n" + "2) Make a Deposit\n" + "3) Make a Withdrawal\n" + "Enter choice (0-3): ";
	} // end menu
	

	@Override
	public void start() {
		Scanner scanner = new Scanner(System.in);
		boolean keepGoing = true;
		while(keepGoing) {
			System.out.print(menu());
			int choice = (int)getDouble(scanner);
			if (choice == 0) {
				keepGoing = false;
			} else if (choice == 1) {
				checkBalance();
			} else if (choice == 2) {
				makeDeposit();
			} else if (choice == 3) {
				makeWithdrawal();
			} else {
				System.out.println("Invalid option.");
			} // end if
		} // end while
	} // end start()
	
	public double getBalance() {
		return balance;
	} // end getBalance()

	public String getBalanceString() {
		return String.format("$%.2f", balance);
	} // end getBalanceString()

	public void setBalance(double balance) {
		this.balance = balance;
	} // end setBalance()

	public void checkBalance() {
		System.out.println("Your balance is: " + getBalanceString());
	} // end checkBalance()

	private double getDouble(Scanner scanner) {
		try {
			return Double.parseDouble(scanner.nextLine());
		} catch (Exception e) {
			System.out.println("Invalid input, returning 0.");
			return 0.0;
		}
	} // end getDouble()
	
	public void makeDeposit() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter deposit amount: ");
		double amount = getDouble(scanner);
		if (amount > 0) {
			balance += amount;
			System.out.println("Deposit successful.");
		} else {
			System.out.println("Invalid deposit amount.");
		} // end if
	} // end makeDeposit()
	
	public void makeWithdrawal() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter withdrawal amount: ");
		double amount = getDouble(scanner);
		if (amount > 0 && amount <= balance) {
			balance -= amount;
			System.out.println("Withdrawal successful.");
		} else {
			System.out.println("Invalid withdrawal amount.");
		} // end if
	} // end makeWithdrawal
}	
