package rMiAdd;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

/**
 * @author amitesh ranjan
 *
 */
public class MyAddclient {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			System.out.println("RMI Add client is running....");
			Adder stub = (Adder)Naming.lookup("rmi://localhost:1001/sum");
			Scanner scn = new Scanner(System.in);
			int a,b;
			System.out.print("Enter your first number: ");
			a = scn.nextInt();
			System.out.print("Enter your second number: ");
			b=scn.nextInt();
			System.out.print("Sum of numbers is : ");
			System.out.println(stub.ADD(a, b));
			
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Error: Exception in stub error....");
			e.printStackTrace();
		}

	}

}
