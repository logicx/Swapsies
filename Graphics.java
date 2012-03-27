import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
//commit
public class Graphics {
	
	Graphics2D g;
	ImageHandler ih;
	
	public Graphics() {
		loadRes();
		ObjectHandler objh  = new ObjectHandler();
		gameLoop();
	}
	
	public void loadRes(){
		ih = new ImageHandler();
	}
	
	public void gameLoop()
	{
		while(GameState.running) {
			
			g = ((Graphics2D)Window.strategy.getDrawGraphics());
			paint(g);
			ObjectHandler.removeOjects();
			
			if(GameState.allspawned) {
				updateObjects();
			}
			
		}
	}
	
	public void updateObjects() {
		for(Tile tile : ObjectHandler.tiles) {
			tile.updatePos();
		}
	}
	
	public void paint(Graphics2D g) {
	    g.clearRect(0, 0, Window.width, Window.height);
		drawBackground(g);
		drawTiles(g);
		Window.strategy.show();
		
	}
	
	public void drawTiles(Graphics2D g) {
		for(Tile tile : ObjectHandler.tiles) {
			tile.draw(g);
		}
	}
	public void drawBackground(Graphics2D g) {
		
		for(int x=0; x<Window.width; x+=32) {
			for(int y=0; y<Window.height; y+=32) {
	
				g.drawImage(ImageHandler.grass, x, y, null);
			}
		}

	}
	
}
