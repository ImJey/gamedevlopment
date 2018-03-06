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
	public static BufferedImage[] loadSprite(String ImageName) {
		BufferedImage[] Images=null;
		BufferedImage Texture=loadImage(ImageName);
		Images=new BufferedImage[Texture.getHeight()/Texture.getWidth()];
		int x=0;
		int y=0;
		int imgcount=Texture.getHeight()/Texture.getWidth();
		for(int i=0;i<Texture.getHeight()/Texture.getWidth();i++){
			Images[i]=Texture.getSubimage(0, y, Texture.getWidth(), Texture.getHeight()/imgcount);
		y+=Texture.getWidth();
		}
		
		return Images;
	}
}
