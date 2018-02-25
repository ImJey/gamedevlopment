package Entity.Tree;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ThreadLocalRandom;

import Item.Item;
import Main.Handler;
import Tiles.Tile;

public class LeaveManager {

	protected ArrayList<Leaves> Leave;
	protected Handler h;
	private float x;
	private float y;
	public LeaveManager(Handler h,float x,float y){
		this.h=h;
		this.x=x;
		this.Leave=new ArrayList<>();
		this.y=y;
	}
	
	public void generatebydying(){
		for(int a=0;a<ThreadLocalRandom.current().nextInt(30,99);a++){
			System.out.println(h);
			System.out.println(x);
			Leave.add(new Leaves(h,x+ThreadLocalRandom.current().nextInt(0,Tile.size),y+ThreadLocalRandom.current().nextInt(0,Tile.size)));
		}
	}
	public void tick(){
		for(Leaves L : Leave){
			L.tick();
		}
		Iterator<Leaves> it = Leave.iterator();
		while(it.hasNext()){
			Leaves l = it.next();
			if(l.hground && l.timer){
				it.remove();
			}
		}
	}
	public void render(Graphics g){
		for(Leaves L : Leave){
				L.render(g);
		}
	}
}
