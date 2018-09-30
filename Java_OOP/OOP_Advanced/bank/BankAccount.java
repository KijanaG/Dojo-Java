package oop.advanced.bank;

public class BankAccount {
	private String accountNumber;
	private double checkingsBalance;
	private double savingsBalance;
	private static int totalAccounts;
	private static double totalAmount;
	
	public BankAccount() {
		createAccountNumber();
		totalAccounts+= 1;
	}
	private String createAccountNumber() {
		accountNumber = "";
		for(int i=0;i<10;i++) {
			int r = (int) Math.floor(Math.random()*10);
			accountNumber += r;
		}
		return accountNumber;
	}
	public double getCheckingsBalance() {
		return checkingsBalance;
	}
	public double getSavingsBalance() {
		return savingsBalance;
	}
	public void depositMoney(double amount, char account) {
		if(account == 'S' || account == 's') {
			totalAmount+=amount;
			savingsBalance += amount;
		} else if(account=='C' || account=='c') {
			totalAmount+=amount;
			checkingsBalance += amount;
		} else {
			System.out.println("Could not add money to account. Must provide 's' or 'c' for savings or checkings respectively.");
		}
	}
	public double withdraw(int amount, char account) {
		if(account == 'S' && amount <= savingsBalance || account == 's' && amount <= savingsBalance) {
			totalAmount-=amount;
			savingsBalance -= amount;
			return amount;
		} else if(account == 'C' && amount <= checkingsBalance || account == 'c' && amount <= checkingsBalance) {
			totalAmount-=amount;
			checkingsBalance -= amount;
			return amount;
		} else {
			System.out.println("Could not withdraw funds. Checkings Balance: "+checkingsBalance+" Savings Balance: "+savingsBalance);
			System.out.println("Must provide 's' or 'c' for savings or checkings respectively.");
			return amount;
		}
	}
	public void showTotals() {
		System.out.println("Checkings total: "+checkingsBalance);
		System.out.println("Savings total: "+savingsBalance);
	}
	public static String privateInfo() {
		return "Total Amount: " +totalAmount+" Total Accounts: "+totalAccounts;
	}
}
