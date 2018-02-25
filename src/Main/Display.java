
package Main;
import java.awt.Canvas;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;

public class Display {

	private JFrame frame;
	private Canvas canvas;
	
	private String title;
	private int width, height;
	
	public Display(String title, int width, int height){
		this.title = title;
		this.width = width;
		this.height = height;
		
		createDisplay();
	}
	
	private void createDisplay(){
		
		frame = new JFrame(title);
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setUndecorated(true);
		frame.setVisible(true);
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));
		canvas.setFocusable(true);
		 

		// Create a new blank cursor.
	 // Create a new blank cursor.

		// Set the blank cursor to the JFrame.
		frame.add(canvas);
		frame.pack();
	
	 
		frame.add(canvas);
		frame.pack();
	}

	public void changeCursor(BufferedImage image){
		BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
		Cursor nc = Toolkit.getDefaultToolkit().createCustomCursor(
			    cursorImg, new Point(0, 0), "blank cursor");
		if(image != null){
		 nc = Toolkit.getDefaultToolkit().createCustomCursor(
			    image, new Point(0, 0), "blank cursor");
		}
		frame.getContentPane().setCursor(nc);
	}
	
	public Canvas getCanvas(){
		return canvas;
	}
	public void ChangeSizeFullScreen(){
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = screenSize.getWidth();
		double height = screenSize.getHeight();
		this.frame.setSize(new Dimension((int)width,(int)height));
		
		this.frame = new JFrame(title);
		frame.setSize((int)width, (int)height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setUndecorated(true);
		frame.setVisible(true);
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension((int)width, (int)height));
		canvas.setMaximumSize(new Dimension((int)width, (int)height));
		canvas.setMinimumSize(new Dimension((int)width, (int)height));
		canvas.setFocusable(true);
		 

		// Create a new blank cursor.
	
		// Set the blank cursor to the JFrame.
 
	 
		frame.add(canvas);
		frame.pack();
	 
		
	}
	
	public void delete(){
		System.out.println("Tried to delete!");
		this.frame=null;
		this.canvas=null;
	}
	
	public JFrame getFrame(){
		return frame;
	}
	
}