/*
 * Dev Patel
 */
import java.util.Scanner;
public class TaskOrganizerFE {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		TaskOrganizer tOrganizer = new TaskOrganizer();
		System.out.println("Welcome to Task Organizer!");
		boolean quit = false;
		/*
		 * all the code below utilizes the user input to know what methods to run
		 */
		while (!quit)
		{
			System.out.println("Enter 1: To Add a Task");
			System.out.println("Enter 2: To Remove a Task");
			System.out.println("Enter 3: To Print Tasks to Console");
			System.out.println("Enter 4: To Read from a Task File");
			System.out.println("Enter 5: To Write to a Task File");
			System.out.println("Enter 9: To Quit");
			int choice = keyboard.nextInt();
			switch (choice)
			{
			case 1:
				tOrganizer.addTask();
				break;
			case 2:
				tOrganizer.deleteTask();
				break;
			case 3:
				tOrganizer.printAll();
				break;
			case 4:
				tOrganizer.readFile();
				break;
			case 5:
				tOrganizer.writeFile();
				break;
			case 9:
				quit = true;
				break;
			}	
		}
		System.out.println("Goodbye!");
	}
}