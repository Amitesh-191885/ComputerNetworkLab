/*
 * By: Amitesh Ranjan
 * Roll: 191885
 */

/* Package */
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerChatTCP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to the connection oriented client chat application...");
		System.out.println("Server is Running...");
		try {
			ServerSocket ServSoc = new ServerSocket(9292);
			System.out.println("Welcome socket is waiting for connection...");
			Socket ConSoc = ServSoc.accept();
			System.out.println("Connected to Client...");
			String messagein="",messageout;
			
			BufferedReader BufRead = new BufferedReader(new InputStreamReader(System.in));
			DataInputStream datain = new DataInputStream(ConSoc.getInputStream());
			DataOutputStream dataout = new DataOutputStream(ConSoc.getOutputStream());
			
			while(!messagein.equals("Quit")) {
				messagein = datain.readUTF();
				System.out.println("Client: "+messagein);
				System.out.print("Me: ");
				messageout = BufRead.readLine();
				dataout.writeUTF(messageout);
				dataout.flush();
				
			}
			
			datain.close();
			ConSoc.close();
			ServSoc.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Some Exception.....");
		}
		

	}

}
