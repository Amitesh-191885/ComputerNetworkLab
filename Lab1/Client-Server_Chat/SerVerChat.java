/*
 * By: Amitesh Ranjan
 * Roll: 191885
 */

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class SerVerChat {

	public static void main(String[] args) throws IOException {
		ServerSocket SERVERSoc = new ServerSocket(440);
		System.out.println("Server is connecting....");
		System.out.println("You are welcome in server client chat...");
		
		Socket ConSoc = SERVERSoc.accept();
		System.out.println("Connection Established....");
		String messageIn="",messageout;
		
		BufferedReader BufRead = new BufferedReader(new InputStreamReader(System.in));
		
		DataInputStream dataIn = new DataInputStream(ConSoc.getInputStream());
		DataOutputStream dataOut = new DataOutputStream(ConSoc.getOutputStream());
		
		while(!messageIn.equals("Bye")) {
			messageIn= dataIn.readUTF();
			System.out.println("Client: "+messageIn);
			System.out.print("Me: ");
			messageout = BufRead.readLine();
			
			dataOut.writeUTF(messageout);
			dataOut.flush();
		}
		
		dataIn.close();
		ConSoc.close();
		SERVERSoc.close();
	}
}
