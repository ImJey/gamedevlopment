package Item;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.regex.Pattern;

import Main.Handler;
import Main.ImageLoader;
import Main.Management;
import Main.Utils;
import Tiles.Tile;

public class Item {

	public static final boolean IR = false;
	protected float x,y;
	protected int width,height;
	protected int id,count;
	protected BufferedImage Texture;
	protected int IName;
	protected String ShowName;
	protected Rectangle bounds;

	public static Item[]Items = new Item[1024];
	public static Item Wood=new Item(ImageLoader.loadImage("Wood"), 0, 0);
	public Item(BufferedImage Texture,int id,int IName){
		this.id=id;
		this.Texture=Texture;
		this.width=Tile.size;
		this.height=Tile.size;
		String language=".de";
		String dataa;
		
		dataa=Utils.loadFileAsString(Management.MainFolder+"\\ItemNames"+language);
		String[] ItemNames=dataa.split(Pattern.quote(":"));
		this.ShowName=ItemNames[IName];
		this.bounds=new Rectangle(width/2/2, height/2/2, width/2, height/2);
	}
	

	protected boolean PickedUP =false;
	
	public void render(Graphics g){
//		System.out.println(this.Texture);
		g.drawImage(this.Texture,(int) (x - Handler.getCamera().getxOffset()), (int) (y - Handler.getCamera().getyOffset()),width,height,null);
		
	}
	/**
	 * @return the x
	 */
	public float getX() {
		return x;
	}



	/**
	 * @param x the x to set
	 */
	public void setX(float x) {
		this.x = x;
	}



	/**
	 * @return the y
	 */
	public float getY() {
		return y;
	}



	/**
	 * @param y the y to set
	 */
	public void setY(float y) {
		this.y = y;
	}



	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}



	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}



	/**
	 * @return the showName
	 */
	public String getShowName() {
		return ShowName;
	}



	/**
	 * @param showName the showName to set
	 */
	public void setShowName(String showName) {
		ShowName = showName;
	}



	/**
	 * @return the count
	 */
	public int getCount() {
		return count;
	}



	public Item createNew(float x,float y){
		Item i=new Item(Texture,id,IName);
		i.setX(x);
		i.setY(y);
		i.setCount(1);
		i.setBounds(x,y);
		return i;
	}
	private void setBounds(float x2, float y2) {
		bounds.x=(int) x2;
		bounds.y=(int) y2;
		
	}
	public void setPosition(int x, int y) {
		this.x=x;
		this.y=y;
		bounds.x = x;
		bounds.y = y;
	}
	public void setCount(int nc){
		this.count=nc;
	}
	public Rectangle getbounds() {
		// TODO Auto-generated method stub
		return bounds;
	}
	public Image getTexture() {
		// TODO Auto-generated method stub
		return Texture;
	}
	public int getIname() {
		// TODO Auto-generated method stub
		return IName;
	}
}
