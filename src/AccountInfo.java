import info.account.commands.Command;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class AccountInfo {

	private final static String FILENAME =  "accounts.dat";
	
	public static void main(String[] args) {
		
		File accountFile = null;
		Scanner fileScanner = null;
		
		ArrayList<String> content = new ArrayList<String>();
		Scanner usrInpt = new Scanner(System.in);
		Command user_command;
		
		int cmdChoice = 0;
		String password = null;
		String userName = null;
		String info = null;
		String[] line;
		
		
		/*
		 * Open the file containing the account information and begin
		 * reading from it.  If the file does not exist, then create it.
		 */
		try{
			accountFile = new File(FILENAME);
			fileScanner = new Scanner(accountFile);
			System.out.println("Opened file " + FILENAME);
			
			while( fileScanner.hasNext() ) {
				content.add( fileScanner.nextLine() );
			}
			
		}
		catch(FileNotFoundException fnfe){
			System.out.println("Creating file..");
		}
		
		
		/*
		 *  Main loop.  Executes the program until the user command is QUIT.
		 */
		do{
			
			//Get user command and execute it.					
			do{				
				//Displaying commands
				for(Command cmd : Command.values() ){
					cmd.toString();
				}		
				try{					
					cmdChoice = usrInpt.nextInt();				
					if( cmdChoice < 1 || cmdChoice > Command.values().length){
						System.out.println("That is not a valid command.");
						cmdChoice = 0;
						continue;
					}
				}
				catch(Exception e) {
					System.out.println("Enter the integer value corresponding with a command.");
					cmdChoice = 0;
				}

			}while(cmdChoice == 0);
			
			//Execute the user command.
			user_command = Command.values()[cmdChoice - 1];	
			switch(user_command) {
				case DISPLAY: 
					System.out.println("Display results to screen!");
					break;
				case EDIT: 
					System.out.println("Editing an entry!");
					break;
				case ADD: 
					System.out.println("Adding an entry!");
					break;
				case DELETE: 
					System.out.println("Deleting an entry!");
					break;
				case QUIT: 
					System.out.println("Quitting!");
					break;
			}
		}while(user_command != Command.QUIT);
		
		System.out.println("Goodbye!");
		
		


	}

}
