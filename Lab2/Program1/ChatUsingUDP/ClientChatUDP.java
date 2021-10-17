/*
 * By: Amitesh Ranjan
 * Roll: 191885
 */

/* Package */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class ClientChatUDP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			int ClientPort = 990, ServerPort = 991;
			DatagramSocket ClientSocket = new DatagramSocket(ClientPort);
			byte sendbuf[] = new byte[1024];
			DatagramPacket DataPack = new DatagramPacket(sendbuf, sendbuf.length);
			BufferedReader BufRead = new BufferedReader(new InputStreamReader(System.in));
			InetAddress IP = InetAddress.getLocalHost();
			System.out.println("Connectionless Server Chat application running...");
			System.out.println("Type 'QUIT' to stop");
			
			while(true) {
				System.out.print("Me: ");
				String str = new String(BufRead.readLine());
				sendbuf = str.getBytes();
				if(str.equals("QUIT")) {
					System.out.println("Closed");
					ClientSocket.send(new DatagramPacket(sendbuf,str.length(),IP,ServerPort));
					break;
				}
				
				ClientSocket.send(new DatagramPacket(sendbuf,str.length(),IP,ServerPort));
				ClientSocket.receive(DataPack);
				
				String receivestr = new String(DataPack.getData(),0,DataPack.getLength());
				System.out.println("Server: "+receivestr);
				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Something went wrong...");
			e.printStackTrace();
		}
		

	}

}
