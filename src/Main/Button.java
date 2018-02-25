package Main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.IOException;

public abstract class Button {

	
	protected Handler h;
	protected boolean hover=false;
	protected int x,y,width,height,TextSize;
	protected String Text;
	public Button(Handler h,int x,int y,int width,int height,String Text){
		this.x=x;
		this.y=y;
		this.h=h;
		this.width=width;
		this.height=height;
		this.Text=Text;
	}
	
	public void tick(){
		 if(h.getM().getX() >= x && h.getM().getX() <= x+width && h.getM().getY() >= y && h.getM().getY() <= y+height)
	 {
			 hover=true;
			 if(h.getM().isLClick()==true){
		 System.out.println(h.getM().isLClick());
		 h.getM().setLClick(false);
		 try {
			OC();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 }
		 else
			 hover=false;
	}
	public abstract void OC() throws IOException;
	public void render(Graphics g){
		  TextSize = h.getG().w*h.getG().hi/16/16/16/2;
		  g.setFont(new Font("TimesNewRoman", Font.BOLD, TextSize));
		g.setColor(Color.RED);
		if(hover)
			g.setColor(Color.BLUE);
		g.fillRect(x, y, width, height);
		g.setColor(Color.BLACK);
		while(x+g.getFontMetrics().stringWidth(Text)/2+g.getFontMetrics().stringWidth(Text) >= x+width){
			TextSize-=1;
			g.setFont(new Font("TimesNewRoman", Font.BOLD, TextSize));
		}
		 System.out.println(TextSize);
		  g.drawString(Text, x+g.getFontMetrics().stringWidth(Text)/2, y+height/2);
		  
	}
}
