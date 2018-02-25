package Main;

import java.io.File;

public class Management {

	
	public static File MainFolder = new File("C:\\Users\\"+System.getProperty("user.name")+"\\Desktop\\GAMEFOLDER\\");
	public static File Graphics = new File(MainFolder+"\\Graphics\\");
	public static File Saves = new File(MainFolder+"\\Saves\\");
	public static File InfoFolder = new File(MainFolder+"\\Info\\");
	public static void setSave(String string) {
		Saves = new File(string);
		System.out.println("New Save Folder= :"+'"'+string+'"');
	}
}
