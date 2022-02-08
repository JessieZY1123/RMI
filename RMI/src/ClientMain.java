

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;


public class ClientMain {
		public static void main(String[] args) throws Exception {
			String host = args[0];
			int post = Integer.parseInt(args[1]);
			Registry registry = LocateRegistry.getRegistry(host, post);
			ServerInterface server = (ServerInterface)registry.lookup("RMI_Serve.ServerImp");
			
			System.out.println("Welcome to the Chat Room");
			System.out.println("Please enter you name: ");
			Scanner scan = new Scanner(System.in);
	            String name = scan.next();
	            System.out.println("Welcome to the Chat Room,"+ name);
			
			new Thread(new ClientImp(name,0,server)).start();
			

		}
	}
