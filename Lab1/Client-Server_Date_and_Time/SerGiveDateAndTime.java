/*
 * By: Amitesh Ranjan
 * Roll: 191885
 */
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;


public class SerGiveDateAndTime {

	public static void main(String[] args) throws IOException {
		ServerSocket sersoc = new ServerSocket(84);//Welcome Socket...
		System.out.println("Welcome to server.");
		System.out.print("Connecting..");
		while(true) {
			System.out.println("..........");
			Socket sc = sersoc.accept(); //Connection Socket... 
			DataOutputStream DOPS = new DataOutputStream(sc.getOutputStream());
			System.out.println("Server connected...");
			DOPS.writeBytes("Server's Machine: " + (new Date()).toString());
			DOPS.close();
			sc.close();
		}
	}
}
