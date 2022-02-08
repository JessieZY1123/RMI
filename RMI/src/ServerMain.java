

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;



public class ServerMain {
	 public static void main(String[] args) throws Exception {
		 String host = args[0];		
		 int post = Integer.parseInt(args[1]);
		  ServerInterface server = new ServerImp();
		  Registry registry = LocateRegistry.createRegistry(post);
		      Naming.rebind("rmi://"+host+":"+post+"/RMI_Serve.ServerImp", server);
		      System.out.println("Chat Room is ready");

	    }

}