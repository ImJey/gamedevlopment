package Stats;

import java.awt.Graphics;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import Main.Button;
import Main.ButtonManager;
import Main.Handler;
import Main.Management;
import Main.Utils;

public class MenuA extends State{
protected ButtonManager BM;
public Button New,Load;
protected Handler h;
	public MenuA(Handler handler) {
		super(handler);
		this.h=handler;
		 
		this.New = new Button(h,100,50,100,50,"New Game") {
			
			@Override
			public void OC() throws IOException {
				System.out.println("Generating new Data...");
				int SaveCount=1;
				for(File F:Management.Saves.listFiles())
					SaveCount+=1;
				new File(Management.Saves+"\\"+SaveCount+"\\").mkdirs();
				Management.setSave(Management.Saves+"\\"+SaveCount+"\\");
				Utils.writeFile("\\Player.coordinates", 5*Tiles.Tile.size+" "+5*Tiles.Tile.size);
				
				State.setState(new GameState(h, ""+Management.MainFolder+"/"));
				
			}
		};
	this.Load = new Button(h,100,150,100,50,"Load Game") {
			
			@Override
			public void OC() {
				System.exit(0);
				
			}
		};
		this.BM=new ButtonManager(handler);
		BM.addButton(New);
		BM.addButton(Load);
	}

	@Override
	public void tick() {
		BM.tick();
		 
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		BM.render(g);
	 
	}
}
