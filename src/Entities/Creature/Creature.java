package Entities.Creature;

import java.awt.Graphics;

import Entities.Entity;
import Main.Handler;
import Tiles.Tile;

public abstract class Creature extends Entity {

	protected float xMove,yMove;
	public Creature(Handler handler,float x, float y, int width, int height) {
		super(handler, x, y, width, height);
		// TODO Auto-generated constructor stub
	}

	public abstract void tick();
	public abstract void render(Graphics g);
	
	
	
	
	public void move(Handler handler){
		if(!checkEntityCollisions(handler,xMove, 0f))
			moveX(handler);
		if(!checkEntityCollisions(handler,0f, yMove))
			moveY(handler);
	}
	public void moveX(Handler handler){
		if(xMove > 0){//Moving right
			int tx = (int) (x + xMove + bounds.x + bounds.width) / Tile.size;
			
			if(!collisionWithTile(handler,tx, (int) (y + bounds.y) / Tile.size) &&
					!collisionWithTile(handler,tx, (int) (y + bounds.y + bounds.height) / Tile.size)){
				if(x+xMove <= handler.getWorld().getWidth()*Tile.size)
				x += xMove;
			}else{
				x = tx * Tile.size - bounds.x - bounds.width - 1;
			}
			
		}else if(xMove < 0){//Moving left
			int tx = (int) (x + xMove + bounds.x) / Tile.size;
			
			if(!collisionWithTile(handler,tx, (int) (y + bounds.y) / Tile.size) &&
					!collisionWithTile(handler,tx, (int) (y + bounds.y + bounds.height) / Tile.size)){
				if(x+xMove > 0)
				x += xMove;
			}else{
				x = tx * Tile.size + Tile.size - bounds.x;
			}
			
		}
	}
	public void moveY(Handler handler){
		if(yMove < 0){//Up
			int ty = (int) (y + yMove + bounds.y) / Tile.size;
			
			if(!collisionWithTile(handler,(int) (x + bounds.x) / Tile.size, ty) &&
					!collisionWithTile(handler,(int) (x + bounds.x + bounds.width) / Tile.size, ty)){
				if(y+yMove > 0)
				y += yMove;
			}else{
				y = ty * Tile.size + Tile.size - bounds.y;
			}
			
		}else if(yMove > 0){//Down
			int ty = (int) (y + yMove + bounds.y + bounds.height) / Tile.size;
			
			if(!collisionWithTile(handler,(int) (x + bounds.x) / Tile.size, ty) &&
					!collisionWithTile(handler,(int) (x + bounds.x + bounds.width) / Tile.size, ty)){
				if(y+yMove < handler.getWorld().getHeight()*Tile.size)
				y += yMove;
			}else{
				y = ty * Tile.size - bounds.y - bounds.height - 1;
			}
			
		}
	}
	
	protected boolean collisionWithTile(Handler handler,int x, int y){
		return handler.getWorld().getTile(x, y).isSolid();
	}
}
