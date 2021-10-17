
package rMiAdd;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author amitesh Ranjan 
 *
 */
public interface Adder extends Remote {
	public int ADD(int x, int y) throws RemoteException;
}
