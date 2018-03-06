package Entities.Creature;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import Graphics.Animation;
import Main.Handler;
import Main.ImageLoader;
import Tiles.Tile;

public class Player extends Creature {


	protected Animation MD,MU,ML,MR;
	protected PlayerInventory PI;
	protected int speed=3;
	protected Rectangle R1,R2,R3,R4;
	protected static int width=Tiles.Tile.size;
	protected static int height=Tiles.Tile.size*3/2;
	protected Handler h;
	protected PlayerControl PC;
	public Player(Handler h,float x, float y) {
		super(h,x, y, width, height);
		this.h=h;
		this.MD=new Animation(254, ImageLoader.loadSprite("PD"));
		this.MU=new Animation(254, ImageLoader.loadSprite("PU"));
		this.MR=new Animation(254, ImageLoader.loadSprite("PR"));
		this.ML=new Animation(254, ImageLoader.loadSprite("PL"));
		this.PI=new PlayerInventory(h, 30);
		this.PC=new PlayerControl();
		h.getG().addPlayerControl(PC);
		this.health=100;
		this.R1=new Rectangle((int)this.x-width, (int)this.y, width, height);
		this.R2=new Rectangle((int)this.x+width, (int)this.y, width, height);
		this.R3=new Rectangle(0, 0, width, height);
		this.R4=new Rectangle(0, 0, width, height);
		
		// TODO Auto-generated constructor stub
	}
	private void updateClickBoxes() {
		this.R1=new Rectangle((int) (x - h.getCamera().getxOffset())-width, (int)this.y, width, height);
		this.R2=new Rectangle((int) (x - h.getCamera().getxOffset())+width, (int)this.y, width, height);
		this.R3=new Rectangle(0, 0, width, height);
		this.R4=new Rectangle(0, 0, width, height);
		
	}
	protected String MDD = "D";
	protected boolean rest=false;
	public void tick(){
		updateClickBoxes();
		getInventory().tick();
		h.getCamera().centerOnEntity(this);
		yMove=0;
		 
		xMove=0;
		if(PC.getKey(KeyEvent.VK_W)){
			 
			yMove-=2*speed;
			this.MDD="P";
		}
		if(PC.getKey(KeyEvent.VK_S)){
			yMove+=2*speed;
			this.MDD="D";
		}
		if(PC.getKey(KeyEvent.VK_A)){
 
			xMove-=2*speed;
			this.MDD="L";
		}
		if(PC.getKey(KeyEvent.VK_D)){
			xMove+=2*speed;
			this.MDD="R";
		}
		if(PC.getKey(KeyEvent.VK_E))
		{
			System.out.println("Open Inventory:"+PI.active);
			PI.active=!PI.active;
			PC.setKey(KeyEvent.VK_E,false);
		}
		if(xMove ==0&& yMove==0){
			rest=true;
		}
		if(xMove!=0||yMove!=0){
			rest=false;
		} 
		move(h);
		
	}
	


	public void render(Graphics g){
		if(handler.getM().isLClick()){
			handler.getM().setLClick(false);
			int x=handler.getM().getX();
			int y=handler.getM().getY();
			Tile T = handler.getWorld().getTile(x, y);
			T.setLightLevel(0);
		}
		if(this.MDD=="D"){
			if(!rest)
			MD.tick();
			g.drawImage(MD.getCurrentFrame(),(int) (x - h.getCamera().getxOffset()), (int) (y - h.getCamera().getyOffset()),width,height,null);
		}
		if(this.MDD=="P"){
			if(!rest)
			MU.tick();
			g.drawImage(MU.getCurrentFrame(),(int) (x - h.getCamera().getxOffset()), (int) (y - h.getCamera().getyOffset()),width,height,null);
		}
		if(this.MDD=="L"){
			if(!rest)
			ML.tick();
			g.drawImage(ML.getCurrentFrame(),(int) (x - h.getCamera().getxOffset()), (int) (y - h.getCamera().getyOffset()),width,height,null);
		}
		if(this.MDD=="R"){
			if(!rest)
			MR.tick();
			g.drawImage(MR.getCurrentFrame(),(int) (x - h.getCamera().getxOffset()), (int) (y - h.getCamera().getyOffset()),width,height,null);
		}
//		g.drawRect(R1.x,R1.y,R1.width,R1.height);
//		g.drawRect(R2.x,R2.y,R2.width,R2.height);
		
	}

	public void getSpecialFunction(Graphics g) {
		PI.render(g);
		
	}

	public PlayerInventory getInventory() {
		// TODO Auto-generated method stub
		return PI;
	}
}
