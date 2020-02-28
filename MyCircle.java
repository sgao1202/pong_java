//MyCircle class for final PONG

import javax.swing.*;
import java.awt.*;

public class MyCircle
{
	//Declare instance variables that keep track of the center of the Circle
	private int cx, cy;
	//Declare an instance variable that keeps track of the radius, direction,
	private int radius, direction, velocity;
	//velocity, and color of the Circle
	private Color color;
	
	//other instance variables that cannot be local
	
	
	public MyCircle(int x, int y, int r, Color c)
	{
		cx = x;
		cy = y;
		radius = r;
		color = c;
	}
	
	//Precondition: A Graphics object is received
	//Postcondition: The circle is drawn on the screen using the correct data
	public void fill(Graphics g)
	{
		Color oldColor = g.getColor();
		g.setColor(color);
		g.fillOval(cx, cy, radius, radius);
		g.setColor(oldColor);
	}
	
	//Precondition: A velocity named v is received
	//Postcondition: The velocity is set to v
	public void setVelocity(int v)
	{
		velocity = v;
	}
	
	//Precondition: Degrees (or direction) named degrees is received
	//Postcondition: The direction is set to degrees
	public void setDirection(int degrees)
	{
		direction = (direction + degrees) % 360;
	}
	
	//Overloaded move method
	//Precondition:  Two ints are received
	//Postcondition: The center coordinate is updated.
	public void move(int x, int y)
	{
		cx = cx + x;
		cy = cy + y;
	}
	
	//This overloaded move method is written in its entirety
	public void move()
	{
		move((int)(velocity * Math.cos(Math.toRadians(direction))),
			(int)(velocity * Math.sin(Math.toRadians(direction))));
	}
	
	//Precondition: A new center X coordinate is received
	//Postcondition: The center for the X coordinate is updated.
	public void setX(int x)
	{
		cx = x;
	}
	
	//Precondition: A new center Y coordinate is received
	//Postcondition: The center for the Y coordinate is updated.
	public void setY(int y)
	{
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
	public int getRadius()
	{
		return radius;
	}
	
	public int getDirection()
	{
		return direction;
	}
	
	public int getVelocity()
	{
		return velocity;
	}
}