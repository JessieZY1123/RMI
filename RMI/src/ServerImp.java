

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;


public class ServerImp extends UnicastRemoteObject implements ServerInterface{
	private ArrayList<ClientInterface> clients;
	
	protected ServerImp() throws RemoteException {
		clients =new ArrayList<ClientInterface>();
	}
	
	public void boardcastToAll(String message) throws RemoteException{
		if(clients.size()==0) return;
		for(int i=0; i< clients.size();i++) {
			clients.get(i).receiveMessage(message);
		}
		
		System.out.println(message);
		
	}
public synchronized void wellcome(ClientInterface client) throws RemoteException {
//		System.out.println("Welcome to the Chat Room");
//		System.out.println("Please enter you name: ");
	// if(clients.contains(clientName)==false) {
	clientToAll("Chat_Master: "+ client.getName()+" just join in the Chat Room.");
	System.out.println(client.getName() + " just join in the Chat Room.");	
	clients.add(client);
	System.out.println(client.getName()+ "'s assigned ID="+clients.size());
	 }	
		
	//}

	public synchronized void clientToAll(String message) throws RemoteException{
		 boardcastToAll(message);
				
	}
	public synchronized void removeClient(ClientInterface client) throws RemoteException{
		if(clients.contains(client)) {
		clients.remove(client);
		System.out.println(client.getName() + " remove the room.");
		boardcastToAll(client.getName() + " leave the chat room.");
	}
	}
	
	public ArrayList<ClientInterface> getList(){
		return clients;
		
	}
//	public void getList() throws RemoteException{
//		for(int i=0;i<clients.size();i++) {
//			System.out.print(clients.get(i).getName());
//		}
//
//	}
}
