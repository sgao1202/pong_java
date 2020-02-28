 //MyPanel for final PONG
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class MyPanel extends JPanel
{
	//instance variables
	private Color myColor;
	private int hitCount;	//keep track of the amount of times the paddle hits the ball
	//Declare a Circle object
	private MyCircle circ;
	//Declare a MyRectangle object
	private MyRectangle rect;
	//Declare 2 ints to represent your x and y coordinate on screen
	private int x, y;
	//other instance variables that can't be local variables.
	private boolean contain;
	private boolean isOver;
	//the next line declares a Timer instance variable for this Panel.
	private javax.swing.Timer timer;
	
	public MyPanel(Color bg)
	{
		//set the background of the panel with the Color of the parameter
		myColor = bg;
		setBackground(bg);
		//create a Circle object
		circ = new MyCircle(100, 40, 40, Color.GREEN);
		//create a Rectangle object
		rect = new MyRectangle(50, 20, 25, 125, Color.green);
		//initialize any other instance variables you have.
		hitCount = 0;
		contain = false;
		isOver = true;
		x = 20;
		y = 20;
		//set the direction of the Circle
		circ.setDirection(135);
		
		//set the velocity of the Circle
		circ.setVelocity(3);
		//create and start the time - that is done for you on lines below.
		timer = new javax.swing.Timer(5, new MoveListener());  //MoveListener is defined below.
		timer.start();
		
		//Add a mouse listener to this class using a private class (outline of private class below)
		addMouseListener(new PanelListener());
		//Add a motion listener to this class using a private class (outline of private class below)
		addMouseMotionListener(new PanelMotionListener());
	}
	
	public void paintComponent(Graphics g)
	{
		//call the paintComponent from the superclass to initialize all the instance
		//variables in the superclass first.  If you don't do this, you will have trouble with
		//the display of the components.
		super.paintComponent(g);
		
		//start game over here if boolean variable is true (reset coordinates and counter)
		if (isOver)
		{
			restart();
		}
		//Statement to paint the Circle object onto the screen
		circ.fill(g);
		
		//Statement to paint the Rectangle object onto the screen.
		rect.fill(g);
		
		//Code to draw the dotted line on the JPanel (relative to the panel size)
		int midLine = getWidth() / 2;
		for (int y = 0; y < getHeight(); y += 60)
		{
			g.setColor(Color.WHITE);
			g.drawLine(midLine, y, midLine, y + 30);
		}
		
		//Statement to display the score (relative to the panel size)
		g.drawString(hitCount + "", midLine - (g.getFontMetrics().stringWidth(hitCount + "") / 2), 50); 
	}

	//Make a private class here that is called by the timer	
	private class MoveListener implements ActionListener
	{
		//Method Header - you decide.
		public void actionPerformed(ActionEvent e)
		{
			//I did not provide a complete outline for this section.  I provided
			//the basic idea.
			
			//Determine the collision (i.e. where the ball hit).  If it's
			//a wall, determine which wall and change the direction.
			//If it's the paddle, change the direction.	
			
			//hit the side of the paddle
			if ((circ.getCx() <= rect.getCx() + rect.getWidth() && (circ.getCy() + circ.getRadius() >= rect.getCy() && circ.getCy() < rect.getCy() + rect.getHeight())))
			{
				circ.setDirection((180 - (2 *circ.getDirection())));
				hitCount++;
				
				if (hitCount % 5 == 0)
					circ.setVelocity(circ.getVelocity() + 3);
			}
			//hit the right wall
			else if((circ.getCx() + circ.getRadius()) >= getWidth())
			{
				circ.setDirection(180 - (2 *circ.getDirection()));
			}
			//hit the top or bottom wall
			else if ((circ.getCy() <= 0) || (circ.getCy() + circ.getRadius() >= getHeight()))
			{
				circ.setDirection(360 - (2 * circ.getDirection()));
			}
			
			//account for the ball hitting the top/bottom side of the paddle
			else if ((circ.getCx() >= rect.getCx() && circ.getCx() <= rect.getCx() + rect.getWidth()) && (circ.getCy() + circ.getRadius() >= rect.getCy() && circ.getCy() <= rect.getCy() + rect.getHeight()))
			{
				circ.setDirection(360 - (2 *circ.getDirection()));
			}
			
			//passes the left wall (out of bounds)
			if (circ.getCx() <= 0)
				isOver = true;
			else 
				isOver = false;
			
			circ.move();
			repaint();
		}
	}
	
	private class PanelListener extends MouseAdapter
	{
		//You decide the method(s) to use when the mouse is clicked.
		//You decide what to do in the method(s).
		public void mousePressed(MouseEvent e)
		{
			if (rect.containsPoint(e.getX(), e.getY()))
			{
				contain = true;
				x = e.getX();
				y = e.getY();
			}
			else
			{
				contain = false;
			}
		}
	}
	
	private class PanelMotionListener extends MouseMotionAdapter
	{
		//You decide the method(s) to use when the paddle is dragged.
		//You decide what to do in the method(s).
		//Remember, as the paddle is dragged, the method(s) you use will 
		//constantly be called by the system.  There will be a continual
		//update of specific instance variables.  You will constantly be
		//asking the paddle to move.
		public void mouseDragged(MouseEvent e)
		{
			if (contain)
			{
				int upY = e.getY() - y;
			
				rect.move(rect.getCx(), rect.getCy() + upY);
				repaint();
				x = e.getX();
				y = e.getY();
			}
		}
	}
	
	public void restart()
	{
		circ.setX(150);		
		circ.setY(100);
		rect.move(getWidth() / 4, 50);
		hitCount = 0;
		circ.setVelocity(3);
	}
}