package app;

import java.rmi.registry.LocateRegistry;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;

import service.EmployeeService;
import service.impl.EmployeeImpl;

public class MainServer {
	public static void main(String[] args) {	
		try {
			Hashtable<String, String> tbl = new Hashtable<String, String>();
			tbl.put("java.security.policy", "policy.policy");
			Context context = new InitialContext(tbl);
			LocateRegistry.createRegistry(8989);
			
			// init
			EmployeeService empService = new EmployeeImpl();
			
			// rmi
			context.bind("rmi://localhost:8989/EmployeeService", empService);
			
			System.out.println("Connection port 8989...");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
