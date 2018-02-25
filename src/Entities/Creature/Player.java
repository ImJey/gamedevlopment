package Entities.Creature;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import Main.Handler;
import Tiles.Tile;

public class Player extends Creature {

	protected PlayerInventory PI;
	
	protected static int width=Tiles.Tile.size;
	protected static int height=Tiles.Tile.size*3/2;
	protected Handler h;
	protected PlayerControl PC;
	public Player(Handler h,float x, float y) {
		super(h,x, y, width, height);
		this.h=h;
		this.PI=new PlayerInventory(h, 16);
		this.PC=new PlayerControl();
		h.getG().addPlayerControl(PC);
		this.health=100;
		// TODO Auto-generated constructor stub
	}
	
	public void tick(){
		
		getInventory().tick();
		h.getCamera().centerOnEntity(this);
		yMove=0;
		 
		xMove=0;
		if(PC.getKey(KeyEvent.VK_W)){
			System.out.println("FOUND!");
			yMove-=2;
		}
		if(PC.getKey(KeyEvent.VK_S)){
			yMove+=2;
		}
		if(PC.getKey(KeyEvent.VK_A)){
			System.out.println("FOUND!");
			xMove-=2;
		}
		if(PC.getKey(KeyEvent.VK_D)){
			xMove+=2;
		}
		if(PC.getKey(KeyEvent.VK_E))
		{
			System.out.println("Open Inventory:"+PI.active);
			PI.active=!PI.active;
			PC.setKey(KeyEvent.VK_E,false);
		}
		move(h);
	}
	
	public void render(Graphics g){
		g.fillRect((int) (x - h.getCamera().getxOffset()), (int) (y - h.getCamera().getyOffset()),width,height);
		
	}

	public void getSpecialFunction(Graphics g) {
		PI.render(g);
		
	}

	public PlayerInventory getInventory() {
		// TODO Auto-generated method stub
		return PI;
	}
}
