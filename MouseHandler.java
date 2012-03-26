import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class MouseHandler implements MouseListener {

	public void mouseClicked(MouseEvent e) {
		for(Tile tile : ObjectHandler.tiles) {
			if(mouseBox().intersects(tile.tileBox())) {
				if(ObjectHandler.st.size() < 2) {
					if(!tile.selected) {
						ObjectHandler.st.add(tile);
						tile.selected = true;
						System.out.println("Selected tile!");
						
						if(ObjectHandler.st.size() == 2) {
							System.out.println("Swaping tiles");
							swapTiles(ObjectHandler.st.get(0), ObjectHandler.st.get(1));
						}
						
						break;
					}
					

				}
			}
		}
	}
	
	public double getDist(Tile t1, Tile t2) {
		
		double dist = Math.sqrt(Math.pow((t2.getX() - t1.getX()), 2) + Math.pow((t2.getY() - t1.getY()), 2));
		dist = Math.floor((dist)/32);
		return dist;
	}
	
	public void swapTiles(Tile t1, Tile t2) {
		
		if(getDist(t1, t2) == 1) {
			int t1x = t1.x;
			int t1y = t1.y;
			int t2x = t2.x;
			int t2y = t2.y;
			
			t1.x = t2x;
			t1.y = t2y;
			t2.x = t1x;
			t2.y = t1y;
			
			ObjectHandler.st.clear();
			t1.selected = false;
			t2.selected = false;
		} else {
			System.out.println("Too far away!");
			ObjectHandler.st.clear();
			t1.selected = false;
			t2.selected = false;
		}
	}


	public void mouseEntered(MouseEvent e) {}


	public void mouseExited(MouseEvent e) {}


	public void mousePressed(MouseEvent e) {}


	public void mouseReleased(MouseEvent e) {}

	public Rectangle mouseBox() {
		return new Rectangle(MouseInfo.getPointerInfo().getLocation().x,
							 MouseInfo.getPointerInfo().getLocation().y,
							 16, 16);
	}
}
