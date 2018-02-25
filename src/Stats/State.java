package Stats;

import java.awt.Graphics;

import Main.Handler;
 

public abstract class State {

	private static State currentState = null;
	protected boolean initruned = false;
	public static void setState(State state){
		currentState = state;
		if(!state.initruned)
		{state.init();
		state.initruned = true;
		}
	}
	
	public static State getState(){
		return currentState;
	}
	
	//CLASS
	
	protected Handler handler;
	
	public State(Handler handler){
		this.handler = handler;
	}
	
	public abstract void tick();
	public abstract void init();
	public abstract void render(Graphics g);
	
}