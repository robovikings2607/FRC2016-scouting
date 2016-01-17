package scouting.active;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageMaker {
	public static BufferedImage createImage(String filePath){
		File file = new File(filePath);
		try{
			BufferedImage bi = ImageIO.read(file);
			return bi;
		} catch (IOException e){
			System.out.println("Error reading image");
			return null;
		}
	}
}
