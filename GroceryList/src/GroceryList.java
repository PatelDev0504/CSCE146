/*
 * Dev Patel
 */

public class GroceryList {
	protected class ListNode
	{
		GroceryItem data;
		ListNode link; //next element
		public ListNode(GroceryItem aData, ListNode aLink)
		{
			data = aData;
			link = aLink;
		}
	}
	/*
	 * Most of these methods were methods that we went over in class. I used
	 * a similar structure as those methods to create these.
	 */
	private ListNode head;
	private ListNode current;
	private ListNode previous;
	public GroceryList()
	{
		head = current = previous = null;
	}
	public void gotoNext()
	{
		if (current == null)
			return;
		previous = current;
		current = current.link;
	}
	public GroceryItem getCurrent()
	{
		if (current != null)
			return current.data;
		return null;
	}
	public void setCurrent(GroceryItem aData)
	{
		if (current !=null && aData != null)
			current.data = aData;
	}
	public void addItem(GroceryItem aData)
	{
		ListNode newNode = new ListNode(aData, null);
		if (head == null) //List is empty
		{
			head = current = newNode;
			return;
		}
		//List is not empty
		ListNode temp = head;
		while (temp.link!=null)
			temp = temp.link;
		temp.link = newNode;
	}
	public void addItemAfterCurrent(GroceryItem aData)
	{
		if (current == null)
			return;
		ListNode newNode = new ListNode(aData, current.link);
		current.link = newNode;
	}
	public void removeCurrent()
	{
		if (current == head)
		{
			head = head.link;
			current = head;
		} else
		{
			previous.link = current.link;
			current = current.link;
		}	
	}
	public void showList()
	{
		ListNode temp = head;
		while (temp.link!= null)
		{
			System.out.println(temp.data);
			temp = temp.link;
		}
	}
	/*
	 * This method is creating a new ListNode temp that is being used to check
	 * every GroceryItem. There is a while loop combined with an if statement
	 * to see if the Grocery List contains the Grocery Item.
	 */
	public boolean contains(GroceryItem aData)
	{
		ListNode temp = head;
		boolean contains = false;
		while (temp !=null)
		{
			if (temp.data.getName().equals(aData.getName())&&temp.data.getValue()==(aData.getValue()))
			{
				contains = true;
			}
			temp = temp.link;
		}
		return contains;
	}
	/*
	 * This method is creating a new ListNode temp that is being used to go through
	 * every single Grocery Item. In the while loop, the value of the item is being
	 * added to the total cost which is returned after the while loop is ended.
	 */
	public double totalCost()
	{
		ListNode temp = head;
		double cost = 0.0;
		while (temp != null)
		{
			cost = cost + temp.data.getValue();
			temp = temp.link;
		}
		return cost;
	}
}
