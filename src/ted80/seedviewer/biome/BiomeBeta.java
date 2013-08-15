package ted80.seedviewer.biome;

import ted80.seedviewer.block.Block;

public class BiomeBeta extends Biome
{
	BiomeBeta(int i, int c, String n)
	{
		super(i, c, n);
		
		if(i == 57)
		{
			topBlock = Block.BLOCK_SAND.blockID;
			fillerBlock = Block.BLOCK_SAND.blockID;
		}
	}
}
