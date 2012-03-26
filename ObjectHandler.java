import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;


public class ObjectHandler {
	private Random random = new Random();
	BufferedImage spawnImage;
	
	public static ArrayList<Tile> tiles;
	public static ArrayList<Tile> st;
	
	public ObjectHandler() {
		st = new ArrayList<Tile>();
		createTiles();
	}
	
	public void createTiles() {
		tiles = new ArrayList<Tile>();
		
		
		for(int x = 0; x < Window.width; x+=32) {
			for(int y = 0; y < Window.height; y+=32) {
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
	}
	
}
