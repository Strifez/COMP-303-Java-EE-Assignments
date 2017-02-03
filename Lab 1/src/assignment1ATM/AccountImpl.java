package assignment1ATM;

public class AccountImpl implements Account {
	private static int accountNumber; // account number
	private static double balance; // funds available for withdrawal
	
	// Account constructor initializes attributes
	   public AccountImpl(int AccountNumber, 
	      double AvailableBalance)
	   {
	      accountNumber = AccountNumber;
	      balance = AvailableBalance;
	   } // end Account constructor
	   
	   // deposits an amount to the account
	   public void deposit(double amount)
	   {
		   if(amount > 0.0)
		   {
			   balance += amount; // add to total balance
		   }
		   
		   return;
	   } // end method deposit

	   // withdraws an amount from the account
	   public void withdraw(double amount)
	   {
		   if (amount > 0.0)
		   {
			   balance -= amount; // subtract from available balance
		   }
		   return;
	   } // end method withdraw
	   
	// Method to get Account Information
		public static Object getAccountInfo()
		{
			String accountInfo = String.format("Account Number: %.2f%n Owners Name: %s%n Balance: $%.2f%n", accountNumber, balance);
			return accountInfo;
		}
}
