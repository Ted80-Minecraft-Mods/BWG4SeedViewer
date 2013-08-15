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
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT); 
		
		for(int c = 0; c < Generation.chunklist.chunks.size(); c++)
		{
			int cx = Generation.chunklist.chunks.get(c).chunkY;
			int cy = Generation.chunklist.chunks.get(c).chunkX;
			int[][] top = Generation.chunklist.chunks.get(c).TOPBLOCK;
			
			for(int x = 0; x < 16; x++)
			{
				for(int y = 0; y < 16; y++)
				{
					int id = top[x][y];
					
					GL11.glPushMatrix();
						GL11.glTranslatef(x * 2 + (cx * 32), y * 2 + (cy * 32), 0);
						getColor(id, c, x, y);
					   
						GL11.glBegin(GL11.GL_QUADS);
							GL11.glVertex2f(x * 2 + (cx * 32), y * 2 + (cy * 32) + 4); 
							GL11.glVertex2f(x * 2 + (cx * 32), y * 2 + (cy * 32));
							GL11.glVertex2f(x * 2 + (cx * 32) + 4, y * 2 + (cy * 32));
							GL11.glVertex2f(x * 2 + (cx * 32) + 4, y * 2 + (cy * 32) + 4);
						GL11.glEnd();
					GL11.glPopMatrix();
				}
			}
		}
	}
	
	public void getColor(int id, int ch, int x, int y)
	{
		float[] c = new float[]{Block.blocksList[id].blockColor1,Block.blocksList[id].blockColor2,Block.blocksList[id].blockColor3};
		
		for(int l = 0; l < 3; l++)
		{
			c[l] -= (float) Generation.chunklist.chunks.get(ch).HEIGHT[x][y] / 256F;
			if(c[l] < 0F)
			{
				c[l] = 0F;
			}
			if(c[l] > 1F)
			{
				c[l] = 1F;
			}
		}
		
		GL11.glColor3f(c[0],c[1],c[2]);
	}
}
