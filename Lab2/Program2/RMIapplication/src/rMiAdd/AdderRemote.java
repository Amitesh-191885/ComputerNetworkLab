package rMiAdd;

import java.rmi.*;
import java.rmi.server.*;

public class AdderRemote extends UnicastRemoteObject implements Adder {

	public AdderRemote() throws RemoteException {
		// TODO Auto-generated constructor stub
		super();
	}

	@Override
	public int ADD(int x, int y) throws RemoteException {
		// TODO Auto-generated method stub
		return (x+y);
	}

}
