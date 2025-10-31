import java.util.*;

public class Customer extends User {
	private CheckingAccount checking;
	private SavingsAccount savings;
	
	public Customer() {
		this.checking = new CheckingAccount();
		this.savings = new SavingsAccount();
		this.userName = "Alice";
		this.PIN = "0000";
	} // end Customer()
	
	public Customer(String userName, String PIN) {
		this();
		this.userName = userName;
		this.PIN = PIN;
	} // end Customer(String, String)
	
	@Override
	public void start() {
		boolean keepGoing = true;
		Scanner scanner = new Scanner(System.in);
		while (keepGoing) {
			System.out.print(menu());
			int choice = Integer.parseInt(scanner.nextLine());
			if (choice == 0) {
                                keepGoing = false;
                        } else if (choice == 1) {
                                checking.start();
                        } else if (choice == 2) {
                                savings.start();
                        } else if (choice == 3) {
                                changePIN();
                        } else {
                                System.out.println("Invalid option.");
                        } // end if
		} // end while
	} // end start()
	
	@Override
	public String menu() {
		return "\n--- Customer Menu ---\n" + "0) Exit\n" + "1) Checking Account\n" + "2) Savings Account\n" + "3) Change PIN\n" + "Enter choice (0-3): ";
	} // end menu()
	
	public void changePIN() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter new PIN: ");
		String newPIN = scanner.nextLine();
		setPIN(newPIN);
		System.out.println("PIN changed successfully.");
	} // end changePIN()
	
	@Override
	public String getReport() {
		return "User: " + userName + "\nChecking Balance: " + checking.getBalanceString() + "\nSavings Balance: " + savings.getBalanceString() + "\nInterest Rate: " + savings.getInterestRate();
	} // end getReport()
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("User name: ");
		String name = scanner.nextLine();
		System.out.println("PIN: ");
		String pin = scanner.nextLine();
		
		Customer test = new Customer(name, pin);

		if (test.login(name, pin)) {
			System.out.println("Login successful\n");
			test.start();
		} else {
			System.out.println("Login failed.");
		} // end if
	} // end main
} // end Customer
