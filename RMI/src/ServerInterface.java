

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface ServerInterface extends Remote{
	void boardcastToAll(String message)throws RemoteException;
	void wellcome(ClientInterface client) throws RemoteException;
	void clientToAll(String message) throws RemoteException;
	void removeClient(ClientInterface client) throws RemoteException;
	ArrayList<ClientInterface> getList()throws RemoteException;
	
}
