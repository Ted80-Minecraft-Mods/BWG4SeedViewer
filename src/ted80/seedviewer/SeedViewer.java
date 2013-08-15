package ted80.seedviewer;

import java.util.Random;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

import ted80.seedviewer.draw.Draw;
import ted80.seedviewer.gen.Generation;
import ted80.seedviewer.generator.Generator;

public class SeedViewer 
{
	public Draw draw;
	
	public Generation gen;
	public int gentimer = 0;
	
	public SeedViewer()
	{
		try
		{
			Display.setDisplayMode(new DisplayMode(1000, 800));
			Display.setTitle("BWG4 Seed Viewer - made by ted80");
			Display.create();
		}
		catch(LWJGLException e)
		{
			System.out.println("[LWJGL] Failed to create display.");
		}
		
		initOpenGL();
		
		start();
	}

	public void initOpenGL()
	{
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(0, 1000, 0, 800, 1, -1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
	}
	
	public void start()
	{
		draw = new Draw();
		gen = new Generation(Generator.BETA1, translateSeed("Glacier"));
		
		while(!Display.isCloseRequested())
		{
			gentimer--;
			if(gentimer < 0)
			{
				if(Generation.chunklist.genQueue.size() > 0)
				{
					Thread genchunk = new Thread(Generation.chunklist);
					genchunk.start();
				}
				gentimer = 2;
			}
			
			draw.updateScreen();
			
			Display.update();
			Display.sync(2);
		}
		
		Display.destroy();
	}
	
	public static void main(String[] args) 
	{
		new SeedViewer();
	}
	
	public long translateSeed(String s)
	{
		long i = (new Random()).nextLong();

		if (!stringNullOrLengthZero(s))
		{
		    try
		    {
		        long j = Long.parseLong(s);

		        if (j != 0L)
		        {
		            i = j;
		        }
		    }
		    catch (NumberFormatException numberformatexception)
		    {
		        i = (long)s.hashCode();
		    }
		}
		
		return i;
	}
	
    public static boolean stringNullOrLengthZero(String par0Str)
    {
        return par0Str == null || par0Str.length() == 0;
    }
}