package Entities.Creature;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import Item.Item;
import Main.Handler;
import Main.ImageLoader;
import Tiles.Tile;
import Tool.Tool;

public class Slot {

	public boolean IR = false;
	protected BufferedImage Texture,Texture2;
	protected int id;
	protected boolean SS=false;
	protected boolean Ms=false;
	protected boolean Ms2=false;
	protected boolean Selected = false;
	protected boolean hovered = false;
	protected Item i=null;
	protected Tool t=null;
	protected int x,y,width,height,xy,xx;
	protected Handler h;
	protected SlotManager SM;
	protected boolean snd=false;
	public Slot(Handler h,int i,int x,int y,SlotManager SM) {
		this.id=i;
		this.SM=SM;
		this.Texture2=ImageLoader.loadImage("Slot2");
		this.Texture=ImageLoader.loadImage("Slot");
		this.x=id*Tile.size/2;
		this.x=x;
		this.y=y;
		this.width=Tile.size/2;
		this.height=Tile.size/2;
		this.h=h;
	}

	public void tick() {
 
	 
	}
public static  boolean renderItem=true;
	public void render(Graphics g) {
		
		g.drawImage(Texture, x, y,width,height, null);
		if(hovered)
			g.drawImage(Texture2, x, y,width,height, null);
		if(Selected)
			g.drawImage(Texture2, x, y,width,height, null);
		if(i!=null && renderItem){
			g.drawImage(i.getTexture(), x, y,width,height,null);
			g.drawString(""+i.getCount(), x+width-g.getFontMetrics().stringWidth(""+i.getCount()), y+height);
		}
		
	}

	public void setIR(boolean b){
		this.IR=b;
	}
}
