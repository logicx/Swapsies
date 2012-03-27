import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;
//commit
public class Window {
	 public static BufferStrategy strategy;
	static String title = "";
	static int width = 640;
	static int height = 480;
	static Frame frame;	
	public static void main(String[] args) {
		Window window = new Window();
	
		 frame = new Frame("Swapsies - Logicx");
		
		 frame.setPreferredSize(new Dimension(640,480));
		
		 frame.addWindowListener(new WindowAdapter(){
			  public void windowClosing(WindowEvent we){
			  System.exit(0);
			  }
			  });
		 
		frame.addMouseListener(new MouseHandler());
		frame.setResizable(false);
		strategy = frame.getBufferStrategy();
		frame.setBackground(Color.GRAY);
		frame.pack();
	    frame.setVisible(true);
	    frame.createBufferStrategy(2);
	    strategy = frame.getBufferStrategy();
		
		
		graphics();
	}
	
	public static void graphics()
	{
		Graphics graphics = new Graphics();
	}
}
	

