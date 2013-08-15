package ted80.seedviewer.gen;

import ted80.seedviewer.gen.chunk.Chunk;

public interface IChunkProvider
{
    Chunk provideChunk(int i, int j);

    void populate(IChunkProvider ichunkprovider, int i, int j);
}
