
import java.io.*;
import java.net.*;


public class SocketClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		//System.out.println("Hahhahhaha");
		 	Socket echoSocket = null;
	        PrintWriter out = null;
	        BufferedReader in=null,in3 = null;
	        String host = null ;
	        BufferedReader in2 = null;

	        try {
	            echoSocket = new Socket(InetAddress.getByName(null), 9101);
	            out = new PrintWriter(echoSocket.getOutputStream(), true);
	            in = new BufferedReader(new InputStreamReader(
	                                        echoSocket.getInputStream()));
//	            while(in.readLine()!=null){
//	            	System.out.println(in.readLine());
//	            }

	            for (int i = 0; i < 2; i++) {	
System.out.println(in.readLine());
}
//	            while (in.readLine()!=null) {	
//	            	System.out.println(in.readLine());
//	            	}



BufferedReader stdIn = new BufferedReader(
        new InputStreamReader(System.in));
String userInput;
userInput = stdIn.readLine();
out.println(userInput);

in2 = new BufferedReader(new InputStreamReader(
        echoSocket.getInputStream()));

for (int i = 0; i < 3; i++) {	
System.out.println(in2.readLine());
}



BufferedReader stdIn2 = new BufferedReader(
        new InputStreamReader(System.in));
String studentName;
studentName = stdIn.readLine();
out.println(studentName);

in3 = new BufferedReader(new InputStreamReader(
        echoSocket.getInputStream()));

for (int i = 0; i < 3; i++) {	
System.out.println(in3.readLine());
}




	            
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


