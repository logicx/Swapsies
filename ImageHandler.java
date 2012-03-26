import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

//commit
public class ImageHandler {
	static BufferedImage image = null;
	static URL imageURL;
	static BufferedImage grass, red, blue, yellow;
	
	public ImageHandler()  {
		loadImages();
	}
	
	public void loadImages() {
		grass = loadImage("grass.png");
		red = loadImage("red.png");
		blue = loadImage("blue.png");
		yellow = loadImage("yellow.png");
	}
	
	public BufferedImage loadImage(String filename) {
		try {
		 imageURL = getClass().getClassLoader().getResource("res/"+filename);
		 image = ImageIO.read(imageURL);
		 System.out.println("Loaded image: " + filename);
		 
		 return image;
		} catch(IOException e) {
			System.out.println("Couldn't load image: " + filename);
			return null;
		}
		
	}
	
}
