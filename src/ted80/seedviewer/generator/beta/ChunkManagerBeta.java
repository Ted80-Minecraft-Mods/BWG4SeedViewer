package ted80.seedviewer.generator.beta;

import java.util.Random;

import ted80.seedviewer.biome.Biome;
import ted80.seedviewer.gen.ChunkManager;
import ted80.seedviewer.gen.NoiseOctaves2;
import ted80.seedviewer.generator.Generator;

public class ChunkManagerBeta extends ChunkManager
{
    private static NoiseOctaves2 field_4194_e;
    private static NoiseOctaves2 field_4193_f;
    private static NoiseOctaves2 field_4192_g;
    public static double temperature[]; 
    public static double humidity[];
    public static double field_4196_c[];
	private static int biomeLookupTable[] = new int[4096];	
	
    private Generator generator;
	
	public ChunkManagerBeta(long seed, Generator g)
	{
		generateBiomeLookup();
        field_4194_e = new NoiseOctaves2(new Random(seed * 9871L), 4);
        field_4193_f = new NoiseOctaves2(new Random(seed * 39811L), 4);
        field_4192_g = new NoiseOctaves2(new Random(seed * 0x84a59L), 2);
        generator = g;
	}

	public Biome[] loadBlockGeneratorData(Biome[] oldBiomeList, int x, int y, int width, int depth) 
    {
        return this.getBiomeGenAt(oldBiomeList, x, y, width, depth, true);
    }

    public Biome[] getBiomeGenAt(Biome[] par1ArrayOfBiomeGenBase, int par2, int par3, int par4, int par5, boolean par6)
    {
        if (par1ArrayOfBiomeGenBase == null || par1ArrayOfBiomeGenBase.length < par4 * par5)
        {
            par1ArrayOfBiomeGenBase = new Biome[par4 * par5];
        }

		int var7[] = getBiomesGens(par2, par3, par4, par5);

        for (int var8 = 0; var8 < par4 * par5; ++var8)
        {
            par1ArrayOfBiomeGenBase[var8] = Biome.biomeList[var7[var8]];
        }

        return par1ArrayOfBiomeGenBase;
    }

    public Biome[] getBiomesForGeneration(Biome[] par1ArrayOfBiomeGenBase, int par2, int par3, int par4, int par5)
    {
        if (par1ArrayOfBiomeGenBase == null || par1ArrayOfBiomeGenBase.length < par4 * par5)
        {
            par1ArrayOfBiomeGenBase = new Biome[par4 * par5];
        }

		int var6[] = getBiomesGens(par2, par3, par4, par5);

        for (int var7 = 0; var7 < par4 * par5; ++var7)
        {
            par1ArrayOfBiomeGenBase[var7] = Biome.biomeList[var6[var7]];
        }

        return par1ArrayOfBiomeGenBase;
    }
	
	public static double[] getColdTemperatures(double ad[], int i, int j, int k, int l)
    {
        if(ad == null || ad.length < k * l)
        {
            ad = new double[k * l];
        }
        ad = field_4194_e.func_4112_a(ad, i, j, k, l, 0.02500000037252903D, 0.02500000037252903D, 0.25D);
        field_4196_c = field_4192_g.func_4112_a(field_4196_c, i, j, k, l, 0.25D, 0.25D, 0.58823529411764708D);
        int i1 = 0;
        for(int j1 = 0; j1 < k; j1++)
        {
            for(int k1 = 0; k1 < l; k1++)
            {
                double d = field_4196_c[i1] * 1.1000000000000001D + 0.5D;
                double d1 = 0.01D;
                double d2 = 1.0D - d1;
                double d3 = (ad[i1] * 0.14999999999999999D + 0.69999999999999996D) * d2 + d * d1;
                d3 = 1.0D - (1.0D - d3) * (1.0D - d3);
                if(d3 < 0.0D)
                {
                    d3 = 0.0D;
                }
                if(d3 > 1.0D)
                {
                    d3 = 1.0D;
                }
                ad[i1] = d3;
                i1++;
            }

        }

        return ad;
    }
	
    public static int[] getBiomesGens(int par1, int par2, int par3, int par4)
    {		
		int[] abiomegenbase = new int[par3 * par4];
		temperature = field_4194_e.func_4112_a(temperature, par1, par2, par3, par3, 0.02500000037252903D, 0.02500000037252903D, 0.25D);
		humidity = field_4193_f.func_4112_a(humidity, par1, par2, par3, par3, 0.05000000074505806D, 0.05000000074505806D, 0.33333333333333331D);
		field_4196_c = field_4192_g.func_4112_a(field_4196_c, par1, par2, par3, par3, 0.25D, 0.25D, 0.58823529411764708D);
		int i1 = 0;
		for(int j1 = 0; j1 < par3; j1++)
		{
			for(int k1 = 0; k1 < par4; k1++)
			{
				double d = field_4196_c[i1] * 1.1000000000000001D + 0.5D;
				double d1 = 0.01D;
				double d2 = 1.0D - d1;
				double d3 = (temperature[i1] * 0.14999999999999999D + 0.69999999999999996D) * d2 + d * d1;
				d1 = 0.002D;
				d2 = 1.0D - d1;
				double d4 = (humidity[i1] * 0.14999999999999999D + 0.5D) * d2 + d * d1;
				d3 = 1.0D - (1.0D - d3) * (1.0D - d3);
				if(d3 < 0.0D)
				{
					d3 = 0.0D;
				}
				if(d4 < 0.0D)
				{
					d4 = 0.0D;
				}
				if(d3 > 1.0D)
				{
					d3 = 1.0D;
				}
				if(d4 > 1.0D)
				{
					d4 = 1.0D;
				}
				temperature[i1] = d3;
				humidity[i1] = d4;
				abiomegenbase[i1++] = getBiomeFromLookup(d3, d4);
			}
		}
		return abiomegenbase;
    }
	
