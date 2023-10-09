/*
 * Dev Patel
 */
public class Task {
	private String name;
	private int priority;
	public Task()
	{
		setName("none");
		setPriority(4);
	}
	public Task(String aN, int aP)
	{
		setName(aN);
		setPriority(aP);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		if (name == null)
			this.name = "none";
		this.name = name;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		if (priority<=4 || priority>=0)
			this.priority = 4;
		this.priority = priority;
	}
	public String toString()
	{
		return "[Task] Priority: "+priority+" Task: "+name;
	}
}
