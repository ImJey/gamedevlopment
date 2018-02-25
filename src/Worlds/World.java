package Worlds;

import java.awt.Graphics;
import java.io.File;

import Entities.EntityManager;
import Entities.Creature.Player;
import Entity.Tree.Tree;
import Item.Item;
import Item.ItemManager;
import Main.Handler;
import Main.Utils;
import Tiles.Tile;

public class World {
	protected String worldname = "";
	protected int[][] tiles;
 
 
	public boolean active = false;
 
	protected EntityManager EM;
	protected int width,height,spawnX,spawnY;
	protected Handler handler;
	protected ItemManager IM;
 
//	protected ArrayList<Teleport> Teleports = new ArrayList<>();
	protected boolean genPlayer = true;
	public boolean rendering;
	public World(Handler handler,String Path){
		this.handler=handler;
		loadWorld(Path);
		this.worldname=Path;
		this.rendering = true;
		this.IM=new ItemManager(handler);
		
		this.IM.add(Item.Wood.createNew(300, 300));
		this.EM=new EntityManager(handler, new Player(handler,0, 0));
	EM.addEntity(new Tree(handler, 100, 100, Tile.size, Tile.size));
	System.out.println("Created new WORLD!");
		}
		
	
	 
	public String wname(){
		return worldname;
	}
	
	 
	
	public  void loadWorld(String Path){
		
		
		String file = Utils.loadFileAsString(Path+"w.txt");
		String[] tokens = file.split("\\s+");
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);
		tiles = new int[width][height];
		for(int y = 0;y < height;y++){
			for(int x = 0;x < width;x++){
				tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);
			}
		}
	
		loadEntities(Path);
		
	}

	private void loadEntities(String path) {
		File EntityFolder = new File(path+"entity.txt");
		if(EntityFolder.exists()){
			System.out.println("Loading Entites...");
		}
		
	}



	
	public Tile getTile(int x, int y){
		if(x < 0 || y < 0 || x >= width || y >= height)
			return Tile.grassTile;
		Tile t = Tile.tiles[tiles[x][y]];
		if(t == null)
			return Tile.grassTile;
		return t;
	}
	
	public void tick(){
	 EM.tick();
	 IM.tick();
	}

	public void render(Graphics g) {
//		System.out.println(Tile.size);
		
		int xStart = (int) Math.max(0, Handler.getCamera().getxOffset() / Tile.size);
		int xEnd = (int) Math.min(width, (Handler.getCamera().getxOffset() + handler.getWidth()) / Tile.size + 1);
		int yStart = (int) Math.max(0, Handler.getCamera().getyOffset() / Tile.size);
		int yEnd = (int) Math.min(height, (Handler.getCamera().getyOffset() + handler.getHeight()) / Tile.size + 1);
		for(int y = yStart;y < yEnd;y++){
			for(int x = xStart;x < xEnd;x++){
				
				getTile(x, y).render(g, (int) (x * Tile.size - Handler.getCamera().getxOffset()),
						(int) (y * Tile.size - Handler.getCamera().getyOffset()));
			}
		}
	
		IM.render(g);
		EM.render(g);
		EM.getPlayer().getSpecialFunction(g);
	
		}
	




	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}








	

	public void setRendering(boolean b){
		rendering=b;
	}



	public void setPlayerPosition(int i, int j) {
//		P.setPosition(i,j);
		
	}
	
	
	public int[][] getTiles() {
		// TODO Auto-generated method stub
		return tiles;
	}



	public EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return EM;
	}

 
	
}