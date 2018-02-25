package Main;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import Entities.Creature.PlayerControl;
import Stats.MenuA;
import Stats.State;

public class Game implements Runnable{
	protected boolean running =false;
protected Thread Tick,Render,Init;
protected BufferStrategy bs;
protected Graphics g;
protected Display D;
protected Handler h;
protected MouseManager MMM;
public int w,hi;
public Game(String DisplayTitle,int width,int height){
	this.D=new Display(DisplayTitle,width,height);
	System.out.println("Display Created!");
	this.w=width;
	this.hi=height;
	this.h=new Handler(this);
}
protected int ticks=0,frames=60,CurrentFPS=0;
public void run(){
	running=true;
	ticker();
	render();
	try {
		Init();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
private void Init() throws IOException{
	if(Management.InfoFolder.exists()){
		if(!new File(Management.InfoFolder+"\\Info.txt").exists()){
			FileWriter FW =new FileWriter(new File(Management.InfoFolder+"\\Info.txt"));
		FW.close();
		}
	}
	State.setState(new MenuA(h));
	MMM=new MouseManager();
	amM(MMM);
}
private void tick(){
	if(Stats.State.getState() != null)
		Stats.State.getState().tick();
}
public void ticker(){
	Tick=new Thread("tick"){
		public void run(){
			double timePerTick = 1000000000 / frames;
			double delta = 0;
			long now;
			long lastTime = System.nanoTime();
			long timer = 0;
		
			 ticks = 0;
			while(running){
				timePerTick = 1000000000 / frames;
				now = System.nanoTime();
				delta += (now - lastTime) / timePerTick;
				timer += now - lastTime;
				lastTime = now;
				
				if(delta >= 1){
					tick();
					render();
					ticks++;
					delta--;
				}
			 
				if(timer >= 1000000000){
					CurrentFPS = ticks;
					System.out.println("Ticks and Frames: " + ticks);
					 
					ticks = 0;
					timer = 0;
					
				
					
					
				
					
				}
			}
		}
	};
	Tick.start();
}
private void render() {
	
	bs = D.getCanvas().getBufferStrategy();
	if(bs == null){
		D.getCanvas().createBufferStrategy(3);
		return;
	}
	g = bs.getDrawGraphics();
	//Clear Screen
	g.clearRect(0, 0, 400, 300);
	
	//Draw Here!
	 
	if(Stats.State.getState() != null)
		Stats.State.getState().render(g);
	
	//End Drawing!
	bs.show();
	g.dispose();
	
}
public MouseManager getMouseManager(){
	return MMM;
}
public void amM(MouseManager MM) {
	D.getCanvas().addMouseListener(MM);
	D.getCanvas().addMouseMotionListener(MM);
	D.getCanvas().addMouseWheelListener(MM);
	D.getFrame().addMouseListener(MM);
	D.getFrame().addMouseMotionListener(MM);
	D.getFrame().addMouseWheelListener(MM);
	h.setM(MM);
	
	
}
public void addPlayerControl(PlayerControl PC) {
	D.getCanvas().addKeyListener(PC);
	D.getFrame().addKeyListener(PC);
	
}
}
