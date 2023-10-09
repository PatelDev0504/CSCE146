/*
 * Dev Patel
 */
public class Prize {
	private String name;
	
	public Prize(String n1) //a constructor for a prize
	{
		setName(n1);
	}
	public Prize() //default constructor for a prize
	{
		name = "none";
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
}
