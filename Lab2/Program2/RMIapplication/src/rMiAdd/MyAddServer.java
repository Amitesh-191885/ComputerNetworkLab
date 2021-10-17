
package rMiAdd;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * @author amitesh ranjan
 *
 */
public class MyAddServer {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			System.out.println("RMI Server is running.....");
			System.out.println("For add two numbers");
			Adder skelton = new AdderRemote();
			Registry registry = LocateRegistry.createRegistry(1001);
			
			registry.rebind("sum", skelton);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			System.out.println("Error: Not Running surver....");
			e.printStackTrace();
		}
		
	}

}
