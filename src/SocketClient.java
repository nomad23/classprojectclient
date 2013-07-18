
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
	        BufferedReader in = null;
	        String host = null ;

	        try {
	            echoSocket = new Socket(InetAddress.getByName(null), 9091);
	            out = new PrintWriter(echoSocket.getOutputStream(), true);
	            in = new BufferedReader(new InputStreamReader(
	                                        echoSocket.getInputStream()));
	        } catch (UnknownHostException e) {
	            System.err.println("Don't know about host: "+host);
	            System.exit(1);
	        } catch (IOException e) {
	            System.err.println("Couldn't get I/O for "
	                               + "the connection to: "+host);
	            System.exit(1);
	        }

		BufferedReader stdIn = new BufferedReader(
	                                   new InputStreamReader(System.in));
		String userInput;

		while ((userInput = stdIn.readLine()) != null) {
		    out.println(userInput);
		    System.out.println("echo: " + in.readLine());
		}

		out.close();
		in.close();
		stdIn.close();
		echoSocket.close();
	    }
		
	}


