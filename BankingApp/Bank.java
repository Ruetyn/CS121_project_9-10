import java.io.*;
import java.util.*;

class CustomerList extends ArrayList<Customer> implements Serializable {}

public class Bank implements Serializable {
	
	private Admin admin;
	private CustomerList customers;

	public Bank() {
		admin = new Admin();
		loadCustomers();
		start();
		saveCustomers();
	} // end Bank()
	
	public void start() {
		Scanner scanner = new Scanner(System.in);
		boolean keepGoing = true;

		while (keepGoing) {
			System.out.println("\n--- Bank Menu ---\n" + "0) Exit system\n" + "1) Login as admin\n" + "2) Login as customer\n" + "Action: ");
			String choice = scanner.nextLine();
			if (choice.equals("0")) {
				keepGoing = false;
			} else if (choice.equals("1")) {
				startAdmin();
			} else if (choice.equals("2")) {
				loginAsCustomer();
			} else {
				System.out.println("Invalid option.");
			} // end if
		} // end while
	} // end start()
	
	public void startAdmin() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("\nAdmin Login");
		System.out.print("User name: ");
		String user = scanner.nextLine();
		System.out.print("PIN: ");
		String pin = scanner.nextLine();

		if (admin.login(user, pin)) {
			boolean keepGoing = true;
			while (keepGoing) {
				System.out.print(admin.menu());
				String choice = scanner.nextLine();
				if (choice.equals("0")) {
					keepGoing = false;
				} else if (choice.equals("1")) {
					fullCustomerReport();
				} else if (choice.equals("2")) {
					addUser();
				} else if (choice.equals("3")) {
					applyInterest();
				} else {
					System.out.println("Invalid option.");
				} // end if
			} // end while
		} else {
			System.out.println("Invalid admin login.");
		} // end if
	} // end startAdmin()
	
	public void fullCustomerReport() {
		System.out.println("\nFull Customer Report");
		for (Customer c : customers) {
			System.out.println(c.getReport());
		} // end for
	} // end fullCustomerReport()
	
	public void addUser() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("\nAdd User");
		System.out.print("Name: ");
		String name = scanner.nextLine();
		System.out.print("PIN: ");
		String pin = scanner.nextLine();

		Customer newCustomer = new Customer(name, pin);
		customers.add(newCustomer);
		System.out.println("User added successfully.");
	} // end addUser()
	
	public void applyInterest() {
		System.out.println("\nApply Interest");
		for (Customer c : customers) {
			c.getSavings().calcInterest();
		} // end for
	} // end applyInterest()
	
	public void loginAsCustomer() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("\nCustomer Login");
		System.out.print("User name: ");
		String name = scanner.nextLine();
		System.out.print("PIN: ");
		String pin = scanner.nextLine();
		boolean found = false;

		for (Customer c : customers) {
			if (c.login(name, pin)) {
				System.out.println("Login successful.");
				c.start();
				found = true;
				break;
			} // end if
		} // end for
		if (!found) {
			System.out.println("Invalid username or PIN.");
		} // end if
	} // end loginAsCustomer()
	
	public void loadSampleCustomers() {
		customers = new CustomerList();

		Customer alice = new Customer("Alice", "1111");
		alice.getChecking().setBalance(1000);
		alice.getSavings().setBalance(1000);
		customers.add(alice);
		customers.add(new Customer("Bob", "2222"));
		customers.add(new Customer("Cindy", "3333"));
		System.out.println("Sample customers loaded.");
	} // end loadSampleCustomes()
	
	public void saveCustomers() {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("customers.dat"))) {
			out.writeObject(customers);
		} catch (IOException e) {
			System.out.println("Error saving customers: " + e.getMessage());
		} // end try/catch
	} // end saveCustomers()
	
	public void loadCustomers() {
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("customers.dat"))) {
			customers = (CustomerList) in.readObject();
			System.out.println("Customers loaded from file.");
		} catch (Exception e) {
			System.out.println("No saved data found. Loading sample customer...");
			loadSampleCustomers();
		} // end try/catch
	} // end loadCustomers()
	
	public static void main(String[] args) {
		new Bank();
	} // end main
} // end Bank class
