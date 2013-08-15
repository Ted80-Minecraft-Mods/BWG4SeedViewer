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
		
		for(int i = 0; i < 15; i++)
		{
			for(int j = 0; j < 12; j++)
			{
				genQueue.add(new int[]{j,i});
			}
		}
	}
	
	public void genNextInQueue()
	{
		if(genQueue.size() > 0)
		{
			Chunk c = Generation.chunkprovider.provideChunk(genQueue.get(0)[0], genQueue.get(0)[1]);
			genQueue.remove(0);
			chunks.add(c);
		}
	}

	public void run() 
	{
		genNextInQueue();
	}
}
