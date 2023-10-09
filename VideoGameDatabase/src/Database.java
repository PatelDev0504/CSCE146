/*
 * Dev Patel
 */

import java.util.Scanner;
public class Database { 
	public static VideoGameCollection col = new VideoGameCollection();
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to the Video Game Database!");
		boolean quit = false;	
		try
		{
			while (!quit)
			{
			System.out.println("Enter 1 to load the video game database.\nEnter 2 to search the database.\nEnter 0 to quit.");
			int choice = input.nextInt();
			switch (choice)
			{
			case 1:
				col.load();
				break;
			case 2:
				search();
				break;
			case 0:
				quit = true;
				input.close();
				break;
			}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void search()
	{
		Scanner userInput = new Scanner(System.in);
		try {
		System.out.println("Enter the name of the game or \"*\" for all.");
		String aName = userInput.nextLine();
		System.out.println("Enter the name of the console of \"*\" for all.");
		String aConsole = userInput.nextLine();
		/*
		 * The code underneath calls the search method and then prints the results
		 * to the terminal.
		 */
		GenLL<VideoGame> temp = col.search(aName, aConsole);
		temp.printAll();
		/*
		 * The code underneath asks the user if they want to print the results to a file.
		 * If so, it also prompts the user to see if they want to append the file or not.
		 * Then it calls the writeFile method.
		 */
		System.out.println("Would you like to print the results to a file? If so, press 1. If not, then press 2.");
		int c1 = userInput.nextInt();
		String bName="";
		boolean option = false;
		switch (c1)
		{
		case 1:
			Scanner input2 = new Scanner(System.in);
			System.out.println("Please enter the name of the file you want to print the results into.");
			bName = input2.nextLine();
			System.out.println("Do you want to append the file? Enter 1 to append. Enter 2 to overwrite.");
			if (input2.nextInt()==1)
				option = true;
			break;
		}
		if (bName.equals(""))
			return;
		col.writeFile(bName, temp, option);
		}
		catch (Exception e)
		{
			System.out.println("Incorrect Input");
			return;
		}
	}
}
