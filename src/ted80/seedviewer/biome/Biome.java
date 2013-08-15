package ted80.seedviewer.biome;

public class Biome 
{
	public static final Biome[] biomeList = new Biome[500];
	
	public static final Biome DEFAULT_OCEAN               = new BiomeDefault(0, 0xFFFFFF, "Ocean");
    public static final Biome DEFAULT_PLAINS              = new BiomeDefault(1, 0xCCCCCC, "Plains");
    public static final Biome DEFAULT_DESERT              = new BiomeDefault(2, 0xFFFFFF, "Desert");
    public static final Biome DEFAULT_EXTREMEHILLS        = new BiomeDefault(3, 0xCCCCCC, "Extreme Hills");
    public static final Biome DEFAULT_FOREST              = new BiomeDefault(4, 0xFFFFFF, "Forest");
    public static final Biome DEFAULT_TAIGA               = new BiomeDefault(5, 0xCCCCCC, "Taiga");
    public static final Biome DEFAULT_SWAMPLAND           = new BiomeDefault(6, 0xFFFFFF, "Swampland");
    public static final Biome DEFAULT_RIVER               = new BiomeDefault(7, 0xCCCCCC, "River");
    public static final Biome DEFAULT_FROZENOCEAN         = new BiomeDefault(8, 0xFFFFFF, "Frozen Ocean");
    public static final Biome DEFAULT_FROZENRIVER         = new BiomeDefault(9, 0xCCCCCC, "Frozen River");
    public static final Biome DEFAULT_ICEPLAINS           = new BiomeDefault(10, 0xFFFFFF, "Ice Plains");
    public static final Biome DEFAULT_ICEMOUNTAINS        = new BiomeDefault(11, 0xCCCCCC, "Ice Mountains");
    public static final Biome DEFAULT_MUSHROOMISLAND      = new BiomeDefault(12, 0xFFFFFF, "Mushroom Island");
    public static final Biome DEFAULT_MUSHROOMISLANDSHORE = new BiomeDefault(13, 0xCCCCCC, "Mushroom Island Shore");
    public static final Biome DEFAULT_BEACH               = new BiomeDefault(14, 0xFFFFFF, "Beach");
    public static final Biome DEFAULT_DESERTHILLS         = new BiomeDefault(15, 0xCCCCCC, "Desert Hills");
    public static final Biome DEFAULT_FORESTHILLS         = new BiomeDefault(16, 0xFFFFFF, "Forest");
    public static final Biome DEFAULT_TAIGAHILLS          = new BiomeDefault(17, 0xCCCCCC, "Taiga Hills");
    public static final Biome DEFAULT_EXTREMEHILLSEDGE    = new BiomeDefault(18, 0xFFFFFF, "Extreme Hills Edge");
    public static final Biome DEFAULT_JUNGLE              = new BiomeDefault(19, 0xCCCCCC, "Jungle");
    public static final Biome DEFAULT_JUNGLEHILLS         = new BiomeDefault(20, 0xFFFFFF, "Jungle Hills");
    
	public static final Biome BETA_RAINFOREST             = new BiomeBeta(50, 0xCCCCCC, "Rainforest");
	public static final Biome BETA_SWAMPLAND              = new BiomeBeta(51, 0xFFFFFF, "Swampland");
	public static final Biome BETA_SEASONALFOREST         = new BiomeBeta(52, 0xCCCCCC, "Seasonal Forest");
	public static final Biome BETA_FOREST                 = new BiomeBeta(53, 0xFFFFFF, "Forest");
	public static final Biome BETA_SAVANNA                = new BiomeBeta(54, 0xCCCCCC, "Savanna");
	public static final Biome BETA_SCHRUBLAND             = new BiomeBeta(55, 0xFFFFFF, "Schrubland");
	public static final Biome BETA_TAIGA                  = new BiomeBeta(56, 0xCCCCCC, "Taiga");
	public static final Biome BETA_DESERT                 = new BiomeBeta(57, 0xFFFFFF, "Desert");
	public static final Biome BETA_PLAINS                 = new BiomeBeta(58, 0xCCCCCC, "Plains");
	public static final Biome BETA_TUNDRA                 = new BiomeBeta(59, 0xFFFFFF, "Tundra");
	
