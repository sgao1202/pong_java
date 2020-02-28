//PongDriver for final PONG
import javax.swing.*;

import java.awt.*;

public class PongDriver
{
	public static void main(String[] args)
	{
		//Code to create a JFrame object
		JFrame theJFrame = new JFrame();
		//Code to set the title of the JFrame
		theJFrame.setTitle("Pong");
		//Code to set the size of the JFrame
		theJFrame.setSize(400, 300);
		theJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Code to add a MyPanel object to the JFrame
		MyPanel thePanel = new MyPanel(Color.BLACK);
	    theJFrame.add(thePanel);
		//Code to make the window visible
	    theJFrame.setVisible(true);
	}
}