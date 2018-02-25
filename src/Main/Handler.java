package Main;

import Graphics.GameCamera;
import Worlds.World;

public class Handler {

	protected  Game G;
	protected static World W;
	protected MouseManager M;
	protected int width,height;
	protected static GameCamera C;
	public Handler(Game G){
		this.width=G.w;
		this.height=G.hi;
		this.G=G;
		this.C=new GameCamera(this, 0, 0);
	}
 
	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	public Game getG() {
		return G;
	}
	 
	public void setG(Game g) {
		G = g;
	}

	public MouseManager getM(){
		return M;
	}

	public void setM(MouseManager MManage){
		M=MManage;
	}

	public static World getWorld() {
		// TODO Auto-generated method stub
		return W;
	}

	public static  GameCamera getCamera() {
		// TODO Auto-generated method stub
		return C;
	}

	public void setWorld(World world) {
		this.W=world;
		
	}
	
	
}
