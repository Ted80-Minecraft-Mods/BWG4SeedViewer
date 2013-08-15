package ted80.seedviewer.gen;

import ted80.seedviewer.gen.chunk.Chunk;
import ted80.seedviewer.gen.chunk.ChunkList;
import ted80.seedviewer.generator.Generator;
import ted80.seedviewer.generator.beta.ChunkManagerBeta;
import ted80.seedviewer.generator.beta.ChunkProviderBeta;

public class Generation 
{
	public static ChunkList chunklist;
	public static IChunkProvider chunkprovider;
	public static ChunkManager chunkmanager;
	public static Generator generator;
	public static long seed;
	
	public Generation(Generator g, long s)
	{
		generator = g;
		seed = s;
		
		chunkmanager = getChunkManager();
		chunkprovider = getChunkProvider();

		chunklist = new ChunkList();
	}
	
	public ChunkManager getChunkManager()
	{
		if(generator == Generator.BETA1 || generator == Generator.BETA2)
		{
			return new ChunkManagerBeta(seed, generator);
		}
		
		return new ChunkManagerBeta(seed, generator);
	}
	
	public IChunkProvider getChunkProvider()
	{	
		if(generator == Generator.BETA1 || generator == Generator.BETA2)
		{
			return new ChunkProviderBeta(seed);
		}
		
		return new ChunkProviderBeta(seed);
	}
}
