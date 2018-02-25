package Tool;

import java.awt.image.BufferedImage;

import Item.Item;

public abstract class Tool extends Item{

	public Tool(BufferedImage Texture, int id, int IName) {
		super(Texture, id, IName);
		// TODO Auto-generated constructor stub
	}

	public abstract void OnUse();
}
