package assignment1ATM;

import java.net.*;
import java.io.*;


public class ATMServer {

	 // Choose a port outside of the range 1-1024:
	  public static final int PORT = 8090;
	  public static void main(String[] args)
	      throws IOException {
	    ServerSocket s = new ServerSocket(PORT);
	    System.out.println("Started: " + s);
	    try {
	      // Blocks until a connection occurs:
	      Socket socket = s.accept();
	      try {
	        System.out.println(
	          "Connection accepted: "+ socket);
	        BufferedReader in =
	          new BufferedReader(
	            new InputStreamReader(
	              socket.getInputStream()));
	        // Output is automatically flushed
	        // by PrintWriter:
	        PrintWriter out =
	          new PrintWriter(
	            new BufferedWriter(
	              new OutputStreamWriter(
	                socket.getOutputStream())),true);
	        while (true) {
	        	//read the client if someone send END1 stop if not recieve what the client is sending
	          String str = in.readLine();
	          if (str.equals("END")) break;
	          System.out.println("Echoing: " + str);
	          out.println(str);
	        }
	      // Always close the two sockets...
	      } finally {
	        System.out.println("closing...");
	        socket.close();
	      }
	    } finally {
	      s.close();
	    }
	  }
}
