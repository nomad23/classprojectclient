
import java.io.*;
import java.net.*;

import javax.swing.JOptionPane;


public class SocketClient {

	/**
	 * @param args
	 */
	
	
	public static String clientInputReader() throws IOException{
		
		BufferedReader clientIn = new BufferedReader(
		        new InputStreamReader(System.in));
		String userInput;
		userInput =clientIn.readLine();		
		return userInput;
	}
//public static String clientInputReader2() throws IOException{
//		
//		BufferedReader clientInn = new BufferedReader(
//		        new InputStreamReader(System.in));
//		String userInputt;
//		userInputt =clientInn.readLine();		
//		return userInputt;
//	}
	
	public static boolean sendToServer(Socket theSocket,String data) throws IOException{
		//Socket echoSocket;
		PrintWriter out = null;
		out = new PrintWriter(theSocket.getOutputStream(), true);
		out.println(data);
		return true;
	}
	public static boolean printToScreen(Socket theSocket) throws IOException{
		
		 BufferedReader	in2 = new BufferedReader(new InputStreamReader(
		        theSocket.getInputStream()));
		
		 
		 // Get first sentence returned from server that comes back with length
		 int stringLength = Integer.parseInt(in2.readLine());
		
		 //Create character array with dynamic string length to stop read when sentence is fully captured:
		 char[] inputChars = new char[stringLength];
		 int charsRead = 0;
		 if ((charsRead =  in2.read(inputChars)) != -1)
         {
			 //System.out.flush();
             //System.out.println("Chars read from stream: " + charsRead); 
			 String s =new String(inputChars);
			 JOptionPane.showMessageDialog(null,s);

             System.out.println(inputChars);
             System.out.flush();
         }

		return true;
	}
	
public static boolean getNumber (clientProtocol protocol,Socket theSocket)throws  IOException{
	String studentNumber = JOptionPane.showInputDialog(
            "Enter The Student's Number:");
    if(!protocol.receiveNumber(studentNumber)){
    	JOptionPane.showMessageDialog(null,"Please Input an Integer");
    	SocketClient.getNumber(protocol, theSocket);
    }
    else{
    	SocketClient.sendToServer(theSocket,studentNumber);
        SocketClient.printToScreen(theSocket);
    }
	return true;
}

public static boolean getName (clientProtocol protocol,Socket theSocket)throws  IOException{
	String studentName = JOptionPane.showInputDialog(
            "Enter The Student's Name:");
    if(!protocol.receiveName(studentName)){
    	JOptionPane.showMessageDialog(null,"Please Input a String");
    	SocketClient.getName(protocol, theSocket);
    }
    else{
    	SocketClient.sendToServer(theSocket,studentName);
        SocketClient.printToScreen(theSocket);
    }
	return true;
}

	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		//System.out.println("Hahhahhaha");
		 clientProtocol protocol = new clientProtocol();
		 	Socket echoSocket = null;
	        PrintWriter out = null;
	        BufferedReader in=null;
	        String host = null ;
	       

	        try {
	            echoSocket = new Socket(InetAddress.getByName(null), 9101);
	            out = new PrintWriter(echoSocket.getOutputStream(), true);
	            in = new BufferedReader(new InputStreamReader(
	                                        echoSocket.getInputStream()));

	            for (int i = 0; i < 2; i++) {	
System.out.println(in.readLine());
}

	            SocketClient.getNumber(protocol,echoSocket);
	            SocketClient.getName(protocol,echoSocket);

    
	        } catch (UnknownHostException e) {
	            System.err.println("Don't know about host: "+host);
	            System.exit(1);
	        } catch (IOException e) {
	            System.err.println("Couldn't get I/O for "
	                               + "the connection to: "+host);
	            System.exit(1);
	        }

		

		
		out.close();
		in.close();
		//stdIn.close();
		echoSocket.close();
	    }
		
	}


