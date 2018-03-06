package Main;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class MouseManager implements MouseListener,MouseMotionListener,MouseWheelListener{

	protected boolean LClick=false,RClick=false;
	protected int x,y;
	@Override
	public void mouseClicked(MouseEvent e) {
		
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1)
			{
			LClick=true;
		 
			}
		if(e.getButton() == MouseEvent.BUTTON2)
			RClick=true;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1)
			LClick=false;
		if(e.getButton() == MouseEvent.BUTTON2)
			RClick=false;
	}

	/**
	 * @return the lClick
	 */
	public boolean isLClick() {
		return LClick;	}

	/**
	 * @param lClick the lClick to set
	 */
	public void setLClick(boolean lClick) {
		LClick = lClick;
	}

	/**
	 * @return the rClick
	 */
	public boolean isRClick() {
		
		return RClick;
	}

	/**
	 * @param rClick the rClick to set
	 */
	public void setRClick(boolean rClick) {
		RClick = rClick;
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		this.x=e.getX();
		this.y=e.getY();
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		RClick=false;
		LClick=false;
	}

	public boolean mouseScrollDown = false,ScrollUp=false;
	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		int notches=e.getWheelRotation();
		if(notches <0){
			mouseScrollDown=true;
		}
		else{
			ScrollUp=true;
		}
		
	}

	
	@Override
	public void mouseDragged(MouseEvent e) {
		this.x=e.getX();
		this.y=e.getY();
		
	}
	public boolean checkXBetween(int a,int b){
		if(a+getX()<b)
			return true;
		return false;
	}
	public boolean checkYBetween(int a,int b){
		if(a+getX()<b)
			return true;
		return false;
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		this.x=e.getX();
		this.y=e.getY();
	}
	

}
