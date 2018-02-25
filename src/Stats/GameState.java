package Stats;

import java.awt.Graphics;

import Main.Handler;
import Worlds.World;

public class GameState extends State {

	protected Handler handler;
	public GameState(Handler handler,String WorldPath) {
		super(handler);
		this.handler=handler;
		handler.setWorld(new World(handler, WorldPath));
	}

	@Override
	public void tick() {

		handler.getWorld().tick();
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public void render(Graphics g) {
		handler.getWorld().render(g);

	}

}
