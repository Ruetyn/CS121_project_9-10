public class SavingsAccount extends CheckingAccount {
	private double interestRate;

	public SavingsAccount() {
		super();
		this.interestRate = 0.01;
	} // end SavingsAccount()
	
	public SavingsAccount(double balance, double interestRate) {
		super(balance);
		this.interestRate = interestRate;
	} // end SavingsAccount(double, double)
	
	public void calcInterest() {
		double interest = getBalance() * interestRate;
		setBalance(getBalance() +interest);
		System.out.println("Interest added: " + String.format("$%.2f", interest));
	} // end calcInterest()
	
	public void setInterestRate(double rate) {
		this.interestRate = rate;
	} // end setInterestRate(double)
	
	public double getInterestRate() {
		return interestRate;
	} // end getInterestRate()
	
	public static void main(String[] args) {
		SavingsAccount savings = new SavingsAccount(1000, 0.05);
		savings.calcInterest();
		savings.checkBalance();
	} // end main
} // end SavingsAccount
