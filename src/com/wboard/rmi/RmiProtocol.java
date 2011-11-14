package com.wboard.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 * http://download.oracle.com/javase/tutorial/rmi/designing.html
 * @author SKCCADMIN
 *
 */
public interface RmiProtocol extends Remote {
	<T> T executeTask(Task<T> t) throws RemoteException;
}
