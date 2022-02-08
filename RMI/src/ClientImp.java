

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;



public class ClientImp extends UnicastRemoteObject implements ClientInterface, Runnable{
	private ServerInterface server;
	private String name;
	private int Id;
	private String message;

	protected ClientImp(String name, int Id, ServerInterface server) throws RemoteException {
		this.Id =Id;
		this.name=name;
		this.server = server;
	}
	
	public void sendMessage(String message)throws RemoteException{
		server.boardcastToAll(this.name+ ": "+ message);
	}
	
	public void receiveMessage(String message) throws RemoteException{
		System.out.println(message);
	}
	@Override
	public void run() {
		try {
						
			if(server.getList().size()==0) {
				System.out.println("It seems you are the first person in this chat room.");
			}
			for(ClientInterface i: server.getList()) {
				System.out.println("You can send message to "+i.getName());
			}
			this.server.wellcome(this);
			System.out.println("You can send message now, or just enter the “exit” to leave the room.");
			while(true) {
			Scanner scan = new Scanner(System.in);
			String n= scan.nextLine();
			if(n.equals("exit")) {
				server.removeClient(this);
				System.out.println(this.name + " leave the char room.");
				break;
			}
				sendMessage(n);	
		} 
		}	
		catch (Exception e) {
			
		}
	}

	public String getName() throws RemoteException {
		// TODO Auto-generated method stub
		return name;
	}

	public int getId() throws RemoteException {
		// TODO Auto-generated method stub
		return Id;
	}

	public void setName(String name) throws RemoteException {
		// TODO Auto-generated method stub
		this.name= name;
	}

	public void setID(int Id) throws RemoteException {
		// TODO Auto-generated method stub
		this.Id = Id;
	}



}
