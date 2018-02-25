package Entities.Creature;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import Item.Item;
import Main.Handler;
import Main.Launch;
import Tiles.Tile;

public class Inventory {

	protected Handler h;
	protected int x,y,w,hi;
	protected int Selected=0;
	protected BufferedImage BackGround;
	protected boolean active=true;
	protected SlotManager SM;
	protected ArrayList<Slot> SlotList=new ArrayList<>();
	public Inventory(Handler h,int Slots){
		this.x=h.getWidth()/3*2/2;
		this.y=h.getHeight()/3*2/2;
		this.w=h.getWidth()/3;
		this.hi=h.getHeight()/4;
		this.h=h;
		this.SM=new SlotManager(h);
		int b= x+Tile.size/3;
		int n= y+Tile.size/3;
		for(int i=0;i<Slots;i++){
			
			Slot S=new Slot(h,i,b,n);
			 
			if(i<=10)
			{
				S.xx=b;
				S.xy=n;
			}
			SM.add(S);
		b+=Tile.size/3+Tile.size/4;
		if(b > x+w-Tile.size/3){
			b=x+Tile.size/3;
			n+=Tile.size/3+Tile.size/4;
		}
		}
		
	}
	
	public void tick(){
//		System.out.println("TIKC!");
		if(active)
		for(Slot S: SM.Slots)
			S.tick();
		
		if(h.getM().ScrollUp){
		Selected+=1;
		if(Selected>10)
			Selected=0;
		h.getM().ScrollUp=false;
for(Slot S:SM.Slots){
		S.Selected=false;
		if(S.id==Selected)
			S.Selected=true;
		}
		}
		if(h.getM().mouseScrollDown){
			Selected-=1;
			if(Selected<0)
				Selected=10;
			h.getM().mouseScrollDown=false;
	for(Slot S:SM.Slots){
			S.Selected=false;
			if(S.id==Selected)
				S.Selected=true;
			}
			
			}
		
	}
	public void render(Graphics g){
		if(!active){
//			int xy=Launch.DISPLAYWIDTH/3;
			int xa;
			xa=Launch.DISPLAYWIDTH/3;
			for(Slot S: SM.Slots){
		
				if(S.id <= 10){
					S.hovered=false;
//					System.out.println("Render ID:"+S.id+":"+xa);
					S.x=xa;
					S.y=800;
					xa+=Tile.size/2;
					S.render(g);
				}
			
			}
		}
		if(active){
			g.fillRect(x, y, w, hi);
		for(Slot S: SM.Slots){
			if(S.id<=10){
				S.x=S.xx;
				S.y=S.xy;
//				System.out.println(S.id+":   "+S.x+":"+S.y);
			}
			S.render(g);
		}
		}
	}
	public ArrayList<Slot> getSlotList(){
		return SM.Slots; 
	}
	public boolean addItem(Item I){
		for(Slot S: SM.Slots){
			if(S.i==null){
				S.i=I;
				return true;
			}
			if(S.i.getId()==I.getId() && S.i.getCount()+I.getCount() < 100){
				S.i.setCount(S.i.getCount()+I.getCount());
			}
			
		}
		return false;
	}
}
