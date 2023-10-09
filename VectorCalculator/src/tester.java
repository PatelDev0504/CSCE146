/*
 * Dev Patel
 */
import java.util.Scanner;

public class tester {
	public static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		boolean quit = false;
		while (!quit)
		{
			System.out.println("Enter 1: To add two vectors \nEnter 2: To subtract two vectors \nEnter 3: To find the magnitutde of a vector \nEnter 9: To quit the program");
			int choice = input.nextInt();
			switch (choice) //this switch allows the code to go through different cases based on what the user inputed.
			{
			case 1: 
				addVector();
				break;
			case 2:
				subtractVector();
				break;
			case 3:
				findMagnitudeVector();
				break;
			case 9:
				quit = true;
				break;
			}
		}
		
	}
	//these three methods are written here to call for user input for the addVector(), subtractVector(), and findVectorMagnitude() methods.
	public static void addVector()
	{
		System.out.println("Please print the size of the first vector:");
		int vectorSize1 = input.nextInt();
		Vector vector01 = new Vector(vectorSize1);
		vector01.setComponents();
		System.out.println("Please print the size of the second vector:");
		int vectorSize2 = input.nextInt();
		Vector vector02 = new Vector(vectorSize2);
		vector02.setComponents();
		vector01.add(vector02);
	}
	public static void subtractVector()
	{
		System.out.println("Please print the size of the first vector:");
		int vectorSize1 = input.nextInt();
		Vector vector01 = new Vector(vectorSize1);
		vector01.setComponents();
		System.out.println("Please print the size of the second vector:");
		int vectorSize2 = input.nextInt();
		Vector vector02 = new Vector(vectorSize2);
		vector02.setComponents();
		vector01.subtract(vector02);
	}
	public static void findMagnitudeVector()
	{
		System.out.println("Please print the size of the first vector:");
		int vectorSize1 = input.nextInt();
		Vector vector01 = new Vector(vectorSize1);
		vector01.setComponents();
		vector01.findMagnitude();
	}
}
