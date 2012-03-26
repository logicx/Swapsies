import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Tile {
	BufferedImage tileImage;
	int x, y;
	boolean selected = false;
	
	public Tile(int x2, int y2, BufferedImage image){
		x = x2;
		y = y2;
		tileImage = image;
		
	}
	
	public void draw(Graphics2D g) {
		g.drawImage(tileImage, x, y, null);
		
		if(selected) {
			g.setColor(Color.black);
			g.drawOval(x, y, 32, 32);
		}
	}
	
	public Rectangle tileBox() {
		return new Rectangle(x,y,32, 32);
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() { 
		return y;
	}
}
