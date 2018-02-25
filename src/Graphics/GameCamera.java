package Graphics;


import Entities.Entity;
import Main.Handler;


public class GameCamera {
	
	private Handler handler;
	private float xOffset, yOffset;
	
	public GameCamera(Handler handler, float xOffset, float yOffset){
		this.handler = handler;
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
	
	public void checkBlankSpace(Handler Handler){
		if(xOffset < 0){
			xOffset = 0;
		}else if(xOffset > Handler.getWorld().getWidth() * Tiles.Tile.size - handler.getG().w)
		{
			xOffset = Handler.getWorld().getWidth() * Tiles.Tile.size - handler.getG().w;
		}
		else if(xOffset > Handler.getWorld().getWidth() * Tiles.Tile.size - handler.getG().w)
		{
			xOffset = Handler.getWorld().getWidth() * Tiles.Tile.size - handler.getG().w;
		}
		if(yOffset < 0){
			yOffset = 0;
			
		}else if(yOffset > Handler.getWorld().getHeight() * Tiles.Tile.size - handler.getG().hi){
			yOffset = Handler.getWorld().getHeight() * Tiles.Tile.size - handler.getG().hi;
		}
	}
	
	public void centerOnEntity(Entity e){
		
			
			xOffset = e.getX() - handler.getG().w /2+ e.getWidth() / 2;
			yOffset = e.getY() - handler.getG().hi /2 + e.getHeight() / 2;
			checkBlankSpace(handler);
		
	
	}
	
	public void move(float xAmt, float yAmt,Handler h){
		xOffset += xAmt;
		yOffset += yAmt;
		checkBlankSpace(h);
	}

	public float getxOffset() {
		return xOffset;
	}

	public void setxOffset(float xOffset) {
		this.xOffset = xOffset;
	}

	public float getyOffset() {
		return yOffset;
	}

	public void setyOffset(float yOffset) {
		this.yOffset = yOffset;
	}




	public void setyOffset1(float yOffset) {
		this.yOffset = yOffset;
	}
	
	
	
}
