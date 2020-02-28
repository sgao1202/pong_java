//MyRectangle class for final PONG

import javax.swing.*;
import java.awt.*;

public class MyRectangle
{
	//Declare instance variables to store the coordinate of the top left corner of the Rectangle,
	private int cx, cy;
	//Declare instance variables to store the color, width, and height of the Rectangle.
	private int width, height;
	private Color color;
	//other instance variables that cannot be local
	
	public MyRectangle(int x, int y, int w, int h, Color c1)
	{
		//Initialize the instance variables
		cx = x;
		cy = y;
		width = w;
		height = h;
		color = c1;
	}
	
	//Precondition: A Graphics object is received
	//Postcondition: The Rectangle is drawn on the screen using the correct data
	public void fill(Graphics g)
	{
		Color oldColor = g.getColor();
		g.setColor(color);
		g.fillRect(cx, cy, width, height);
		g.setColor(oldColor);
	}
	
	//Precondition: Two ints are received that represent a coordinate
	//Postcondition: Returns true if the coordinate is contained within the Rectangle, false otherwise
	public boolean containsPoint(int x, int y)
	{
		if (((x >= cx) && (x <= cx + width) && ((y >= cy) && (y <= cy + height))))
			return true;
		return false;
	}
	
	//Precondition: Two ints are received
	//Postcondition: The top left coordinate is updated.
	public void move(int x, int y)
	{
		cx = x;
		cy = y;
	}

	//Any other methods you need
	public int getCx()
	{
		return cx;
	}
	
	public int getCy()
	{
		return cy;
	}
	
	public int getWidth()
	{
		return width;
	}
	
	public int getHeight()
	{
		return height;
	}
}