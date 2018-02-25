package Entities.Creature;

import Main.Handler;

public class PlayerInventory extends Inventory{

	protected int sSlot=0;
	protected Slot Selected;
	public PlayerInventory(Handler h, int Slots) {
		super(h, Slots);
		// TODO Auto-generated constructor stub
	}

	public void setActive(boolean b)
	{
		active=b;
	}
	
}
