/*
 * Dev Patel
 */
public class GroceryItem {
	private String name;
	private double value;
	/*
	 * This is the default constructor.
	 */
	public GroceryItem()
	{
		setName("none");
		setValue(0.0);
	}
	/*
	 * This is a constructor with a parameter.
	 */
	public GroceryItem(String aName, double aValue)
	{
		setName(aName);
		setValue(aValue);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		if (name==null)
			this.name = "none";
		else
			this.name = name;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		if (value<0.0)
			value = 0.0;
		else
			this.value = value;
	}
	/*
	 * This toString() method is called when printing out all the values
	 * of the Grocery List.
	 */
	public String toString()
	{
		return "Grocery Item Name: "+name+" Value: "+value;
	}
}
