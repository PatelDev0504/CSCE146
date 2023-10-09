/*
 * Dev Patel
 */
public class GenLL <T>{
	protected class ListNode
	{
		T data;
		ListNode link; //next element
		public ListNode(T aData, ListNode aLink)
		{
			data = aData;
			link = aLink;
		}
	}
	//GenLL class here
	private ListNode head;//first element
	private ListNode current; //a movable reference to an element
	private ListNode previous;
	private int size;
	public GenLL()
	{
		head = current = previous = null;
		this.size = 0;
	}
	public void add(T aData)
	{
		ListNode newNode = new ListNode(aData, null);
		if (head == null) //List is empty
		{
			head = current = newNode;
			this.size = 1;
			return;
		}
		//List is not empty
		ListNode temp = head;
		while (temp.link!=null)
			temp = temp.link;
		temp.link = newNode;
		this.size ++;
	}
	public void print()
	{
		ListNode temp = head;
		while (temp != null)
		{
			System.out.println(temp.data);
			temp = temp.link;
		}		
	}
	public T getCurrent()
	{
		if (current != null)
			return current.data;
		return null;
	}
	public void setCurrent(T aData)
	{
		if (current !=null && aData != null)
			current.data = aData;
	}
	public void gotoNext()
	{
		if (current == null)
			return;
		previous = current;
		current = current.link;
	}
	public void reset()
	{
		current = head;
		previous = null;
	}
	public boolean hasMore()
	{
		return current != null;
	}
	public void addAfterCurrent(T aData)
	{
		if (current == null)
			return;
		ListNode newNode = new ListNode(aData, current.link);
		current.link = newNode;
		this.size++;
	}
	public void removeCurrent()
	{
		if (current == head)
		{
			head = head.link;
			current = head;
			this.size=0;
		} else
		{
			previous.link = current.link;
			current = current.link;
			this.size --;
		}	
	}
	public int getSize()
	{
		return this.size;
	}
	public T getAt(int i)
	{
		if (i<0 || i>= size)
			return null;
		ListNode temp = head;
		for (int j=0;j<i; j++)
			temp =temp.link;
		return temp.data;
	}
	public void setAt(int index, T aData)
	{
		if(index < 0 || index >= size || aData == null)
			return;
		ListNode temp = head;
		for (int i=0; i<index; i++)
		{
			temp = temp.link;
		}
		temp.data = aData;
	}
	public void printAll()
	{
		ListNode temp = head;
		while (temp != null)
		{
			System.out.println(temp.data);
			temp = temp.link;
		}
	}
}
