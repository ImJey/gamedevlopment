package Entity.Electric;

import Item.Item;

public class ItemNBurn {

	protected Item i;
	protected int fuel;
	public ItemNBurn(Item i,int fuel){
		this.i=i;
		this.fuel=fuel;
	}
	
	public int getfuel(){
		return fuel;
	}
	public Item getItem(){
		return i;
	}
}
