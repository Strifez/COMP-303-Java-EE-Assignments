package assignment1ATM;

import java.net.*;

import javax.swing.JOptionPane;

import java.io.*;


public class ATMClient {
	 public static void main(String[] args)
		      throws IOException {
	InetAddress addr = InetAddress.getByName(null);

    System.out.println("addr = " + addr);
    Socket socket = new Socket(addr, ATMServer.PORT); //the port on MyServer.java
    //Socket socket = new Socket("10.28.38.129", MyServer.PORT);

    try {
      System.out.println("socket = " + socket);
      BufferedReader in =
        new BufferedReader(
          new InputStreamReader(
            socket.getInputStream()));
      
      AccountImpl myAccount = new AccountImpl(12345, 1000.00);
      
      int entry=0;
      
      while (entry!=4) {
    	  
    	  entry = Integer.parseInt(JOptionPane.showInputDialog("Enter one of the following: "
    			  + " 1 - Withdraw"
    			  + " 2 - Deposit"
    			  + " 3 - Show Balance"
	 	    	  + " 4 - Quit"));
    	//if user press 1 they will put in an amount to take out from the account	
  	    if (entry == 1)
  	    {
  	    	//Convert a string to a double because we are dealing with balance, User can make Withdrawal
  			double withdrawAmount = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter Withdraw Amount:"));
  			myAccount.withdraw(withdrawAmount);
  			
  			//Show the Balance after withdraw
  			JOptionPane.showMessageDialog(null, myAccount.getAccountInfo());	
  			
  	    }
  	// if user press 2 they will deposit amount to account
	    else if (entry == 2)
	    {
	    	//User can make a Deposit
			double depositAmount = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter Deposit Amount: "));
			myAccount.deposit(depositAmount);
			
			JOptionPane.showMessageDialog(null, myAccount.getAccountInfo());
	    	
	    }
	    // if user press 3 they will see their current Balance
	    else if (entry == 3)
	    {
	    	//shows initial Information
			JOptionPane.showMessageDialog(null, myAccount.getAccountInfo());
			
	    }
	    // if user press 4 the program will close
	    else if (entry == 4)
	    {
	    	JOptionPane.showMessageDialog(null, "GoodBye");
	    	PrintWriter out =
	        new PrintWriter(
	          new BufferedWriter(
	            new OutputStreamWriter(
	              socket.getOutputStream())),true);
	    	out.println("END");
	    	String str = in.readLine();
	        System.out.println(str);
	    	//System.exit(0);
	    }
      }
    } finally {
      System.out.println("closing...");
      socket.close();
    }
  }
}

