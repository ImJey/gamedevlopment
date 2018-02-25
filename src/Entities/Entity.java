package Entities;

import java.awt.Graphics;
import java.awt.Rectangle;

import Main.Handler;

public abstract class Entity {
	protected Rectangle bounds;
	protected float x,y;
	protected int width,height;
	protected int Stage=1;
	protected Handler handler;
	protected int health;

	/**
	 * @return the x
	 */
	protected boolean Death= false;
	public boolean run=false;
	public float getX() {
		return x;
	}
	public abstract void tick();
	public abstract void render(Graphics g);
	public Entity(Handler handler,float x, float y, int width, int height) {
		this.bounds = new Rectangle(0,0, width, height);
		this.x = x;
		this.y = y;
		this.handler=handler;
		this.width = width;
		this.height = height;
	}public Rectangle getCollisionBounds(float xOffset, float yOffset){
		return new Rectangle((int) (x + bounds.x + xOffset), (int) (y + bounds.y + yOffset), bounds.width, bounds.height);
	}
	public boolean checkEntityCollisions(Handler handler,float xOffset, float yOffset){

		for(Entity e : handler.getWorld().getEntityManager().getEntities()){
			if(e.equals(this))
				continue;
			 
			if(e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xOffset, yOffset)))
				return true;
		}
		return false;
		
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
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}
	/**
	 * @param width the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}
	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}
	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}
	public int getStage() {
		// TODO Auto-generated method stub
		return Stage;
	}
	public void runMe(Graphics g) {
		// TODO Auto-generated method stub
		
	}
	public void runMeN() {
		// TODO Auto-generated method stub
		
	}
}
