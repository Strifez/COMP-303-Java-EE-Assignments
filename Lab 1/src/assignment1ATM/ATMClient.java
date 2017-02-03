package assignment1ATM;

import javax.swing.JOptionPane;

public class ATMClient {

	public static void main(String[] args) {
		//new object with values 
				AccountImpl myAccount = new AccountImpl(12345,100.00);
			    
				int entry=0; 
				//while loop to allow the user the option to pick if they want to Withdraw, Deposit or Show Balance
			    while (entry != 4) //As long as the number is not equal to 4 the program will not close even if you enter a number not in the options
			    {
			    	//Menu Beginning asking the user to chose what they want to do
			    	entry = Integer.parseInt(JOptionPane.showInputDialog("Enter one of the Following: "
			 	    		+ " 1 - Withdraw "
			 	    		+ " 2 - Deposit "
			 	    		+ " 3 - Show Balance"
			 	    		+ " 4 - Quit"));
			    //if user press 1 they will put in an amount to take out from the account	
			    if (entry == 1)
			    {
			    	//Convert a string to a double because we are dealing with balance, User can make Withdrawal
					double withdrawAmount = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter Withdraw Amount:"));
					AccountImpl.withdraw(withdrawAmount);
					
					//Show the Balance after withdraw
					JOptionPane.showMessageDialog(null, AccountImpl.getAccountInfo());
					
			    }
			    // if user press 2 they will deposit amount to account
			    else if (entry == 2)
			    {
			    	//User can make a Deposit
					double depositAmount = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter Deposit Amount: "));
					AccountImpl.deposit(depositAmount);
					
					JOptionPane.showMessageDialog(null, AccountImpl.getAccountInfo());
			    	
			    }
			    // if user press 3 they will see their current Balance
			    else if (entry == 3)
			    {
			    	//shows initial Information
					JOptionPane.showMessageDialog(null, AccountImpl.getAccountInfo());
					
			    }
			    // if user press 4 the program will close
			    else if (entry == 4)
			    {
			    	JOptionPane.showMessageDialog(null, "GoodBye");
			    	System.exit(0);
			    }
			    }
			 
	}

}
