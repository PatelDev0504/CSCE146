/*
 * Dev Patel
 */
public class Prize {
	private String name;
	private int cost;
	
	public Prize(String n1, int c1) //a constructor for a prize
	{
		setName(n1);
		setCost(c1);
	}
	public Prize() //default constructor for a prize
	{
		name = "none";
		cost = 0;
	}
	public void setName(String n1) 
	{
		if (n1 == null)
		{
			name = "none";
		} else
		{
			name = n1;
		}
	}
	
	public String getName()
	{
		return name;
	}
	public void setCost(int c1)
	{
		if (c1<0)
		{
			cost = 0;
		} else
		{
			cost = c1;
		}
	}
	public int getCost()
	{
		return cost;
	}	
	
}
