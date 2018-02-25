package Entities;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

import Entities.Creature.Player;
import Entity.Tree.Leaves;
import Main.Handler;

public class EntityManager {

	protected ArrayList<Entity> Entities = new ArrayList<>();
	protected Handler h;
	protected Player P;
	private Comparator<Entity> renderSorter = new Comparator<Entity>(){
		@Override
		public int compare(Entity a, Entity b) {
			if(a.getY() + a.getHeight() < b.getY() + b.getHeight())
				return -1;
			return 1;
		}
	};
	private Comparator<Entity> renderStage = new Comparator<Entity>(){
		@Override
		public int compare(Entity a, Entity b) {
			if(a.getStage() < b.getStage())
				return -1;
			return 1;
		}
	};
	public EntityManager(Handler h,Player P){
		Entities.add(P);
		this.P=P;
		this.h=h;
	}
	
	public void  tick(){
		for(Entity e : Entities){
			e.tick();
		}
		Iterator<Entity> it = Entities.iterator();
		while(it.hasNext()){
			Entity l = it.next();
			if(l.Death){
				it.remove();
			}
		}
		for(Entity e : Entities){
			if(e.run){
			e.runMeN();
			break;
			}
		}
		Entities.sort(renderSorter);
	}
	public void render(Graphics g){
		for(Entity e : Entities){
			e.render(g);
		}
		for(Entity e : Entities){
			if(e.run){
			e.runMe(g);
			break;
			}
		}
	
		
	}
	public void removeEntity(Entity E){
		for(Entity EE: Entities)
			if(E==EE)
				Entities.remove(this);
	}
	public void addEntity(Entity E){
		Entities.add(E);
	}

	public ArrayList<Entity> getEntities() {
		// TODO Auto-generated method stub
		return Entities;
	}

	public Player getPlayer() {
		// TODO Auto-generated method stub
		return P;
	}
}
