package ted80.seedviewer.gen;

import ted80.seedviewer.biome.Biome;

abstract public class ChunkManager 
{
	abstract public Biome[] loadBlockGeneratorData(Biome[] oldBiomeList, int x, int y, int width, int depth);
	
	abstract public Biome[] getBiomeGenAt(Biome[] par1ArrayOfBiomeGenBase, int par2, int par3, int par4, int par5, boolean par6);
	
	abstract public Biome[] getBiomesForGeneration(Biome[] par1ArrayOfBiomeGenBase, int par2, int par3, int par4, int par5);
}
