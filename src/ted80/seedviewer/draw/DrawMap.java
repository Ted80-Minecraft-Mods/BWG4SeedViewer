package ted80.seedviewer.draw;

import org.lwjgl.opengl.GL11;

import ted80.seedviewer.block.Block;
import ted80.seedviewer.gen.Generation;

public class DrawMap 
{
	public DrawMap()
	{
		
	}
	
	public void updateMap()
	{
		//GL11.glClear(GL11.GL_COLOR_BUFFER_BIT); 
		
		System.out.println(Generation.chunklist.chunks.size());
		
		for(int c = 0; c < Generation.chunklist.chunks.size(); c++)
		{
			int cx = Generation.chunklist.chunks.get(c).chunkX;
			int cy = Generation.chunklist.chunks.get(c).chunkY;
			
			for(int x = 0; x < 16; x++)
			{
				for(int y = 0; y < 16; y++)
				{
					int id = Generation.chunklist.chunks.get(c).TOPBLOCK[x][y];
					
					GL11.glPushMatrix();
						GL11.glTranslatef(x + (cx * 16), y + (cy * 16), 0);
						GL11.glColor3f(Block.blocksList[id].blockColor1,Block.blocksList[id].blockColor2,Block.blocksList[id].blockColor3);
					   
						GL11.glBegin(GL11.GL_QUADS);
							GL11.glVertex2f(x + (cx * 16), y + (cy * 16) + 1); 
							GL11.glVertex2f(x + (cx * 16), y + (cy * 16));
							GL11.glVertex2f(x + (cx * 16) + 1, y + (cy * 16));
							GL11.glVertex2f(x + (cx * 16) + 1, y + (cy * 16) + 1);
						GL11.glEnd();
					GL11.glPopMatrix();
				}
			}
		}
	}
}
