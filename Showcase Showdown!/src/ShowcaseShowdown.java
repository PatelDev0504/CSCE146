/*
 * Dev Patel
 */

import java.util.Scanner;
public class ShowcaseShowdown 
{
	static Scanner input = new Scanner(System.in);
	public static void main(String[] args) 
	{
		int size = PrizeList.checkFile("./ShowcasePrizeList.txt");
		PrizeList prizes = new PrizeList(size);
		prizes.readFile("./ShowcasePrizeList.txt");
		boolean quit = false;
		System.out.println("Welcome to Showcase Showdown!");
		while(!quit)
		{
			System.out.println("Your prizes are:");
			Prize[] temp = new Prize[5];
			int totalCost=0;
			/*
			 * This code below is creating an array of random prizes.
			 * It is also checking to see if the array has any repeat
			 * prizes. If so, then it replaces the new prize to ensure
			 * that there are no repeats.
			 */
			for (int i=0; i<temp.length; i++)
			{
				temp[i] = prizes.random();
				boolean check = false;
				for (int j =0; j<temp.length; j++)
				{
					if (temp[i]==temp[j]&& i>j)
						check = true;
				}
				if (!check)
				{
					i++;
				}
				i--;
			}
			/*
			 * This loop is created to print out the prize names and 
			 * keep track of the total cost of the prizes.
			 */
			for (int i=0; i<temp.length; i++)
			{
				System.out.println(temp[i].getName());
				totalCost+=temp[i].getCost();
			}
			try //this is used to make sure that the user inputs a valid value.
			{
				System.out.println("You must guess the total cost of the prizes without going over and within $1,300 of its actual price.");
				System.out.println("Enter your guess:");
				int guess = input.nextInt();
				System.out.println("The actual cost was "+totalCost);
				if (guess>totalCost)
				{
					System.out.println("Your guess was over. You lose.");
				} else if (guess>totalCost-1300)
				{
					System.out.println("You win!");
				} else
				{
					System.out.println("Your guess was close, but not close enough. You lose.");
				}
				/*
				 * This is checking to see if the user would like to quit.
				 */
				System.out.println("Would you like to quit? Enter 1 to quit. Enter anything else to continue.");
				int qGame = input.nextInt();
				if (qGame==1)
				{	quit = true;
				}
				}
			catch (Exception e)
			{
				input.nextLine();
				System.out.println("Try again. Please enter an integer number like 1000.");
			}
		}
	}

}
