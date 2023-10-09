/*
 * Dev Patel
 */
import java.util.Scanner;
public class Vector {
	private int size;
	private double[] components;
	public static Scanner input = new Scanner(System.in);
	
	public Vector()
	{
		setSize(1);
		components = new double[size];
	}
	public Vector(int s1)
	{
		if (s1<1) //This is a logic check because there cannot be a vector with less than one component. That is why the vector is automatically set to 1.
			System.out.println("Sorry, the vector must contain at least one component. The vector has been automatically set to 1 component.");
		setSize(s1);
		components = new double[size];
		
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		if (size>0)
			this.size=size;
		else
			this.size = 1;
	}
	
	public void setComponents() {
		System.out.println("Enter the components of the vector:");
		for (int i=0;i<size;i++)
		{
			components[i]=input.nextDouble();
			if (i<size-1)
			{
				System.out.println("Enter the next component:");
			} else {
				System.out.println("All the components have been entered.");
			}
		}
	}
	
	public double getComponents(int c1)
	{
		return components[c1];
	}
	
	public void printComponents()
	{
		for (int i=0; i<size; i++)
		{
			System.out.println(getComponents(i));
		}
	}
	
	public void add(Vector v1) //this method is to add two vectors together. It prints out all of the components to create an equation that the user can read.
	{
		if (this.size != v1.getSize() ) {
			System.out.println("An error occurred trying to add vectors of different sizes.");
		}
		else {
			this.printComponents();
			System.out.println("+");
			v1.printComponents();
			System.out.println("=");
			for (int i=0;i<size;i++)
			{
				System.out.println(getComponents(i)+v1.getComponents(i));
			}
		}
		System.out.println();
	}
	public void subtract(Vector v1)//this method is to subtract one vector from another. It prints out all of the components to create an equation that the user can read.
	{
		if (this.size != v1.getSize() ) {
			System.out.println("An error occurred trying to subtract vectors of different sizes.");
		}
		else {
			this.printComponents();
			System.out.println("-");
			v1.printComponents();
			System.out.println("=");
			for (int i=0;i<size;i++)
			{
				System.out.println(getComponents(i)-v1.getComponents(i));
			}
		}
		System.out.println();
	}
	
	public void findMagnitude() //this method finds the magnitude of a vector. In contrast to the other two methods, this one only prints out the magnitude.
	{
		double temp1=0;
		for (int i=0;i<size;i++)
		{
			temp1+=getComponents(i)*getComponents(i);
		}
		System.out.println("The magnitude of the vector is: "+Math.sqrt(temp1));
	}
}
