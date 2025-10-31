import java.io.Serializable;
import java.util.*;

public abstract class User implements HasMenu, Serializable {
	protected String userName;
	protected String PIN;

	public boolean login() {
		boolean result = false;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter username: ");
		String enteredUserName = scanner.nextLine();
		System.out.println("Enter PIN: ");
		String enteredPIN = scanner.nextLine();
		boolean correctUser = this.userName.equals(enteredUserName);
		boolean correctPIN = this.PIN.equals(enteredPIN);
		if (!correctUser && !correctPIN) {
			System.out.println("Incorrect username and PIN.");
		} else if (!correctUser && correctPIN) {
			System.out.println("Incorrect username.");
		} else if (correctUser && !correctPIN) {
			System.out.println("Incorrect PIN.");
		} else {
			System.out.println("Login successful.");
			result = true;
		} // end if
		return result;
	} // end login()
	
	public boolean login(String userName, String PIN) {
		boolean result = false;
		if  (this.userName.equals(userName) && this.PIN.equals(PIN)) {
			result = true;
		} // end if
		return result;
	} // end login(string, string)
	
	public void setUserName(String userName) {
		this.userName = userName;
	} // end setUserName(String)
	
	public String getUserName() {
		return userName;
	} // end getUserName ()
	
	public void setPIN(String PIN) {
		this.PIN = PIN;
	} // end setPIN(String)
	
	public String getPIN() {
		return PIN;
	} // end getPIN()
	
	public abstract String getReport();
} // end User	
