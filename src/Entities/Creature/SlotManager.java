package Entities.Creature;

import java.awt.Graphics;
import java.util.ArrayList;

import Main.Handler;

public class SlotManager {

	protected Handler h;
	protected Slot SSlot1,SSlot2;
	protected ArrayList<Slot> Slots=new ArrayList<>();
	public SlotManager(Handler h){
		this.h=h;
	}
	
	public void tick(){
		int mx=h.getM().getX();
		int my=h.getM().getY();
		
		
		
	}
	public void render(Graphics g){
		for(Slot S:Slots)
			S.render(g);
	}

	public void add(Slot s) {
		Slots.add(s);
	}
}
