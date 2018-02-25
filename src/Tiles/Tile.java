package Tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import Main.Launch;

public abstract class Tile {
	
	//STATIC
	 static String Path = "C:\\Users\\user\\JData\\";
	public static Tile[] tiles = new Tile[4096];
	 
	
 
	//CLASS
	
	public static  int size = Launch.Size/15;
	public static Tile grassTile = new grassTile(1);
	protected BufferedImage texture;
	protected final int id;
	
	public Tile(BufferedImage texture, int id){
		
		this.texture = texture;
		this.id = id;
		
		tiles[id] = this;
		
	}
	

	
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


	
}
