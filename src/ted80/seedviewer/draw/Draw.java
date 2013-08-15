package ted80.seedviewer.draw;

public class Draw 
{
	public DrawMap drawmap = new DrawMap();
	
	public Draw()
	{
		
	}
	
	public void updateScreen()
	{
		drawmap.updateMap();
	}
}
