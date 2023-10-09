/*
 * Dev Patel
 */
import java.util.Scanner;
public class Runner {
		static Scanner input = new Scanner(System.in);
		public static void main(String[] args) {
		PrizeList prizes = new PrizeList(PrizeList.checkFile("./words.txt"));
		System.out.println("Welcome to Hangman");
		prizes.readFile("./words.txt");
		boolean quit = false;
		while (!quit)
		{
			playHangman();
			System.out.println("Would you like to quit? Enter 1 to quit. Enter anything else to continue.");
			String qGame = input.next();
			if (qGame.equals("1"))
			{	quit = true;
			}
		}
		input.close();
	}

		public static void playHangman()
		{
			Prize random = PrizeList.random();
			System.out.print("Guess the word ");
			String blank = "";
			String r1 = random.getName();
			for (int i=0; i<r1.length();i++)
			{
				System.out.print("*");
				blank += "*";
			}
			System.out.println();
			System.out.println("You have 6 lives to find the word.");
			int lives = 6;
			while (lives>0)
			{
				System.out.print("Give me a letter.");
				String letter = input.next();
				if (r1.contains(letter))
				{
					int index = r1.indexOf(letter);
					for (int i =0; i<r1.length();i++)
					{
						if (i==r1.length()-1)
						{
							if (r1.substring(i).equals(letter))
								blank=blank.substring(0,i)+letter;
						} else
						{
							if (r1.substring(i, i+1).equals(letter))
								blank=blank.substring(0,i)+letter+blank.substring(i+1);
						}
					}
					System.out.println(blank.substring(0, index)+letter+blank.substring(index+1));
					blank = blank.substring(0, index)+letter+blank.substring(index+1);
				} else
				{
					System.out.println("That letter is not in the word. You have lost 1 life.");
					lives--;
				}
				if (lives ==0)
				{
					System.out.println("Sorry you lose. The word was "+r1+".");
				}
				if (!blank.contains("*"))
				{
					System.out.println("You win!");
					lives = 0;
				}
			}
		}
}
