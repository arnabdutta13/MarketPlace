/**
 * 
 */
package com.marketplace;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.marketplace.entity.Command;
import com.marketplace.exception.MarketPlaceException;
import com.marketplace.service.ServiceFactory;

/**
 * @author arnab
 *
 */
public class MarketPlaceApp {
	
	static Map<String, Command> commandMap = new HashMap<>();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		init();
		
		try {
			while (true) {
				try {
					System.out.print("# ");
					String command = in.nextLine();
					String[] cmdParts = command.split("\\s+");
					if (commandMap.containsKey(cmdParts[0])) {
						if ("EXIT".equalsIgnoreCase(cmdParts[0])) {
							System.out.println("Exiting application");
							return;
						}
						String result = (String) ServiceFactory.getService(commandMap.get(cmdParts[0]).getType())
														.process(commandMap.get(cmdParts[0]), cmdParts);
						System.out.println(result);
					} else {
						System.out.println("Error - Command not present");
					}
					
				} catch(Exception e) {
					if (e instanceof MarketPlaceException) {
						System.out.println(e.getMessage());
						
					}
				}
			}
		} finally {
			in.close();
		}
	}
	
	public static void init() {
		commandMap.put("REGISTER", new Command("REGISTER", 1, "USER"));
		commandMap.put("CREATE_LISTING", new Command("CREATE_LISTING", 5, "LISTING"));
		commandMap.put("DELETE_LISTING", new Command("DELETE_LISTING", 2, "LISTING"));
		commandMap.put("GET_LISTING", new Command("GET_LISTING", 2, "LISTING"));
		commandMap.put("GET_CATEGORY", new Command("GET_CATEGORY", 2, "CATEGORY"));
		commandMap.put("GET_TOP_CATEGORY", new Command("GET_TOP_CATEGORY", 1, "CATEGORY"));
		commandMap.put("EXIT", new Command("EXIT", 0, "EXIT"));
	}
}
