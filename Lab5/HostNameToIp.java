import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;
/**
 * Lab: Write a program to develop a Client that contacts a given 
 * 		DNS server to resolve a given host name.
 * 
 * @author Amitesh Ranjan
 * 		   Roll 191885
 */
public class HostNameToIp 
{
	public static void main(String[] args){ 
		String HostName; 
		Scanner Input = new Scanner(System.in); 
		System.out.print("Enter The host name to find IP address: "); 
		HostName = Input.nextLine(); 
		try { 
			InetAddress address = InetAddress.getByName(HostName);
			System.out.println("Host name and IP address: " + address.toString()); 
			System.out.println("IP address: " + address.getHostAddress());
		} 
		catch (UnknownHostException ex) {
		     System.err.println("Could not find " + HostName); 
		}
	}
}

