/*
 * Dev Patel
 */
public class VideoGame {
	private String name;
	private String console;
	public VideoGame()
	{
		this.name = "none";
		this.console = "none";
	}
	public VideoGame(String aName, String aConsole)
	{
		this.name=aName;
		this.console=aConsole;
	}
	public String getName()
	{
		return name;
	}
	public String getConsole()
	{
		return console;
	}
	public void setName(String aName)
	{
		if (aName == null)
			return;
		this.name = aName;
	}
	public void setConsole(String aConsole)
	{
		if (aConsole == null)
			return;
		this.console=aConsole;
	}
	public String toString()
	{
		return name+"\t"+console;
	}
}
