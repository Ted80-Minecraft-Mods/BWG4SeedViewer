package ted80.seedviewer.gen.chunk;

import java.util.ArrayList;

import ted80.seedviewer.gen.Generation;

public class ChunkList implements Runnable
{
	public ArrayList<Chunk> chunks;
	public ArrayList<int[]> genQueue;
	
	public ChunkList()
	{
		chunks = new ArrayList<Chunk>();
		genQueue = new ArrayList<int[]>();
		
		for(int i = 0; i < 10; i++)
		{
			for(int j = 0; j < 10; j++)
			{
				genQueue.add(new int[]{i,j});
			}
		}
	}
	
	public void genNextInQueue()
	{
		if(genQueue.size() > 0)
		{
			int[] chunkcoords = genQueue.get(0);
			genQueue.remove(0);
			
			Chunk c = Generation.chunkprovider.provideChunk(chunkcoords[0], chunkcoords[1]);
			chunks.add(c);
		}
	}

	public void run() 
	{
		genNextInQueue();
	}
}
