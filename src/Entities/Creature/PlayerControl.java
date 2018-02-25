package Entities.Creature;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayerControl implements KeyListener{

	protected boolean[] Key;
	public PlayerControl(){
	Key= new boolean[256];
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		for(int i = 0;i < Key.length;i++){
			if(i==e.getKeyCode())
				Key[i]=true;
			
		}
		
	}
	public boolean getKey(int Code){
		
		return Key[Code];
	}
	@Override
	public void keyReleased(KeyEvent e) {
		for(int i = 0;i < Key.length;i++){
			if(i==e.getKeyCode())
				Key[i]=false;
			
		}
	}
	public void setKey(int vkE, boolean b) {
		Key[vkE]=b;
		
	}

}
