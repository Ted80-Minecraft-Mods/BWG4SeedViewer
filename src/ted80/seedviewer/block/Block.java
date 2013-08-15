package ted80.seedviewer.block;

public class Block 
{
	public static final Block[] blocksList = new Block[256];
	
	public static final Block BLOCK_AIR = new Block(0,    1.0F,1.0F,1.0F);
	public static final Block BLOCK_STONE = new Block(1,  0.7F,0.7F,0.7F);
	public static final Block BLOCK_GRASS = new Block(2,  0.2F,0.7F,0.2F);
	public static final Block BLOCK_DIRT = new Block(3,   0.7F,0.4F,0.0F);
	public static final Block BLOCK_SAND = new Block(4,   0.6F,0.6F,0.0F);
	public static final Block BLOCK_GRAVEL = new Block(5, 0.8F,0.8F,0.8F);
	public static final Block BLOCK_WATER = new Block(6,  0.2F,0.2F,0.8F);
	public static final Block BLOCK_LAVA = new Block(7,   0.5F,0.2F,0.0F);
	public static final Block BLOCK_ICE = new Block(8,    0.8F,0.8F,1.0F);
	public static final Block BLOCK_SNOW = new Block(9,   0.9F,0.9F,0.9F);
	
	public final int blockID;
	public final float blockColor1;
	public final float blockColor2;
	public final float blockColor3;
	
    public Block(int i, float c1, float c2, float c3)
    {
    	blockID = i;
    	blockColor1 = c1;
    	blockColor2 = c2;
    	blockColor3 = c3;
    	blocksList[i] = this;
    }
}
