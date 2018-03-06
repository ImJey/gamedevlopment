package Entities.Creature;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import Item.Item;
import Main.Handler;
import Tiles.Tile;

public class SlotManager {

	protected Handler h;
	protected Slot SSlot1,SSlot2;
	protected ArrayList<Slot> Slots=new ArrayList<>();
	public SlotManager(Handler h){
		this.h=h;
	}
	protected int SID=-1;
	protected Item SelItem=null;
	public void tick(){
		int mx=h.getM().getX();
		int my=h.getM().getY();
 
		if(SelItem!=null&&SelItem.getCount() == 0){
			SelItem=null;
			for(Slot QS:Slots){
				QS.i=null;
				QS.IR=false;
			}
		}
		for(Slot S:Slots){
			if(mx>= S.x&&mx<=S.x+S.width && my>=S.y&&my<=S.y+S.height){
				S.hovered=true;
				if(h.getM().isLClick()){
					h.getM().setLClick(false);
					if(SelItem!=null){
						if(S.i==null){
							S.i=new Item((BufferedImage)SelItem.getTexture(),SelItem.getId(),SelItem.getIname());
							S.i.setCount(1);
							SelItem.setCount(SelItem.getCount()-1);
							for(Slot SQ:Slots){
								if(SQ.id==SID)
									 break;
								
							}
						}else if(S.i.getId()==SelItem.getId()){
							if(S.id==SID){
								SID=-1;
								SelItem=null;
								return;
							}
							S.i.setCount(S.i.getCount()+1);
							SelItem.setCount(SelItem.getCount()-1);
							for(Slot SQ:Slots){
								if(SQ.id==SID){
									if(SelItem.getCount()>0){
									SQ.i=new Item((BufferedImage)SelItem.getTexture(),SelItem.getId(),SelItem.getIname());
								
									SQ.i.setCount(SelItem.getCount());
									}else{
										SQ.i=null;
										SelItem=null;
										S.IR=false;
									}
								}}
						}
						else{
							return;
						}
					}else if(SelItem==null&&S.i!=null){
						for(Slot SQ:Slots){
							if(!S.IR )
								continue;
							else
								return;
						}
						 
						SelItem=new Item((BufferedImage) S.i.getTexture(),S.i.getId(),S.i.getIname());
						SelItem.setCount(S.i.getCount());
						SID=S.id;
					}
				}
					
				}else{
					S.hovered = false;
				}
		}
		
		
	}
	public void render(Graphics g){
		for(Slot S:Slots){
			S.render(g);
		}
		if(SelItem!=null)
		{
				g.drawImage(SelItem.getTexture(), h.getM().getX(), h.getM().getY(),Tile.size/2,Tile.size/2, null);
				g.drawString(""+SelItem.getCount(), h.getM().getX()+Tile.size/2-g.getFontMetrics().stringWidth(""+SelItem.getCount()), h.getM().getY()+Tile.size/2);
		}
		
		
		
		
	}

	public void add(Slot s) {
		Slots.add(s);
	}
}
