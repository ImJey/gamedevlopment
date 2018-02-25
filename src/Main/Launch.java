package Main;

import java.awt.Dimension;
import java.awt.Toolkit;

public class Launch {
	static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	static double width = screenSize.getWidth();
	static double height = screenSize.getHeight();
	public static int DISPLAYWIDTH = (int) width;
	public static int DISPLAYHEIGHT = (int) height;
	public static int  Size=(int) (width+height)/3;
	public static void main(String[] Args){
	
		Game g= new Game("Test Game", (int)width, (int)height);
		g.run();
	}
	@Override
	public String toString() {
		return "Launch [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

}
