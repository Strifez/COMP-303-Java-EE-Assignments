package assignment1ATM;

public class AccountImpl implements Account {
	private int accountNumber; // account number
	private double balance; // funds available for withdrawal
	
	// Account constructor initializes attributes
	   public AccountImpl(int AccountNumber, 
	      double AvailableBalance)
	   {
	      accountNumber = AccountNumber;
	      balance = AvailableBalance;
	   } // end Account constructor
	   
	//Getter and Setters   
	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	//Methods
	   // deposits an amount to the account
	   public void deposit(double depositAmount)
	   {
		   if(depositAmount > 0.0)
		   {
			   balance += depositAmount; // add to total balance
		   }
		   
		   return;
	   } // end method deposit

	   // withdraws an amount from the account
	   public void withdraw(double withdrawAmount)
	   {
		   if (withdrawAmount > 0.0)
		   {
			   balance -= withdrawAmount; // subtract from available balance
		   }
		   return;
	   } // end method withdraw
	   
	// Method to get Account Information
		public String getAccountInfo()
		{
			String accountInfo = String.format("Account Number: %.2f%n Balance: $%.2f%n", accountNumber, balance);
			return accountInfo;
		}

}
