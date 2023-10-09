/*
 * Dev Patel
 */
public class DoubleDoubleLL {
	protected class ListNode
	{
		double data;
		ListNode forwardLink; //next element
		ListNode backwardLink; //previous element
		public ListNode(double aData, ListNode aforwardLink,ListNode abackwardLink)
		{
			data = aData;
			forwardLink = aforwardLink;
			backwardLink = abackwardLink;
		}
	}
	private ListNode head;
	private ListNode previous;
	private ListNode current;
	private ListNode next;
	private ListNode end;
	public DoubleDoubleLL()
	{
		head = current = previous = next = end = null;
	}
	/*
	 * moves current to the next list node
	 */
	public void gotoNext()
	{
		if (current == null)
			return;
		previous = current;
		current = current.forwardLink;
		if (current == null)
		{
			next = null;
			return;
		}
		next = current.forwardLink;
	}
	/*
	 * moves current to the previous list node
	 */
	public void gotoPrev()
	{
		if (current.backwardLink == null || current == null)
			return;
		next = current;
		current = previous;
		previous = current.backwardLink;
	}
	/*
	 * sets current to the head
	 */
	public void reset()
	{
		current = head;
		previous = current.backwardLink;
		next = current.forwardLink;
	}
	/*
	 * sets current to the last list node
	 */
	public void gotoEnd()
	{
		current = end;
		previous = current.backwardLink;
		next = current.forwardLink;
	}
	/*
	 * returns true or false based on if there is any more list nodes after current
	 */
	public boolean hasMore()
	{
		return (current != null);
	}
	/*
	 * returns current
	 */
	public double getCurrent()
	{
		return current.data;
	}
	/*
	 * lets the user change the data of the current reference
	 */
	public void setCurrent(double aDouble)
	{
		if (current == null)
			return;
		current.data = aDouble;
	}
	/*
	 * adds another list node to the linked list at the end of the list
	 */
	public void add(double aDouble)
	{
		if (head == null)
		{
			ListNode newNode = new ListNode(aDouble, null, null);
			head = current = end = newNode;
			previous = newNode.backwardLink;
			next = newNode.forwardLink;
			return;
		}
		ListNode newNode = new ListNode(aDouble, null, end);
		end.forwardLink = newNode;
		next = current.forwardLink;
		end = newNode;
	}
	/*
	 * adds another list node to the linked list right after current
	 */
	public void addAfterCurrent(double aDouble)
	{
		if (current == null)
			return;
		ListNode newNode = new ListNode (aDouble, current, next);
		current.forwardLink = newNode;
		next.backwardLink = newNode;
		next = newNode;
	}
	/*
	 * removes a certain double from the linked list
	 */
	public void remove(double aDouble)
	{
		if (head == null) //if list is empty
		{
			return;
		}
		ListNode temp = head;
		while (temp != null)
		{
			if (temp.data==aDouble)
			{
				if (temp == end)
				{
					temp.backwardLink.forwardLink = null;
					temp = temp.backwardLink;
					end.backwardLink = null;
					end = temp;
					return;
				}
				temp.backwardLink.forwardLink = temp.forwardLink;
				temp.forwardLink.backwardLink = temp.backwardLink;
			}
			temp = temp.forwardLink;
		}
	}
	/*
	 * removes the current double from the linked list
	 */
	public void removeCurrent()
	{
		if (current == null || head == null)
			return;
		if (current == head)
		{
			current.forwardLink.backwardLink = null;
			current = head = current.forwardLink;
			previous = head.backwardLink;
			next = current.forwardLink;
			return;
		}
		if (current == end)
		{
			previous.forwardLink = null;
			current = previous;
			previous = current.backwardLink;
			next = current.forwardLink;
			end = current;
			return;
		}
		previous.forwardLink = next;
		next.backwardLink = previous;
		current = next;
		next = current.forwardLink;
	}
	/*
	 * prints out all of the data stored in the linked list
	 */
	public void print()
	{
		if (head == null)
			return;
		ListNode temp = head;
		while (temp!=null)
		{
			System.out.println(temp.data);
			temp = temp.forwardLink;
		}
	}
	/*
	 * checks the linked list for a certain double value and returns true if there is one
	 */
	public boolean contains(double aDouble)
	{
		ListNode temp = head;
		while (temp!= null)
		{
			if (temp.data == aDouble)
				return true;
			temp = temp.forwardLink;
		}
		return false;
	}
}