	public static final Biome ALPHA_RAINFOREST            = new BiomeAlpha(60, 0xCCCCCC, "Rainforest");
	public static final Biome ALPHA_SWAMPLAND             = new BiomeAlpha(61, 0xFFFFFF, "Swampland");
	public static final Biome ALPHA_SEASONALFOREST        = new BiomeAlpha(62, 0xCCCCCC, "Seasonal Forest");
	public static final Biome ALPHA_FOREST                = new BiomeAlpha(63, 0xFFFFFF, "Forest");
	public static final Biome ALPHA_SAVANNA               = new BiomeAlpha(64, 0xCCCCCC, "Savanna");
	public static final Biome ALPHA_SCHRUBLAND            = new BiomeAlpha(65, 0xFFFFFF, "Schrubland");
	public static final Biome ALPHA_TAIGA                 = new BiomeAlpha(66, 0xCCCCCC, "Taiga");
	public static final Biome ALPHA_DESERT                = new BiomeAlpha(67, 0xFFFFFF, "Desert");
	public static final Biome ALPHA_PLAINS                = new BiomeAlpha(68, 0xCCCCCC, "Plains");
	public static final Biome ALPHA_TUNDRA                = new BiomeAlpha(69, 0xFFFFFF, "Tundra");
	
	public static final Biome BETTER_OCEAN                = new BiomeAlpha(100, 0xFFFFFF, "Ocean");
	public static final Biome BETTER_TROPICALISLAND       = new BiomeAlpha(101, 0xCCCCCC, "Tropical Island");
	public static final Biome BETTER_JUNGLEISLAND         = new BiomeAlpha(102, 0xFFFFFF, "Jungle Island");
	public static final Biome BETTER_MUSHROOMISLAND       = new BiomeAlpha(103, 0xCCCCCC, "Mushroom Island");
	public static final Biome BETTER_BEACH                = new BiomeAlpha(104, 0xFFFFFF, "Beach"); 
	public static final Biome BETTER_BEACHDUNES           = new BiomeAlpha(105, 0xCCCCCC, "Beach Dunes"); 
	public static final Biome BETTER_SNOWPINES            = new BiomeAlpha(106, 0xFFFFFF, "Snow Pines");
	public static final Biome BETTER_SNOWFOREST           = new BiomeAlpha(107, 0xCCCCCC, "Snow Forest");
	public static final Biome BETTER_SNOWTAIGA            = new BiomeAlpha(108, 0xFFFFFF, "Snow Taiga");
	public static final Biome BETTER_SNOWPLAINS           = new BiomeAlpha(109, 0xCCCCCC, "Snow Plains");
	public static final Biome BETTER_SNOWHILLS            = new BiomeAlpha(110, 0xFFFFFF, "Snow Hills");
	public static final Biome BETTER_PLAINS               = new BiomeAlpha(111, 0xCCCCCC, "Plains");
	public static final Biome BETTER_FOREST               = new BiomeAlpha(112, 0xFFFFFF, "Forest");
	public static final Biome BETTER_FORESTHILLS          = new BiomeAlpha(113, 0xCCCCCC, "Forest Hills");
	public static final Biome BETTER_FORESTLAKES          = new BiomeAlpha(114, 0xFFFFFF, "Forest Lakes");
	public static final Biome BETTER_PINES                = new BiomeAlpha(115, 0xCCCCCC, "Pines");
	public static final Biome BETTER_TAIGA                = new BiomeAlpha(116, 0xFFFFFF, "Taiga");
	public static final Biome BETTER_GRASSLAND            = new BiomeAlpha(117, 0xCCCCCC, "Grassland");
	public static final Biome BETTER_RAINFOREST           = new BiomeAlpha(118, 0xFFFFFF, "Rainforest");
	public static final Biome BETTER_JUNGLE               = new BiomeAlpha(119, 0xCCCCCC, "Jungle");
	public static final Biome BETTER_SWAMPLAND            = new BiomeAlpha(120, 0xFFFFFF, "Swampland");
	public static final Biome BETTER_DESERT               = new BiomeAlpha(121, 0xCCCCCC, "Desert");
	public static final Biome BETTER_SAVANNA              = new BiomeAlpha(122, 0xFFFFFF, "Savanna");
	public static final Biome BETTER_SAVANNAFOREST        = new BiomeAlpha(123, 0xCCCCCC, "Savanna Forest");
	public static final Biome BETTER_SCHRUBLAND           = new BiomeAlpha(124, 0xFFFFFF, "Schrubland");
	public static final Biome BETTER_ICERIVER             = new BiomeAlpha(125, 0xCCCCCC, "Ice River");
	public static final Biome BETTER_RIVER                = new BiomeAlpha(126, 0xFFFFFF, "River");
	public static final Biome BETTER_SWAMPRIVER           = new BiomeAlpha(127, 0xCCCCCC, "Swamp River");
	public static final Biome BETTER_SANDRIVER            = new BiomeAlpha(128, 0xFFFFFF, "Sand River");
    
    public final int biomeID;
    public final int biomeColor;
    public final String biomeName;
    
    public int topBlock;
    public int fillerBlock;
    
    public Biome(int i, int c, String n)
    {
    	biomeID = i;
    	biomeColor = c;
    	biomeName = n;
    	biomeList[i] = this;
    }
}
