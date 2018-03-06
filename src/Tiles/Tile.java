package Tiles;

import java.awt.Color;import java.awt.CompositeContext;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.RescaleOp;

import Main.Handler;
import Main.ImageLoader;
import Main.Launch;

public abstract class Tile {
	 RescaleOp rescale;
	//STATIC
	 static String Path = "C:\\Users\\user\\JData\\";
	public static Tile[] tiles = new Tile[4096];
	protected int LightLevel=8;
	
 
	//CLASS
	
	public static  int size = Launch.Size/15;
	public static Tile grassTile = new grassTile(0);
	public static Tile DirtTile = new Tile(ImageLoader.loadImage("Dirt"),1) {
	};
	protected BufferedImage texture;
	protected final int id;
	
	public Tile(BufferedImage texture, int id){
		
		this.texture = texture;
		this.id = id;
		this.Standard=texture;
		tiles[id] = this;
		
	}

	protected BufferedImage Standard;
	 
		public void render(Graphics g, int x, int y){
			g.drawImage(texture, x, y, size,size,null);
		 
		 
		
 }
	
	public boolean isSolid(){
		return false;
	}
	
	public int getId(){
		return id;
	}

	public boolean underPlayer() {
		return true;
	}

	public boolean isRandom(){
		return false;
	}
	 
	public void setLightLevel(int l) {
		this.LightLevel=l;
		
	}

	
}
