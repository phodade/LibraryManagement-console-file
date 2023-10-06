package ApplicationMain;

import java.io.IOException;
import java.util.Scanner;

import LibraryManagement.LibraryManagement;
import UserManagement.UserManagment;


public class ApplicationMain {

	public static void main(String args[]) throws IOException
	{
		Scanner scan = new Scanner(System.in);
		boolean CanIKeepRunTheProgram = true;
		
        System.out.println("** WELCOME TO APPLICATION MANAGMENT **");
		
		System.out.println(" Enter the login name : ");
		String login = scan.nextLine();
		
		System.out.println(" Enter the Password : ");
		String password = scan.nextLine();
		
		if(!UserManagment.validateUserandPassword(login, password))
		{
			System.out.println("Login Failed !!! Close The Application....");
			return;
		}

		while (CanIKeepRunTheProgram == true )
		{
			
		    System.out.println(" ** WELCOME TO LIBRARY MANAGMENT ** ");
			System.out.println(" 1.User Managment ");
			System.out.println(" 2.Library Managment ");
			System.out.println(" 3.Quit ");
			
			int optionselectedbyuser = scan.nextInt();
			
			if(optionselectedbyuser == 1)
			{
			UserManagment.UserManagment();
			}
			else if(optionselectedbyuser == 2)
			{
		    LibraryManagement.LibraryManagement();
			}
			else if(optionselectedbyuser == 3)
			{
				break;
			}
		}
	}

}