package Entity.Tree;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import Entities.Entity;
import Main.Handler;
import Main.ImageLoader;
import Tiles.Tile;

public class Stamm extends Entity{
	protected int TreetopX,TreetopY,bx,by;
	protected Handler h;
	protected BufferedImage Texture1,Texture2,Texture3;
	public Stamm(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
		this.Texture2=ImageLoader.loadImage("TBottom");
		this.h=handler;
		this.bx=(int)x;
		this.by=(int)y;
		this.bounds=new Rectangle(Tile.size/4,0+Tile.size/6,Tile.size/3,Tile.size/2-Tile.size/3);
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Texture2,(int) (bx - h.getCamera().getxOffset()), (int) (by - h.getCamera().getyOffset()),Tile.size,Tile.size/2, null);
		
		
	}

}
