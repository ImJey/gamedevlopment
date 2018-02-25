package Main;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageLoader {

	public static BufferedImage loadImage(String ImageName){
		try {
			String path = "C:\\Users\\"+System.getProperty("user.name")+"\\Desktop\\GAMEFOLDER\\Graphics\\"+ImageName+".png";
			System.out.println("Loading: "+path);
			return ImageIO.read(new File(path));
		} catch (IOException e) {
			
			System.out.println("Error by: "+e);
			
			
		}
		return null;
	}
	public static Image convert(BufferedImage bi) {
	    return Toolkit.getDefaultToolkit().createImage(bi.getSource());
	}
}
