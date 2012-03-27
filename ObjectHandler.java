import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

//commit
public class ObjectHandler {
	private Random random = new Random();
	BufferedImage spawnImage;
	
	public static ArrayList<Tile> tiles;
	public static ArrayList<Tile> st;
	public static ArrayList<Tile> toremove;
	
	public ObjectHandler() {
		st = new ArrayList<Tile>();
		toremove = new ArrayList<Tile>();
		createTiles();
	}
	
	public static void removeOjects() {
		for(Tile tile : toremove) {
			tiles.remove(tile);
			
		}
		
		toremove.clear();
	}
	
	public static void clearSelected() {
		for(Tile tile : st) {
			tile.selected = false;
		}
		st.clear();
	}
	
	public static Tile getTileAtPoint(int x, int y) {
		Tile t;
		
		for(Tile tile : tiles) {
			if(tile.x == x && tile.y == y) {
				t = tile;
				return t;
			}
		}
		
		return null;
	}
	
	public void createTiles() {
		tiles = new ArrayList<Tile>();
		
		
		for(int x = 20; x < Window.width-32; x+=40) {
			for(int y = 50; y < Window.height-32; y+=40) {
				int num = random.nextInt(3);
				
				if(y > 0) {
					switch(num) {
						
						
						case 0:
							spawnImage = ImageHandler.red;
							break;
							
						case 1:
							spawnImage = ImageHandler.blue;
							break;
							
						case 2:
							spawnImage = ImageHandler.yellow;
							break;

					}
					
					Tile tile = new Tile(x, y-5, spawnImage);
					tiles.add(tile);
				}
			}
		}
		GameState.allspawned = true;
	}
	
}
