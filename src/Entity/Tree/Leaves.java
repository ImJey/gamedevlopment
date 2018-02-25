package Entity.Tree;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.concurrent.ThreadLocalRandom;

import Main.Handler;
import Main.ImageLoader;
import Tiles.Tile;

public class Leaves {

	protected int Time;
	protected float x,f,maxF;
	protected boolean hground=false;
	boolean timer=false;
	private Handler h;
	protected BufferedImage Texture;
	public Leaves(Handler h,float x, float f) {
		int seconds =5;
		this.h=h;
		this.x=x;
		this.f=f;
		this.Texture=ImageLoader.loadImage("leave");
		this.maxF=f+Tile.size;
		this.Time=ThreadLocalRandom.current().nextInt(1*60,seconds*60);
		
	}
	
	protected int counter=0;
	public void tick(){
		counter+=1;
		if(counter==Time){
			hground=true;
			timer=true;
		}
		if(!hground){
			x+=ThreadLocalRandom.current().nextInt(-1,1);
			f+=ThreadLocalRandom.current().nextInt(1,4);
		if(f>=maxF){
			hground=true;
		}
		}
	}
	public void render(Graphics g){
		
		g.drawImage(Texture,(int) (x - h.getCamera().getxOffset()), (int) (f - h.getCamera().getyOffset()),Tile.size/5,Tile.size/5,null);
	}

}
