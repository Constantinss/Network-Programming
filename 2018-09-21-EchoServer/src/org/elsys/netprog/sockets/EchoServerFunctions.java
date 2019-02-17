package org.elsys.netprog.sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EchoServer {

	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(10001);
		    Socket clientSocket = serverSocket.accept();
		    System.out.println("client connected from " + clientSocket.getInetAddress());
		    PrintWriter out =
		        new PrintWriter(clientSocket.getOutputStream(), true);
		    BufferedReader in = new BufferedReader(
		        new InputStreamReader(clientSocket.getInputStream()));
		    
		    String inputLine = in.readLine();
		    double sum = 0;
		    double n;
		    String operation = "add";
		    String[] operations = new String[] {"add", "sub", "mul", "div"};

		    while (!"exit".equals(inputLine)) {
		    	try {
		    		n = Double.parseDouble(inputLine);
		    		
		    		switch (operation) {
			    	case "add":
			    		sum += n;
			    		break;
					case "sub":
						sum -= n;
			    		break;
					case "mul":
						sum *= n;
						break;
					case "div":
						if (n == 0f) {
							out.println("Cannot divide by zero!");
					        System.out.println("Cannot divide by zero!");
						}
						sum /= n;
						break;
			    	}
		    		
		    		//out.println(sum);
		    	} catch (NumberFormatException e) {
		    		if (Arrays.asList(operations).contains(inputLine)) {
		    			operation = inputLine;
		    		} else {
		    			out.println("error");
			    		System.out.println("error");
		    		}
		    	}
		    	
		    	out.println(sum);
		    	
		    	inputLine = in.readLine();
		    }
		} catch (Throwable t) {
			System.out.println(t.getMessage());
		} finally {
			if (serverSocket != null && !serverSocket.isClosed()) {
				serverSocket.close();
			}
			
			System.out.println("Server closed");
		}
	}

}
