package ted80.seedviewer.gen.chunk;

public class Chunk 
{
	public int chunkX;
	public int chunkY;
	
	public int[][] TOPBLOCK;
	public int[][] BIOMES;
	public int[][] HEIGHT;
	
	public Chunk(int x, int y, int[][] toparray, int[][] biomearray, int[][] heightarray)
	{
		chunkX = x;
		chunkY = y;
		
		TOPBLOCK = toparray;
		BIOMES = biomearray;
		HEIGHT = heightarray;
	}
}
