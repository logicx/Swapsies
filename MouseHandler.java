import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
//commit

public class MouseHandler implements MouseListener {

	public void mouseClicked(MouseEvent e) {
		
		if(e.getButton() == e.BUTTON1) {
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
		
		if(e.getButton() == e.BUTTON3) {
			int mx = MouseInfo.getPointerInfo().getLocation().x;
			int my = MouseInfo.getPointerInfo().getLocation().y;
			
			try {
				for(Tile tile : ObjectHandler.tiles) {
					if(mouseBox().intersects(tile.tileBox())) {
						ObjectHandler.toremove.add(tile);
					}
				}
			} catch(Exception ex) {
				
			}

		}
	}
	
	public double getDist(Tile t1, Tile t2) {
		double dist = Math.sqrt(Math.pow((t2.getX() - t1.getX()), 2) + Math.pow((t2.getY() - t1.getY()), 2));
		dist = Math.floor((dist)/32);
		return dist;
	}
	
	public void swapTiles(Tile t1, Tile t2) {
		int t1x = t1.x;
		int t1y = t1.y;
		int t2x = t2.x;
		int t2y = t2.y;
		
		if(t1x == t2x || t1y == t2y) {
			double dist = getDist(t1, t2);
			
			if(dist == 1) {
				if(t1.tileImage != t2.tileImage) {
					System.out.println(dist);
	
					t1.x = t2x;
					t1.y = t2y;
					t2.x = t1x;
					t2.y = t1y;
					
					
				} else {
					System.out.println("Can't move, same colour!");

				}
			} else {
				System.out.println("Too far away!");

			}
		} else {
			System.out.println("Invalid movement direction!!");
		}
		ObjectHandler.clearSelected();
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
