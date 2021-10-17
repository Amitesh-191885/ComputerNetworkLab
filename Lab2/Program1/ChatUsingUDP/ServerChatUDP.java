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

public class ServerChatUDP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			int ClientPort = 990, ServerPort = 991;
			DatagramSocket ServerSoc = new DatagramSocket(ServerPort);
			byte sendBuf[] = new byte[1024];
			DatagramPacket datapack = new DatagramPacket(sendBuf,sendBuf.length);
			BufferedReader BufRead = new BufferedReader(new InputStreamReader(System.in));
			InetAddress IP= InetAddress.getLocalHost();
			System.out.println("Client chat application running...");
			System.out.println("Waiting for client message...");
			while(true) {
				ServerSoc.receive(datapack);
				String Instr = new String(datapack.getData(),0,datapack.getLength());
				if(Instr.equals("QUIT")) {
					System.out.println("Closed");
					break;
				}
				
				System.out.println("Client: "+Instr);
				System.out.print("Me: ");
				String outstr = new String(BufRead.readLine());
				sendBuf = outstr.getBytes();
				ServerSoc.send(new DatagramPacket(sendBuf,outstr.length(),IP,ClientPort));
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
