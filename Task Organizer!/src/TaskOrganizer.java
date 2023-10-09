/*
 * Dev Patel
 */

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class TaskOrganizer {
	private GenLL <Task> [] organizedTasks;
	private Scanner input = new Scanner(System.in);
	/*
	 * this creates an array of 5 linked lists, one for each priority.
	 */
	public TaskOrganizer() {
		organizedTasks = new GenLL[5];
		for (int i=0; i<organizedTasks.length; i++)
			organizedTasks[i] = new GenLL<Task>();
	}
	/*
	 * this prompts the user to create a new Task object and then places it within
	 * a linked list within the array based on the priority of the task
	 */
	public void addTask()
	{
		System.out.println("Enter the task's priority");
		int priority = input.nextInt();
		System.out.println("Enter the task's action");
		String name = input.nextLine() + input.nextLine();
		for (int i=0; i<organizedTasks[priority].getSize(); i++)
		{
			if (name.equals(organizedTasks[priority].getAt(i).getName()))
			{
				System.out.println("This task already exists. It was not added to the list.");
				return;
			}
		}
		Task newTask = new Task(name, priority);
		organizedTasks[priority].add(newTask);
		sort(organizedTasks[priority]);
	}
	/*
	 * this method prompts the user to find the object that the user wants to 
	 * remove from the linked lists
	 */
	public void deleteTask()
	{
		System.out.println("Enter the task's priority");
		int priority = input.nextInt();
		System.out.println("Enter the task's action");
		String action = input.nextLine()+input.nextLine();
		organizedTasks[priority].reset();
		while (organizedTasks[priority].hasMore())
		{
			if (organizedTasks[priority].getCurrent().getName().compareTo(action)==0)
			{
				organizedTasks[priority].removeCurrent();
				break;
			}
			organizedTasks[priority].gotoNext();
		}
	}
	/*
	 * This method prints all of the linked lists within the array
	 */
	public void printAll()
	{
		for (int i=0; i<organizedTasks.length; i++)
		{
			organizedTasks[i].print();
		}
	}
	/*
	 * This method reads a file that is given by the user. It then populates
	 * the linked lists within the array after removing all of the tasks 
	 * already stored.
	 */
	public void readFile()
	{
		for (int i=0; i<organizedTasks.length; i++)
		{
			for (int j=0; j<organizedTasks[i].getSize(); j++)
			{
				organizedTasks[i].reset();
				organizedTasks[i].removeCurrent();
			}
		}
		System.out.println("Enter the file name:");
		String fileName = input.nextLine();
		try
		{
			Scanner fileScanner = new Scanner(new File(fileName));
			while(fileScanner.hasNextLine())
			{
				String fileLine = fileScanner.nextLine();
				String[] splitLines = fileLine.split("\t");
				if(splitLines.length == 2)
				{
					String name = splitLines[1];
					int priority = Integer.parseInt(splitLines[0]);
					Task newTask = new Task(name,priority);
					organizedTasks[priority].add(newTask);
				}
			}
			fileScanner.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		for (int i=0; i < organizedTasks.length; i++)
		{
			sort(organizedTasks[i]);
		}
	}
	/*
	 * This method prompts the user for a file name and then creates a new file with
	 * that name. It also prints out everything stored to the new file in order of 
	 * priority and alphabetical.
	 */
	public void writeFile()
	{
		System.out.println("Enter the file name");
		String fileName = input.nextLine();
		try
		{
			PrintWriter fileWriter = new PrintWriter(new File(fileName));
			for (int i=0; i<organizedTasks.length; i++)
			{
				organizedTasks[i].reset();
				while (organizedTasks[i].hasMore())
				{
					fileWriter.println(organizedTasks[i].getCurrent().getPriority()+"\t"+organizedTasks[i].getCurrent().getName());
					organizedTasks[i].gotoNext();
				}
			}
			fileWriter.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	/*
	 * This sorts a linked list alphabetically
	 */
	public void sort(GenLL<Task> genLL)
	{
		String temp;
		for (int i=0; i<genLL.getSize(); i++)
		{
			for (int j=i+1; j<genLL.getSize(); j++)
			{
				if (genLL.getAt(j).getName().compareTo(genLL.getAt(j-1).getName())<0)
				{
					temp = genLL.getAt(j-1).getName();
					genLL.getAt(j-1).setName(genLL.getAt(j).getName());
					genLL.getAt(j).setName(temp);
				}
			}
		}
	}
}