    private static int getBiomeFromLookup(double d, double d1)
    {
        int i = (int)(d * 63D);
        int j = (int)(d1 * 63D);
        return biomeLookupTable[i + j * 64];
    }

    public void generateBiomeLookup()  
    {
		if(generator == Generator.BETA1)
		{
			for(int i = 0; i < 64; i++)
			{
				for(int j = 0; j < 64; j++)
				{
					biomeLookupTable[i + j * 64] = getBetaBiomes((float)i / 63F, (float)j / 63F);
				}
			}
		}
		else if(generator == Generator.BETA2)
		{
			for(int i = 0; i < 64; i++)
			{
				for(int j = 0; j < 64; j++)
				{
					biomeLookupTable[i + j * 64] = getDefaultBiomes((float)i / 63F, (float)j / 63F);
				}
			}
		}
    }
    
    public int getBetaBiomes(float f, float f1) 
    {
		f1 *= f;
		if(f < 0.1F)
		{
			return Biome.BETA_TUNDRA.biomeID; 
		}
		if(f1 < 0.2F)
		{
			if(f < 0.5F)
			{
				return Biome.BETA_TUNDRA.biomeID;
			}
			if(f < 0.95F)
			{
				return Biome.BETA_SAVANNA.biomeID;
			} else
			{
				return Biome.BETA_DESERT.biomeID;
			}
		}
		if(f1 > 0.5F && f < 0.7F)
		{
			return Biome.BETA_SWAMPLAND.biomeID;
		}
		if(f < 0.5F)
		{
			return Biome.BETA_TAIGA.biomeID;
		}
		if(f < 0.97F)
		{
			if(f1 < 0.35F)
			{
				return Biome.BETA_SCHRUBLAND.biomeID;
			} else
			{
				return Biome.BETA_FOREST.biomeID;
			}
		}
		if(f1 < 0.45F)
		{
			return Biome.BETA_PLAINS.biomeID;
		}
		if(f1 < 0.9F)
		{
			return Biome.BETA_SEASONALFOREST.biomeID;
		} else
		{
			return Biome.BETA_RAINFOREST.biomeID;
		}
    }
    
    public int getDefaultBiomes(float temp, float rain) 
    {
		rain *= temp;
		if(temp < 0.2F)
		{
			if(rain < 0.1F)
			{
				return Biome.BETTER_SNOWPLAINS.biomeID; 
			}
			else
			{
				return Biome.BETTER_SNOWPINES.biomeID; 
			}
		}
		if(temp < 0.4F)
		{
			if(rain < 0.1F)
			{
				return Biome.BETTER_SNOWTAIGA.biomeID; 
			}
			if(rain < 0.2F)
			{
				return Biome.BETTER_SNOWFOREST.biomeID; 
			}
			else
			{
				return Biome.BETTER_SNOWPINES.biomeID; 
			}
		}
		if(temp < 0.5F)
		{
			if(rain < 0.1F)
			{
				return Biome.BETTER_SNOWTAIGA.biomeID; 
			}
			if(rain < 0.2F)
			{
				return Biome.BETTER_FOREST.biomeID; 
			}
			else
			{
				return Biome.BETTER_PINES.biomeID; 
			} 
		}
		if(temp < 0.7F)
		{
			if(rain < 0.3F)
			{
				return Biome.BETTER_FOREST.biomeID; 
			}
			if(rain < 0.5F)
			{
				return Biome.BETTER_FORESTHILLS.biomeID; 
			}
			if(rain < 0.7F)
			{
				return Biome.BETTER_GRASSLAND.biomeID; 
			}
			else
			{
				return Biome.BETTER_SWAMPLAND.biomeID; 
			} 
		}
		if(temp < 0.8F)
		{
			if(rain < 0.2F)
			{
				return Biome.BETTER_PLAINS.biomeID; 
			}
			if(rain < 0.5F)
			{
				return Biome.BETTER_FOREST.biomeID; 
			}
			if(rain < 0.7F)
			{
				return Biome.BETTER_FORESTLAKES.biomeID; 
			}
			else
			{
				return Biome.BETTER_SWAMPLAND.biomeID; 
			}
		}
		if(rain < 0.2F)
		{
			if(temp < 0.9F)
			{
				return Biome.BETTER_SCHRUBLAND.biomeID; 
			}
			else
			{
				return Biome.BETTER_DESERT.biomeID; 
			}
		}
		if(rain < 0.3F)
		{
			return Biome.BETTER_SAVANNA.biomeID; 
		}
		if(rain < 0.4F)
		{
			return Biome.BETTER_PLAINS.biomeID; 
		}
		if(rain < 0.7F)
		{
			return Biome.BETTER_FORESTLAKES.biomeID;  
		}
		if(rain < 0.8F)
		{
			return Biome.BETTER_RAINFOREST.biomeID; 
		}
		else
		{
			return Biome.BETTER_JUNGLE.biomeID; 
		}
    }
}
