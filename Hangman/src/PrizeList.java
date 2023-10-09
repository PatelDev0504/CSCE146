/*
 * Dev Patel
 */

import java.io.File;
import java.util.Scanner;

public class PrizeList {
	public static  Prize[] prizeList;
	public static int size;
	public PrizeList()
	{
		prizeList = new Prize[1];
	}
	public PrizeList(int i)
	{
		if (i<1)
			i=1;
		prizeList = new Prize[i];
	}
	/*
	 * This method below is needed to make sure that the prize is 
	 * added to the right spot which is to the left of the array in
	 * the first null prize.
	 */
	public void addPrize(Prize p1)
	{
		if (prizeList[prizeList.length-1]!=null)
		{
			return;
		}
		for (int i=0; i<prizeList.length;i++)
		{
			if (prizeList[i]==null)
			{
				prizeList[i]=p1;
				break;
			}
		}
	}
	/*
	 * This method reads the file and calls the addPrize() method above
	 * to add prizes into the PrizeList[] array. It also is checking to
	 * see if the line is in the right format (tab delim) before creating
	 * a Prize.
	 */
	public void readFile(String aName)
	{
		try
		{
			Scanner fileScanner = new Scanner(new File(aName));
			String fileLine;
			while (fileScanner.hasNextLine())
			{
				fileLine = fileScanner.nextLine();
				Prize newPrize = new Prize(fileLine);
				this.addPrize(newPrize);
			}
			fileScanner.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	/*
	 * This method is reading the file to see how many lines there are.
	 * It also checks to see if the line is in the right format. This 
	 * method is only used to see how many elements are needed in the
	 * array.
	 */
	public static int checkFile(String aName)
	{
		try
		{
			Scanner fileScanner1 = new Scanner(new File(aName));
			String fileLine;
			int count=0;
			while (fileScanner1.hasNextLine())
			{
				fileLine = fileScanner1.nextLine();
					count++;
			}
			fileScanner1.close();
			return count;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return -1;
		
	}
	/*
	 * This method was made to test if the files were read correctly.
	 * It is not used in the Showcase Showdown.
	 */
	public void printPrizes()
	{
		for(Prize prize : prizeList)
		{
			if (prize==null)
				break;
			System.out.println(prize.getName());
		}
	}
	/*
	 * This is calling a random prize in the array. It is using the 
	 * Math.random() method which calls a value between [0,1) and 
	 * increasing the range by multiplying it by the length of the 
	 * array before type casting into an array.
	 */
	public static Prize random()
	{
		int random = (int)(Math.random()*prizeList.length);
		return prizeList[random];
	}
}
