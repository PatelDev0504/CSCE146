/*
 * Dev Patel
 */

import java.io.*;
import java.util.Scanner;

public class VideoGameCollection {
	private GenLL <VideoGame> collection;
	public VideoGameCollection()
	{
		collection = new GenLL<VideoGame>();
	}
	public void addVideoGame(VideoGame aVG)
	{
		collection.add(aVG);
	}
	public void removeVideoGame(VideoGame aVG)
	{
		collection.reset();
		while (collection.hasMore())
		{
			if (collection.getCurrent().equals(aVG))
			{
				collection.removeCurrent();
				break;
			}
			collection.gotoNext();
		}
	}
	public VideoGame getAt(int i)
	{
		return collection.getAt(i);
	}
	/*
	 * This method prints an entire linked list into a file. It delimits the file by tabs.
	 */
	public void writeFile(String aName, GenLL<VideoGame> genLL, boolean option)
	{
		try
		{
			PrintWriter fileWriter = new PrintWriter(new FileOutputStream(new File(aName),option));
			genLL.reset();
			while (genLL.hasMore())
			{
				fileWriter.println(genLL.getCurrent().getName()+"\t"+genLL.getCurrent().getConsole());
				genLL.gotoNext();
			}
			fileWriter.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	/*
	 * This method asks the user for the file name. Then the method uses a while loop to 
	 * read the file line by line. Then line is split by \t and used to create a 
	 * Video Game object. This object is then added to the linked list.
	 */
	public void load()
	{
		Scanner keyboard = new Scanner(System.in);
		try {
			System.out.println("Enter the file name");
			String aName = keyboard.nextLine();
			Scanner fileScanner = new Scanner(new File(aName));
			String fileLine;
			while (fileScanner.hasNextLine())
			{
				fileLine = fileScanner.nextLine();
				String [] splitLines = fileLine.split("\t");
				if (splitLines.length==2)
				{
					String name = splitLines[0];
					String console = splitLines[1];
					VideoGame newGame = new VideoGame(name, console);
					this.addVideoGame(newGame);
				}
			}
			fileScanner.close();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	/*
	 * This method is used to search the entire linked list for the name of the
	 * game and console. When the right search results are found, they are added
	 * to another linked list which is then returned.
	 */
	public GenLL<VideoGame> search(String aName, String aConsole)
	{
		GenLL<VideoGame> temp = new GenLL<VideoGame>();
		if (aName.equals("*") && aConsole.equals("*"))
		{
			for (int i=0; i<collection.getSize(); i++)
				temp.add(collection.getAt(i));
			return temp;
		}else if (aName.equals("*"))
		{
			for (int i=0; i<collection.getSize(); i++)
			{
					if (collection.getAt(i).getConsole().toLowerCase().contains(aConsole.toLowerCase()))
					{
						temp.add(collection.getAt(i));
					}
			}
			return temp;
		}else if (aConsole.equals("*"))
		{
			for (int i=0; i<collection.getSize(); i++)
			{
				if (collection.getAt(i).getName().toLowerCase().contains(aName.toLowerCase()))
				{
						temp.add(collection.getAt(i));
				}
			}
			return temp;
		}else
		{
			for (int i=0; i<collection.getSize(); i++)
			
		{
			if (collection.getAt(i).getName().toLowerCase().contains(aName.toLowerCase()))
			{
				if (collection.getAt(i).getConsole().toLowerCase().contains(aConsole.toLowerCase()))
				{
					temp.add(collection.getAt(i));
				}
			}
		}
		}
		return temp;
	}
}