package ted80.seedviewer.generator;

public class Generator 
{
	public static final Generator[] generatorList = new Generator[30];
	
	public static final Generator DEFAULT = new Generator(0, "Default 1.6.2");
	public static final Generator BETTERDEFAULT = new Generator(1, "Better Default");
	public static final Generator BETTERLARGE = new Generator(2, "Better Default Large");
	public static final Generator BETA1 = new Generator(3, "Beta - Beta biomes");
	public static final Generator BETA2 = new Generator(4, "Beta - Default biomes");
	public static final Generator ALPHA = new Generator(5, "Alpha");
	public static final Generator INFDEV = new Generator(6, "Infdev");
	public static final Generator INDEV = new Generator(7, "Indev");
	public static final Generator SKY1 = new Generator(8, "Sky Dimension - Default biomes");
	public static final Generator SKY2 = new Generator(9, "Sky Dimension - Beta biomes");

	public final int generatorID;
	public final String generatorName;
	
	public Generator(int i, String n)
	{
		generatorID = i;
		generatorName = n;
	}
}
