package Main;

import java.awt.Graphics;
import java.util.ArrayList;

public class ButtonManager {

	protected ArrayList<Button> Buttons;
	protected Handler h;
	public ButtonManager(Handler h){
		this.h=h;
		h.getG().amM(new MouseManager());
		Buttons =new ArrayList<>();
	}
	
	public void tick(){
		for(Button B:Buttons){
			B.tick();
		}
	}
	public void render(Graphics g){
		for(Button B:Buttons)
			B.render(g);
	}
	public void addButton(Button B){
		Buttons.add(B);
	}
}
