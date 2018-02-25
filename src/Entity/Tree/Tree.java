package Entity.Tree;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

import javax.xml.transform.Source;

import Entities.Entity;
import Main.Handler;
import Main.ImageLoader;
import Tiles.Tile;


public class Tree extends Entity{


	protected Image FallingTree;
	protected boolean dying=false;
	protected Handler h;
	protected int TreetopX,TreetopY,bx,by;
	protected BufferedImage Texture1,Texture2,Texture3;
	protected Thread Run;
	protected LeaveManager LM;
	public Tree(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
		this.health=100;
		this.bounds=new Rectangle(0,Tile.size,Tile.size,Tile.size/5);
		this.h=handler;
		this.LM=new LeaveManager(handler, this.x, this.y);
		this.Texture1=ImageLoader.loadImage("TreeTop");
		this.Texture2=ImageLoader.loadImage("Treebottom");
		this.TreetopX=(int) this.x;
		this.TreetopY=(int)this.y;
		this.FallingTree=ImageLoader.convert(Texture1);
		this.bx=(int)x;
		this.by=(int)y;
	}

	private void move(int x,int y){
		TreetopX+=x;
		TreetopY+=y;
	}
	private void bmove(int x,int y){
		bx+=x;
		by+=y;
	}
	private void setPos(int x,int y){
		TreetopX=x;
		TreetopY=y;
		bx=x;
		by=y;
	}
	public int x(){
		return (int) this.x;
	}
	public int y(){
		return (int) this.y;
	}
	protected void shake(){
		Run = new Thread("run"){
			public void run(){
				int delay=15;
				for (int i = 0; i < 8; i++) {
			          			          try {
						
			          			        	move(1,0);
			          			        	bmove(1,0);
			          			        	Thread.sleep(delay);
			          			        	setPos(x(),y());
			          			        	Thread.sleep(delay);
			          			        	move(-1,0);
			          			        	bmove(-1,0);
			          			        	Thread.sleep(delay);
			          			        	setPos(x(),y());
			          			        	Thread.sleep(delay);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
			}
		};
		Run.start();
	}
	protected int counter=0;
	@Override
	public void tick() {
		if(addTime)
			timer+=1;
		if(handler.getM().getX() >= this.x && handler.getM().getX() <= this.x+this.width&&!dying){
			if(handler.getM().isLClick()){
				handler.getM().setLClick(false);
				shake();
				counter+=1;
				LM.generatebydying();
				if(counter > 2){
					dying=true;
					RunAnimation();
					this.Texture2=ImageLoader.loadImage("TBottom");
				}
			}
		}
		LM.tick();
	}

	protected boolean AnimationOVer=false;
	@Override
	public void runMe(Graphics g){
		handler.getWorld().getEntityManager().addEntity(new Stamm(h,this.x,this.y+Tile.size*3/2,this.width,this.height));
		Death=true;
	}
	protected int seconds=0;
	protected boolean runned=false;
	protected int  timer=0;

	protected boolean addTime=false;
	public void RunAnimation(){
		
	
	}
	@Override
	public void render(Graphics g) {
		LM.render(g);
		
		if(!dying){
			g.drawImage(Texture1,(int) (TreetopX - h.getCamera().getxOffset()), (int) (TreetopY - h.getCamera().getyOffset()),Tile.size,Tile.size*3/2, null);
			g.drawImage(Texture2,(int) (bx - h.getCamera().getxOffset()), (int) (by - h.getCamera().getyOffset())+Tile.size*3/2,Tile.size,Tile.size/2, null);
			
		}
		if(dying){
			
			run=true;
		}
	
		
	}

}
