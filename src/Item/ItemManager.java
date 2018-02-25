package Item;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

import Main.Handler;

public class ItemManager {

	protected Handler h;
	protected ArrayList<Item> ItemList;
	public ItemManager(Handler h)
	{
		this.h=h;
		this.ItemList=new ArrayList<>();
	}
	
	public void tick()
	{
	for(Item I:ItemList)
		if(I.getbounds().intersects(Handler.getWorld().getEntityManager().getPlayer().getCollisionBounds(0f, 0f))){
			
			
			if(Handler.getWorld().getEntityManager().getPlayer().getInventory().addItem(I)){
				I.PickedUP=true;	
			}
		}
	Iterator<Item> it = ItemList.iterator();
	while(it.hasNext()){
		Item i = it.next();
		if(i.PickedUP){
			it.remove();
		}
	}
	}

	public void render(Graphics g) {
		for(Item I:ItemList)
		{
			I.render(g);
		}
	}
	public void add(Item i){
		ItemList.add(i);
	}
	
}
