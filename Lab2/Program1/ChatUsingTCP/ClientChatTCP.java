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
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientChatTCP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to the Connection oriented Server chat application...");
		System.out.println("Connecting to server...");
		try {
			Socket ConSoc = new Socket("127.0.0.1",9292);
			System.out.println("Connected to server: ");
			System.out.println("Enter ''Quit'' to exit server chat application");
			String strin, strOut="";  //Variables for store ;
			
			BufferedReader BufRead = new BufferedReader(new InputStreamReader(System.in));
			DataInputStream DataInStream =  new DataInputStream(ConSoc.getInputStream());
			DataOutputStream DataOutStream = new DataOutputStream(ConSoc.getOutputStream());
			while(!strOut.equals("Quit")) {
				System.out.print("Me: ");
				strOut = BufRead.readLine();
				DataOutStream.writeUTF(strOut);
				DataOutStream.flush();
				strin = DataInStream.readUTF();
				System.out.println("Server: "+strin);
			}
			ConSoc.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Not connected...");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("IO Exception");
		}

	}

}
