

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientInterface extends Remote{
	void sendMessage(String message)throws RemoteException;
	void receiveMessage(String message) throws RemoteException;
	String getName() throws RemoteException;
	int getId() throws RemoteException;
	void setName(String name) throws RemoteException;
	void setID (int Id) throws RemoteException;
}
